package dev.tobycook.demo.models.production;

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
@Table(schema = "production", name = "productreview")
public class ProductReview {
    @Id
    @Column(name = "productreviewid")
    private Integer id;

    @Column(name = "productid")
    private Integer productid;

    @Column(name = "reviewername")
    private String reviewerName;

    @Column(name = "reviewdate")
    private Timestamp reviewDate;

    @Column(name = "emailaddress")
    private String emailAddress;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "comments")
    private String comments;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @ManyToOne
    @JoinColumn(name = "productid", insertable = false, updatable = false, nullable = false)
    @JsonBackReference
    private Product product;
}
