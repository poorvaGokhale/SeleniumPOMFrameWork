
Statement: Selenium Automation : Yahoo Mail SignIn

Objective: Demonstrate how classes, pages are orgnized and clean coding, defining framework

Application: Yahoo Mail

Scope:
Implementation of POM 
Chrome Browser
Basic Reporting
Login testcases

Non-Scope: ( Due to Time and Objective of assignment)
Page Factory implementation
Multiple drivers handling - ie, firefox etc.
Detailed Reporting  - screenshot
Logger
Thread \selenium grid \capabilities

Architecture:
This is implementation of Page Object Model with Selenium TestNG.
This is very basic implementation as POC not all aspects are covered in details.
Allure report  Integrated for reporting purpose


Assumtions:
chrome as a web Browser for tests 
Testdats will be updated for successful Test Run

PreRequiste:
Selenium WebDriver for Chrome Setup
Maven for managing Dependencies setup

Testcases:
Invalid User
Invalid Password
Valid User and valid password

Automation flow:
Launch URL -> Enter Username -> Click signin
Launch URl -> Enter Username -> Click SignIn -> Enter Passwprd -> Click Login

Installation and Execution:
Setup project: clone this project from git: 
git clone https://github.com/poorvaGokhale/SeleniumPOMFrameWork

Setup testdata:
update Testdata: provide valid Yahoo mail username and password in order to pass those tests
inputfile path: test/resources/config.properties

Execute:
open terminal and navigate to project directory
Run "mvn clean test"

Reports:
run 
$allure serve target/allure-results