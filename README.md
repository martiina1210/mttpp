# SauceDemo Automation Framework

This project represents a basic UI automation testing framework developed as part of the course *Methods and Techniques of Software Testing*.

## Technologies Used

- Java
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Page Object Model (POM)

---

## Project Structure

```
src
 ├── main
 │    └── java
 │         └── pages
 │              LoginPage.java
 │              ProductsPage.java
 │              MenuPage.java
 │
 └── test
      └── java
           └── tests
                BaseTest.java
                FirstTest.java
```


## Implemented Test Scenarios

1. Valid login
2. Invalid login
3. Add product to cart
4. Remove product from cart
5. Logout

---

## How to Run the Tests

### Using Command Prompt

Navigate to the project folder:

```
cd path-to-project
```

Run:

```
mvn clean test
```

---

## Test Report

After execution, the report is generated in:

```
target/surefire-reports/index.html
```

Open this file in a browser to view test results.

---


