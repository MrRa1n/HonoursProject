package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

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
}
