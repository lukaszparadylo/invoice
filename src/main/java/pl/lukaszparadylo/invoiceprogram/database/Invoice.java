package pl.lukaszparadylo.invoiceprogram.database;

import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@NamedQueries(
        @NamedQuery(
                name = "Invoice.retrieveInvoices",
                query = "FROM Invoice WHERE user.id=:USER_ID"
        )
)
@Entity
@Table(name="INVOICE")
@NoArgsConstructor
public class Invoice {
    int invoiceID;
    int invoiceNumber;
    Date dateOfSold;
    Date dateOfPaid;
    String paymentMethod;
    List<Item> itemList = new ArrayList<>();
    User user;
    Client client;
    int vat;

    public Invoice(User user, Client client, int invoiceNumber, Date dateOfSold, Date dateOfPaid, String paymentMethod){
        this.user=user;
        this.client=client;
        this.invoiceNumber=invoiceNumber;
        this.dateOfSold = dateOfSold;
        this.dateOfPaid = dateOfPaid;
        this.paymentMethod = paymentMethod;
    }
    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "INVOICE_ID", unique = true)
    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    @Column(name = "INVOICE_NUMBER")
    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }
    @Column(name = "DATE_OF_SOLD")
    public Date getDateOfSold() {
        return dateOfSold;
    }

    public void setDateOfSold(Date dateOfSold) {
        this.dateOfSold = dateOfSold;
    }
    @Column(name = "DATE_OF_PAID")
    public Date getDateOfPaid() {
        return dateOfPaid;
    }

    public void setDateOfPaid(Date dateOfPaid) {
        this.dateOfPaid = dateOfPaid;
    }
    @Column(name = "PAYMENT_METHOD")
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    @Column(name = "VAT")
    public int getVat() {
        return vat;
    }

    public void setVat(int vat) {
        this.vat = vat;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
