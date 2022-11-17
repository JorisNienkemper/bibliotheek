package nl.bld.bibliotheek.app.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Member {
    @Id
    @SequenceGenerator(name = "user_sequence", sequenceName = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    private long id;

    @Column(unique = true)
    private String userName;

    @OneToMany
    Set<Book> books = new HashSet<>();

    public long getId() {
        return id;
    }

     public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Member(String userName, Set<Book> books) {
        this.userName = userName;
        this.books = books;
    }

    public Member() {
    }

    public void addBookToList(){
        this.books = books;
    }
}
