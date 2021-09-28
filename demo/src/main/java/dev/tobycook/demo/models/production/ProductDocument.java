package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productdocument")
public class ProductDocument implements Serializable {

    private static final long serialVersionUID = -816248467928117351L;

    @Id
    @Column(name = "productid")
    private Integer id;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @Id
    @Column(name = "documentnode")
    private String documentNode;
}
