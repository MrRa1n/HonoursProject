package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "personcreditcard")
public class PersonCreditCard implements Serializable {

    private static final long serialVersionUID = 2100530040108858127L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "creditcardid")
    private Integer creditCardId;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
