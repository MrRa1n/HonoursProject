package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.person.BusinessEntity;
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

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private BusinessEntity businessEntity;

    @JsonManagedReference
    @OneToMany(mappedBy = "store")
    private List<Customer> customers;
}
