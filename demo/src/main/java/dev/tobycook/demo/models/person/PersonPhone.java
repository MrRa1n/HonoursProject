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

@Getter
@Setter
@Entity
@Table(schema = "person", name = "personphone")
public class PersonPhone implements Serializable {

    private static final long serialVersionUID = 4233489744425790163L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "phonenumber")
    private String phoneNumber;

    @Id
    @Column(name = "phonenumbertypeid")
    private Integer phoneNumberTypeId;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Person person;

    @ManyToOne
    @JoinColumn(name = "phonenumbertypeid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private PhoneNumberType phoneNumberType;
}
