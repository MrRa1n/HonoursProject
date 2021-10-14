package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.tobycook.demo.models.person.CountryRegion;
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
@Table(schema = "sales", name = "countryregioncurrency")
public class CountryRegionCurrency implements Serializable {

    private static final long serialVersionUID = 2324895246173096181L;

    @Id
    @Column(name = "countryregioncode")
    private String countryRegionCode;

    @Id
    @Column(name = "currencycode")
    private Character currencyCode;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "countryregioncode", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private CountryRegion countryRegion;

    @ManyToOne
    @JoinColumn(name = "currencycode", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Currency currency;
}
