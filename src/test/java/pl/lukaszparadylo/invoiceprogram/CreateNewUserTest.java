package pl.lukaszparadylo.invoiceprogram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.dao.UserDao;
import pl.lukaszparadylo.invoiceprogram.database.User;

@SpringBootTest
public class CreateNewUserTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void createNewUser(){
        User user = new User("Firma","Firma Owner", 12345L, 1234567L);
        userDao.save(user);
        int userId = (int) userDao.findById(user.getId()).stream().count();
        Assertions.assertEquals(userId, 1);
    }
}
