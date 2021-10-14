package dev.tobycook.demo.models.person;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private BusinessEntity businessEntity;

    @ManyToOne
    @JoinColumn(name = "personid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Person person;

    @ManyToOne
    @JoinColumn(name = "contacttypeid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private ContactType contactType;
}
