package pl.lukaszparadylo.invoiceprogram.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.lukaszparadylo.invoiceprogram.mapper.ItemMapper;
import pl.lukaszparadylo.invoiceprogram.repository.ItemRepository;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ItemTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemMapper itemMapper;

    @Test
    public void createAndSaveNewItem(){
        Product product = new Product("Product 1", null);
        Item item = new Item(product,new BigDecimal("123"),2,new BigDecimal("222"));
        itemRepository.save(item);
        Integer itemId = item.getId();
        ItemDto itemDto = itemMapper.mapToItemDao(itemRepository.findById(itemId).orElse(new Item()));
        Assertions.assertEquals(itemId, itemDto.getId());
        itemRepository.deleteAll();
    }
}