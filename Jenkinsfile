pipeline {
    agent any

    environment {
        NameSpace='JasperJames'
    }

    stages {
        stage('Checkout') {
            steps {
                git poll: true, url: 'https://github.com/androidjp/spring-boot-basic'
            }
        }
        /// 快速自动化测试（解决：开发快，测试慢的问题）
        stage('Test') {
            steps {
                sh 'ls -al'
                sh 'chmod +x gradlew'
                sh './gradlew test'
            }
        }

        stage('Sonar') {
            steps {
                sh './gradlew sonarqube'
            }
        }
        // 解决问题： 不同功能部门间的部门墙 方案 集成
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
       // 解决问题： 开发和运维的墙。自动部署（CD）、快速发布（避免伪敏捷）
       stage('Deploy') {
           steps {
               sh 'whoami'
               withCredentials([sshUserPrivateKey(credentialsId: "training_pem", keyFileVariable: 'keyfile')]) {
                   sh "ssh -i $keyfile ubuntu@172.31.12.139 mkdir -p /home/ubuntu/works/$NameSpace"
                   sh "scp -i $keyfile ./build/libs/demo-0.0.1-SNAPSHOT.jar ubuntu@172.31.12.139:/home/ubuntu/works/$NameSpace/demo.jar"
                   sh "ssh -i $keyfile ubuntu@172.31.12.139 'ls /home/ubuntu/works/$NameSpace'"
                   /// 把错误输出，变成标准输出（2>&1 &  ,因为第一次，没有进程给你kill，所以，会返回一个大于1（被认为命令执行错误）的指令，所以，有这个强转为1）
                   sh "ssh -i $keyfile ubuntu@172.31.12.139 'kill -9 \$(lsof -t -i:8768) 2>&1 &'"
                   /// 这里的`2>&1`是为了让我能在日志中看到错误的输出
                   /// nohup 为了让命令在后台跑，不阻碍Jenkins结束
                   sh "ssh -i $keyfile ubuntu@172.31.12.139 'nohup java -jar -Dserver.port=8768 /home/ubuntu/works/$NameSpace/demo.jar > demo.log 2>&1 &'"
                   sh "sleep 10"
                   sh "curl 172.31.12.139:8768/fizzbuzzgame/1"
               }
           }
       }
    }
}