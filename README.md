# GameLog 

A desktop application built with Java and Swing to manage, track, and log your personal video game collection. Implements a strict Model-View-Controller (MVC) architecture.

## Features
* Add, update, and delete games from your personal catalog.
* Track completion status, scores, and playtime.
* Filter and search games by platform or genre.
* Persistent data storage using a relational database.

## Tech Stack
* **Language:** Java (JDK 21)
* **GUI Framework:** Java Swing
* **Architecture:** MVC (Model-View-Controller)
* **Database:** MySQL
* **Dependencies:**
  * MySQL Connector/J (JDBC driver for database connection)
  * Java Swing Layout (for UI component positioning)

## Prerequisites
To run this project locally, you will need:
* Java Development Kit (JDK) installed.
* NetBeans IDE (recommended, as this is an Ant-based project).
* MySQL Server (XAMPP/MySQL Workbench).

## Installation & Setup

1. **Clone the repository:**
   `git clone https://github.com/juaanmrtnn/GameLog.git`

2. **Database Setup:**
   * Open your MySQL client.
   * Run the provided SQL script located in the `database/gamelog_db.sql` folder to create the schema and tables.
   * Update the database credentials (username and password) in the `Persistencia.java` file to match your local setup.

3. **Run the Application:**
   * Open the project in NetBeans.
   * Ensure the libraries (`mysql-connector-java-8.0.15.jar` and `swing-layout-1.0.2.jar`) are correctly linked in the project properties (Libraries folder).
   * Build and Run the project (`F6`).
