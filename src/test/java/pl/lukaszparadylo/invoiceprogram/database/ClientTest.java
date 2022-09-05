package pl.lukaszparadylo.invoiceprogram.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.mapper.ClientMapper;
import pl.lukaszparadylo.invoiceprogram.repository.ClientRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ClientTest {
    private final String BANK = "BANK_SS";
    private final String NAME = "Jan";
    private final String OWNER_NAME = "Jan Kowalski";
    private final Integer NIP = 123456;
    private final Long ACCOUNT_NUMBER = 123456789L;

    @Autowired
    ClientRepository clientRepository;
    @Autowired
    ClientMapper clientMapper;

    @Test
    public void createAndSaveNewClient(){
        Client client = new Client(NAME, NIP,BANK,ACCOUNT_NUMBER,new User());
        clientRepository.save(client);
        Integer clientId = client.getId();
        ClientDto clientDto = clientMapper.mapToClientDto(clientRepository.findById(clientId).orElse(new Client()));
        Assertions.assertEquals(clientId, clientDto.getId());
        clientRepository.deleteAll();
    }
}