package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productdescription")
public class ProductDescription {
    @Id
    @Column(name = "productdescriptionid")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
