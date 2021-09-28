package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productcosthistory")
public class ProductCostHistory implements Serializable {

    private static final long serialVersionUID = 7269957629130360715L;

    @Id
    @Column(name = "productid")
    private Integer productid;

    @Id
    @Column(name = "startdate")
    private Timestamp startdate;

    @Column(name = "enddate")
    private Timestamp enddate;

    @Column(name = "standardcost")
    private Double standardcost;

    @Column(name = "modifieddate")
    private Timestamp modifieddate;
}
