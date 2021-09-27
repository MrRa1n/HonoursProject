package dev.tobycook.demo.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "person", name = "emailaddress")
public class EmailAddress implements Serializable {

    private static final long serialVersionUID = -4883449971393581509L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "emailaddressid")
    private Integer emailAddressId;

    @Column(name = "emailaddress")
    private String emailAddress;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
