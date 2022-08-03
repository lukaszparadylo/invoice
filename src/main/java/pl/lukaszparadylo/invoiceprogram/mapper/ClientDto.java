package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import pl.lukaszparadylo.invoiceprogram.dao.ClientDAO;
import pl.lukaszparadylo.invoiceprogram.dao.UserDao;
import pl.lukaszparadylo.invoiceprogram.database.Client;
import pl.lukaszparadylo.invoiceprogram.database.User;

import java.util.ArrayList;
import java.util.List;

public class ClientDto {

    ClientDAO clientDAO;
    @Autowired
    public ClientDto(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public List<User> getListOfUsers(UserDao userDao){
       return new ArrayList<>();
    }
    public Client getClient(int id){
        return new Client(clientDAO.findClientByClientId(id).getClientId(),clientDAO.findClientByClientId(id).getClientName(),
                clientDAO.findClientByClientId(id).getClientNIP(), clientDAO.findClientByClientId(id).getClientBank(),
                clientDAO.findClientByClientId(id).getClientAccountNumber(), new User());
    }
}
