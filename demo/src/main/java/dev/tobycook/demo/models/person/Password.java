package dev.tobycook.demo.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "person", name = "password")
public class Password {
    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "passwordhash")
    private String passwordHash;

    @Column(name = "passwordsalt")
    private String passwordSalt;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
