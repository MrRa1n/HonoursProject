package dev.tobycook.demo.models.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.sales.Customer;
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
@Table(schema = "person", name = "person")
public class Person {
    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "persontype")
    private Character personType;

    @Column(name = "namestyle")
    private Boolean nameStyle;

    @Column(name = "title")
    private String title;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "middlename")
    private String middleName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "suffix")
    private String suffix;

    @Column(name = "emailpromotion")
    private Integer emailPromotion;

    @Column(name = "additionalcontactinfo")
    private String additionalContactInfo;

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
    @OneToMany(mappedBy = "person")
    private List<Customer> customers;

    @JsonManagedReference
    @OneToMany(mappedBy = "person")
    private List<BusinessEntityContact> contacts;
}
