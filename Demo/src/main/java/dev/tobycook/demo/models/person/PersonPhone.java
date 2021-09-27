package dev.tobycook.demo.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
}
