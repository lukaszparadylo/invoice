package pl.lukaszparadylo.invoiceprogram;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.dao.InvoiceDAO;
import pl.lukaszparadylo.invoiceprogram.dao.UserDao;
import pl.lukaszparadylo.invoiceprogram.database.Invoice;
import pl.lukaszparadylo.invoiceprogram.database.User;
import pl.lukaszparadylo.invoiceprogram.mapper.UserDto;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class InvoiceProgramQueriesTests {

    @Autowired
    UserDao userDao;
    @Autowired
    InvoiceDAO invoiceDAO;
    @Test
    public void userQueryTest(){
        System.out.println("-----------------------------------");
        //int numberOfUsers = userDao.retrieveUser(29).size();
        userDao.findById(29).stream()
                .map(n->n.getName())
                .forEach(System.out::println);
        //Assertions.assertEquals(1, numberOfUsers);
        System.out.println("-----------------------------------");
    }
    @Test
    public void invoiceQueryTest(){
        System.out.println("Invoice-----------------------------------");
        //int numberOfUsers = userDao.retrieveUser(29).size();
        List<Invoice> invoice = invoiceDAO.retrieveInvoices(29);
        invoice.stream().map(n->n.getInvoiceID()).forEach(System.out::println);
        invoice.stream().map(m->m.getUser().getName()).forEach(System.out::println);
        //Assertions.assertEquals(1, numberOfUsers);
        System.out.println("Invoice-----------------------------------");
    }
    @Test
    public void getUser(){
        System.out.println("Users-----------------------------------");
        List<User> usersList = (List<User>) userDao.findAll();
        usersList = usersList.stream().filter(n->n.getId()==29)
                .map(n->new User(n.getName(), n.getOwnerName(),
                        n.getNIP(), n.getREGON()))
                .collect(Collectors.toList());
        for (User u : usersList) {
            System.out.println("|"+u.getName()+"|"
                    +u.getOwnerName()+"|"+u.getNIP()+"|"+u.getREGON()+"|");
        }
        System.out.println("Users-----------------------------------");
    }
    @Test
    public void getAllUsers() {


    }
}
