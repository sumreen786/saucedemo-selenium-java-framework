# Hybrid Automation Testing Framework

## Project Overview

This project is a Hybrid Automation Testing Framework developed for a web-based e-commerce application using Java, Selenium WebDriver, TestNG, Maven, and Apache POI.

The framework is designed to improve:
- Reusability
- Maintainability
- Scalability
- Test execution efficiency

The framework currently follows:
- Page Object Model (POM)
- Data-Driven Testing (DDT)

The project currently focuses on automating core functionalities such as login validation and basic workflow testing.

---

# Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- Apache POI
- Git & GitHub
- IntelliJ IDEA

---

# Current Framework Features

## Implemented Features

- Login page automation
- Page Object Model (POM)
- Base class implementation
- Reusable wait utility
- Data-Driven Testing using Excel
- Reusable methods and utilities
- Test execution using TestNG

---

# Framework Structure

src/test/java

│

├── base
├── pages
├── tests
└── utilities
      ├── WaitManager
      └── ExcelUtils

---

# Modules Automated

- Login Module

---

# Framework Design

## Page Object Model (POM)

The framework follows the Page Object Model design pattern to separate web elements and page actions from test classes. This improves code maintainability, readability, and reusability.

## Data-Driven Testing (DDT)

Excel files are used for storing test data. TestNG DataProvider is used to execute login tests with multiple sets of test data.

## Wait Utility

Reusable explicit wait methods are implemented to handle synchronization issues and dynamic elements.

## Base Class

Browser setup and browser closing methods are maintained in a separate base class using:
- @BeforeMethod
- @AfterMethod

---

# Tools Used in the Project

| Tool | Purpose |
|------|----------|
| Selenium WebDriver | Web automation |
| TestNG | Test execution and assertions |
| Maven | Dependency management |
| Apache POI | Excel data handling |
| GitHub | Version control |
| IntelliJ IDEA | Development IDE |

---

# Features Planned for Future Implementation

- Product Page Automation
- Add to Cart Automation
- Checkout Flow Automation
- Screenshot Capture on Failure
- Cross-Browser Testing
- Cucumber BDD Integration
- Feature Files
- Step Definitions
- Runner Classes
- TestNG Listeners
- Jenkins CI/CD Integration
- Advanced Reporting
- Selenium Grid Execution
- REST Assured API Automation
- Docker Integration

---

# Learning Outcomes

Through this project, the following concepts were learned and implemented:

- Selenium WebDriver automation
- TestNG framework usage
- Page Object Model
- Data-Driven Testing
- Synchronization handling
- Reusable framework design
- Framework structuring using Maven
- Basic automation framework development

---

# Author

Sumreen Banu H
Automation Testing Enthusiast
