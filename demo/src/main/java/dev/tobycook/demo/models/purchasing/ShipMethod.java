package dev.tobycook.demo.models.purchasing;

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
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "purchasing", name = "shipmethod")
public class ShipMethod {
    @Id
    @Column(name = "shipmethodid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "shipbase")
    private Double shipBase;

    @Column(name = "shiprate")
    private Double shipRate;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "shipMethod")
    private List<PurchaseOrderHeader> purchaseOrderHeaders;
}
