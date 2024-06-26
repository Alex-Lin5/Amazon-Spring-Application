pipeline {
    agent any
    // tools {
    //     maven 'Maven 3.9.6'
    //     // jdk: 'Java21'
    // }

    stages {
        stage('Checkout') {
            steps {
                // checkout scmGit(branches: [[name: '*/master']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubSSH', url: 'git@github.com:Alex-Lin5/Amazon-Spring-Application.git']])
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubUsrPas', url: 'https://github.com/Alex-Lin5/Amazon-Spring-Application.git']])
                // checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[credentialsId: 'GitHubUsrPas', url: 'https://github.com/Alex-Lin5/Amazon-Spring-Application']])
            }
        }
        stage('maven build'){
            steps{
                bat 'mvn clean install'
            }
        }
        stage('build docker image'){
            steps{
                script{
                    bat 'docker build -t amazon/spring:latest .'
                }
            }
        }
    }
}
