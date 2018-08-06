package train.abromand.spring5webapp.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO )
    private Long id;
    private String title;
    private String isbn;
    private String publisher;

    @ManyToMany
    @JoinTable( name = "author_book", joinColumns = @JoinColumn( name = "book_id"),
            inverseJoinColumns = @JoinColumn( name = "author_id" ) )
    private Set<Author> authors = new HashSet<>();
    public Book() {

    }
    public Book( String title, String isbn, String publisher ) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
    }
    public Book( String title, String isbn, String publisher, Set<Author> authors ) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authors = authors;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getTitleName() { return title; }
    public void setTitleName( String title ) {
        this.title = title;
    }
    public String getIsnbName() { return isbn; }
    public void setIsbnName( String isbn ) {
        this.isbn = isbn;
    }
    public String getPublisher() { return publisher; }
    public void setPublisher( String publisher ) {
        this.publisher = publisher;
    }
    public Set<Author> getAuthors() { return authors; }
    public void setFirstName( Set<Author> authors ) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return id != null ? id.equals(book.id) : book.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
