package dev.tobycook.demo.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
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
}
