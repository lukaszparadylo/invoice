package pl.lukaszparadylo.invoiceprogram.mapper;

import org.springframework.stereotype.Service;
import pl.lukaszparadylo.invoiceprogram.database.*;

@Service
public class ItemMapper {
    public Item mapToItem(final ItemDto itemDao){
        return new Item(
                itemDao.getId(),
                new Product(itemDao.getProductDto().getId(),
                        itemDao.getProductDto().getName(),new User()),
                        itemDao.getPrice(),
                        itemDao.getQuantity(),
                        itemDao.getValue(),
                        new Invoice()
        );
    }
    public ItemDto mapToItemDao(final Item item){
        return new ItemDto(
                item.getId(),
                new ProductDto(item.getProduct().getId(),
                        item.getProduct().getName()),
                item.getPrice(),
                item.getQuantity(),
                item.getValue()
        );
    }
}
