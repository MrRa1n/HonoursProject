package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.humanresources.Employee;
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
@Table(schema = "sales", name = "salesperson")
public class SalesPerson {
    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "territoryid")
    private Integer territoryId;

    @Column(name = "salesquota")
    private Double salesQuota;

    @Column(name = "bonus")
    private Double bonus;

    @Column(name = "commissionpct")
    private Double commissionPercentage;

    @Column(name = "salesytd")
    private Double salesYtd;

    @Column(name = "saleslastyear")
    private Double salesLastYear;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "territoryid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private SalesTerritory salesTerritory;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesPerson")
    private List<SalesTerritoryHistory> salesTerritoryHistory;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesPerson")
    private List<SalesOrderHeader> salesOrderHeaders;

    @JsonManagedReference
    @OneToMany(mappedBy = "salesPerson")
    private List<SalesPersonQuotaHistory> salesPersonQuotaHistory;
}
