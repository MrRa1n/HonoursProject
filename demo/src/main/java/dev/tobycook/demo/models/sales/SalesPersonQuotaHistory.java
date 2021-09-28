package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salespersonquotahistory")
public class SalesPersonQuotaHistory {
    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "quotadate")
    private Timestamp quotaDate;

    @Column(name = "salesquota")
    private Double salesQuota;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
