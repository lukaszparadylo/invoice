package pl.lukaszparadylo.invoiceprogram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszparadylo.invoiceprogram.database.Product;

@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
