package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
}
