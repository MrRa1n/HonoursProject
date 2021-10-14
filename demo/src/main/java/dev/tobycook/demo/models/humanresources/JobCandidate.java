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
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "humanresources", name = "jobcandidate")
public class JobCandidate {
    @Id
    @Column(name = "jobcandidateid")
    private Integer id;

    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "resume")
    private String resume;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Employee employee;
}
