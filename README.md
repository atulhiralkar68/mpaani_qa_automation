# Set Up Instruction
**Required softwares:**
      * JDK : http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html 
      * Maven : https://maven.apache.org/download.cgi
      * Eclipse : http://www.eclipse.org/downloads/packages/eclipse-ide-java-developers/neon2

# How to set up project
1. Clone this project - $repo
2. Import project in eclipse as Maven existing project
3. Make sure you have set JDK 1.8 in build path for this project.
4. Make sure you have given the path of feature folder in RunCukeTest.java file

## Run Project from eclipse on prod
1. Open src/main/resources
2. Open QA.properties file and update PhoneNumbForPhysicalDevice
3. Open src/test/java 
4. Open runner package from it
5. Open CukeRunnerTest class
6. Change the tag name that we have given in feature file
7. Right click and Select "Run As" and then select "JUnit Test"

## Run Project from eclipse on staging
1. Open src/test/java 
2. Open runner package from it
3. Open CukeRunnerTest class
4. Change the tag name that we have given in feature file
5. Right click and Select "Run As" and then select "JUnit Test"


## Run Project from command line on staging
1. Open terminal(MAC) or CMD(windows) and go to project directory
2. Run command -mvn test -Dtest=runner.CukeRunnerTest -Dcucumber.options="Feature/ --tags {tagName}" -DphoneNumber=7022015845 -DplatformValue=androidStaging

## Run Project from command line on prod
1. Open terminal(MAC) or CMD(windows) and go to project directory
2. Run command -mvn test -Dtest=runner.CukeRunnerTest -Dcucumber.options="Feature/ --tags {tagName}"-DphoneNumber={Real device number} -DplatformValue= androidProd

