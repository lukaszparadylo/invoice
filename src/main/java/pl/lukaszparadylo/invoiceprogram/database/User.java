package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@AllArgsConstructor
public class User {
    int id;
    String name;
    String ownerName;
    long NIP;
    long REGON;
    Pass pass;
    List<Client> clientList = new ArrayList<>();
    List<Product> productList = new ArrayList<>();
    List<Invoice> invoiceList = new ArrayList<>();
    public User(int id, String name, String ownerName, long NIP, long REGON) {
        this.id = id;
        this.name = name;
        this.ownerName = ownerName;
        this.NIP = NIP;
        this.REGON = REGON;
    }

    public User(String name, String ownerName, long NIP, long REGON, Pass pass,
                List clientList, List productList, List invoiceList) {
        this.name = name;
        this.ownerName = ownerName;
        this.NIP = NIP;
        this.REGON = REGON;
        this.pass = pass;
        this.clientList = clientList;
        this.productList = productList;
        this.invoiceList = invoiceList;
    }

    @Id
    @NonNull
    @GeneratedValue
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "OWNER_NAME")
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    @Column(name = "NIP")
    public long getNIP() {
        return NIP;
    }

    public void setNIP(long NIP) {
        this.NIP = NIP;
    }
    @Column(name = "REGON")
    public long getREGON() {
        return REGON;
    }

    public void setREGON(long REGON) {
        this.REGON = REGON;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PASS_ID")
    public Pass getPass() {
        return pass;
    }

    public void setPass(Pass pass) {
        this.pass = pass;
    }
    @OneToMany(
            targetEntity = Client.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
    @OneToMany(
            targetEntity = Product.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @OneToMany(
            targetEntity = Invoice.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public void setInvoiceList(List<Invoice> invoiceList) {
        this.invoiceList = invoiceList;
    }
}
