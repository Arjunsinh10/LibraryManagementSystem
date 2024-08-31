public class LibraryTest {

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
}
