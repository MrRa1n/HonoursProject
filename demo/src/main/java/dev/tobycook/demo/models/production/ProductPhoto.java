package dev.tobycook.demo.models.production;

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

@Getter
@Setter
@Entity
@Table(schema = "production", name = "productphoto")
public class ProductPhoto {
    @Id
    @Column(name = "productphotoid")
    private Integer id;

    @Column(name = "thumbnailphoto")
    private Byte[] thumbnailPhoto;

    @Column(name = "thumbnailphotofilename")
    private String thumbnailPhotoFileName;

    @Column(name = "largephoto")
    private Byte[] largePhoto;

    @Column(name = "largephotofilename")
    private String largePhotoFileName;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @JsonManagedReference
    @OneToMany(mappedBy = "productPhoto")
    private List<ProductProductPhoto> productProductPhotos;
}
