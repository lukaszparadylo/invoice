package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.stereotype.Service;
import pl.lukaszparadylo.invoiceprogram.database.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public User mapToUser(final UserDto userDto){
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getOwnerName(),
                userDto.getNIP(),
                userDto.getREGON(),
                new Pass(userDto.getPassDto().getId(),
                        userDto.getPassDto().getPassword(),
                        userDto.getPassDto().getEmailLogin(),
                        userDto.getPassDto().getVerify()),
                new ArrayList<Client>().stream().map(n->new Client(
                            n.getId(),n.getName(),n.getNIP(),n.getBank(),
                            n.getAccountNumber(), null))
                        .collect(Collectors.toList()),
                new ArrayList<Product>().stream().map(n->new Product(
                            n.getId(), n.getName(), null))
                        .collect(Collectors.toList()),
                new ArrayList<Invoice>().stream().map(n->new Invoice(
                        n.getId(),n.getInvoiceNumber(),n.getDateOfSold(),n.getDateOfPaid(),
                        n.getPaymentMethod(),new ArrayList<Item>().stream().map(m->new Item(
                                m.getId(),
                                new Product(m.getProduct().getId(),
                                    m.getProduct().getName(),
                                    null
                                ),
                                m.getPrice(),
                                m.getQuantity(),
                                m.getValue(),
                        null
                        )).collect(Collectors.toList()),
                        null,
                        null,
                        n.getVat()
                )).collect(Collectors.toList())
        );
    }
    public UserDto mapToUserDto(final User user){
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getOwnerName(),
                user.getNIP(),
                user.getREGON(),
                new PassDto(user.getPass().getId(),
                        user.getPass().getPassword(),
                        user.getPass().getEmailLogin(),
                        user.getPass().getVerify()),
                new ArrayList<ClientDto>().stream().map(n->new ClientDto(
                            n.getId(),n.getName(),n.getNIP(),n.getBank(),
                            n.getAccountNumber()))
                        .collect(Collectors.toList()),
                new ArrayList<ProductDto>().stream().map(n->new ProductDto(
                            n.getId(), n.getName())).collect(Collectors.toList())
        );
    }
}
