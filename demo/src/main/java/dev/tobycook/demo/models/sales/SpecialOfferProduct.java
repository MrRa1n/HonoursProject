package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "specialofferproduct")
public class SpecialOfferProduct implements Serializable {

    private static final long serialVersionUID = -6177300140118144016L;

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
