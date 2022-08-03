package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lukaszparadylo.invoiceprogram.dao.ProductDAO;
import pl.lukaszparadylo.invoiceprogram.dao.UserDao;
import pl.lukaszparadylo.invoiceprogram.database.Product;
import pl.lukaszparadylo.invoiceprogram.database.User;

public class ProductDto {

    ProductDAO productDAO;

    @Autowired
    public ProductDto(ProductDAO productDAO){
        this.productDAO=productDAO;
    }
    public Product getProduct(int id){
        return new Product(productDAO.findProductById(id).getId(),productDAO.findProductById(id).getName(),
                new User());
    }
}
