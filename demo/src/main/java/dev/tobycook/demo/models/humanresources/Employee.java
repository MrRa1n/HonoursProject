package dev.tobycook.demo.models.humanresources;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "humanresources", name = "employee")
public class Employee {
    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "nationalidnumber")
    private String nationalIdNumber;

    @Column(name = "loginid")
    private String loginId;

    @Column(name = "jobtitle")
    private String jobTitle;

    @Column(name = "birthdate")
    private Date birthDate;

    @Column(name = "maritalstatus")
    private Character maritalStatus;

    @Column(name = "gender")
    private Character gender;

    @Column(name = "hiredate")
    private Date hireDate;

    @Column(name = "salariedflag")
    private Boolean isSalaried;

    @Column(name = "vacationhours")
    private Short vacationHours;

    @Column(name = "sickleavehours")
    private Short sickLeaveHours;

    @Column(name = "currentflag")
    private Boolean isCurrent;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @Column(name = "organizationnode")
    private String organisationNode;
}
