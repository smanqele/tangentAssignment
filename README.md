Notes on the tangentAssignment project
======================================
A. Resource Summary
---------------------
Before we begin with the installation I want to start with the summary of resources used 
to create this project:
i) Tomcat 8.0.32
ii) Java JDK 1.8.0_102
iii) Spring 4.2.1
iv) Spring-security 4.0.2
v)	Junit 4.10
vi)	slf4j 1.6.1
vii) jstl 1.2
viii) javax.servlet api 3.1.0
xi) Eclipse JEE IDE - Version Mars 2 Release 4.5.2 
x) The internet connection. The application connects to the Tangent's back end services for authentication and project data
using a combination of a resource URI and the REST tools privided by the Spring framework.
Except for the Tomcat server and the internet, all the resources are listed in the maven pom file which will help with organize
these resources for you when you update the project.

B. Project Installation
------------------------
1. Download a web server like Tomcat for your project (I used Tomcat 8.0.32)
(See http://www.tutorialspoint.com/articles/run-your-first-jsp-program-in-apache-tomcat-server
or http://www.coreservlets.com/Apache-Tomcat-Tutorial/ on how to run applications using Tomcat. 
That being said, any server of your choice, like Jetty or JBoss can suffice)
2. Download / Pull the project to your local folder.
3. Locate the pom.xml file (at the root of the project)
4. Using your favourate IDE or using command line, create a project 
(Please see the following resource for an introduction on the steps to achieve this:
http://blog.sonatype.com/2009/09/maven-tips-and-tricks-using-github/ )
5. After updating, cleaning and installing your project start the server.

C. Running the application
---------------------------
1. Once the server has sucessfully started, use this URL to start at the login page:
http://localhost:8080/tangentprojects/login
2. You can use "admin1" for username and password. Once authentication has happened you will be presented
with a list of projects in a drop down format.
3. After choosing a project entry from the drop down you will see the project details together with the tasks drop down 
list (if the project contains such a list)
4. Choose a  task from the drop down and you will see the task details, accompanied by the relevant project details for that
task
5. This represents the functionality of the application, and each of the above steps is contained in its own JSP page (with
the relevant Spring Controller code).
6. All the JSP files are in this folder: /tangentprojects/src/main/webapp/WEB-INF/views/
7. All the controller files are here: /tangentprojects/src/main/java/com/sihle/tangent/controller/

