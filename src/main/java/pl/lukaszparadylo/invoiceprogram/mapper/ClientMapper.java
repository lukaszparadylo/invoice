package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.stereotype.Service;
import pl.lukaszparadylo.invoiceprogram.database.Client;
import pl.lukaszparadylo.invoiceprogram.database.ClientDto;
import pl.lukaszparadylo.invoiceprogram.database.User;
import pl.lukaszparadylo.invoiceprogram.database.UserDto;

@Service
public class ClientMapper {

    public Client mapTpClient(final ClientDto clientDto){
        return new Client(
                clientDto.getId(),
                clientDto.getName(),
                clientDto.getNIP(),
                clientDto.getBank(),
                clientDto.getAccountNumber(),
                new User()
        );
    }
    public ClientDto mapToClientDto(final  Client client){
        return new ClientDto(
                client.getId(),
                client.getName(),
                client.getNIP(),
                client.getBank(),
                client.getAccountNumber()
        );
    }
}
