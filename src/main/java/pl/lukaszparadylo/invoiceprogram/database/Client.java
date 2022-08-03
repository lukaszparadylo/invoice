package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name="CLIENT")
@AllArgsConstructor
@NoArgsConstructor
public class Client{
    int clientId;
    String clientName;
    int ClientNIP;
    String clientBank;
    Long clientAccountNumber;
    User user;


    public Client(String clientName, int clientNIP, String clientBank, Long clientAccountNumber) {
        this.clientName = clientName;
        ClientNIP = clientNIP;
        this.clientBank = clientBank;
        this.clientAccountNumber = clientAccountNumber;
    }
    @Id
    @NonNull
    @GeneratedValue
    @Column(name="ID", unique = true)
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    @Column(name = "NAME")
    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    @Column(name = "NIP")
    public int getClientNIP() {
        return ClientNIP;
    }

    public void setClientNIP(int clientNIP) {
        ClientNIP = clientNIP;
    }

    @Column(name = "BANK")
    public String getClientBank() {
        return clientBank;
    }

    public void setClientBank(String clientBank) {
        this.clientBank = clientBank;
    }

    @Column(name = "ACCOUNT_NUMBER")
    public Long getClientAccountNumber() {
        return clientAccountNumber;
    }

    public void setClientAccountNumber(Long clientAccountNumber) {
        this.clientAccountNumber = clientAccountNumber;
    }

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
