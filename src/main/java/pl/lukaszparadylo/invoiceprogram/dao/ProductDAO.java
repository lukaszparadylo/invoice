package pl.lukaszparadylo.invoiceprogram.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszparadylo.invoiceprogram.database.Invoice;
import pl.lukaszparadylo.invoiceprogram.database.Product;

@Transactional
@Repository
public interface ProductDAO extends CrudRepository<Product, Integer> {
    public Product findProductById(Integer id);
}
