import javax.persistence.*;
import java.util.List;

@Entity
public class Library {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @OneToMany(mappedBy = "library",cascade = CascadeType.ALL)
    List<Book> book;

    public Library() {
    }

    public Library(String name) {
        this.name = name;
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

    public List<Book> getBook() {
        return book;
    }

    public void setBook(List<Book> book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Library{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
