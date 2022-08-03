package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lukaszparadylo.invoiceprogram.dao.UserDao;
import pl.lukaszparadylo.invoiceprogram.database.Client;
import pl.lukaszparadylo.invoiceprogram.database.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class UserDto {
    UserDao userDao;
    @Autowired
    public UserDto(UserDao userDao){
        this.userDao=userDao;
    }
    public List<User> getUsers(){
        List<User> userList = new ArrayList<>();
        userDao.findAll().forEach(n->{
            userList.add(new User(n.getName(),
                    n.getOwnerName(),n.getNIP(),n.getREGON()));
        });
        return userList;
    }
    public User getUser(int id){
        return new User(userDao.findUserById(id).getId(),userDao.findUserById(id).getName(),
                userDao.findUserById(id).getOwnerName(),userDao.findUserById(id).getNIP(),
                userDao.findUserById(id).getREGON(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
/*        List<User> usersList = (List<User>) userDao.findAll();
        usersList = usersList.stream().filter(n->n.getId()==id)
                .map(n->new User(n.getId(),n.getName(), n.getOwnerName(), n.getNIP(), n.getREGON(),
                new ArrayList<>(),new ArrayList<>(),new ArrayList<>()))
                .collect(Collectors.toList());
        return usersList;*/
    }
}
