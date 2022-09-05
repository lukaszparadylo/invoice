package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "INVOICE")
public class Invoice {
    private Integer id;
    private Integer invoiceNumber;
    private Date dateOfSold;
    private Date dateOfPaid;
    private String paymentMethod;
    private List<Item> itemList = new ArrayList<>();
    private User user;
    private Client client;
    private Integer vat;

    public Invoice(Integer invoiceNumber, Date dateOfSold, Date dateOfPaid,
                   String paymentMethod, List<Item> itemList, User user, Client client, Integer vat) {
        this.invoiceNumber = invoiceNumber;
        this.dateOfSold = dateOfSold;
        this.dateOfPaid = dateOfPaid;
        this.paymentMethod = paymentMethod;
        this.itemList = itemList;
        this.user = user;
        this.client = client;
        this.vat = vat;
    }
    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @Column(name = "INVOICE_NUMBER")
    public Integer getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(Integer invoiceNumber) {
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
    @OneToMany(
            targetEntity = Item.class,
            mappedBy = "invoice",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CLIENT_ID")
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    @Column(name = "VAT")
    public Integer getVat() {
        return vat;
    }

    public void setVat(Integer vat) {
        this.vat = vat;
    }
}
