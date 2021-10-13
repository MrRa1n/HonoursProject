package dev.tobycook.demo.models.humanresources;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "humanresources", name = "department")
public class Department {
    @Id
    @Column(name = "departmentid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "groupname")
    private String groupName;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
