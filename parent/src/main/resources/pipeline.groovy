node {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/wolf-J/wolf-git-workspace.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'M3'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
        // bat(/cd Parent
         //"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
      sh "cd Parent \n '${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      sh "echo 'exec shell!'"
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
}