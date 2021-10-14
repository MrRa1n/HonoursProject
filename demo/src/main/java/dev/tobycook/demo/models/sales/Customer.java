package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.person.Person;
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
@Table(schema = "sales", name = "customer")
public class Customer {
    @Id
    @Column(name = "customerid")
    private Integer id;

    // can maybe drop this?
    @Column(name = "personid")
    private Integer personId;

    @Column(name = "storeid")
    private Integer storeId;

    @Column(name = "territoryid")
    private Integer territoryId;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "storeid", insertable = false, updatable = false)
    @JsonBackReference
    private Store store;

    @ManyToOne
    @JoinColumn(name = "personid", insertable = false, updatable = false)
    @JsonBackReference
    private Person person;

    @ManyToOne
    @JoinColumn(name = "territoryid", insertable = false, updatable = false)
    @JsonBackReference
    private SalesTerritory salesTerritory;

    @JsonManagedReference
    @OneToMany(mappedBy = "customer")
    private List<SalesOrderHeader> salesOrderHeaders;
}
