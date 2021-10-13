package dev.tobycook.demo.models.humanresources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "humanresources", name = "employeepayhistory")
public class EmployeePayHistory implements Serializable {

    private static final long serialVersionUID = -1369491151348125259L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "ratechangedate")
    private Timestamp rateChangeDate;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "payfrequency")
    private Short payFrequency;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Employee employee;
}
