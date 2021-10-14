package dev.tobycook.demo.models.sales;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "currencyrate")
public class CurrencyRate {
    @Id
    @Column(name = "currencyrateid")
    private Integer id;

    @Column(name = "currencyratedate")
    private Timestamp date;

    @Column(name = "fromcurrencycode")
    private Character[] fromCurrencyCode;

    @Column(name = "tocurrencycode")
    private Character[] toCurrencyCode;

    @Column(name = "averagerate")
    private Double averageRate;

    @Column(name = "endofdayrate")
    private Double endOfDayRate;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "currencyRate")
    private List<SalesOrderHeader> salesOrderHeaders;

    @ManyToOne
    @JoinColumn(name = "fromcurrencycode", insertable = false, updatable = false)
    @JsonBackReference
    private Currency fromCurrency;

    @ManyToOne
    @JoinColumn(name = "tocurrencycode", insertable = false, updatable = false)
    @JsonBackReference
    private Currency toCurrency;
}
