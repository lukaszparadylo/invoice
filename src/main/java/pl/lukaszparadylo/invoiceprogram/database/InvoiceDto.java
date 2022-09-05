package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class InvoiceDto {
    private Integer id;
    private Integer invoiceNumber;
    private Date dateOfSold;
    private Date dateOfPaid;
    private String paymentMethod;
    private List<Item> itemList = new ArrayList<>();
    private Integer vat;
}
