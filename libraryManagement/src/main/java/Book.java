import javax.persistence.*;
import java.sql.Date;
@Entity
public class Book {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name,authorName,publisherName;
    int price;
    Date date;
    @ManyToOne
    Library library;

    public Book(int id, String name, String authorName, String publisherName, int price, Date date, Library library) {
        this.id = id;
        this.name = name;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.price = price;
        this.date = date;
        this.library = library;
    }

    public Book() {
    }

    public Book(String name, String authorName, String publisherName, int price, Date date) {
        this.name = name;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.price = price;
        this.date = date;
    }

    public Book(String name, String authorName, String publisherName, int price, Date date, Library library) {
        this.name = name;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.price = price;
        this.date = date;
        this.library = library;
    }

    public Book(String name, String authorName, String publisherName, Date date, Library library) {
        this.name = name;
        this.authorName = authorName;
        this.publisherName = publisherName;
        this.date = date;
        this.library = library;
    }

    public Book(String name, String authorName, String publisherName, Date date) {
        this.name = name;
        this.authorName = authorName;
        this.publisherName = publisherName;
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publisherName='" + publisherName + '\'' +
                ", price=" + price +
                ", date=" + date +
                ", library=" + library +
                '}';
    }
}
