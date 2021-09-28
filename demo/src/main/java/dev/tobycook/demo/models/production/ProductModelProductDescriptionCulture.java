package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productmodelproductdescriptionculture")
public class ProductModelProductDescriptionCulture implements Serializable {

    private static final long serialVersionUID = -2098295761933728223L;

    @Id
    @Column(name = "productmodelid")
    private Integer productModelId;

    @Id
    @Column(name = "productdescriptionid")
    private Integer productDescriptionId;

    @Id
    @Column(name = "cultureid")
    private Character[] cultureId;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
