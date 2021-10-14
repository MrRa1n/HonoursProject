package dev.tobycook.demo.models.person;

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
@Table(schema = "person", name = "address")
public class Address {
    @Id
    @Column(name = "addressid")
    private Integer id;

    @Column(name = "addressline1")
    private String addressLine1;

    @Column(name = "addressline2")
    private String addressLine2;

    @Column(name = "city")
    private String city;

    @Column(name = "stateprovinceid")
    private Integer stateProvinceId;

    @Column(name = "postalcode")
    private String postCode;

    @Column(name = "spatiallocation")
    private String spatialLocation;

    @Column(name = "rowguid")
    private UUID rowguid;

    @Column(name = "modifieddate")
    private Timestamp modifieddate;

    @JsonManagedReference
    @OneToMany(mappedBy = "address")
    private List<BusinessEntityAddress> businessEntityAddresses;

    @ManyToOne
    @JoinColumn(name = "stateprovinceid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private StateProvince stateProvince;
}
