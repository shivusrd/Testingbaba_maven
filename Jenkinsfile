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
                bat "mvn test"
            }
	
        stage('Deploy') {
            steps {
                 bat "mvn clean"
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
}
