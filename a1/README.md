# Assignment 2 Installation

## Prerequisites

1. Maven 3.0.x or 3.1.x
2. Java JDK 6 or 7
3. JBOSS_HOME environment variable defined.

## Database / Data Source Setup

1. Setup database and user by running initial_setup.sql under the source directory:

        mysql -uroot -p < src/initial_setup.sql

    Note: This creates a user `a2` identified by `a2`.

2. Setup JTA Data Source to:

        java:jboss/datasources/assignment2

    Note: JDBC URL is: `jdbc:mysql://localhost/a2`

## Deploy Application

1. Stop all instances of JBoss Application Server
2. Go to the root directory of the assignment code where pom.xml is.
3. Run the following command and it will start JBoss and deploy a war archive with the assignment code automatically.

        maven clean install

4. Navigate to:

        http://localhost:8080/a2-jhou-shsu

## Some other useful commands

* mvn jboss-as:deploy
* mvn jboss-as:undeploy
* mvn jboss-as:redeploy
