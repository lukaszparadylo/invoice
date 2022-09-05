package pl.lukaszparadylo.invoiceprogram.database;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ITEM")
public class Item {
    private Integer id;
    private Product product;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal value;
    private Invoice invoice;

    public Item(Product product, BigDecimal price, Integer quantity, BigDecimal value,Invoice invoice) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
        this.invoice = invoice;
    }

    @Id
    @GeneratedValue
    @NonNull
    @Column(name = "ID", unique = true)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    @Column(name = "PRICE")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    @Column(name = "QUANTITY")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    @Column(name = "VALUE")
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "INVOICE_ID")
    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
