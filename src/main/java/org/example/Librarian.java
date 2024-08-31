

public class Librarian extends Person {

    public Librarian(String name) {
        super(name);
    }

    @Override
    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("Librarian " + getName() + " added the book: " + book.getTitle());
    }
}
