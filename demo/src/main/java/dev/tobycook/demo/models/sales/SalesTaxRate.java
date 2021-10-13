package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salestaxrate")
public class SalesTaxRate {
    @Id
    @Column(name = "salestaxrateid")
    private Integer id;

    @Column(name = "stateprovinceid")
    private Integer stateProvinceId;

    @Column(name = "taxtype")
    private Short type;

    @Column(name = "taxrate")
    private Double rate;

    @Column(name = "name")
    private String name;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
