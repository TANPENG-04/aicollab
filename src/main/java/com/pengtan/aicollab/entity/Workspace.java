package com.pengtan.aicollab.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Entity
@Table(name = "workspaces")
@Data
@EqualsAndHashCode(callSuper = true)
public class Workspace extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    private List<Document> documents;

    @OneToMany(mappedBy = "workspace", cascade = CascadeType.ALL)
    private List<Task> tasks;
}