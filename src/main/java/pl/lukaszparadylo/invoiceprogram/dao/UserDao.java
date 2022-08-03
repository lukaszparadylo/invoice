package pl.lukaszparadylo.invoiceprogram.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.lukaszparadylo.invoiceprogram.database.User;

import java.util.List;

@Transactional
@Repository
public interface UserDao extends CrudRepository<User, Integer> {
    @Query
    List<User> retrieveUser(@Param("IS_USER_EXISTS") int isUserExists);
    User findUserById(Integer id);
}
