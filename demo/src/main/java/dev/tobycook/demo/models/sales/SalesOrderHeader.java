package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "customerid", insertable = false, updatable = false)
    @JsonBackReference
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "creditcardid", insertable = false, updatable = false)
    @JsonBackReference
    private CreditCard creditCard;

    @ManyToOne
    @JoinColumn(name = "currencyrateid", insertable = false, updatable = false)
    @JsonBackReference
    private CurrencyRate currencyRate;

    @ManyToOne
    @JoinColumn(name = "salespersonid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesPerson salesPerson;

    @ManyToOne
    @JoinColumn(name = "territoryid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesTerritory salesTerritory;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesOrderHeader")
    private List<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasons;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesOrderHeader")
    private List<SalesOrderDetail> salesOrderDetails;
}
