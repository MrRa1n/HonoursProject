package dev.tobycook.demo.models.production;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
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

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "documentnode", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Document document;
}
