package dev.tobycook.demo.models.purchasing;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.tobycook.demo.models.production.Product;
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
@Table(schema = "purchasing", name = "purchaseorderdetail")
public class PurchaseOrderDetail implements Serializable {

    private static final long serialVersionUID = 3713302900692159185L;

    @Id
    @Column(name = "purchaseorderid")
    private Integer purchaseOrderId;

    @Id
    @Column(name = "purchaseorderdetailid")
    private Integer purchaseOrderDetailId;

    @Column(name = "duedate")
    private Timestamp dueDate;

    @Column(name = "orderqty")
    private Short orderQuantity;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "receivedqty")
    private Double receivedQuantity;

    @Column(name = "rejectedqty")
    private Double rejectedQuantity;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "purchaseorderid", insertable = false, updatable = false)
    @JsonBackReference
    private PurchaseOrderHeader purchaseOrderHeader;
}
