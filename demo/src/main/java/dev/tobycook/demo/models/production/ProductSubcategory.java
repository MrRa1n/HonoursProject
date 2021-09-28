package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productsubcategory")
public class ProductSubcategory {
    @Id
    @Column(name = "productsubcategoryid")
    private Integer id;

    @Column(name = "productcategoryid")
    private Integer categoryId;

    @Column(name = "name")
    private String name;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
