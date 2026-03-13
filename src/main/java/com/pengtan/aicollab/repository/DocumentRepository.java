package com.pengtan.aicollab.repository;

import com.pengtan.aicollab.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DocumentRepository extends JpaRepository<Document, Long> {
    // 查询某个工作空间下的所有文档
    List<Document> findByWorkspaceId(Long workspaceId);
}