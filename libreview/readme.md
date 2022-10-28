About the project:
This is a test automation project for libreview.com to verify the header links ( Patient and Professionals) are displayed for specific conntry. Also inclucded in this project is the python test script for fetching the data from API and representing it in a desired statement.

Prerequisites

JDK8 installed
Eclipse installed
Python3 installed

Built with
Selenium + Java - Test Automation
Maven - Dependency management
TestNG Framework
Python - For API data 
Excel - Test Data Management
Git - Repository to manage the code

Features:
Scripts to select country and language
Header link verification for Patient and Professionals 
Python script to fetch API data from census board endpoint

Usage:

Clone the git repository on to the local system. Open the project in Eclipse. To run the project, right click and select Run as - TestNG.
PageObject design pattern is implemented. The test will launch the firefox browser and open the Libreview url. It will set the country and language as United States and English and do a verification of header links (Patient and Professionals). The country and language will be changed to France and French and the header link verification will be done again. 

Brief overview of the classes:
@BeforeTest
Initiate_Driver: It launches the browser driver and set the url before the actual test begins

@Test
Country_Language_Selection: This class contains methods to set the language and country and link verification. The test data is fetched from the excel data sheet

Waits: Implicit and explicit wait conditions are implemented to handle the sync in the application. waitforElement method waits for certain condition to be met before the execution moves ahead.

Package fetchAPIDataPythonFile - api.py:
api.py python file contains the code to fetch API data and present it in the desired statement form. The python file can be downloaded and executed from command line where python is already installed.