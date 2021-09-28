package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salesorderheader")
public class SalesOrderHeader {
    @Id
    @Column(name = "salesorderid")
    private Integer salesOrderId;

    @Column(name = "revisionnumber")
    private Short revisionNumber;

    @Column(name = "orderdate")
    private Timestamp orderDate;

    @Column(name = "duedate")
    private Timestamp dueDate;

    @Column(name = "shipdate")
    private Timestamp shipDate;

    @Column(name = "status")
    private Short status;

    @Column(name = "onlineorderflag")
    private Boolean onlineOrderFlag;

    @Column(name = "purchaseordernumber")
    private String purchaseOrderNumber;

    @Column(name="accountnumber")
    private String accountNumber;

    @Column(name = "customerid")
    private Integer customerId;

    @Column(name = "salespersonid")
    private Integer salesPersonId;

    @Column(name = "territoryid")
    private Integer territoryId;

    @Column(name = "billtoaddressid")
    private Integer billToAddressId;

    @Column(name = "shiptoaddressid")
    private Integer shipToAddressId;

    @Column(name = "shipmethodid")
    private Integer shipMethodId;

    @Column(name = "creditcardid")
    private Integer creditCardId;

    @Column(name = "creditcardapprovalcode")
    private String creditCardApprovalCode;

    @Column(name = "currencyrateid")
    private Integer currencyRateId;

    @Column(name = "subtotal")
    private Double subTotal;

    @Column(name = "taxamt")
    private Double taxAmount;

    @Column(name = "freight")
    private Double freight;

    @Column(name = "totaldue")
    private Double totalDue;

    @Column(name = "comment")
    private String comment;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
