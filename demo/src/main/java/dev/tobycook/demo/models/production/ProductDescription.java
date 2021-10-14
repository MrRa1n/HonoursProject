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
@Table(schema = "production", name = "productdescription")
public class ProductDescription {
    @Id
    @Column(name = "productdescriptionid")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "productDescription")
    private List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures;
}
