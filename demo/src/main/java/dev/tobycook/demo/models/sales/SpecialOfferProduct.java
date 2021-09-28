package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "specialofferproduct")
public class SpecialOfferProduct {
    @Id
    @Column(name = "specialofferid")
    private Integer specialOfferId;

    @Id
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
