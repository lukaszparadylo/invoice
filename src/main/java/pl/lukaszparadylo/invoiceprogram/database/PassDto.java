package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PassDto {
    int id;
    String password;
    String emailLogin;
    Boolean verify;
}
