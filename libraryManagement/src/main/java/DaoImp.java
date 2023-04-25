import org.hibernate.Session;
import org.hibernate.Transaction;

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
        System.out.println("enter name of library");
        String libraryName = bufferedReader.readLine();
        Library library = new Library();
        library.setName(libraryName);
        entityManager.persist(library);
        int choice;
        do {
            System.out.println("enter 1 to enter book\n0 to exit");
            choice = Integer.parseInt(bufferedReader.readLine());
            if (choice == 1) {
                System.out.println("enter name of book");
                String bookName = bufferedReader.readLine();
                System.out.println("enter name of author name");
                String authorName = bufferedReader.readLine();
                System.out.println("enter price of book");
                int price = Integer.parseInt(bufferedReader.readLine());
                System.out.println("enter Date of book");
                Date date = Date.valueOf(bufferedReader.readLine());
                System.out.println("enter name of publication");

                String publicationName = bufferedReader.readLine();
                Book book = new Book(bookName,authorName,publicationName,price,date,library);
                entityManager.persist(book);

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
            Library library = entityManager.find(Library.class,id);
            library.setName(newName);
            entityManager.merge(library);
            entityManager.getTransaction().commit();
        }else if(choice==2){
            System.out.println("enter new price book");
            int price= Integer.parseInt(bufferedReader.readLine());
            Book book = entityManager.find(Book.class,id);
            book.setPrice(price);
            entityManager.merge(book);
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
            Library library = entityManager.find(Library.class,id);
            entityManager.remove(library);
            entityManager.getTransaction().commit();
        }else if(choice==2){
            Book book = entityManager.find(Book.class,id);
            entityManager.remove(book);
            entityManager.getTransaction().commit();
        }
        entityManager.close();
    }

    public static void display() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<Book> bookList = entityManager.createQuery("from Book").getResultList();
        for(Book book : bookList){
            System.out.println(book);
        }
        entityManager.close();
    }

    public static void query1() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> bookRoot = criteriaQuery.from(Book.class);
        criteriaQuery.select(bookRoot);
        int price=400;
        criteriaQuery.where(criteriaBuilder.gt(bookRoot.<Number>get("price"), price));

        List<Book> bookList = entityManager.createQuery(criteriaQuery).getResultList();
        for(Book book : bookList){
            System.out.println(book);
        }
        entityManager.close();
    }

    public static void query2() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Book> criteriaQuery = criteriaBuilder.createQuery(Book.class);

        Root<Book> bookRoot = criteriaQuery.from(Book.class);
        criteriaQuery.select(bookRoot);
        criteriaQuery.orderBy(criteriaBuilder.asc(bookRoot.get("publisherName")));

        List<Book> bookList = entityManager.createQuery(criteriaQuery).getResultList();
        for(Book book : bookList){
            System.out.println(book);
        }
        entityManager.close();
    }
}
