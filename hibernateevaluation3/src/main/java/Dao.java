import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Dao {
    static Configuration configuration = new Configuration().configure();
    static SessionFactory sessionFactory = configuration.buildSessionFactory();
    public static Customer loginCheck(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = sessionFactory.openSession();

        System.out.println(request.getParameter("name")+" "+request.getParameter("pass"));
        Query query = session.createQuery("from Customer where name ='"+request.getParameter("name")+"' and password = '"+request.getParameter("pass")+"'");
        List<Customer> list=query.list();
        if(list.size()!=0){
            HttpSession session1 = request.getSession();
            System.out.println("login done");
            session1.setAttribute("cust",list.get(0));
            session1.setAttribute("userId",list.get(0).getId());
            session1.setAttribute("email",list.get(0).getName());
            session1.setAttribute("id",list.get(0).getName());
            System.out.println("session created");

        }
        else{
            PrintWriter out = response.getWriter();
            out.println("Wrong Id or Wrong Password");
            request.getRequestDispatcher("login.jsp").include(request,response);
        }
        session.close();
        return list.get(0);
    }
    public static List<Customer> selectAllCustomer() {


        List<Customer> crm = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction

            // get an user object

            crm = session.createQuery("from Customer").list();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return crm;
    }

    public static List<Product> selectProduct(String id) {

        Transaction transaction = null;
        List<Customer> user = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // get an user object
            System.out.println("selectCrm");
            user = session.createQuery("from Customer where name ='"+id+"'").getResultList();
            System.out.println(user+"show all product");
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user.get(0).getProductList();
    }

    public static void createCustomer(Customer crm) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();


            // save the student object
            session.save(crm);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static void createProduct(Product product,HttpServletRequest request) {

        HttpSession httpSession = request.getSession(false);
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object

            String email = (String)httpSession.getAttribute("email");
            System.out.println(email);
            List<Customer> crms= session.createQuery("from Customer where name = '"+email+"'").list();
            Customer updateCrm = crms.get(0);
            System.out.println(updateCrm);
            updateCrm.getProductList().add(product);
            session.update(updateCrm);

            // commit transaction
            transaction.commit();

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void delete(int id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a todo object
            Customer customer = session.get(Customer.class, id);
            if (customer != null) {
                session.delete(customer);
                System.out.println("customer is deleted");

            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void deleteproduct(int id, HttpServletRequest request) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();

            // Delete a todo object
            Product product = session.get(Product.class, id);
            if (product != null) {
                HttpSession httpSession = request.getSession(false);
                String email = (String)httpSession.getAttribute("email");
                List<Customer> crms= session.createQuery("from Customer where name = '"+email+"'").list();
                Customer updateCrm = crms.get(0);
                updateCrm.productList.remove(product);
                session.update(updateCrm);
                System.out.println("product is deleted");

            }

            // commit transaction
            transaction.commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public static void editCustomer(Customer customer) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(customer);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public static void saveEdit(Product product) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student object
            session.update(product);
            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public static Customer getCustomer(int id) {
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class,id);
        session.close();
        return customer;
    }

    public static Product getProduct(int id) {
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class,id);
        session.close();
        return product;
    }
}
