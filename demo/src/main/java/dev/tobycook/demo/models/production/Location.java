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

@Getter
@Setter
@Entity
@Table(schema = "production", name = "location")
public class Location {
    @Id
    @Column(name = "locationid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "costrate")
    private Double costRate;

    @Column(name = "availability")
    private Double availability;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "location")
    private List<WorkOrderRouting> workOrderRouting;

    @JsonManagedReference
    @OneToMany(mappedBy = "location")
    private List<ProductInventory> productInventory;
}
