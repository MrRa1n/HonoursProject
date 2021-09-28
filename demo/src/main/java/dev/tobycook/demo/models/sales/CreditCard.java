package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "creditcard")
public class CreditCard {
    @Id
    @Column(name = "creditcardid")
    private Integer id;

    @Column(name = "cardtype")
    private String type;

    @Column(name = "cardnumber")
    private String number;

    @Column(name = "expmonth")
    private Short expiryMonth;

    @Column(name = "expyear")
    private Short expiryYear;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
