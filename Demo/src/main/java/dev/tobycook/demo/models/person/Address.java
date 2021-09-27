package dev.tobycook.demo.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
}
