package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "countryregioncurrency")
public class CountryRegionCurrency {
    @Id
    @Column(name = "countryregioncode")
    private String countryRegionCode;

    @Id
    @Column(name = "currencycode")
    private Character currencyCode;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
