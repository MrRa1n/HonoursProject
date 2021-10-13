package dev.tobycook.demo.models.person;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.purchasing.Vendor;
import dev.tobycook.demo.models.sales.Store;
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
@Table(schema = "person", name = "businessentity")
public class BusinessEntity {
    @Id
    @Column(name = "businessentityid")
    private Integer id;

    @Column(name = "rowguid")
    private UUID rowguid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "businessEntity")
    private List<Store> stores;

    @JsonManagedReference
    @OneToMany(mappedBy = "businessEntity")
    private List<Vendor> vendors;

    @JsonManagedReference
    @OneToMany(mappedBy = "businessEntity")
    private List<BusinessEntityAddress> addresses;

    @JsonManagedReference
    @OneToMany(mappedBy = "businessEntity")
    private List<BusinessEntityContact> contacts;

    @JsonManagedReference
    @OneToMany(mappedBy = "businessEntity")
    private List<Person> people;
}
