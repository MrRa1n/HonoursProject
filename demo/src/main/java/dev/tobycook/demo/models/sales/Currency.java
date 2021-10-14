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

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "currency")
public class Currency {

    @Id
    @Column(name = "currencycode")
    private String currencyCode;
    private String name;
    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "fromCurrency")
    private List<CurrencyRate> fromCurrencyRates;

    @JsonManagedReference
    @OneToMany(mappedBy = "toCurrency")
    private List<CurrencyRate> toCurrencyRates;

    @JsonManagedReference
    @OneToMany(mappedBy = "currency")
    private List<CountryRegionCurrency> countryRegionCurrencies;
}
