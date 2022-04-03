pipeline {
  agent any
  tools {
    maven 'maven-3.8.4' 
  }
  stages {
    stage ('Build') {
      steps {
        sh 'mvn clean install'
      }
    }
  }
}
