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

    @JsonManagedReference
    @OneToMany(mappedBy = "creditCard")
    private List<SalesOrderHeader> salesOrderHeaders;

    @JsonManagedReference
    @OneToMany(mappedBy = "creditCard")
    private List<PersonCreditCard> personCreditCards;
}
