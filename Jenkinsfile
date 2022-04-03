pipeline 
{
    agent any
    
    tools
    {
    
    maven "MAVEN_HOME   "
    }

    stages 
    {
        stage('Build') 
        {
            steps 
            {
                git 'https://github.com/shivusrd/Testingbaba_maven.git'
                
                bat "mvn -Dmaven.test.failure.ignore=true clean package"
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
