package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productlistpricehistory")
public class ProductListPriceHistory implements Serializable {

    private static final long serialVersionUID = -3102480563131222749L;

    @Id
    @Column(name = "productid")
    private Integer id;

    @Id
    @Column(name = "startdate")
    private Timestamp startDate;

    @Column(name = "enddate")
    private Timestamp endDate;

    @Column(name = "listprice")
    private Double listPrice;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
