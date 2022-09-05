package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ItemDto {
    private Integer id;
    private ProductDto productDto;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal value;
}
