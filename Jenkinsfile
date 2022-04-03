pipeline {
    agent any

    stages {
        stage("git") {
            steps {
                
                git credentialsId:'git_credentials', url: 'https://github.com/shivusrd/Testingbaba_maven'
            }
        }
        stage('Test') {
            steps {
               bat mvn clean install
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
