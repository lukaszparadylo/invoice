package pl.lukaszparadylo.invoiceprogram.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszparadylo.invoiceprogram.database.Pass;

@Transactional
@Repository
public interface PassDao extends CrudRepository<Pass, Integer> {
}
