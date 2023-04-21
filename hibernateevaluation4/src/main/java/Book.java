import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;


@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int price;
    Date date;
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "book")
    Publication publication;
@ManyToOne
    Author author;

    public Book(int id, String name, int price, Date date, Publication publication, Author author) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.publication = publication;
        this.author = author;
    }

    public Book(String name, int price, Date date, Publication publication, Author author) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.publication = publication;
        this.author = author;
    }

    public Book(String name, int price, Date date, Author author) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.author = author;
    }

    public Book(String name, int price, Date date, Publication publication, String author_name) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.publication = publication;

    }

    public Book() {
    }

    public Book(int id, String name, int price, Date date, Publication publication) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.date = date;
        this.publication = publication;
    }

    public Book(String name, int price, Date date, Publication publication) {
        this.name = name;
        this.price = price;
        this.date = date;
        this.publication = publication;
    }

    public Book(String name, int price, Date date) {
        this.name = name;
        this.price = price;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Publication getPublication() {
        return publication;
    }

    public void setPublication(Publication publication) {
        this.publication = publication;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", author=" + author +
                '}';
    }
}
