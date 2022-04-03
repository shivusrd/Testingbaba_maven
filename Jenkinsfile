pipeline {
    agent any

    stages {
        stage('Build and git clone') {
            steps {
                echo 'Building..'
                git clone https://github.com/shivusrd/Testingbaba_maven
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
