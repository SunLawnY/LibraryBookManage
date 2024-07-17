package org.OOPTask;

import org.OOPTask.Exception.BookNotFoundException;
import org.OOPTask.Exception.DuplicateUserException;
import org.OOPTask.Exception.UserNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    Library testLibrary = new Library();

    @Test
    void addNewBook() {
        Book test = new Book(12345, "TestBook", "TestAuthor");
        testLibrary.addNewBook(test);

        assertEquals(testLibrary.getAllBooksInLibrary().size(),1);
        Book test2 = new Book(22345, "TestBook2", "TestAuthor2");
        testLibrary.addNewBook(test2);
        assertEquals(testLibrary.getAllBooksInLibrary().size(),2);
    }

    @Test
    void removeBook() throws BookNotFoundException {
        Book test = new Book(12345, "TestBook", "TestAuthor");
        Book test2 = new Book(22345, "TestBook2", "TestAuthor2");
        testLibrary.addNewBook(test);
        testLibrary.addNewBook(test2);
        assertEquals(testLibrary.getAllBooksInLibrary().size(),2);
        testLibrary.removeBook(test);
        assertEquals(testLibrary.getAllBooksInLibrary().size(), 1);
    }

    @Test
    void addNewUser() throws DuplicateUserException {
        User test1 = new User(1, "test1");
        User test2 = new User(2, "test2");
        testLibrary.addNewUser(test1);
        testLibrary.addNewUser(test2);
        assertEquals(testLibrary.getAllUsersInLibrary().size(), 2);
    }

    @Test
    void removeUser() throws DuplicateUserException, UserNotFoundException {
        User test1 = new User(1, "test1");
        User test2 = new User(2, "test2");
        testLibrary.addNewUser(test1);
        testLibrary.addNewUser(test2);
        assertEquals(testLibrary.getAllUsersInLibrary().size(), 2);
        testLibrary.removeUser(test2);
        assertEquals(testLibrary.getAllUsersInLibrary().size(), 1);
    }

    @Test
    void bookBorrowedByUser() throws UserNotFoundException, BookNotFoundException, DuplicateUserException {
        Book testBook1 = new Book(12345, "TestBook", "TestAuthor");
        Book testBook2 = new Book(22345, "TestBook2", "TestAuthor2");
        testLibrary.addNewBook(testBook1);
        testLibrary.addNewBook(testBook2);
        User testUser1 = new User(1, "test1");
        User testUser2 = new User(2, "test2");
        testLibrary.addNewUser(testUser1);
        testLibrary.addNewUser(testUser2);

        testLibrary.bookBorrowedByUser(testUser1, testBook1);
        assertEquals(testLibrary.getAllBooksInLibrary().size(), 1);
        assertEquals(testUser1.getBorrowedBook().getFirst(), testBook1);
        assertEquals(testLibrary.getAllBooksInLibrary().getFirst(), testBook2);
    }

    @Test
    void bookReturnedByUser() throws DuplicateUserException, UserNotFoundException, BookNotFoundException {
        Book testBook1 = new Book(12345, "TestBook", "TestAuthor");
        Book testBook2 = new Book(22345, "TestBook2", "TestAuthor2");
        testLibrary.addNewBook(testBook1);
        testLibrary.addNewBook(testBook2);
        User testUser1 = new User(1, "test1");
        User testUser2 = new User(2, "test2");
        testLibrary.addNewUser(testUser1);
        testLibrary.addNewUser(testUser2);
        testLibrary.bookBorrowedByUser(testUser2, testBook2);

        assertFalse(testBook2.isAvailable());
        assertEquals(testLibrary.getAllBooksInLibrary().size(), 2);
        assertEquals(testUser2.getBorrowedBook().size(), 1);
        assertEquals(testUser2.getBorrowedBook().getFirst(), testBook2);
        assertEquals(testLibrary.getAllBooksInLibrary().getFirst(), testBook1);

        testLibrary.bookReturnedByUser(testUser2, testBook2);

        assertEquals(testLibrary.getAllBooksInLibrary().size(), 2);
        assertTrue(testBook2.isAvailable());
        assertEquals(testUser2.getBorrowedBook().size(), 0);
    }
}