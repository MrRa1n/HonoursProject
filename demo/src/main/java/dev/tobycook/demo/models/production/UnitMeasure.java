package dev.tobycook.demo.models.production;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "unitmeasure")
public class UnitMeasure {
    @Id
    @Column(name = "unitmeasurecode")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "sizeUnitMeasure")
    private List<Product> sizeProducts;

    @JsonManagedReference
    @OneToMany(mappedBy = "weightUnitMeasure")
    private List<Product> weightProducts;
}
