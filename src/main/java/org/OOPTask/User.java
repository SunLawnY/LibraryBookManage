package org.OOPTask;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String userName;
    private List<Book> borrowedBook;
    private List<BorrowRecord> borrowRecords;

    public User(int id, String username) {
        this.id = id;
        this.userName = username;
        this.borrowedBook = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
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

    public void addBorrowedRecord(BorrowRecord record){
        borrowRecords.add(record);
    }

    public void returnBorrowRecord(BorrowRecord record){
        for(BorrowRecord borrowRecord : borrowRecords){
            if(borrowRecord.getBook().equals(record.getBook()) && borrowRecord.getReturnDate() == null){
                borrowRecord.setReturnDate(record.getReturnDate());
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "User: " + getUserName();
    }
}
