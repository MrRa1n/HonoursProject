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
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "workorderrouting")
public class WorkOrderRouting implements Serializable {

    private static final long serialVersionUID = -8760582418394446634L;

    @Id
    @Column(name = "workorderid")
    private Integer workOrderId;

    @Id
    @Column(name = "productid")
    private Integer productId;

    @Id
    @Column(name = "operationsequence")
    private Short operationSequence;

    @Column(name = "locationid")
    private Short locationid;

    @Column(name = "scheduledstartdate")
    private Timestamp scheduledStartDate;

    @Column(name = "scheduledenddate")
    private Timestamp scheduledEndDate;

    @Column(name = "actualstartdate")
    private Timestamp actualStartDate;

    @Column(name = "actualenddate")
    private Timestamp actualEndDate;

    @Column(name = "actualresourcehrs")
    private Double actualResourceHrs;

    @Column(name = "plannedcost")
    private Double plannedCost;

    @Column(name = "actualcost")
    private Double actualCost;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "workorderid", insertable = false, updatable = false)
    @JsonBackReference
    private WorkOrder workOrder;

    @ManyToOne
    @JoinColumn(name = "locationid", insertable = false, updatable = false)
    @JsonBackReference
    private Location location;
}
