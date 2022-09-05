package pl.lukaszparadylo.invoiceprogram.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.mapper.PassMapper;
import pl.lukaszparadylo.invoiceprogram.mapper.UserMapper;
import pl.lukaszparadylo.invoiceprogram.repository.PassRepository;
import pl.lukaszparadylo.invoiceprogram.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserTest {
    private final String LOGIN = "login";
    private final String PASSWORD = "password";
    private final String NAME = "Jan";
    private final String OWNER_NAME = "Jan Kowalski";
    private final Integer NIP = 123456;
    private final Integer REGON = 987654321;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PassRepository passRepository;
    @Autowired
    PassMapper passMapper;
    @Autowired
    UserMapper userMapper;


    @Test
    public void createNewUser(){
        Pass pass = new Pass(PASSWORD,LOGIN);
        User user = new User(NAME,OWNER_NAME, NIP, REGON, pass, new ArrayList<>(), new ArrayList<>());
        userRepository.save(user);
        Integer userId = user.getId();
        UserDto userDto = userMapper.mapToUserDto(userRepository.findById(userId).orElse(new User()));
        System.out.println(userDto.getPassDto().getEmailLogin());
        Assertions.assertEquals(userId, userDto.getId());
        userRepository.deleteAll();
    }
    @Test
    public void createNewUserWenLoginInNotExists(){
        Pass pass = new Pass(PASSWORD,LOGIN);
        User user = new User(NAME,OWNER_NAME, NIP, REGON, pass, new ArrayList<>(),new ArrayList<>());
        User user2 = new User(NAME,OWNER_NAME, NIP, REGON, pass, new ArrayList<>(),new ArrayList<>());
        try{
            userRepository.save(user);
            userRepository.save(user2);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Integer userId = user.getId();
        UserDto userDto = userMapper.mapToUserDto(userRepository.findById(userId).orElse(new User()));
        String isUserLogin = userDto.getPassDto().getEmailLogin();
        Assertions.assertEquals(false, isUserLogin.isEmpty());
        userRepository.deleteAll();
    }
    @Test
    public void createNewClientByUser(){
        Pass pass = new Pass(PASSWORD,LOGIN);
        Client client = new Client(NAME,NIP,"Bank", 123456789L, null);
        List<Client> clientList = new ArrayList<>();
        clientList.add(client);
        User user = new User(NAME,OWNER_NAME, NIP, REGON, pass, clientList,new ArrayList<>());
        client.setUser(user);
        userRepository.save(user);
        Integer userId = user.getId();
        UserDto userDto = userMapper.mapToUserDto(userRepository.findById(userId).orElse(new User()));
        Assertions.assertEquals(userId,userDto.getId());
        userRepository.deleteAll();
    }
}