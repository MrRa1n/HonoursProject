package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
}
