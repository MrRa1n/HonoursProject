package dev.tobycook.demo.models.sales;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "sales", name = "salesreason")
public class SalesReason {
    @Id
    @Column(name = "salesreasonid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "reasontype")
    private String type;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
