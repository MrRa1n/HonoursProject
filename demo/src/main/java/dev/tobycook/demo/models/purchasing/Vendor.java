package dev.tobycook.demo.models.purchasing;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import dev.tobycook.demo.models.person.BusinessEntity;
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
import java.util.List;

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

    @JsonManagedReference
    @OneToMany(mappedBy = "vendor")
    private List<PurchaseOrderHeader> purchaseOrderHeaders;

    @JsonManagedReference
    @OneToMany(mappedBy = "vendor")
    private List<ProductVendor> productVendors;
}
