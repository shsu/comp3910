# COMP3910 A3 Server

##System Requirements:

* JDK 1.6 or higher
* Maven 3.1.1 or higher
* JBoss AS 7.1.1 or higher

##Building the project:
1. Start JBoss AS 7 manually (standalone mode)
2. In root directory of project

        mvn clean install

This will build a WAR, deploy it to JBoss, and run the unit test
