The instructions for setting the site up:

1- First of all Download the Heroku Tool Belt  from  link:
https://s3.amazonaws.com/assets.heroku.com/heroku-toolbelt/heroku-toolbelt.exe

2- Create account on Heroku with below signup link .
https://signup.heroku.com/dc

3- Open Command Prompt and login on Heroku
 C:\> heroku login
 
4- Convert the application to maven application by creating a pom.xml file init.

5- Add the required dependencies in the pom.xml

6- Add the WebApp Runner plugin in the pom.xml.
Webapp Runner allows you to launch an application in a Tomcat container on any computer that has a JRE installed. No previous steps to install Tomcat are required when using Webapp Runner. It’s just a jar file that can be executed and configured using the java command.

7- Create a Procfile in the project & add the following statement to it:
web:    java $JAVA_OPTS -jar target/dependency/webapp-runner.jar --port $PORT target/*.war


8- Commit the changes to Git:
$ git init
$ git add .
$ git commit -m "Ready to deploy"

9- Create the heroku application by:
$ heroku create expediatask2022

10- Deploy the project code to heroku application:
$ git push heroku master

11- Ensure that at least one instance of the application is running:
$ heroku ps:scale web=1

12- Open the application in browser by:
$ heroku open


