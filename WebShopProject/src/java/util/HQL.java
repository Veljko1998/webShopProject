/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import model.Product;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Veljko
 */
public class HQL {
    public static ArrayList<Product> getProductByCatId(int catId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query byCatId = session.createQuery("from Product p where p.category_id=?");
        byCatId.setInteger(0, catId);
        ArrayList<Product> productsByCatId = new ArrayList(byCatId.list());
        session.getTransaction().commit();
        return productsByCatId;
    }
    public static ArrayList<Product> getAllProduct() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query selectAllProducts = session.createQuery("from Product");
        ArrayList<Product> allProducts = new ArrayList(selectAllProducts.list());
        session.getTransaction().commit();
        return allProducts;
    }
}
