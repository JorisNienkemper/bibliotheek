package nl.bld.bibliotheek.app.domain;


import jakarta.persistence.*;

@Entity
public class Loan {

    @Id
    @GeneratedValue
    private long id;

    @OneToOne
    private Book book;

    @ManyToOne
    private  Member member;

    public Loan (Book book, Member member) {
        setBook(book);
        setMember(member);
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}
