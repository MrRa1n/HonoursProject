package dev.tobycook.demo.models.person;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.sales.CountryRegionCurrency;
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
@Table(schema = "person", name = "countryregion")
public class CountryRegion {
    @Id
    @Column(name = "countryregioncode")
    private String countryRegionCode;

    @Column(name = "name")
    private String name;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "countryRegion")
    private List<StateProvince> stateProvinces;

    @JsonManagedReference
    @OneToMany(mappedBy = "countryRegion")
    private List<CountryRegionCurrency> countryRegionCurrencies;
}
