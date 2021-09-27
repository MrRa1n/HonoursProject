package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

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
}
