package dev.tobycook.demo.models.humanresources;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.person.Person;
import dev.tobycook.demo.models.purchasing.PurchaseOrderHeader;
import dev.tobycook.demo.models.sales.SalesPerson;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
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

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Person person;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<SalesPerson> salesPeople;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<JobCandidate> jobCandidates;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<EmployeePayHistory> employeePayHistory;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<EmployeeDepartmentHistory> employeeDepartmentHistory;

    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<PurchaseOrderHeader> purchaseOrderHeaders;
}
