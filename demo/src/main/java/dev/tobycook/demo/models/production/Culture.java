package dev.tobycook.demo.models.production;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "culture")
public class Culture {
    @Id
    @Column(name = "cultureid")
    private Character[] id;

    @Column(name = "name")
    private String name;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "culture")
    private List<ProductModelProductDescriptionCulture> productModelProductDescriptionCultures;
}
