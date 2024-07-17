package org.OOPTask;

import org.OOPTask.Exception.BookNotFoundException;
import org.OOPTask.Exception.DuplicateUserException;
import org.OOPTask.Exception.UserNotFoundException;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book(1, "Book One", "Author One");
        Book book2 = new Book(2, "Book Two", "Author Two");

        library.addNewBook(book1);
        library.addNewBook(book2);

        User user1 = new User(1, "User One");
        User user2 = new User(2, "User Two");

        try {
            library.addNewUser(user1);
            library.addNewUser(user2);
        } catch (DuplicateUserException e) {
            e.printStackTrace();
        }

        try {
            library.bookBorrowedByUser(user1, book1);
            library.bookBorrowedByUser(user2, book2);
        } catch (BookNotFoundException | UserNotFoundException e) {
            e.printStackTrace();
        }

        try {
            library.bookReturnedByUser(user1, book1);
        } catch (UserNotFoundException | BookNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Books in Library: " + library.getAllBooksInLibrary());
        System.out.println("Users in Library: " + library.getAllUsersInLibrary());
        System.out.println("Borrow Records: " + library.getAllBorrowRecords());
    }
}
