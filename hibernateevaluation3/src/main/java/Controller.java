import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/")
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Configuration configuration = new Configuration().configure();
    SessionFactory sessionFactory = configuration.buildSessionFactory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        String action = request.getServletPath();

            switch (action) {
                case "/EditCustomer":
                    saveEdit(request,response);
                    break;
                case "/editCustomer":
                    edit(request,response);
                    break;

                case "/deleteCustomer":
                    try {
                        delete(request,response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "/editProduct":
                    editformproduct(request,response);
                    break;
                case "/editsaveProduct":
                    editProduct(request,response);
                    break;
                case "/deleteProduct":
                    deleteProduct(request,response);
                    break;
                case "/loginAuth":
                    loginAuth(request, response);
                    break;

                case "/registerCustomer":
                    showNewForm(request, response);
                    break;
                case "/registerUser":
                    showNewProduct(request, response);
                    break;
                case    "/SaveCustomer":
                    saveCustomer(request,response);
                    break;
                case    "/SaveProduct":
                    saveProduct(request,response);
                    break;

                case    "/logout":
                    try {
                        logout(request,response);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
            }
}

    private void editformproduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Session session = sessionFactory.openSession();
        Product product = session.get(Product.class,id);
        request.setAttribute("todo",product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("editProductForm.jsp");
        dispatcher.forward(request, response);
    }

    private void saveallo(HttpServletRequest request, HttpServletResponse response) {
        int allo=Integer.parseInt(request.getParameter("allo"));

    }

    private void
    saveEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Customer customer = Dao.getCustomer(id);
        customer.setName(name);
        Dao.editCustomer(customer);
        List<Customer> listCustomer = Dao.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user-list.jsp");
        dispatcher.forward(request, response);

    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Dao.deleteproduct(id,request);
        HttpSession session = request.getSession(false);
        List<Product> listTodo = Dao.selectProduct((String)session.getAttribute("id"));
        request.setAttribute("listTodo", listTodo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("crm-list.jsp");
        dispatcher.forward(request, response);
    }
    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product products = Dao.getProduct(id);
        int qty = Integer.parseInt(request.getParameter("initqty"));
        int quantity = products.quantity;
        quantity-=qty-products.initialQuantity;
        Product product  = new Product(id,products.name,products.price,quantity,qty);
        HttpSession session1 = request.getSession(false);
        Dao.saveEdit(product);
        Session session = sessionFactory.openSession();
        Customer customers = (Customer)session1.getAttribute("cust");
        Customer customer = session.get(Customer.class, customers.id);
        List<Product> productList = customer.getProductList();
        System.out.println(productList);
        request.setAttribute("productList",productList);
        int total=0;
        for(Product product1 : productList){
            System.out.println();
            total+=product1.price*product1.initialQuantity;
        }
        request.setAttribute("total", total);

        request.setAttribute("userid",session1.getAttribute("userId"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("crm-list.jsp");
        dispatcher.forward(request, response);

    }

    private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession(false);
        Customer customers = (Customer)httpSession.getAttribute("cust") ;
        Session session = sessionFactory.openSession();
        Customer customer = session.get(Customer.class,customers.id);
        request.setAttribute("todo",customer);
        session.close();
        RequestDispatcher dispatcher = request.getRequestDispatcher("editCustomerForm.jsp");
        dispatcher.forward(request, response);
    }
    private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        HttpSession httpSession = request.getSession(false);
        Customer customers = (Customer)httpSession.getAttribute("cust") ;
        Dao.delete(customers.id);
        logout(request,response);
    }

    private void logout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        HttpSession session = request.getSession(false);
        session.invalidate();
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void saveProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product product = new Product(name,price,quantity);
        Dao.createProduct(product,request);
        HttpSession session = request.getSession(false);
        List<Product> listTodo = Dao.selectProduct((String)session.getAttribute("id"));
        request.setAttribute("listTodo", listTodo);
        RequestDispatcher dispatcher = request.getRequestDispatcher("crm-list.jsp");
        dispatcher.forward(request, response);
    }

    private void saveCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String password = request.getParameter("pass");
        List<Product> productList = new ArrayList<>();
        Product product = new Product("allo",50,15,0);
        Product product1 = new Product("pyaz",40,20,0);
        Product product2 = new Product("paneer",240,25,0);
        productList.add(product);
        productList.add(product1);
        productList.add(product2);

        Customer crm = new Customer(name,password,productList);
        Dao.createCustomer(crm);
        List<Customer> listCustomer = Dao.selectAllCustomer();
        request.setAttribute("listCustomer", listCustomer);

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("registerCrmForm.jsp");
        dispatcher.forward(request, response);
    }
    private void showNewProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("registerProductForm.jsp");
        dispatcher.forward(request, response);
    }

    private void loginAuth(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customer customer= Dao.loginCheck(request,response);
        List<Product> productList = customer.getProductList();
        System.out.println(productList);
        request.setAttribute("productList",productList);
        int total=0;
        for(Product product : productList){
            total+=product.price*product.initialQuantity;
        }
        request.setAttribute("total", total);
        HttpSession session = request.getSession(false);
        request.setAttribute("userid",session.getAttribute("userId"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("crm-list.jsp");
        dispatcher.forward(request, response);
    }
    }
