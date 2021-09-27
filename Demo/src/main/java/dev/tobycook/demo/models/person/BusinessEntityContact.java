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
@Table(schema = "person", name = "businessentitycontact")
public class BusinessEntityContact implements Serializable {

    private static final long serialVersionUID = 9184876744409446609L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "personid")
    private Integer personId;

    @Id
    @Column(name = "contacttypeid")
    private Integer contactTypeId;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
