package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

/**
 * The Library class represents a collection of books that can be added, borrowed, and returned.
 * It maintains a map of books identified by their ISBN numbers.
 */
public class Library {
    private Map<String, Book> books = new HashMap<>();
    /**
     * Adds a new book to the library.
     * If the book with the same ISBN already exists, it will not be added again.
     *
     * @param book The book to be added to the library.
     */
    // Adds a new book to the library
    public void addBook(Book book) {
        if (!books.containsKey(book.getIsbn())) {
            books.put(book.getIsbn(), book);
        }
    }
    /**
     * Checks if a book is available in the library.
     * A book is considered available if it exists in the library and is not currently borrowed.
     *
     * @param isbn The ISBN of the book to check.
     * @return True if the book is available, false otherwise.
     */
    // Checks if a book is available in the library
    public boolean isBookAvailable(String isbn) {
        return books.containsKey(isbn) && !books.get(isbn).isBorrowed();
    }
    /**
     * Borrows a book from the library.
     * The book must be available (not currently borrowed) to be successfully borrowed.
     *
     * @param isbn The ISBN of the book to borrow.
     * @throws IllegalArgumentException if the book is not available.
     */
    // Borrows a book from the library if available
    public void borrowBook(String isbn) {
        if (books.containsKey(isbn)) {
            Book book = books.get(isbn);
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
            } else {
                throw new IllegalArgumentException("Book not available");
            }
        } else {
            throw new IllegalArgumentException("Book not available");
        }
    }
    /**
     * Returns a borrowed book to the library.
     * The book must be borrowed before it can be returned.
     *
     * @param isbn The ISBN of the book to return.
     * @throws IllegalArgumentException if the book is not found or was not borrowed.
     */
    // Returns a borrowed book to the library
    public void returnBook(String isbn) {
        if (books.containsKey(isbn)) {
            Book book = books.get(isbn);
            if (book.isBorrowed()) {
                book.setBorrowed(false);
            } else {
                throw new IllegalArgumentException("Book was not borrowed");
            }
        } else {
            throw new IllegalArgumentException("Book not found");
        }
    }

    /**
     * Returns a list of all available books in the library.
     * An available book is one that is not currently borrowed.
     *
     * @return A list of available books.
     */

    // Returns a list of all available books in the library
    public List<Book> viewAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books.values()) {
            if (!book.isBorrowed()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    // Returns the map of all books (for testing purposes)
    public Map<String, Book> getBooks() {
        return books;
    }
}
