import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

public class DaoImp {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("yash");
    public static void insert() throws IOException {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        System.out.println("enter name of zoo");
        String libraryName = bufferedReader.readLine();
        Zoo zoo = new Zoo();
        zoo.setName(libraryName);
        entityManager.persist(zoo);
        int choice;
        do {
            System.out.println("enter 1 to enter animal\n0 to exit");
            choice = Integer.parseInt(bufferedReader.readLine());
            if (choice == 1) {
                System.out.println("enter name of animal");
                String animalName = bufferedReader.readLine();
                System.out.println("enter the type of animal");
                String type = bufferedReader.readLine();
                System.out.println("enter age of animal");
                int age = Integer.parseInt(bufferedReader.readLine());
                System.out.println("enter Date of book");

                Animal animal = new Animal(animalName,age,type,zoo);
                entityManager.persist(animal);

            }
        }while(choice!=0);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static void update() throws IOException {
        System.out.println("enter 1 for library update \n enter 2 for book update ");
        int choice = Integer.parseInt(bufferedReader.readLine());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        System.out.println("Enter the id to be update");
        int id = Integer.parseInt(bufferedReader.readLine());
        entityManager.getTransaction().begin();
        if(choice==1){
            String newName = bufferedReader.readLine();
            Zoo zoo = entityManager.find(Zoo.class,id);
            zoo.setName(newName);
            entityManager.merge(zoo);
            entityManager.getTransaction().commit();
        }else if(choice==2){
            System.out.println("enter new age of animal");
            int age= Integer.parseInt(bufferedReader.readLine());
            Animal animal = entityManager.find(Animal.class,id);
            animal.setAge(age);
            entityManager.merge(animal);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public static void delete() throws IOException {
        System.out.println("enter 1 for library delete \n enter 2 for book delete ");
        int choice = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Enter the id to be deleted");
        int id = Integer.parseInt(bufferedReader.readLine());
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        if(choice==1){
            Zoo zoo = entityManager.find(Zoo.class,id);
            entityManager.remove(zoo);
            entityManager.getTransaction().commit();
        }else if(choice==2){
            Animal animal = entityManager.find(Animal.class,id);
            entityManager.remove(animal);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public static void display() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Animal> animalList = entityManager.createQuery("from Animal").getResultList();
        for(Animal animal: animalList){
            System.out.println(animal);
        }
        entityManager.close();
    }

    public static void query1() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = criteriaBuilder.createQuery(Animal.class);

        Root<Animal> bookRoot = criteriaQuery.from(Animal.class);
        criteriaQuery.select(bookRoot);
        int age=4;
        criteriaQuery.where(criteriaBuilder.gt(bookRoot.<Number>get("age"), age));

        List<Animal> animalList = entityManager.createQuery(criteriaQuery).getResultList();
        for(Animal animal:animalList){
            System.out.println(animal);
        }
        entityManager.close();
    }

    public static void query2() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = criteriaBuilder.createQuery(Animal.class);
        Root<Animal> bookRoot = criteriaQuery.from(Animal.class);
        criteriaQuery.select(bookRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(bookRoot.get("type")));
        List<Animal> animalList = entityManager.createQuery(criteriaQuery).getResultList();
        for(Animal animal:animalList){
            System.out.println(animal);
        }
        entityManager.close();
    }
}
