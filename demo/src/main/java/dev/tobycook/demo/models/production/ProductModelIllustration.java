package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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
}
