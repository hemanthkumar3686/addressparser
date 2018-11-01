The api is hosted on "https://addressparser.herokuapp.com/address"
Can use POST method on a rest Client with content type as "text/plain"
And the body with an Address String ex: "Calle 39 No 1540"
Building and running the application you need:

Requirements:
JDK 1.8

Running the application locally:
Import the project into the IDE
Run the "src/main/java/com/addressformatter/AddressformatterApplication.java" file as a SpringBoot application
or in a command line console use the following command:
> mvn spring-boot:run

To Invoke the tests:

After initialising the address api from previous step,
run the application as a maven test
or in a new command line console, run the following command:
> mvn test

The test report can be found in the directory: target\cucumber

Test Files Locations:
Feature Files Location: src\test\resources\features
TestNG location: src\test\resources\testng\testng.xml
Step Definitions Location: src\test\java\steps


