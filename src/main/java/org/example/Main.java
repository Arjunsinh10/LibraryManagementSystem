package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Add a Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. View Available Books");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Are you a Librarian or User? (L/U): ");
                    String role = scanner.nextLine();
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    Person person;
                    if (role.equalsIgnoreCase("L")) {
                        person = new Librarian(name);
                    } else {
                        person = new User(name);
                    }

                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter Publication Year: ");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Book book = new Book(isbn, title, author, year);
                    person.addBook(library, book);
                    break;

                case 2:
                    System.out.print("Enter ISBN of the book to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    try {
                        library.borrowBook(borrowIsbn);
                        System.out.println("Book borrowed successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter ISBN of the book to return: ");
                    String returnIsbn = scanner.nextLine();
                    try {
                        library.returnBook(returnIsbn);
                        System.out.println("Book returned successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    System.out.println("Available books:");
                    for (Book b : library.viewAvailableBooks()) {
                        System.out.println(b.getTitle() + " by " + b.getAuthor());
                    }
                    break;

                case 5:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
