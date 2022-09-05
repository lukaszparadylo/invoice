package pl.lukaszparadylo.invoiceprogram.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.mapper.PassMapper;
import pl.lukaszparadylo.invoiceprogram.repository.PassRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PassTest {
    private final String LOGIN = "login";
    private final String PASS = "pass";
    @Autowired
    PassRepository passRepository;
    @Autowired
    PassMapper passMapper;

    @Test
    public void checkSaveGetPassFromDatabase(){
        Pass pass = new Pass(PASS,LOGIN);
        passRepository.save(pass);
        Integer passId = pass.getId();
        Integer passIdFromDB = passMapper.mapToPassDto(passRepository.findById(passId).get()).getId();
        Assertions.assertEquals(passId,passIdFromDB);
        passRepository.deleteAll();
    }

    @Test
    public void getNoExistingElementFromDatabase(){
        PassDto passDto = passMapper.mapToPassDto(passRepository.findById(-1).orElse(new Pass()));
        Assertions.assertEquals(null, passDto.getEmailLogin());
    }
}