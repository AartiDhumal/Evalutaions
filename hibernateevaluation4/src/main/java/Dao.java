import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    public static void insert() throws IOException, ParseException {
        System.out.println("enter name of author");
        String authorName = bufferedReader.readLine();
        Author author = new Author(authorName);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(author);
        int choice;
        do {
            System.out.println("enter 1 to enter book\n0 to exit");
            choice = Integer.parseInt(bufferedReader.readLine());
            if (choice == 1) {
                System.out.println("enter name of book");
                String bookName = bufferedReader.readLine();
                System.out.println("enter price of book");
                int price = Integer.parseInt(bufferedReader.readLine());
                System.out.println("enter Date of book");

                System.out.println("enter name of publication");
                Date date = Date.valueOf(bufferedReader.readLine());
                String publicationName = bufferedReader.readLine();
                Book book = new Book(bookName, price, date,author);
                session.save(book);
                Publication publication = new Publication(publicationName,book);

                session.save(publication);
                transaction.commit();

            }
        }while(choice!=0);



        session.close();
    }

    public static void update() throws IOException {

        System.out.println("enter 1 for author update \n enter 2 for book update \nenter 3 for publication update ");
        int choice = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Enter the id to be update");
        int id = Integer.parseInt(bufferedReader.readLine());
        Session session = sessionFactory.openSession();;
        Transaction transaction = session.beginTransaction();
        if(choice==1){
            String newName = bufferedReader.readLine();
            Author author = session.get(Author.class,id);
            author.setName(newName);
            session.update(author);
            transaction.commit();
        }else if(choice==2){
            System.out.println("enter new price book");
            int price= Integer.parseInt(bufferedReader.readLine());
            Book book = session.get(Book.class,id);
            book.setPrice(price);
            session.update(book);
            transaction.commit();
        }else if(choice==3){
            System.out.println("enter name of publisher of Book");
            Publication publication = session.get(Publication.class,id);
            publication.setName(bufferedReader.readLine());
            session.update(publication);
            transaction.commit();
        }
        session.close();

    }

    public static void delete() throws IOException {
        System.out.println("enter 1 for author delete \n enter 2 for book delete \nenter 3 for publication delete ");
        int choice = Integer.parseInt(bufferedReader.readLine());

        System.out.println("Enter the id to be deleted");
        int id = Integer.parseInt(bufferedReader.readLine());
        Session session = sessionFactory.openSession();;
        Transaction transaction = session.beginTransaction();
        if(choice==1){
            Author author = session.get(Author.class,id);
            session.delete(author);
            transaction.commit();
        }else if(choice==2){
            Book book = session.get(Book.class,id);
            session.delete(book);
            transaction.commit();
        }else if(choice==3){
            Publication publication = session.get(Publication.class,id);
            session.delete(publication);
            transaction.commit();
        }
        session.close();

    }

    public static void display() {
        Session session = sessionFactory.openSession();
        List<Publication> authorList  = session.createQuery("from Publication").list();
        session.close();
        for(Publication publication:authorList){
            System.out.println(publication);
        }
    }

    public static void publisher() {
        Session session = sessionFactory.openSession();
        List<Book> bookList = session.createQuery("from Book where date>='2021-01-01'").list();
        for(Book book:bookList){
            System.out.println(book.author.getName());
        }
        session.close();

    }

    public static void nirali() {
        Session session = sessionFactory.openSession();
        List<Publication> bookList = session.createQuery("from Publication where name ='nirali'").list();
        for(Publication publication:bookList){
            if(publication.book.getPrice()>500){
                System.out.println(publication.book.name);
            }
        }
        session.close();
    }

    public static void author() {
        Session session = sessionFactory.openSession();
        List<Author> authorList = session.createQuery("from Author where name like 'a%i'").list();
        for(Author author:authorList){
            System.out.println(author);
        }
        session.close();
    }
}
