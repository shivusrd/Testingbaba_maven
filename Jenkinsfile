pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               git 'https://github.com/shivusrd/Testingbaba_maven.git'
            }
        }
        stage('Test') {
            steps {
                bat "mvn clean"
            }
        }
        stage('Deploy') {
            steps {
                 bat "mvn test"
            }
			
			post
            {
                success
                {
                archiveArtifacts 'target/*.jar'
                }
            
            }
        }
    }
}
