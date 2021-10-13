package dev.tobycook.demo.models.purchasing;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dev.tobycook.demo.models.person.BusinessEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "purchasing", name = "vendor")
public class Vendor {
    @Id
    @Column(name = "businessentityid")
    private Integer businessEntityId;

    @Column(name = "accountnumber")
    private String accountNumber;

    @Column(name = "name")
    private String name;

    @Column(name = "creditrating")
    private Short creditRating;

    @Column(name = "preferredvendorstatus")
    private Boolean preferredVendorStatus;

    @Column(name = "activeflag")
    private Boolean isActive;

    @Column(name = "purchasingwebserviceurl")
    private String purchasingWebServiceUrl;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "businessentityid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private BusinessEntity businessEntity;
}
