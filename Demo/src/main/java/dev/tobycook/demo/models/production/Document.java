package dev.tobycook.demo.models.production;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(schema = "production", name = "document")
public class Document {
    @Column(name = "title")
    private String title;

    @Column(name = "owner")
    private Integer owner;

    @Column(name = "folderflag")
    private Boolean folderFlag;

    @Column(name = "filename")
    private String fileName;

    @Column(name = "fileextension")
    private String fileExtension;

    @Column(name = "revision")
    private Character revision;

    @Column(name = "changenumber")
    private Integer changeNumber;

    @Column(name = "status")
    private Short status;

    @Column(name = "documentsummary")
    private String documentSummary;

    @Column(name = "document")
    private Byte[] document;

    @Column(name = "rowguid")
    private UUID rowGuid;

    @Column(name = "modifieddate")
    private Timestamp modifiedDate;

    @Id
    @Column(name = "documentnode")
    private String documentNode;
}
