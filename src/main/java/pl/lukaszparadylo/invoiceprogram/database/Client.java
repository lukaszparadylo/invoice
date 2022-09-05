package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "CLIENT")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

    int Id;
    String name;
    int NIP;
    String bank;
    Long accountNumber;
    User user;

    public Client(String name, int NIP, String bank, Long accountNumber, User user) {
        this.name = name;
        this.NIP = NIP;
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.user = user;
    }
    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @Column(name = "NIP")
    public int getNIP() {
        return NIP;
    }

    public void setNIP(int NIP) {
        this.NIP = NIP;
    }
    @Column(name = "BANK")
    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }
    @Column(name = "ACCOUNT_NUMBER")
    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
