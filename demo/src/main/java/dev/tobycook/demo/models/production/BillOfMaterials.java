package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "billofmaterials")
public class BillOfMaterials {
    @Id
    @Column(name = "billofmaterialsid")
    private Integer id;

    @Column(name = "productassemblyid")
    private Integer productAssemblyId;

    @Column(name = "componentid")
    private Integer componentId;

    @Column(name = "startdate")
    private Timestamp startDate;

    @Column(name = "enddate")
    private Timestamp endDate;

    @Column(name = "unitmeasurecode")
    private String unitMeasureCode;

    @Column(name = "bomlevel")
    private Short bomLevel;

    @Column(name = "perassemblyqty")
    private Double perAssemblyQuantity;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;
}
