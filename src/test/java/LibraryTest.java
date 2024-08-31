import org.example.Book;
import org.example.Librarian;
import org.example.Library;
import org.example.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * LibraryTest class contains test cases to verify the functionality
 * of the Library, Book, Librarian, and User classes.
 * It follows the Test-Driven Development (TDD) approach to ensure
 * all components of the Library Management System work as expected.
 */
public class LibraryTest {

    private Library library;
    private Book book;
    private Librarian librarian;
    private User user;

    /**
     * setUp method initializes common objects before each test case.
     * It creates instances of Library, Book, Librarian, and User for testing purposes.
     */
    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("1234567890", "1984", "George Orwell", 1949);
        librarian = new Librarian("Alice");
        user = new User("Bob");
    }

    /**
     * Tests that a librarian can successfully add a book to the library.
     */
    @Test
    public void testLibrarianCanAddBook() {
        librarian.addBook(library, book);
        assertEquals(1, library.getBooks().size(), "Library should contain 1 book after adding a book by librarian.");
        assertTrue(library.getBooks().containsValue(book), "The library should contain the book added by librarian.");
    }

    /**
     * Tests that a user can successfully add a book to the library.
     */
    @Test
    public void testUserCanAddBook() {
        user.addBook(library, book);
        assertEquals(1, library.getBooks().size(), "Library should contain 1 book after adding a book by user.");
        assertTrue(library.getBooks().containsValue(book), "The library should contain the book added by user.");
    }

    /**
     * Tests that duplicate books (same ISBN) are not added to the library.
     */
    @Test
    public void testAddDuplicateBook() {
        librarian.addBook(library, book);
        Book duplicateBook = new Book("1234567890", "1984", "George Orwell", 1949);
        librarian.addBook(library, duplicateBook);
        assertEquals(1, library.getBooks().size(), "Library should still contain 1 book after attempting to add a duplicate.");
    }

    /**
     * Tests that a book can be borrowed from the library, and its status is updated.
     */
    @Test
    public void testBorrowBook() {
        librarian.addBook(library, book);
        library.borrowBook("1234567890");
        assertTrue(book.isBorrowed(), "The book should be marked as borrowed.");
    }

    /**
     * Tests that attempting to borrow a nonexistent book throws an exception.
     */
    @Test
    public void testBorrowNonexistentBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("1111111111");
        });
        assertEquals("Book not available", exception.getMessage(), "Exception message should be 'Book not available'.");
    }

    /**
     * Tests that a book cannot be borrowed again if it is already borrowed.
     */
    @Test
    public void testBorrowAlreadyBorrowedBook() {
        librarian.addBook(library, book);
        library.borrowBook("1234567890");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.borrowBook("1234567890");
        });
        assertEquals("Book not available", exception.getMessage(), "Exception message should be 'Book not available' for already borrowed book.");
    }

    /**
     * Tests that a borrowed book can be returned to the library, and its status is updated.
     */
    @Test
    public void testReturnBook() {
        librarian.addBook(library, book);
        library.borrowBook("1234567890");
        library.returnBook("1234567890");
        assertFalse(book.isBorrowed(), "The book should be marked as not borrowed after return.");
    }

    /**
     * Tests that attempting to return a nonexistent book throws an exception.
     */
    @Test
    public void testReturnNonexistentBook() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("1111111111");
        });
        assertEquals("Book not found", exception.getMessage(), "Exception message should be 'Book not found' for non-existent book.");
    }

    /**
     * Tests that attempting to return a book that was not borrowed throws an exception.
     */
    @Test
    public void testReturnBookThatWasNotBorrowed() {
        librarian.addBook(library, book);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            library.returnBook("1234567890");
        });
        assertEquals("Book was not borrowed", exception.getMessage(), "Exception message should be 'Book was not borrowed'.");
    }

    /**
     * Tests that the library correctly lists available books.
     */
    @Test
    public void testViewAvailableBooks() {
        librarian.addBook(library, book);
        assertEquals(1, library.viewAvailableBooks().size(), "The library should have 1 available book.");
        assertTrue(library.viewAvailableBooks().contains(book), "The available book list should contain the book.");
    }

    /**
     * Tests that a borrowed book is no longer listed as available.
     */
    @Test
    public void testViewAvailableBooksAfterBorrowing() {
        librarian.addBook(library, book);
        library.borrowBook("1234567890");
        assertEquals(0, library.viewAvailableBooks().size(), "The library should have no available books after borrowing the only book.");
    }

    /**
     * Tests that the attributes of the book (ISBN, title, author, publication year) are correctly set.
     */
    @Test
    public void testBookAttributes() {
        assertEquals("1234567890", book.getIsbn(), "The ISBN should match the input value.");
        assertEquals("1984", book.getTitle(), "The title should match the input value.");
        assertEquals("George Orwell", book.getAuthor(), "The author should match the input value.");
        assertEquals(1949, book.getPublicationYear(), "The publication year should match the input value.");
    }

    /**
     * Tests that a newly added book is not marked as borrowed by default.
     */
    @Test
    public void testBookBorrowedStatusInitially() {
        assertFalse(book.isBorrowed(), "The book should not be marked as borrowed initially.");
    }

    /**
     * Tests that a new library is empty before any books are added.
     */
    @Test
    public void testLibraryIsEmptyInitially() {
        Library newLibrary = new Library();
        assertTrue(newLibrary.getBooks().isEmpty(), "A new library should be empty.");
    }

    /**
     * Tests that the library contains a book after it is added.
     */
    @Test
    public void testLibraryContainsBookAfterAdding() {
        librarian.addBook(library, book);
        assertTrue(library.getBooks().containsValue(book), "The library should contain the book after adding it.");
    }

    /**
     * Tests that a book's ISBN is not null.
     */
    @Test
    public void testIsbnNotNull() {
        assertNotNull(book.getIsbn(), "ISBN should not be null.");
    }

    /**
     * Tests that a book's ISBN can be an empty string.
     */
    @Test
    public void testIsbnIsEmpty() {
        book = new Book("", "1984", "George Orwell", 1949);
        assertTrue(book.getIsbn().isEmpty(), "ISBN should be empty.");
    }

    /**
     * Tests that a book's title is not null.
     */
    @Test
    public void testTitleIsNotNull() {
        assertNotNull(book.getTitle(), "Title should not be null.");
    }

    /**
     * Tests that a book's title can be an empty string.
     */
    @Test
    public void testTitleIsEmpty() {
        book = new Book("1234567890", "", "George Orwell", 1949);
        assertTrue(book.getTitle().isEmpty(), "Title should be empty.");
    }

    /**
     * Tests that a book's title can be null.
     */
    @Test
    public void testTitleNull() {
        book = new Book("1234567890", null, "George Orwell", 1949);
        assertNull(book.getTitle(), "Title should be null.");
    }

    /**
     * Tests that a book's author is not null.
     */
    @Test
    public void testAuthorIsNotNull() {
        assertNotNull(book.getAuthor(), "Author should not be null.");
    }

    /**
     * Tests that a book's author can be an empty string.
     */
    @Test
    public void testAuthorIsEmpty() {
        book = new Book("1234567890", "1984", "", 1949);
        assertTrue(book.getAuthor().isEmpty(), "Author should be empty.");
    }

    /**
     * Tests that a book's author can be null.
     */
    @Test
    public void testAuthorNull() {
        book = new Book("1234567890", "1984", null, 1949);
        assertNull(book.getAuthor(), "Author should be null.");
    }
    }

