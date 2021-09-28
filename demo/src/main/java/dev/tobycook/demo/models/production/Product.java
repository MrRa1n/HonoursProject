package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Character[] sizeUnitMeasureCode;

    @Column(name = "weightunitmeasurecode")
    private Character[] weightUnitMeasureCode;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "daystomanufacture")
    private Integer daysToManufacture;

    @Column(name = "productline")
    private Character[] productLine;

    @Column(name = "class")
    private Character[] productClass;

    @Column(name = "style")
    private Character[] style;

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
}
