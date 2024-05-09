Automation Project

Table of Contents
- [Introduction]
- [Features]
- [Installation]
- [Usage]
- [Configuration]
- [Contributing]
- [License]

Introduction
This simple automation framework is written in Java Selenium with Cucumber BDD framework and POM design pattern. It has scenarios and underlying code written for Argos Website.


Features
- Page classes containing objects and methods are written
- Step definition class file written to call the methods.
- Feature file contains Scenarios in Gherkin format
- TestRunner class written to allow parallel execution of scripts and generate simple cucumber reports.
- maven build dependencies included to run the script through maven.

Installation
To use this automation project, follow these steps:

1. Clone the repository: Clone the repository from github.
2. Install dependencies: Go to pom.xml and load the file when downloads the required dependencies.


Usage
To execute the automation scripts please see below:

Here's a brief overview of common usage scenarios:

1. TestRunner file allows the scenarios to be executed in parallel. Click RUn button beside the class name in TestRunner class to execute scripts in parallel.
2. Alternately the scenarios can be executed from feature file as well in which case the scenarios execute consecutively.