package org.OOPTask;

import org.OOPTask.Exception.BookNotFoundException;
import org.OOPTask.Exception.DuplicateUserException;
import org.OOPTask.Exception.UserNotFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> booksInLibrary;
    private List<User> usersInLibrary;
    private List<BorrowRecord> borrowRecords;

    public Library() {
        this.booksInLibrary = new ArrayList<>();
        this.usersInLibrary = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    public List<Book> addNewBook(Book book){
        booksInLibrary.add(book);
        System.out.println(book.getBookName() + " has been added to the Library system");
        return booksInLibrary;
    }

    public List<Book> removeBook(Book book) throws BookNotFoundException {
        if(booksInLibrary.contains(book)) {
            booksInLibrary.remove(book);
            System.out.println(book.getBookName() + " has been removed from the Library system");
        } else {
            throw new BookNotFoundException("Book not found in the library.");
        }
        return booksInLibrary;
    }

    public List<User> addNewUser(User user) throws DuplicateUserException {
        if(usersInLibrary.contains(user)) {
            throw new DuplicateUserException("User already exists in the library.");
        } else {
            usersInLibrary.add(user);
            System.out.println(user + " has been added to the Library system");
            return usersInLibrary;
        }
    }

    public List<User> removeUser(User user) throws UserNotFoundException {
        if(usersInLibrary.contains(user)) {
            usersInLibrary.remove(user);
            System.out.println(user + " has been removed from the Library system");
        } else {
            throw new UserNotFoundException("User not found in the library.");
        }
        return usersInLibrary;
    }

    public void bookBorrowedByUser(User user, Book book) throws BookNotFoundException, UserNotFoundException {
        if (!usersInLibrary.contains(user)){
            throw new UserNotFoundException("User not found in the library.");
        }
        if (!booksInLibrary.contains(book) || !book.isAvailable()){
            throw new BookNotFoundException("Book not available in the library.");
        }
        user.addBorrowedBook(book);
        book.setAvailable(false);
        BorrowRecord record = new BorrowRecord(user, book, LocalDateTime.now());
        user.addBorrowedRecord(record);
        borrowRecords.add(record);
        System.out.println(user.getUserName() + " borrowed " + book.getBookName());
    }

    public void bookReturnedByUser(User user, Book book) throws UserNotFoundException, BookNotFoundException {
        if (!usersInLibrary.contains(user)){
            throw new UserNotFoundException("User not found in the library.");
        }
        if (!user.getBorrowedBook().contains(book)){
            throw new BookNotFoundException("Book not borrowed by this user.");
        }
        user.returnBook(book);
        book.setAvailable(true);
        BorrowRecord returnRecord = new BorrowRecord(user, book, null);
        returnRecord.setReturnDate(LocalDateTime.now());
        user.returnBorrowRecord(returnRecord);
        System.out.println(user.getUserName() + " returned " + book.getBookName());
    }

    public List<Book> getAllBooksInLibrary() {
        return booksInLibrary;
    }

    public List<User> getAllUsersInLibrary() {
        return usersInLibrary;
    }

    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecords;
    }
}
