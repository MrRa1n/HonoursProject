package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salesorderdetail")
public class SalesOrderDetail {
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
}
