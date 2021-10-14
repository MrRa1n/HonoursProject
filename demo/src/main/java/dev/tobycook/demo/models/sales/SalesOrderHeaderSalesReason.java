package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salesorderheadersalesreason")
public class SalesOrderHeaderSalesReason implements Serializable {

    private static final long serialVersionUID = -1175120165296003459L;

    @Id
    @Column(name = "salesorderid")
    private Integer salesOrderId;

    @Id
    @Column(name = "salesreasonid")
    private Integer salesReasonId;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "salesorderid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesOrderHeader salesOrderHeader;

    @ManyToOne
    @JoinColumn(name = "salesreasonid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesReason salesReason;
}
