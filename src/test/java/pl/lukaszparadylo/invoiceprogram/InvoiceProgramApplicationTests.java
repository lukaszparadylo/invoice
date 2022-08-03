package pl.lukaszparadylo.invoiceprogram;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.dao.*;
import pl.lukaszparadylo.invoiceprogram.database.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@SpringBootTest
class InvoiceProgramApplicationTests {
    @Autowired
    private InvoiceDAO invoiceDAO;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ClientDAO clientDAO;
    @Autowired
    private ItemDao itemDao;
    @Autowired
    private ProductDAO productDAO;
    @Test
    void contextLoads() {
        Client client1 = new Client("Client 3",3456, "Bank 3", 1234L);

        User user1 = new User("User 3","Owner name 3", 54321L, 54321L);

        Product kon = new Product("Komputer");
        Product krowa = new Product("Drzewa");
        Product kura = new Product("Kura");

        kon.setUser(user1);
        krowa.setUser(user1);
        kura.setUser(user1);
        Item item = new Item(kon, new BigDecimal(400),2);
        Item item1 = new Item(krowa,new BigDecimal(800),3);
        Item item2 = new Item(kura,new BigDecimal(1200),4);
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        itemList.add(item1);
        itemList.add(item2);
        Invoice invoice = new Invoice(user1,client1,2345,new Date(),new Date(),"card");
        Invoice invoice2 = new Invoice(user1,client1,2345,new Date(),new Date(),"card2");

        client1.setUser(user1);
        item.setProduct(kon);
        item.setInvoice(invoice);
        item.setInvoice(invoice2);
        item1.setProduct(krowa);
        item1.setInvoice(invoice);
        item1.setInvoice(invoice2);
        item2.setProduct(kura);
        item2.setInvoice(invoice);
        item2.setInvoice(invoice2);
        invoice.setItemList(itemList);
        invoice2.setItemList(itemList);
        //invoice.setClient(client1);

        invoiceDAO.save(invoice);

    }
}
