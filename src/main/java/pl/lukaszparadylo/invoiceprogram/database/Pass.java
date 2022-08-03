package pl.lukaszparadylo.invoiceprogram.database;

import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "PASS")
@NoArgsConstructor
public class Pass {
    int id;
    String password;
    String emailLogin;

    public Pass(String password, String emailLogin) {
        this.password = password;
        this.emailLogin = emailLogin;
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
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Column(name = "EMAIL_LOGIN")
    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }
}
