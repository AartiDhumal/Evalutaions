import javax.persistence.*;
import java.util.List;

@Entity
public class Zoo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @OneToMany(mappedBy = "zoo",cascade = CascadeType.ALL)
    List<Animal> animalList;

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

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void setAnimalList(List<Animal> animalList) {
        this.animalList = animalList;
    }

    public Zoo() {
    }

    public Zoo(String name) {
        this.name = name;
    }

    public Zoo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Zoo(int id, String name, List<Animal> animalList) {
        this.id = id;
        this.name = name;
        this.animalList = animalList;
    }

    @Override
    public String toString() {
        return "Zoo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
