pipeline {
    agent any
    tools {
        maven 'Maven 3.6.2'
        jdk 'jdk8'
    }
    stages {
        stage('Build') {
            steps {
                checkout scm
                //sh 'ls > files'
                sh "mvn clean compile"
            }
        }
    }
}