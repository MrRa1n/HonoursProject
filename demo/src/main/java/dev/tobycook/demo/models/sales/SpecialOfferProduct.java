package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.production.Product;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "specialofferproduct")
public class SpecialOfferProduct implements Serializable {

    private static final long serialVersionUID = -6177300140118144016L;

    @Id
    @Column(name = "specialofferid")
    private Integer specialOfferId;

    @Id
    @Column(name = "productid")
    private Integer productId;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false)
    @JsonBackReference
    private Product product;

    @ManyToOne
    @JoinColumn(name = "specialofferid", insertable = false, updatable = false)
    @JsonBackReference
    private SpecialOffer specialOffer;

    @JsonManagedReference
    @OneToMany(mappedBy = "specialOfferProduct")
    private List<SalesOrderDetail> salesOrderDetails;
}
