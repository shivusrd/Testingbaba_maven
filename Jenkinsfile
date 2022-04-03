pipeline {
    agent any
    environment{
        PATH = "C:\Users\dubey\Downloads\apache-maven-3.8.4-bin\apache-maven-3.8.4\bin"
    }

    stages {
        stage("git") {
            steps {
                
                git credentialsId:'git_credentials', url: 'https://github.com/shivusrd/Testingbaba_maven'
            }
        }
        
         stage("build maven") {
            steps {
                
                @bat "clean install"
            }
        }
       
    }
}
