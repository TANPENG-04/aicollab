package com.pengtan.aicollab.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "document_versions")
@Data
@EqualsAndHashCode(callSuper = true)
public class DocumentVersion extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "document_id", nullable = false)
    private Document document;

    @Column(columnDefinition = "TEXT")
    private String contentSnapshot;

    @ManyToOne
    @JoinColumn(name = "edited_by", nullable = false)
    private User editedBy;
}