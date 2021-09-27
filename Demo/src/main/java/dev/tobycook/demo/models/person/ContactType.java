package dev.tobycook.demo.models.person;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "person", name = "contacttype")
public class ContactType {
    @Id
    @Column(name = "contacttypeid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
