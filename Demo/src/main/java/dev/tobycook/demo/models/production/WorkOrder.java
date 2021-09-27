package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "workorder")
public class WorkOrder {
    @Id
    @Column(name = "workorderid")
    private Integer id;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "orderqty")
    private Integer orderQty;

    @Column(name = "scrappedqty")
    private Short scrappedQty;

    @Column(name = "startdate")
    private Timestamp startDate;

    @Column(name = "enddate")
    private Timestamp endDate;

    @Column(name = "duedate")
    private Timestamp dueDate;

    @Column(name = "scrapreasonid")
    private Short scrapReasonId;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
