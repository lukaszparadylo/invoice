package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserDto {
    int id;
    String name;
    String ownerName;
    long NIP;
    long REGON;
    PassDto passDto;
    List<ClientDto> clientDtoList = new ArrayList<>();
    List<ProductDto> productDtoList = new ArrayList<>();
}
