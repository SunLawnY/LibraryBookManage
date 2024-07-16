package org.OOPTask;

import org.OOPTask.Exception.BookNotFoundException;
import org.OOPTask.Exception.DuplicateUserException;
import org.OOPTask.Exception.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksInLibrary;
    private List<User> usersInLibrary;

    public Library() {
        this.booksInLibrary = new ArrayList<>();
        this.usersInLibrary = new ArrayList<>();
    }

    public List<Book> addNewBook(Book book){
        booksInLibrary.add(book);
        System.out.println(book.getBookName() + " has added to Library system");
        return booksInLibrary;
    }

    public List<Book> removeBook(Book book) throws BookNotFoundException {
        if(booksInLibrary.contains(book)) {
            booksInLibrary.remove(book);
            System.out.println(book.getBookName() + " has removed from Library system");
        } else {
            throw new BookNotFoundException();
        }
        return booksInLibrary;
    }

    public List<User> addNewUser(User user) throws DuplicateUserException {
        if(usersInLibrary.contains(user)) {
            throw new DuplicateUserException();
        } else {
            usersInLibrary.add(user);
            System.out.println(user + " has added to Library system");
            return usersInLibrary;
        }
    }

    public List<User> removeUser(User user){
        usersInLibrary.remove(user);
        return usersInLibrary;
    }

    public List<Book> bookBorrowedByUser(User user, Book book) throws BookNotFoundException, UserNotFoundException {
        if (!usersInLibrary.contains(user)){
            throw new UserNotFoundException();
        }
        if (!booksInLibrary.contains(book)){
            throw new BookNotFoundException();
        }
        user.addBorrowedBook(book);
        booksInLibrary.remove(book);
        return user.getBorrowedBook();
    }

    public List<Book> bookReturnedByUser(User user, Book book) throws UserNotFoundException, BookNotFoundException {
        if (!usersInLibrary.contains(user)){
            throw new UserNotFoundException();
        }
        if (!user.getBorrowedBook().contains(book)){
            throw new BookNotFoundException();
        }
        user.returnBook(book);
        booksInLibrary.add(book);
        return booksInLibrary;
    }

    public List<Book> getAllBooksInLibrary() {
        return booksInLibrary;
    }

    public List<User> getAllUserInLibrary() {
        return usersInLibrary;
    }
}
