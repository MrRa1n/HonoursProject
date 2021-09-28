package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productproductphoto")
public class ProductProductPhoto implements Serializable {

    private static final long serialVersionUID = -6521399359369297221L;

    @Id
    @Column(name = "productid")
    private Integer id;

    @Id
    @Column(name = "productphotoid")
    private Integer photoId;

    @Column(name = "primary")
    private Boolean primary;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
