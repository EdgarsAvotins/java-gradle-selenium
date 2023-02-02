# Technical task by Edgars Avotiņš

### Technical clarification
Technologies and versions used while developing this project:
- Java 11
- Gradle v7.6
- Selenium-java v3.141.59
- Junit 5
- REST Assured v5.3.0
- Allure v2.11.2

### Gradle commands
Execute tests on clean environment and open the allure report:

`./gradlew clean test allureServe`

You can separately execute the tests or publish the report:

`./gradlew clean test`

`./gradlew allureServe`

Add `--info` for more details on the execution:

`./gradlew clean test --info`

### Tests
These three tests have been automated, two UI focused tests and one API.
High level information on the steps of each test can be found in src/test/java/tests .

#### TestScenarioAPI
Scenario: As a user I am able to add a book to my collection
- Given user is created and userId saved
- Given user is authenticated and token saved
- Given a book isbn has been received and saved
- When book is added to user
- Then the user has the book added to their collection

#### TestScenarioUI
Scenario: As a user I am able to add a book to my collection
- Given a new user is created via API
- And I have logged in
- When I add a book to the collection
- Then the book has been added to the collection

Scenario: As a user I am able to remove a book from my collection
- Given a new user is created via API
- And I have logged in
- And I add a book to the collection
- When I remove the book from the collection
- Then the book is no longer present in the collection