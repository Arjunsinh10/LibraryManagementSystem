import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class Library {
    private Map<String, Book> books = new HashMap<>();

    // Adds a new book to the library
    public void addBook(Book book) {
        if (!books.containsKey(book.getIsbn())) {
            books.put(book.getIsbn(), book);
        }
    }

    // Checks if a book is available in the library
    public boolean isBookAvailable(String isbn) {
        return books.containsKey(isbn) && !books.get(isbn).isBorrowed();
    }

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
