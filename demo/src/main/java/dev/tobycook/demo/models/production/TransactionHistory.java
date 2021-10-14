package dev.tobycook.demo.models.production;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;
}
