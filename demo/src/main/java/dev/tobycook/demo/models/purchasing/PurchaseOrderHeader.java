package dev.tobycook.demo.models.purchasing;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.humanresources.Employee;
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

    @ManyToOne
    @JoinColumn(name = "shipmethodid", insertable = false, updatable = false)
    @JsonBackReference
    private ShipMethod shipMethod;

    @ManyToOne
    @JoinColumn(name = "employeeid", insertable = false, updatable = false)
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "vendorid", insertable = false, updatable = false)
    @JsonBackReference
    private Vendor vendor;

    @JsonManagedReference
    @OneToMany(mappedBy = "purchaseOrderHeader")
    private List<PurchaseOrderDetail> purchaseOrderDetails;
}
