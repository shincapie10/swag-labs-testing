# 🧪 Swag Labs Automation Framework

Automated testing framework built with **Java**, **Selenium WebDriver** and **TestNG** to validate key user flows in [Swag Labs](https://www.saucedemo.com/).

## 📋 Project Overview

This project automates core test cases for the Swag Labs e-commerce site, including:

1. ✅ **Purchase Flow**: Logs in with a valid user, selects a random product, checks out, and verifies the success message.
2. 🛒 **Cart Removal**: Logs in, adds 3 items to the cart, removes them all, and confirms the cart is empty.
3. 🔒 **Logout Flow**: Logs in, logs out through the sidebar menu and verifies redirection to the login page.

---

## 🧱 Tech Stack

- **Language**: Java 17
- **Testing Framework**: TestNG
- **Automation**: Selenium WebDriver 4
- **Design Pattern**: Page Object Model (POM) with PageFactory
- **Build Tool**: Maven

---

## ⚙️ Prerequisites

- Java 17+
- Maven
- Chrome browser

---

## 🚀 How to Run Tests

```bash
mvn test -DsuiteXmlFile="testng.xml"
```

Execute this command in the folder where the POM.xml and testing.xml files are

---

## 🧪 Test Data

Valid users to log in:

- `standard_user`
- Password for all users: `secret_sauce`

The other users available have intentional design flaws, the only user that works properly is `standard_user`
