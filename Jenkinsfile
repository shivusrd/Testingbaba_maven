pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               git 'https://github.com/shivusrd/Testingbaba_maven.git'
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
