package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.stereotype.Service;
import pl.lukaszparadylo.invoiceprogram.database.*;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Service
public class InvoiceMapper {
    public Invoice mapToInvoice(final InvoiceDto invoiceDto){
        return new Invoice(
                invoiceDto.getId(),
                invoiceDto.getDateOfSold(),
                invoiceDto.getDateOfPaid(),
                invoiceDto.getPaymentMethod(),
                new ArrayList<Item>().stream().map(n->new Item(
                            n.getId(),
                            new Product(n.getProduct().getId(),n.getProduct().getName(),null),
                            n.getPrice(),
                            n.getQuantity(),
                            n.getValue(),
                            new Invoice()))
                        .collect(Collectors.toList()),
                new User(invoiceDto.getUser().getId(),
                        invoiceDto.getUser().getName(),
                        invoiceDto.getUser().getOwnerName(),
                        invoiceDto.getUser().getNIP(),
                        invoiceDto.getUser().getREGON()
                        ),
                new Client(invoiceDto.getClient().getId(),
                        invoiceDto.getClient().getName(),
                        invoiceDto.getClient().getNIP(),
                        invoiceDto.getClient().getBank(),
                        invoiceDto.getClient().getAccountNumber(),
                        null
                        ),
                invoiceDto.getVat()
        );
    }
    public InvoiceDto mapToInvoiceDto(final Invoice invoice){
        return new InvoiceDto(
                invoice.getId(),
                invoice.getDateOfSold(),
                invoice.getDateOfPaid(),
                invoice.getPaymentMethod(),
                new ArrayList<ItemDto>().stream().map(n->new ItemDto(
                                n.getId(),
                                new ProductDto(n.getProductDto().getId(),n.getProductDto().getName(),null),
                                n.getPrice(),
                                n.getQuantity(),
                                n.getValue()))
                        .collect(Collectors.toList()),
                new UserDto(invoice.getUser().getId(),
                        invoice.getUser().getName(),
                        invoice.getUser().getOwnerName(),
                        invoice.getUser().getNIP(),
                        invoice.getUser().getREGON()
                ),
                new ClientDto(invoice.getClient().getId(),
                        invoice.getClient().getName(),
                        invoice.getClient().getNIP(),
                        invoice.getClient().getBank(),
                        invoice.getClient().getAccountNumber(),
                        null
                ),
                invoice.getVat()
        );
    }
}
