/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Veljko
 */
@Entity
@Table(name = "invoice")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_id")
    private Integer invoiceId;
    @Column(name = "invoiceDate")
    @Temporal(TemporalType.DATE)
    private Date invoiceDate;
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    @ManyToOne
    private Customer customerId;
    @OneToMany(mappedBy = "invoiceId")
    private Collection<InvoiceProduct> invoiceProductCollection;

    public Invoice(Integer invoiceId, Date invoiceDate, Customer customerId, Collection<InvoiceProduct> invoiceProductCollection) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.customerId = customerId;
        this.invoiceProductCollection = invoiceProductCollection;
    }

    public Invoice(Date invoiceDate, Customer customerId, Collection<InvoiceProduct> invoiceProductCollection) {
        this.invoiceDate = invoiceDate;
        this.customerId = customerId;
        this.invoiceProductCollection = invoiceProductCollection;
    }

    public Invoice(Integer invoiceId, Date invoiceDate, Customer customerId) {
        this.invoiceId = invoiceId;
        this.invoiceDate = invoiceDate;
        this.customerId = customerId;
    }

    public Invoice(Date invoiceDate, Customer customerId) {
        this.invoiceDate = invoiceDate;
        this.customerId = customerId;
    }

    public Invoice() {
    }
    
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public Customer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }

    public Collection<InvoiceProduct> getInvoiceProductCollection() {
        return invoiceProductCollection;
    }

    public void setInvoiceProductCollection(Collection<InvoiceProduct> invoiceProductCollection) {
        this.invoiceProductCollection = invoiceProductCollection;
    }

    @Override
    public String toString() {
        return "Invoice{" + "invoiceId=" + invoiceId + ", invoiceDate=" + invoiceDate + ", customerId=" + customerId + ", invoiceProductCollection=" + invoiceProductCollection + '}';
    }
    
}
