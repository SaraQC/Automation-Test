# Terkwaz Test Automation Assignment
This is the created test scripts to implement the sent web UI automation task, as below

### Environment description
- Java/Maven Project.
- Selenium WebDriver Framework.
- Page Object Module (POM) design pattern.
- Excel data provider.

### Used Dependencies 
- Selenium
- TestNG
- Extent Reports
- poi

### Tips
- You can run the project via the XML file (RunTests.xml).
- You will find the generated Extend Report in "reports" folder on the project's level.
- The used driver is chromedriver81, you can change based on your browse version.

### Covered Requirements
1- GoogleSearchTest Class:
 Navigating to  "https://www.google.com/ncr"
 Then Searching with "selenium webdriver" using the Excel Reader
 Then waiting for the results page to load
 
 2- GoogleSearchResultsTest Class:
  Checking if the third result text contains "What is Selenium WebDriver?"
  
  3- FileUploaderTest Class:
   Navigating to "https://the-internet.herokuapp.com/"
   Validate on uploading an image (the image taken from "Files" folder on the project's level)
   then asserting that the image uploaded successfully.
  
  4- DynamicLoadingTest Class:
   Navigating again to "https://the-internet.herokuapp.com/"
   Opening the dynamic loading example2
   Start the dynamic loading 
   waiting until the loading icon disappears
   
   5- Use the extend report to genrate an automated test execution HTML report
 

### Steps to clone execute the tests

git clone https://github.com/SaraQC/Automation-Test.git
