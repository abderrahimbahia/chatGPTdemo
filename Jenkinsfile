pipeline{
    agent any
    tools{
        maven 'maven_3.9.6'
    }
    stages{
        stage('Build Maven'){
            steps{
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/abderrahimbahia/chatGPTdemo']])
                sh 'mvn clean install'
            }
        }
        stage('Build Docker Image'){
            steps{
                script{
                    sh 'docker build -t devops-integration .'
                }
            }
        }
        stage('Push Docker Image To DockerHub'){
            steps{
                script{
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u abahia -p ${dockerhubpwd}'
                    }
                    sh 'docker push abahia/devops:devops-integration'
                }
            }
        }
    }
}