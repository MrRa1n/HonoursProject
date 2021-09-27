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
@Table(schema = "person", name = "businessentityaddress")
public class BusinessEntityAddress implements Serializable {

    private static final long serialVersionUID = -1598938183419955327L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "addressid")
    private Integer addressId;

    @Id
    @Column(name = "addresstypeid")
    private Integer addressTypeId;

    @Column(name = "rowguid")
    private UUID rowguid;

    @Column(name = "modifieddate")
    private Timestamp modifieddate;
}
