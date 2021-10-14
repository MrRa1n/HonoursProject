package dev.tobycook.demo.models.production;

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

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "scrapreasonid", insertable = false, updatable = false)
    @JsonBackReference
    private ScrapReason scrapReason;

    @JsonManagedReference
    @OneToMany(mappedBy = "workOrder")
    private List<WorkOrderRouting> workOrderRouting;
}
