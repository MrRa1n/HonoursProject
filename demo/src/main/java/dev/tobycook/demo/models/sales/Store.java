package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "store")
public class Store {
    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "name")
    private String name;

    @Column(name = "salespersonid")
    private Integer salesPersonId;

    @Column(name = "demographics")
    private String demographics;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
