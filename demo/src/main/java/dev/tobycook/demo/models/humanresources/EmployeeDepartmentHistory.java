package dev.tobycook.demo.models.humanresources;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

}
