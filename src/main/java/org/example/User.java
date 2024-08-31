package org.example;

public class User extends Person {

    public User(String name) {
        super(name);
    }

    @Override
    public void addBook(Library library, Book book) {
        library.addBook(book);
        System.out.println("User " + getName() + " added the book: " + book.getTitle());
    }
}
