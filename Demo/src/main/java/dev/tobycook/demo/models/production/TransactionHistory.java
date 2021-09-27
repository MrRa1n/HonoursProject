package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "transactionhistory")
public class TransactionHistory {
    @Id
    @Column(name = "transactionid")
    private Integer transactionId;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "referenceorderid")
    private Integer referenceOrderId;

    @Column(name = "referenceorderlineid")
    private Integer referenceOrderLineId;

    @Column(name = "transactiondate")
    private Timestamp transactionDate;

    @Column(name = "transactiontype")
    private Character transactionType;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "actualcost")
    private Double actualCost;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
