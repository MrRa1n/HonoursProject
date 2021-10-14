package dev.tobycook.demo.models.humanresources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(schema = "humanresources", name = "employeedepartmenthistory")
public class EmployeeDepartmentHistory implements Serializable {

    private static final long serialVersionUID = -3540991940573067892L;

    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Id
    @Column(name = "departmentid")
    private Short departmentId;

    @Id
    @Column(name = "shiftid")
    private Short shiftId;

    @Id
    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "shiftid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Shift shift;

    @ManyToOne
    @JoinColumn(name = "departmentid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Department department;

}
