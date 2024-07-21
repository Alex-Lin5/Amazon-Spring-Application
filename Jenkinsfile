pipeline {
  agent any
  // tools {
  //   maven 'Maven 3.9.6'
  //   // jdk: 'Java21'
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
        sh 'mvn clean package'
      }
    }
    stage('build docker image'){
      steps{
        script{
          sh 'docker build -t amazon/onlineshopping:1.0 .'
        }
      }
    }
    stage('push docker image'){
      steps{
        script{
//           withCredentials([usernamePassword(credentialsId: 'DockerUsrPas', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
//           withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId:'DockerUsrPas', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
          withCredentials([usernamePassword(credentialsId: 'DockerUsrPas', passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
            print USERNAME
            print PASSWORD
            sh 'echo $PASSWORD | docker login --username $USERNAME --password-stdin'
//             sh 'docker login -u ${USERNAME} -p ${PASSWORD} docker.io'
            sh 'docker image tag amazon/onlineshopping:1.0 tank73/onlineshopping:h1.0'
            sh 'docker push tank73/onlineshopping:h1.0'
//             sh 'docker push amazon/onlineshopping:1.0'
          }
        }
      }
    }
    stage('authenticate kubernetes'){
      steps{
        script{
          sh 'minikube start'

        }
      }
    }
    stage('upload images or container registry on kubernetes cluster'){
      steps{
        script{
          sh ''

        }
      }
    }
    stage('deploy application on kubernetes cluster'){
      steps{
        script{
          // configurations
          sh 'kubectl apply -f mysql-configmap.yaml'
          sh 'kubectl apply -f mysql-secret.yaml'
          sh 'kubectl apply -f docker-secret.yaml'

          // deployments
          sh 'kubectl apply -f mysql-deploy.yaml'
          sh 'kubectl apply -f app-deploy.yaml'

        }
      }
    }
    stage('checkout kubernetes deployments'){
      steps{
        script{
          sh 'kubectl get deploy'
          sh 'kubectl get svc'
          sh 'kubectl get pods'
        }
      }
    }

  }
}
