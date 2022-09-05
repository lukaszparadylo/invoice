package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.stereotype.Service;
import pl.lukaszparadylo.invoiceprogram.database.Product;
import pl.lukaszparadylo.invoiceprogram.database.ProductDto;
import pl.lukaszparadylo.invoiceprogram.database.User;
import pl.lukaszparadylo.invoiceprogram.database.UserDto;

@Service
public class ProductMapper {
    public Product mapToProduct(final ProductDto productDto){
            return new Product(
                    productDto.getId(),
                    productDto.getName(),
                    new User()
            );
    }
    public ProductDto mapToProductDto(final  Product product){
        return new ProductDto(
                product.getId(),
                product.getName()
        );
    }
}
