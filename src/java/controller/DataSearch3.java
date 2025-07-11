package controller;

import hibernate.Brand;
import hibernate.HibernateUtil;
import hibernate.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author User
 */
@WebServlet(name = "DataSearch3", urlPatterns = {"/DataSearch3"})
public class DataSearch3 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        
        Criteria c = s.createCriteria(Product.class);  //SELECT * FROM `brand`
        List<Product> productList =  c.list();
        
        for (Product product : productList) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQty());
            System.out.println(" ");
            System.out.println(product.getBrand().getId());
            System.out.println(product.getBrand().getName());
            System.out.println("---------------------------------");
        }
    }

   
}
