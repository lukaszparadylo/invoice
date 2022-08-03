package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NamedQueries(
        @NamedQuery(
                name = "User.retrieveUser",
                query = "FROM User WHERE id=:IS_USER_EXISTS"
        )
)

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

    List<Client> clientsList = new ArrayList<>();
    List<Invoice> invoicesList = new ArrayList<>();

    List<Product> productList = new ArrayList<>();

    public User(String name, String ownerName, long NIP, long REGON){
        this.name = name;
        this.ownerName = ownerName;
        this.NIP = NIP;
        this.REGON = REGON;
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
    @OneToMany(
            targetEntity = Client.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Client> getClientsList() {
        return clientsList;
    }

    public void setClientsList(List<Client> clientsList) {
        this.clientsList = clientsList;
    }
    @OneToMany(
            targetEntity = Invoice.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    public List<Invoice> getInvoicesList() {
        return invoicesList;
    }

    public void setInvoicesList(List<Invoice> invoicesList) {
        this.invoicesList = invoicesList;
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
}
