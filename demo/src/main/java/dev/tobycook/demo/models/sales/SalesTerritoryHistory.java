package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salesterritoryhistory")
public class SalesTerritoryHistory implements Serializable {

    private static final long serialVersionUID = -1104853762908457036L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "territoryid")
    private Integer territoryId;

    @Id
    @Column(name = "startdate")
    private Timestamp startDate;

    @Column(name = "enddate")
    private Timestamp endDate;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "territoryid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesTerritory salesTerritory;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesPerson salesPerson;
}
