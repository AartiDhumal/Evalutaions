import javax.persistence.*;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(joinColumns = {@JoinColumn(name="id")})
    @OrderColumn(name="type")
    List<Product> productList;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, String password, List<Product> productList) {
        this.name = name;
        this.password = password;
        this.productList = productList;
    }

    public Customer(String name, List<Product> productList) {
        this.name = name;
        this.productList = productList;
    }

    public Customer(int id, String name, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
    }

    public Customer(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Customer(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public Customer(int id, String name, String password, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.productList = productList;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
