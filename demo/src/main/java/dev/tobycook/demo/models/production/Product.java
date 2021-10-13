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
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "product")
public class Product {
    @Id
    @Column(name = "productid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "productnumber")
    private String number;

    @Column(name = "makeflag")
    private Boolean makeFlag;

    @Column(name = "finishedgoodsflag")
    private Boolean finishedGoodsFlag;

    @Column(name = "color")
    private String color;

    @Column(name = "safetystocklevel")
    private Short safetyStockLevel;

    @Column(name = "reorderpoint")
    private Short reorderPoint;

    @Column(name = "standardcost")
    private Double standardCost;

    @Column(name = "listprice")
    private Double listPrice;

    @Column(name = "size")
    private String size;

    @Column(name = "sizeunitmeasurecode")
    private String sizeUnitMeasureCode;

    @Column(name = "weightunitmeasurecode")
    private String weightUnitMeasureCode;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "daystomanufacture")
    private Integer daysToManufacture;

    @Column(name = "productline")
    private String productLine;

    @Column(name = "class")
    private String productClass;

    @Column(name = "style")
    private String style;

    @Column(name = "productsubcategoryid")
    private Integer subcategoryId;

    @Column(name = "productmodelid")
    private Integer modelId;

    @Column(name = "sellstartdate")
    private Timestamp sellStartDate;

    @Column(name = "sellenddate")
    private Timestamp sellEndDate;

    @Column(name = "discontinueddate")
    private Timestamp discontinuedDate;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "productmodelid", insertable = false, updatable = false)
    @JsonBackReference
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "productsubcategoryid", insertable = false, updatable = false)
    @JsonBackReference
    private ProductSubcategory productSubcategory;

    @ManyToOne
    @JoinColumn(name = "sizeunitmeasurecode", insertable = false, updatable = false)
    @JsonBackReference
    private UnitMeasure sizeUnitMeasure;

    @ManyToOne
    @JoinColumn(name = "weightunitmeasurecode", insertable = false, updatable = false)
    @JsonBackReference
    private UnitMeasure weightUnitMeasure;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<ProductDocument> productDocuments;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<ProductReview> productReviews;

    @JsonManagedReference
    @OneToMany(mappedBy = "product")
    private List<ProductProductPhoto> productProductPhoto;
}
