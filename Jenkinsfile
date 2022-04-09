pipeline {
    agent any 
    stages {
        stage('Build') { 
            steps {
                git 'https://github.com/shivusrd/Testingbaba_maven.git'
            }
        }
         stage('Deploy') { 
            steps {
                 bat "mvn clean "
            }
        }
        stage('Test') { 
            steps {
                bat "mvn install"
                publishHTML target: [
            allowMissing: true,
            alwaysLinkToLastBuild: true,
            keepAll: true,
            reportDir: 'test-output',
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
