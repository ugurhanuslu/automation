#Findeks Automation Test Project used tools: Java, Maven, Testng, Extent Reports, Log4j

I used Java and Testng for my test scripts, Extent Reports for reporting and Log4j for logging.

You can change the browser from TestNG.xml files

For parallel running: You should change testngXmlFile to ParallelRun.xml at pom.xml line 34

Script for running project: mvn clean test