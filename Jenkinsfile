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
        stage('push docker image'){
            steps{
                script{
//                     def props = readJSON file: './auth.json'
//                     def username = props.username
//                     def password = props.password
//                     withCredentials([usernamePassword(credentialsId: 'DockerUsrPas', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
//                     withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'DockerUsrPas', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                    withCredentials([usernamePassword(credentialsId: 'DockerUsrPas', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                        print USERNAME
                        print PASSWORD
                        bat 'echo $PASSWORD | docker login --username $USERNAME --password-stdin'
//                         bat 'docker login -u ${USERNAME} -p ${PASSWORD} docker.io'
                        bat 'docker push amazon/spring:latest'
                    }
//                     bat 'docker login -u ${username} -p ${password} docker.io'
                    bat 'docker login'
                    bat 'docker push amazon/spring:latest'
                }
            }
        }
    }
}
