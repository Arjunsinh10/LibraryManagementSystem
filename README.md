# Library Management System

## Project Description
The **Library Management System** is a Java-based application designed to manage a library's operations, including adding books, borrowing books, returning books, and viewing available books. This project was developed following the Test-Driven Development (TDD) methodology using **JUnit 5** for testing, ensuring high code quality, maintainability, and reliability.

## Features
- **Add Books**: Allows librarians and users to add new books to the library.
- **Borrow Books**: Users can borrow available books.
- **Return Books**: Users can return borrowed books.
- **View Available Books**: Displays a list of all available books in the library.
- **Main Menu**: Provides an interactive console-based menu for users to choose their desired operation.

## Project Structure
The project consists of the following main classes:
- **`Book.java`**: Represents a book entity with properties like title, author, and availability status.
- **`Library.java`**: Manages the collection of books and handles operations such as adding, borrowing, and returning books.
- **`Main.java`**: Contains the main method and user interface for interacting with the system.
- **`Person.java`**: A superclass for entities that can interact with the library (e.g., librarians and users).
- **`User.java`**: Represents a user who can perform actions like borrowing and returning books.
- **`Librarian.java`**: Represents a librarian with the authority to manage the library's book inventory, including adding new books.
- **`LibrarryTest.java`**: Contains unit tests using **JUnit 5** to validate the functionality of the `Library` class and other core features of the system.

## Test-Driven Development (TDD) Approach
This project was developed using the TDD approach, which involves the following steps:

1. **Write Tests**: Before implementing any feature, test cases were written in `LibrarryTest.java` using **JUnit 5** to define the expected behavior of the functionality.
2. **Implement Code**: Code was implemented to make the tests pass.
3. **Refactor**: After ensuring the tests passed, the code was refactored for optimization and clarity.
4. **Run Tests**: The tests were rerun to ensure that the refactored code still met the requirements.

## Running the Project

### Prerequisites
- **Java Development Kit (JDK)**: Ensure that JDK 8 or higher is installed on your machine.
- **Git**: Ensure that Git is installed for version control.

### Steps to Run

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Arjunsinh10/LibraryManagementSystem
   cd library-management-system

 2.  **Compile the Project**: Navigate to the project directory and compile the Java files:

    javac -d bin src/*.java

3. **Run the Application**: Execute the main class to start the Library Management System:
   ```bash
    java -cp bin Main
4.**Run Unit Tests**: To run the unit tests in LibrarryTest.java, use the following command:

    java -cp bin org.junit.platform.console.ConsoleLauncher -c LibrarryTest

## Version Control and Commit Guidelines

## Commit Structure

When making commits, follow this structure to maintain clarity and consistency:
## Add Feature:
    git commit -m "Add [FeatureName]: Implemented [feature description]."
## Write Tests:
    git commit -m "Write Test: Added tests for [feature] using JUnit 5."
## Fix Issue:
    git commit -m "Fix [IssueName]: Resolved [issue description]."
## Refactor Code:
    git commit -m "Refactor [ComponentName]: Improved code structure and readability."

## Conclusion
This Library Management System is a robust and flexible solution for managing library operations. By following the TDD approach and using JUnit 5 for testing, the project ensures that each feature is thoroughly tested and meets the requirements, making it easier to maintain and extend.

