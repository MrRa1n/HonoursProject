package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "specialoffer")
public class SpecialOffer {
    @Id
    @Column(name = "specialofferid")
    private Integer id;

    @Column(name = "description")
    private String description;

    @Column(name = "discountpct")
    private Double discountPercentage;

    @Column(name = "type")
    private String type;

    @Column(name = "category")
    private String category;

    @Column(name = "startdate")
    private Timestamp startDate;

    @Column(name = "enddate")
    private Timestamp endDate;

    @Column(name = "minqty")
    private Integer minQuantity;

    @Column(name = "maxqty")
    private Integer maxQuantity;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "specialOffer")
    private List<SpecialOfferProduct> specialOfferProducts;
}
