package com.pengtan.aicollab.service;

import com.pengtan.aicollab.dto.WorkspaceRequest;
import com.pengtan.aicollab.dto.WorkspaceResponse;
import com.pengtan.aicollab.entity.User;
import com.pengtan.aicollab.entity.Workspace;
import com.pengtan.aicollab.repository.UserRepository;
import com.pengtan.aicollab.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkspaceService {

    @Autowired
    private WorkspaceRepository workspaceRepository;

    @Autowired
    private UserRepository userRepository;

    public WorkspaceResponse createWorkspace(WorkspaceRequest request, String username) {
        User owner = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        Workspace workspace = new Workspace();
        workspace.setName(request.getName());
        workspace.setOwner(owner);

        workspaceRepository.save(workspace);

        WorkspaceResponse response = new WorkspaceResponse();
        response.setId(workspace.getId());
        response.setName(workspace.getName());
        response.setCreatedAt(workspace.getCreatedAt());
        return response;
    }

    public List<WorkspaceResponse> getMyWorkspaces(String username) {
        // 从数据库查询当前用户拥有的所有工作空间
        List<Workspace> workspaces = workspaceRepository.findByOwnerUsername(username);

        // 转成响应对象
        return workspaces.stream().map(workspace -> {
            WorkspaceResponse response = new WorkspaceResponse();
            response.setId(workspace.getId());
            response.setName(workspace.getName());
            response.setCreatedAt(workspace.getCreatedAt());
            return response;
        }).toList();
    }
}