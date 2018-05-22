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
        
        stage('Test') {
            steps {
                sh 'ls -al'
                sh 'chmod +x gradlew'
                sh './gradlew test'
            }
        }
        
        stage('Sonar') {
            steps {
                sh 'echo "Sonarqube"'
                sh './gradlew sonarqube'
            }
        }
        
        stage('Build') {
            steps {
                sh './gradlew build'
            }
        }
       
    }
}