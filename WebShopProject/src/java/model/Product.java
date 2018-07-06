/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Veljko
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "productName")
    private String productName;
    @Column(name = "productPrice")
    private double productPrice;
    @Column(name = "productDescription")
    private String productDescription;
    @Column(name = "productStock")
    private int productStock;
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne
    private Category categoryId;
    @OneToMany(mappedBy = "productId")
    private Collection<InvoiceProduct> invoiceProductCollection;

    public Product(Integer productId, String productName, double productPrice, String productDescription, int productStock, Category categoryId, Collection<InvoiceProduct> invoiceProductCollection) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productStock = productStock;
        this.categoryId = categoryId;
        this.invoiceProductCollection = invoiceProductCollection;
    }

    public Product(String productName, double productPrice, String productDescription, int productStock, Category categoryId, Collection<InvoiceProduct> invoiceProductCollection) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productStock = productStock;
        this.categoryId = categoryId;
        this.invoiceProductCollection = invoiceProductCollection;
    }

    public Product(Integer productId, String productName, double productPrice, String productDescription, int productStock, Category categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productStock = productStock;
        this.categoryId = categoryId;
    }

    public Product(String productName, double productPrice, String productDescription, int productStock, Category categoryId) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productStock = productStock;
        this.categoryId = categoryId;
    }

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductStock() {
        return productStock;
    }

    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public Collection<InvoiceProduct> getInvoiceProductCollection() {
        return invoiceProductCollection;
    }

    public void setInvoiceProductCollection(Collection<InvoiceProduct> invoiceProductCollection) {
        this.invoiceProductCollection = invoiceProductCollection;
    }

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice + ", productDescription=" + productDescription + ", productStock=" + productStock + ", categoryId=" + categoryId + ", invoiceProductCollection=" + invoiceProductCollection + '}';
    }
    
}
