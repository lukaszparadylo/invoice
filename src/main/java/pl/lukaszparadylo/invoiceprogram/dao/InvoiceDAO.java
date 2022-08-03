package pl.lukaszparadylo.invoiceprogram.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszparadylo.invoiceprogram.database.Invoice;
import pl.lukaszparadylo.invoiceprogram.database.Product;
import pl.lukaszparadylo.invoiceprogram.database.User;

import java.util.List;

@Transactional
@Repository
public interface InvoiceDAO extends CrudRepository<Invoice, Integer>{
    @Query
    List<Invoice> retrieveInvoices(@Param("USER_ID") int allUserInvoices);
}
