package org.OOPTask;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String userName;
    private List<Book> borrowedBook;

    public User(int id, String username) {
        this.id = id;
        this.userName = username;
        this.borrowedBook = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Book> getBorrowedBook() {
        return borrowedBook;
    }

    public void addBorrowedBook(Book book) {
        borrowedBook.add(book);
    }

    public void returnBook(Book book){
        borrowedBook.remove(book);
    }

    @Override
    public String toString() {
        return "User: " + getUserName();
    }
}
