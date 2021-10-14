package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.tobycook.demo.models.production.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salesorderdetail")
public class SalesOrderDetail implements Serializable {

    private static final long serialVersionUID = -4691648415487314992L;

    @Id
    @Column(name = "salesorderid")
    private Integer salesOrderId;

    @Id
    @Column(name = "salesorderdetailid")
    private Integer salesOrderDetailId;

    @Column(name = "carriertrackingnumber")
    private String carrierTrackingNumber;

    @Column(name = "orderqty")
    private Short orderQuantity;

    @Column(name = "productid")
    private Integer productId;

    @Column(name = "specialofferid")
    private Integer specialOfferId;

    @Column(name = "unitprice")
    private Double unitPrice;

    @Column(name = "unitpricediscount")
    private Double unitPriceDiscount;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "salesorderid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesOrderHeader salesOrderHeader;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "specialofferid", insertable = false, updatable = false),
            @JoinColumn(name = "productid", insertable = false, updatable = false)
    })
    @JsonBackReference
    private SpecialOfferProduct specialOfferProduct;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;
}
