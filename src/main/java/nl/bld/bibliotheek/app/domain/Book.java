package nl.bld.bibliotheek.app.domain;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id
    @SequenceGenerator(name = "book_sequence", sequenceName = "book_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_sequence")
    public long serialNumber;
    public String bookTitle;
    public String authorName;
    public int bookQuantity;

    public Book(String bookTitle, String authorName, int bookQuantity) {
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.bookQuantity = bookQuantity;
        }


    public Book(String authorTitle, String bookTitle) {
        this.bookTitle = bookTitle;
        this.authorName = authorTitle;
    }

    public Book() {
    }

    public long getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(long serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }

}
