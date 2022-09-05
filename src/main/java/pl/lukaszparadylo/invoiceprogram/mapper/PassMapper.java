package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.stereotype.Service;
import pl.lukaszparadylo.invoiceprogram.database.Pass;
import pl.lukaszparadylo.invoiceprogram.database.PassDto;

@Service
public class PassMapper {
    public Pass mapToPass(final PassDto passDto){
        return new Pass(
                passDto.getId(),
                passDto.getPassword(),
                passDto.getEmailLogin(),
                passDto.getVerify()
        );
    }
    public PassDto mapToPassDto(final Pass pass){
        return new PassDto(
                pass.getId(),
                pass.getPassword(),
                pass.getEmailLogin(),
                pass.getVerify()
        );
    }
}
