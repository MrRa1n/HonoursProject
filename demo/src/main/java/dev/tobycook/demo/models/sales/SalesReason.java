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

    @JsonManagedReference
    @OneToMany(mappedBy = "salesReason")
    private List<SalesOrderHeaderSalesReason> salesOrderHeaderSalesReasons;
}
