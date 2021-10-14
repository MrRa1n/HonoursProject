package dev.tobycook.demo.models.purchasing;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.tobycook.demo.models.production.UnitMeasure;
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

    @ManyToOne
    @JoinColumn(name = "unitmeasurecode", insertable = false, updatable = false)
    @JsonBackReference
    private UnitMeasure unitMeasure;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false)
    @JsonBackReference
    private Vendor vendor;
}
