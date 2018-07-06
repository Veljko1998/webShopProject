/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prepare;

import java.util.ArrayList;
import model.Product;
import util.HQL;

/**
 *
 * @author Veljko
 */
public class PrepareForDisplay {
    public static String displayAllProducts() {
        String html;
        ArrayList<Product> allProducts = HQL.getAllProduct();
        html = "<table border='2px solid black'>\n" +
                "<tr>" + 
                 "<th>Product Name</th>" +
                 "<th>Description</th>" +
                 "<th>Price</th>" +
                 "<th>Quantity</th>" +
                 "</tr>";
        for(int i=0; i<allProducts.size(); i++) {
            html+= "<tr>"
                    + "<td>" + allProducts.get(i).getProductName() + "</td>\n"
                    + "<td>" + allProducts.get(i).getProductDescription() + "</td>\n"
                    + "<td>" + allProducts.get(i).getProductPrice() + "</td>\n"
                    + "<td>" + allProducts.get(i).getProductStock()+ "</td>\n"
                    + "</tr>";
        }
        html+= "</table>";
        return html;
    }
    /*public static String displayCategoryProducts() { 
        String html;
        ArrayList<Product> allProducts = HQL.getProductByCatId(0);
    }*/
}
