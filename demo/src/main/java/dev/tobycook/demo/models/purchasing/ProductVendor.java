package dev.tobycook.demo.models.purchasing;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "purchasing", name = "productvendor")
public class ProductVendor implements Serializable {

    private static final long serialVersionUID = -4797532001341345350L;

    @Id
    @Column(name = "productid")
    private Integer productId;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "averageleadtime")
    private Integer averageLeadTime;

    @Column(name = "standardprice")
    private Double standardPrice;

    @Column(name = "lastreceiptcost")
    private Double lastReceiptCost;

    @Column(name = "lastreceiptdate")
    private Timestamp lastReceiptDate;

    @Column(name = "minorderqty")
    private Integer minOrderQuantity;

    @Column(name = "maxorderqty")
    private Integer maxOrderQuantity;

    @Column(name = "onorderqty")
    private Integer onOrderQuantity;

    @Column(name = "unitmeasurecode")
    private Character unitMeasureCode;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
