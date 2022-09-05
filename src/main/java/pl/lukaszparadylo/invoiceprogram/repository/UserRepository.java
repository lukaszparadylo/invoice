package pl.lukaszparadylo.invoiceprogram.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszparadylo.invoiceprogram.database.User;

@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {
}
