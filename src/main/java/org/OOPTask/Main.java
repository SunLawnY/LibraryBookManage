package org.OOPTask;

import org.OOPTask.Exception.DuplicateUserException;

public class Main {
    public static void main(String[] args) throws DuplicateUserException {
        Book book1 = new Book(123456789, "The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book(987654321, "1984", "George Orwell");
        Book book3 = new Book(112233445, "To Kill a Mockingbird", "Harper Lee");

        Library library = new Library();
        library.addNewBook(book1);
        library.addNewBook(book2);
        library.addNewBook(book3);
        User user1 = new User(1, "Alice");
        User user2 = new User(2, "Bob");
        User user3 = new User(3, "Charlie");
        library.addNewUser(user1);
        library.addNewUser(user2);
        library.addNewUser(user3);

        System.out.println(library.getAllUserInLibrary());

    }
}