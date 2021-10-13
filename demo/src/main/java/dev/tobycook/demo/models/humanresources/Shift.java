package dev.tobycook.demo.models.humanresources;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "humanresources", name = "shift")
public class Shift {
    @Id
    @Column(name = "shiftid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "starttime")
    private Time startTime;

    @Column(name = "endtime")
    private Time endTime;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "shift")
    private List<EmployeeDepartmentHistory> employeeDepartmentHistory;
}
