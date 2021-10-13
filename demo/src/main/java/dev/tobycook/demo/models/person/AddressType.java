package dev.tobycook.demo.models.person;

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
@Table(schema = "person", name = "addresstype")
public class AddressType {
    @Id
    @Column(name = "addresstypeid")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "addressType")
    private List<BusinessEntityAddress> addresses;
}
