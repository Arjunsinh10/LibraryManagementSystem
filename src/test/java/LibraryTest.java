
import org.example.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions .*;


    public class LibraryTest {

        private Library library;
        private Book book;
        private Librarian librarian;
        private User user;

        @BeforeEach
        public void setUp() {
            library = new Library();
            book = new Book("1234567890", "1984", "George Orwell", 1949);
            librarian = new Librarian("Alice");
            user = new User("Bob");
        }

        @Test
        public void testLibrarianCanAddBook() {
            librarian.addBook(library, book);
            assertEquals(1, library.getBooks().size(), "Library should contain 1 book after adding a book by librarian.");
            assertTrue(library.getBooks().containsValue(book), "The library should contain the book added by librarian.");
        }


        @Test
        public void testUserCanAddBook() {
            user.addBook(library, book);
            assertEquals(1, library.getBooks().size(), "Library should contain 1 book after adding a book by user.");
            assertTrue(library.getBooks().containsValue(book), "The library should contain the book added by user.");
        }

        @Test
        public void testAddDuplicateBook() {
            librarian.addBook(library, book);
            Book duplicateBook = new Book("1234567890", "1984", "George Orwell", 1949);
            librarian.addBook(library, duplicateBook);
            assertEquals(1, library.getBooks().size(), "Library should still contain 1 book after attempting to add a duplicate.");
        }

        @Test
        public void testBorrowBook() {
            librarian.addBook(library, book);
            library.borrowBook("1234567890");
            assertTrue(book.isBorrowed(), "The book should be marked as borrowed.");
        }

        @Test
        public void testBorrowNonexistentBook() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                library.borrowBook("1111111111");
            });
            assertEquals("Book not available", exception.getMessage(), "Exception message should be 'Book not available'.");
        }

        @Test
        public void testBorrowAlreadyBorrowedBook() {
            librarian.addBook(library, book);
            library.borrowBook("1234567890");
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                library.borrowBook("1234567890");
            });
            assertEquals("Book not available", exception.getMessage(), "Exception message should be 'Book not available' for already borrowed book.");
        }

        @Test
        public void testReturnBook() {
            librarian.addBook(library, book);
            library.borrowBook("1234567890");
            library.returnBook("1234567890");
            assertFalse(book.isBorrowed(), "The book should be marked as not borrowed after return.");
        }

        @Test
        public void testReturnNonexistentBook() {
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                library.returnBook("1111111111");
            });
            assertEquals("Book not found", exception.getMessage(), "Exception message should be 'Book not found' for non-existent book.");
        }

        @Test
        public void testReturnBookThatWasNotBorrowed() {
            librarian.addBook(library, book);
            Exception exception = assertThrows(IllegalArgumentException.class, () -> {
                library.returnBook("1234567890");
            });
            assertEquals("Book was not borrowed", exception.getMessage(), "Exception message should be 'Book was not borrowed'.");
        }

        @Test
        public void testViewAvailableBooks() {
            librarian.addBook(library, book);
            assertEquals(1, library.viewAvailableBooks().size(), "The library should have 1 available book.");
            assertTrue(library.viewAvailableBooks().contains(book), "The available book list should contain the book.");
        }

        @Test
        public void testViewAvailableBooksAfterBorrowing() {
            librarian.addBook(library, book);
            library.borrowBook("1234567890");
            assertEquals(0, library.viewAvailableBooks().size(), "The library should have no available books after borrowing the only book.");
        }

        @Test
        public void testBookAttributes() {
            assertEquals("1234567890", book.getIsbn(), "The ISBN should match the input value.");
            assertEquals("1984", book.getTitle(), "The title should match the input value.");
            assertEquals("George Orwell", book.getAuthor(), "The author should match the input value.");
            assertEquals(1949, book.getPublicationYear(), "The publication year should match the input value.");
        }

        @Test
        public void testBookBorrowedStatusInitially() {
            assertFalse(book.isBorrowed(), "The book should not be marked as borrowed initially.");
        }

        @Test
        public void testLibraryIsEmptyInitially() {
            Library newLibrary = new Library();
            assertTrue(newLibrary.getBooks().isEmpty(), "A new library should be empty.");
        }

        @Test
        public void testLibraryContainsBookAfterAdding() {
            librarian.addBook(library, book);
            assertTrue(library.getBooks().containsValue(book), "The library should contain the book after adding it.");
        }
    }



