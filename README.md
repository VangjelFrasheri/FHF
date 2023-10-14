# FHF
Simple Spring Boot Api Service

How to download the code:
1. Create a folder or directory where you want the project locally.
2. 2pen a git bash or equivalent terminal. If you dont have one you can down it here: https://git-scm.com/downloads (this will come with git bash).
3. Run 'git clone https://github.com/VangjelFrasheri/FHF.git
4. After running the command the project should be loaded into your folder/directory that you ran the command from


How to run the executable. Usually this is against best practices and artifacts/jars but I will be providing an executable for ease of running. 

1. a. You will need Java 17+ and can download it here https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
1. b. Once downloaded you should add it to your home path. Doc to help https://phoenixnap.com/kb/install-java-windows#ftoc-heading-6
1. Go to the folder you downloaded cloned to project to and open a bash terminal.
2. Change directories into the target folder. "cd target"
3. run the executable with the following command. "java -jar first-help-financial-0.0.1-RELEASE.jar"
4. The server should be up and running on your local machine and ready to be interacted with. Reference the documentation page on how to make api calls.

How to make your own executable:
1. go to your project directory
2. run "mvnw package -e"
3. this will only work if you have the correct JDK ( 17+)


How to run the code locally in your IDE and make local changes to the behavior before running it:

 Go to your IDE of choice and import the project. The recommended place to import would be spring-tool-suite 4.
 NOTE: The IDE should have spring capablities. If it does not you can look at the first few steps in the "How to run" portion below on installing Spring!


How to run (spring-boot /maven will be necessary to run currently on version 3.1.4 of springboot):
1. If you dont have spring boot version 3.1.4 you can download on the following link: https://spring.io/tools

There is a video on downloading spring tool suite 4 here: https://www.youtube.com/watch?v=DKW6IlUrxG8

If you want to use a different IDE, there are instructions you can follow here: https://docs.spring.io/spring-boot/docs/1.0.0.RC5/reference/html/getting-started-installing-spring-boot.html

2. Once the project is in your IDE (Check how to download above) right click on the project and scroll down to Maven -> Update Project just to make sure the project complies and all the dependancies are there.


3. (optional) you can make any custom changes to the code that you want.

4. Right click on the FirstHelpFinancialApplication.java class then scroll down to "run as" and select Spring Boot App. This should start the server in a few seconds and you will be ready to make API calls. Look at the documentation file for more information.

 

