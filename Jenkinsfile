pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6' 
        jdk 'java-17'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/ravil-yu/MyProject.git', branch: 'master' 
            }
        }
        stage('Build & Test') {
            steps {
                bat 'mvn clean package -Dmaven.test.failure.ignore=true'
            }
        }
        stage('Code Coverage') {
            steps {
                jacoco(execPattern: '**/target/jacoco.exec')
            }
        }
        stage('Static Code Analysis') {
            steps {    
                bat 'mvn sonar:sonar'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            junit '**/target/surefire-reports/*.xml'
            jacoco(execPattern: '**/target/jacoco.exec')
        }
    }
}
