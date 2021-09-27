package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productmodel")
public class ProductModel {
    @Id
    @Column(name = "productmodelid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "catalogdescription")
    private String catalogDescription;

    @Column(name = "instructions")
    private String instructions;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
