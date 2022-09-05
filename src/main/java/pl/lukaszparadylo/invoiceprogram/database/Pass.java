package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "PASS")
@NoArgsConstructor
@AllArgsConstructor
public class Pass {
    int id;
    String password;
    String emailLogin;
    Boolean verify;

    public Pass(String password, String emailLogin) {
        this.password = password;
        this.emailLogin = emailLogin;
    }

    @Id
    @GeneratedValue
    @NonNull
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
    @Column(name = "EMAIL_LOGIN", unique = true)
    public String getEmailLogin() {
        return emailLogin;
    }

    public void setEmailLogin(String emailLogin) {
        this.emailLogin = emailLogin;
    }
    @Column(name = "VERIFY")
    public Boolean getVerify() {
        return verify;
    }

    public void setVerify(Boolean verify) {
        this.verify = verify;
    }
}
