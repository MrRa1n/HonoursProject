package dev.tobycook.demo.models.sales;

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
@Table(schema = "sales", name = "salesterritory")
public class SalesTerritory {
    @Id
    @Column(name = "territoryid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "countryregioncode")
    private String countryRegionCode;

    @Column(name = "group")
    private String group;

    @Column(name = "salesytd")
    private Double salesYtd;

    @Column(name = "saleslastyear")
    private Double salesLastYear;

    @Column(name = "costytd")
    private Double costYtd;

    @Column(name = "costlastyear")
    private Double costLastYear;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesTerritory")
    private List<SalesOrderHeader> salesOrderHeaders;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesTerritory")
    private List<Customer> customers;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesTerritory")
    private List<SalesPerson> salesPeople;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesTerritory")
    private List<SalesTerritoryHistory> salesTerritoryHistory;
}
