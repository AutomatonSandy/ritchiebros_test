# ritchiebros_test

This repository contains a Selenium-based test automation framework for the Ritchie Bros. Auctioneers website. The project is built with Java, Maven, and TestNG, and is designed to run UI tests within a Dockerized Selenium Grid environment.

## ✨ Features

*   **Page Object Model (POM):** The framework uses the Page Object Model design pattern to create a scalable and maintainable test suite.
*   **Selenium Grid Integration:** Configured to run tests on a Selenium Grid managed by Docker Compose.
*   **Video Recording:** The Docker setup includes a video container to record test execution sessions for easier debugging. [This is in progress from github actions]
*   **CI/CD Pipeline:** A GitHub Actions workflow (`uiTests.yml`) automates the testing process by setting up the environment, running tests, and uploading reports.
*   **TestNG Suite:** Test execution is managed through a TestNG XML suite (`uitestsuite.xml`), allowing for easy grouping and execution of test cases.
*   **Configuration Management:** Test environment settings, like the base URL and browser type, are managed through a `config.properties` file.

## 🛠️ Tech Stack

*   **Language:** Java 8
*   **Test Automation:** Selenium 4
*   **Test Framework:** TestNG
*   **Build Tool:** Apache Maven
*   **Containerization:** Docker & Docker Compose
*   **CI/CD:** GitHub Actions

## 📂 Project Structure

```
.
├── .github/workflows/uiTests.yml   # GitHub Actions workflow for CI
├── docker-compose.yml              # Docker services for Selenium Grid
├── pom.xml                         # Maven project configuration
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── pages               # Page Object classes
│   │   │   └── utility             # DriverFactory and ConfigReader
│   │   └── resources
│   │       └── config.properties   # Environment configuration
│   └── test
│       ├── java
│       │   └── tests               # TestNG test classes
│       └── resources
│           └── suites
│               └── uitestsuite.xml # TestNG suite definition
└── videos/                         # Directory for saving test execution videos
```

## 🚀 Getting Started

### Prerequisites

*   [Java Development Kit (JDK 8 or higher)](https://www.oracle.com/java/technologies/downloads/)
*   [Apache Maven](https://maven.apache.org/download.cgi)
*   [Docker](https://docs.docker.com/get-docker/)
*   [Docker Compose](https://docs.docker.com/compose/install/)

### Running the Tests

The tests are configured to run against a Selenium Grid running in Docker containers.

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/automatonsandy/ritchiebros_test.git
    cd ritchiebros_test
    ```

2.  **Start the Selenium Grid:**
    Use Docker Compose to start the Selenium Hub, Chrome Node, and video recording services.
    ```sh
    docker-compose up -d
    ```
    This command will pull the required images and start the containers in the background.

3.  **Run the tests:**
    Execute the tests using the Maven `ui-tests` profile. This profile is configured in the `pom.xml` to run the test suite defined in `uitestsuite.xml`.
    ```sh
    mvn clean test -Pui-tests
    ```

4.  **View Results:**
    *   Test reports are generated in the `target/surefire-reports/` directory.
    *   Recorded videos of the test sessions are saved in the `videos/` directory.

5.  **Stop the Selenium Grid:**
    Once you are done with the tests, stop and remove the containers.
    ```sh
    docker-compose down
    ```

## ⚙️ CI/CD Pipeline

This project includes a GitHub Actions workflow defined in `.github/workflows/uiTests.yml`. This workflow is triggered on every push or pull request to the `main` branch and performs the following steps:

1.  Checks out the repository code.
2.  Sets up JDK 17 and caches Maven dependencies.
3.  Starts the Selenium Grid using `docker-compose`.
4.  Runs the UI tests using the `mvn clean test -Pui-tests` command.
5.  Uploads the Surefire test reports as a build artifact.
6.  Stops the Selenium Grid.