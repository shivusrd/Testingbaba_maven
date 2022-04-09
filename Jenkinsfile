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
		    build wait: false, job: 'cucumber_demo', parameters: [string(name: 'User', value: 'Shivam'), string(name: 'Thread-count', value: '1'), credentials(name: 'Credentials', value: 'fabb8915-2174-4691-a470-a17385b4930a'), booleanParam(name: 'choice', value: true)]
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
