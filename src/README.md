mvn versions:display-dependency-updates
[INFO] The following dependencies in Dependencies have newer versions:
[INFO]   io.qameta.allure:allure-testng ...................... 2.10.0 -> 2.13.5
[INFO]   org.seleniumhq.selenium:selenium-java ...... 3.141.59 -> 4.0.0-alpha-6
[INFO]   org.testng:testng ..................................... 7.0.0 -> 7.3.0

mvn clean test
[INFO] Results:
[INFO] Tests run: 14, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------

mvn clean test -DsuiteXmlFile=src/test/resources/SmokeTest.xml
[INFO] Tests run: 14, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 141.41 s - in TestSuite
[INFO] Results:
[INFO] Tests run: 14, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS

mvn clean test -Dtest=LoginTest#loginTest+emptyPasswordTest test
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 26.839 s - in tests.LoginTest
[INFO] Results:
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
C:\Users\Sorok\IdeaProjects\SauceDemo\src\README.md