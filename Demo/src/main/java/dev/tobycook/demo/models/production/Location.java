package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "location")
public class Location {
    @Id
    @Column(name = "locationid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "costrate")
    private Double costRate;

    @Column(name = "availability")
    private Double availability;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
