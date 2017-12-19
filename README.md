# Grand Circus Survey Analytical Dashboard
#

## Introduction
## 

This is our final project for the Grand Circus Java Development Bootcamp that students
were tasked to complete in two weeks. The main purposes of this project is to
demonstrate our knowledge of deploying a JSP Web Application through use of Spring
MVC, Hibernate, MySQL, Object Oriented Programmming, Frontend languages, Servlets,
Java Beans, and APIs.  This project was a team effort in a group including Michael
Chan, Deante Firmin, Siddique Khatri, and Alexander Cyr.

The topic of our project is to visualize the survey responses from Grand Circus
students. Each week in the Grand Circus Bootcamp, students are obligated to submit
a survey regarding how confident they feel about the material, how they feel about
the teaching style, how they feel about the program manager, how many jobs each
student has applied for, and etc.  This project allows us to hold each student's
information in a database including their responses to the survey question and
allows an administrator to see the responses through data visualizations.

### Prerequisites
### 

You may run this project at http://sad-dashboard.us-east-2.elasticbeanstalk.com/

But if you would like to install and run this project...

The applications needed to run project are... 
	
1) A suitable Java IDE (Eclipse, Netbeans, Intelllij, etc.) with Enterprise Edition. 

2) A version of Java, preferably version 8.
	(http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.
	html) 
	
3) MySQL and a Workbench (https://www.mysql.com/products/) and
	(https://www.mysql.com/products/workbench/) 
	
4) Apache Maven (https://maven.apache.org/download.cgi) 

5) Tomcat (http://tomcat.apache.org) 6) A clone of this repository.

### Installing
### 
1) Install everything mentioned from the Prerequisites section above.

2) Clone this repository.

3) In the MySQL Workbench, find and run the 'GCFinalProj.sql' file.

4) Create a 'Hibernate.cfg.xml file (under the 'Java Resources' folder, under the 'src'
	folder) with the appropriate MySQL connections.

4) If running project with Eclipse, make sure project is deployed as being ran as
	Dynamic Web Project.

5) Right click on the project folder in Eclipse, hover mouse of 'Maven' and convert
	project to Maven.

6) Right click again on project, hover over 'Run As', and select 'Maven Build'.  Run
	Build As clean install.

7) Right click 'Run As' again, and select 'Run on Server'
