package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "unitmeasure")
public class UnitMeasure {
    @Id
    @Column(name = "unitmeasurecode")
    private Character[] code;

    @Column(name = "name")
    private String name;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
