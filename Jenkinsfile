pipeline 
{
    agent any
    
    /*tools
    {
    
    maven "MAVEN"
    }*/

    stages 
    {
        
        
        
        stage('Git') 
        {
            steps 
            {
                git 'https://github.com/shivusrd/Testingbaba_maven.git'
                
                bat "mvn test"
            }
            
           
            
             stage('Build') 
        {
            steps 
            {
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
