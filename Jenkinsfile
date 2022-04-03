pipeline {
    agent any

    stages {
        stage('Maven clean') {
            steps {
                echo 'Building..'
                bat "mvn clean -f Testingbaba_maven"
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                 bat "mvn test -f Testingbaba_maven"
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
