pipeline {
    agent any 

    stages {

        stage('Compile and Clean') { 
            steps {
                sh "mvn clean compile"
            }
        }

        stage('Package') { 
            steps {
                sh "mvn clean package"
            }
        }

        stage('Build Docker Image') {
            steps {
                echo "Building Docker Image"
                sh 'ls'
                sh 'docker build -t jabbar/docker_jenkins_springboot:${BUILD_NUMBER} .'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u nasimun -p ${Dockerpwd}"
                }
            }                
        }

        stage('Docker Push') {
            steps {
                sh 'docker push jabbar/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }

        stage('Docker Deploy') {
            steps {
                sh 'docker run -itd -p 8081:8080 jabbar/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }

        stage('Archiving') { 
            steps {
                archiveArtifacts '**/target/*.jar'
            }
        }
    }
}

