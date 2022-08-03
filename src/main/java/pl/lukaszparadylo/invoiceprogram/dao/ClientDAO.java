package pl.lukaszparadylo.invoiceprogram.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszparadylo.invoiceprogram.database.Client;
import pl.lukaszparadylo.invoiceprogram.database.Invoice;

@Transactional
@Repository
public interface ClientDAO extends CrudRepository<Client, Integer> {
    Client findClientByClientId(Integer id);
}
