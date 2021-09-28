package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "customer")
public class Customer {
    @Id
    @Column(name = "customerid")
    private Integer id;

    @Column(name = "personid")
    private Integer personId;

    @Column(name = "storeid")
    private Integer storeId;

    @Column(name = "territoryid")
    private Integer territoryId;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
