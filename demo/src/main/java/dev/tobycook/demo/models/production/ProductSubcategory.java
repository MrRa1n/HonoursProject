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

    @JsonManagedReference
    @OneToMany(mappedBy = "productSubcategory")
    private List<Product> products;

    @ManyToOne
    @JoinColumn(name = "productcategoryid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private ProductCategory productCategory;
}
