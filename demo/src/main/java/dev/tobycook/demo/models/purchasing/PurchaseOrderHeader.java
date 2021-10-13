package dev.tobycook.demo.models.purchasing;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "purchasing", name = "purchaseorderheader")
public class PurchaseOrderHeader {
    @Id
    @Column(name = "purchaseorderid")
    private Integer purchaseOrderId;

    @Column(name = "revisionnumber")
    private Short revisionNumber;

    @Column(name = "status")
    private Short status;

    @Column(name = "employeeid")
    private Integer employeeId;

    @Column(name = "vendorid")
    private Integer vendorId;

    @Column(name = "shipmethodid")
    private Integer shipMethodId;

    @Column(name = "orderdate")
    private Timestamp orderDate;

    @Column(name = "shipdate")
    private Timestamp shipDate;

    @Column(name = "subtotal")
    private Double subtotal;

    @Column(name = "taxamt")
    private Double taxAmount;

    @Column(name = "freight")
    private Double freight;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
