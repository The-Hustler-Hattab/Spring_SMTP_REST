# Email Sending Form Project

Welcome to the Email Sending Form Project! This project provides a simple web application that allows users to send emails to different recipients using a user-friendly form.

## Table of Contents

- [Features](#features)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation](#installation)
- [Usage](#usage)



## Features

- **User-Friendly Interface:** The application offers an intuitive interface for users to fill out and send emails.
- **From email Selection:** Users can select a from email from a list.
- **Subject and Message:** Users can enter subject and message content for their emails.
- **Validation:** Input validation ensures that required fields are filled correctly.
- **Error Handling:** Proper error handling and feedback to users in case of failures.
- **Backend Integration:** Emails are sent via a backend service for better security and control.

## Getting Started

### Prerequisites

- Java Development Kit (JDK) version 8 or higher
- Maven (for building and managing dependencies)
- Web browser
- Mysql database
- GitHub Oauth credentials

### Installation

1. Clone this repository to your local machine:   
git clone https://github.com/The-Hustler-Hattab/Spring_SMTP_REST.git
2. Setup db tables using schema.sql present in resources folder.
3. Add connection details to application.properties.
4. Add GitHub Oauth credentials to application.properties.
5. Create from email address with free smtp support (outlook) and enable smtp.
6. Add a secret key to application.properties like secret.email.key=superSecretP@ssword!.
7. Encrypt the password using test method and insert the data to the mysql table.
8. Run the application.


---
Project developed by Mohammed Hattab (https://github.com/The-Hustler-Hattab)