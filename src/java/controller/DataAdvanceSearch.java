package controller;

import hibernate.Brand;
import hibernate.HibernateUtil;
import hibernate.Product;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.dom4j.Branch;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author User
 */
@WebServlet(name = "DataAdvanceSearch", urlPatterns = {"/DataAdvanceSearch"})
public class DataAdvanceSearch extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        Criteria c = s.createCriteria(Product.class);
        
        //Restrictions
//        Criterion crt1 = Restrictions.lt("qty", 10);
//        Criterion crt1 = Restrictions.eq("qty", 10);
//        Criterion crt2 = Restrictions.lt("price", 200000.0);
//        Criterion crt3 = Restrictions.like("name", "Ultra", MatchMode.ANYWHERE);
//        Order o1 = Order.asc("qty");
        
        Criterion crt1 = Restrictions.lt("price", 200000.0);
        c.add(crt1);
        
//        Brand b = (Brand) s.load(Brand.class, 1);
//        Criterion crt2 = Restrictions.eq("brand", b);
//        c.add(crt2);

       Criteria c2 = s.createCriteria(Brand.class);
       Criterion crt2 = Restrictions.eq("name", "apple");
       Brand b = (Brand) c2.list().get(0);
       c2.add(crt2);
       
        Criterion crt3 = Restrictions.eq("brand", b);
        c.add(crt3);
        
        Order o1 = Order.asc("price");
        c.addOrder(o1);
        
        List<Product> productList = c.list();
        
        for (Product product : productList) {
            System.out.println(product.getName());
        }
    }

}
