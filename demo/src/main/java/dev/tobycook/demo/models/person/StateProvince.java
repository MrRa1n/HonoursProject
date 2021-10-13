package dev.tobycook.demo.models.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "person", name = "stateprovince")
public class StateProvince {
    @Id
    @Column(name = "stateprovinceid")
    private Integer id;

    @Column(name = "stateprovincecode")
    private Character code;

    @Column(name = "countryregioncode")
    private String countryRegionCode;

    @Column(name = "isonlystateprovinceflag")
    private Boolean isOnlyStateProvinceFlag;

    @Column(name = "name")
    private String name;

    @Column(name = "territoryid")
    private Integer territoryId;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "stateProvince")
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name = "countryregioncode", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private CountryRegion countryRegion;
}
