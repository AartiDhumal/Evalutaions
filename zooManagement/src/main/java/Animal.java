import javax.persistence.*;

@Entity
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int age;
    String type;
    @ManyToOne
    Zoo zoo;

    public Animal() {
    }

    public Animal(String name, int age, String type, Zoo zoo) {
        this.name = name;
        this.age = age;
        this.type = type;
        this.zoo = zoo;
    }

    public Animal(int id, String name, int age, String type, Zoo zoo) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.type = type;
        this.zoo = zoo;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", type='" + type + '\'' +
                ", zoo=" + zoo +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Zoo getZoo() {
        return zoo;
    }

    public void setZoo(Zoo zoo) {
        this.zoo = zoo;
    }
}
