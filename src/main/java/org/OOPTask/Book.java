package org.OOPTask;

public class Book {
    private int isbn;
    private String bookName;
    private String bookAuthor;
    private boolean isAvailable;

    public Book(int isbn, String bookName, String bookAuthor) {
        this.isbn = isbn;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.isAvailable = true;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Book: " + getBookName();
    }
}
