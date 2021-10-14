package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.tobycook.demo.models.production.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "shoppingcartitem")
public class ShoppingCartItem {
    @Id
    @Column(name = "shoppingcartitemid")
    private Integer id;

    @Column(name = "shoppingcartid")
    private String shoppingCartId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "datecreated")
    private Timestamp dateCreated;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;
}
