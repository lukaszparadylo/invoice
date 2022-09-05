package pl.lukaszparadylo.invoiceprogram.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.mapper.ProductMapper;
import pl.lukaszparadylo.invoiceprogram.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProductTest {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;

    @Test
    public void createAndSaveNewProduct(){
        Product product = new Product("Product 1",null);
        productRepository.save(product);
        Integer productId = product.getId();
        ProductDto productDto = new ProductDto();
        try {
            productDto = productMapper.mapToProductDto(productRepository.findById(productId).orElse(new Product()));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        Assertions.assertEquals(productId, productDto.getId());
        productRepository.deleteAll();
    }

}