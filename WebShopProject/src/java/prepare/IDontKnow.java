package prepare;


import model.Category;
import model.Product;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Veljko
 */
public class IDontKnow {
    public static void saveSomething() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Product p = new Product("Apple iPhone 8", 630, "For customers with deeper pocket", 1, (Category) session.load(Category.class, 2));
        Product p1 = new Product("Alcatel OT 322", 20, "No touch no fun", 1, (Category) session.load(Category.class, 1));
        Product p2 = new Product("HTC 10 LTE", 320, "Acceptable", 1, (Category) session.load(Category.class, 3));
        Product p3 = new Product("LG Q6", 160, "Cheap", 1, (Category) session.load(Category.class, 5));
        Product p4 = new Product("Nokia 3310 (2017)", 60, "Almost for free", 1, (Category) session.load(Category.class, 6));
        Product p5 = new Product("Galaxy A6", 250, "Quater of Grand", 1, (Category) session.load(Category.class, 7));
        Product p6 = new Product("Xperia X", 280, "IDKKKKKK", 1, (Category) session.load(Category.class, 8));
        
        session.save(p);
        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(p5);
        session.save(p6);
        
        session.getTransaction().commit();
    }
}
