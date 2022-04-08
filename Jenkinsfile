pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               git 'https://github.com/shivusrd/Testingbaba_maven.git'
            }
        }
        stage('deploy') {
            steps {
                bat "mvn clean"
            }
        }
        stage('test') {
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
