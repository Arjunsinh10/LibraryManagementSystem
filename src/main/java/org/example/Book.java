package org.example;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private int publicationYear;
    private boolean borrowed;

    // Constructor to initialize a book
    public Book(String isbn, String title, String author, int publicationYear) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.borrowed = false; // Books are not borrowed by default
    }

    // Getter for ISBN
    public String getIsbn() {
        return isbn;
    }

    // Getter for Title
    public String getTitle() {
        return title;
    }

    // Getter for Author
    public String getAuthor() {
        return author;
    }

    // Getter for Publication Year
    public int getPublicationYear() {
        return publicationYear;
    }

    // Getter for Borrowed Status
    public boolean isBorrowed() {
        return borrowed;
    }

    // Setter for Borrowed Status
    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}
