package com.pengtan.aicollab.repository;

import com.pengtan.aicollab.entity.Workspace;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WorkspaceRepository extends JpaRepository<Workspace, Long> {

    // 新增这行：根据用户名查询我拥有的工作空间（JPA 自动实现）
    List<Workspace> findByOwnerUsername(String username);
}