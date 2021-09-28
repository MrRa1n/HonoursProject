package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

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
}
