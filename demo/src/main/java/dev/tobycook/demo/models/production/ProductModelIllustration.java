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
@Table(schema = "production", name = "productmodelillustration")
public class ProductModelIllustration implements Serializable {

    private static final long serialVersionUID = -7652523848155641172L;

    @Id
    @Column(name = "productmodelid")
    private Integer id;

    @Id
    @Column(name = "illustrationid")
    private Integer illustrationId;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "productmodelid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private ProductModel productModel;

    @ManyToOne
    @JoinColumn(name = "illustrationid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Illustration illustration;
}
