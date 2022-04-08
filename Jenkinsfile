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
	    publishHTML target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'coverage',
            reportFiles: 'index.html',
            reportName: 'RCov Report'
          ]
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
