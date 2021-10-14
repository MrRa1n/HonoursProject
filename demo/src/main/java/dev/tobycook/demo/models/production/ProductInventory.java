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
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productinventory")
public class ProductInventory implements Serializable {

    private static final long serialVersionUID = -8516033337196732904L;

    @Id
    @Column(name = "productid")
    private Integer id;

    @Id
    @Column(name = "locationid")
    private Short locationId;

    @Column(name = "shelf")
    private String shelf;

    @Column(name = "bin")
    private Short bin;

    @Column(name = "quantity")
    private Short quantity;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "locationid", insertable = false, updatable = false)
    @JsonBackReference
    private Location location;
}
