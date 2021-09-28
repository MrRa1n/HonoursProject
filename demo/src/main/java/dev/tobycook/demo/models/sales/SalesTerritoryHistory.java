package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salesterritoryhistory")
public class SalesTerritoryHistory {
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
}
