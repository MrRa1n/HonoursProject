package dev.tobycook.demo.models.production;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productmodel")
public class ProductModel {
    @Id
    @Column(name = "productmodelid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "catalogdescription")
    private String catalogDescription;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "productModel")
    private List<Product> products;

    @JsonManagedReference
    @OneToMany(mappedBy = "productModel")
    private List<ProductModelIllustration> productModelIllustrations;

    @JsonManagedReference
    @OneToMany(mappedBy = "productModel")
    private List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures;
}
