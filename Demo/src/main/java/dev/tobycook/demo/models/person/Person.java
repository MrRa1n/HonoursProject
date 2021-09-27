package dev.tobycook.demo.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
}
