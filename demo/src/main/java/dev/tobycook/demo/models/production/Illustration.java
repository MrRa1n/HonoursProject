package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "illustration")
public class Illustration {
    @Id
    @Column(name = "illustrationid")
    private Integer id;

    @Column(name = "diagram")
    private String diagram;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
