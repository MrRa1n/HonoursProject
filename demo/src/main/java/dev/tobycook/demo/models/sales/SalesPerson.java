package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
}
