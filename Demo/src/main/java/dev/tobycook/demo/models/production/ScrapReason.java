package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "scrapreason")
public class ScrapReason {
    @Id
    @Column(name = "scrapreasonid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
