pipeline {
    agent any
    tools {
        maven 'Maven-3.9.6' 
        jdk 'java-17'
    }
    stages {
        stage('Checkout') {
            steps {
                git url: 'https://github.com/Tong4343/MyProject.git', branch: 'master' 
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean package'
            }
        }
        stage('Code Coverage') {
            steps {
                jacoco(execPattern: '**/target/jacoco.exec')
            }
        }
        stage('Static Code Analysis') {
            steps {
                
                sh 'mvn sonar:sonar'
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
