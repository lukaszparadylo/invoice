package pl.lukaszparadylo.invoiceprogram.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.lukaszparadylo.invoiceprogram.dao.UserDao;
import pl.lukaszparadylo.invoiceprogram.database.User;
import pl.lukaszparadylo.invoiceprogram.mapper.UserDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("v1/invoice")
public class InvoiceController {

    @Autowired
    UserDao userDao;

    @RequestMapping(method = RequestMethod.GET, value="getUsers")
    public List<User> getUsers(){
        return new UserDto(userDao).getUsers();
    }
    @RequestMapping(method = RequestMethod.GET, value="getUser")
    public User getUser(@RequestParam Integer id){
        return new UserDto(userDao).getUser(id);
    }
}
