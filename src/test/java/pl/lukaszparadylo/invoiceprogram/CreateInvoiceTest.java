package pl.lukaszparadylo.invoiceprogram;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.dao.ClientDAO;
import pl.lukaszparadylo.invoiceprogram.dao.InvoiceDAO;
import pl.lukaszparadylo.invoiceprogram.dao.ProductDAO;
import pl.lukaszparadylo.invoiceprogram.dao.UserDao;
import pl.lukaszparadylo.invoiceprogram.database.*;
import pl.lukaszparadylo.invoiceprogram.mapper.ClientDto;
import pl.lukaszparadylo.invoiceprogram.mapper.ProductDto;
import pl.lukaszparadylo.invoiceprogram.mapper.UserDto;

import java.math.BigDecimal;
import java.util.Date;

@SpringBootTest
public class CreateInvoiceTest {
    @Autowired
    InvoiceDAO invoiceDAO;
    @Autowired
    UserDao userDao;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    ClientDAO clientDAO;
    @Test
    public void createOneInvoiceByUser(){
        //User user = new User("User 123","Owner 123", 4567L, 98765L);
        //Client client = new Client("Client 1",123321,"wwwBank",12345678L);
        //userDao.save(user);

        //Product phone = new Product("Telefon");
        //Product desk = new Product("Biurko");
        Item item1 = new Item(new ProductDto(productDAO).getProduct(149),new BigDecimal("1000"), 1);
        Item item2 = new Item(new ProductDto(productDAO).getProduct(147),new BigDecimal("500"),2);
        UserDto userDto = new UserDto(userDao);
        ClientDto clientDto = new ClientDto(clientDAO);
        Invoice invoice = new Invoice(userDto.getUser(84),clientDto.getClient(102),3, new Date(),new Date(),"cash");

        invoice.getItemList().add(item1);
        invoice.getItemList().add(item2);
        item1.setInvoice(invoice);
        item2.setInvoice(invoice);
        invoiceDAO.save(invoice);

        System.out.println("-------------------------");
        System.out.println(invoice.getClient().getClientId());
        System.out.println(userDto.getUser(84).getId());
        System.out.println(userDto.getUser(84).getName());
        System.out.println(userDto.getUser(84).getOwnerName());
        System.out.println("-------------------------");
    }
}
