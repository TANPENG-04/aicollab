package com.pengtan.aicollab.controller;

import com.pengtan.aicollab.dto.WorkspaceRequest;
import com.pengtan.aicollab.dto.WorkspaceResponse;
import com.pengtan.aicollab.service.WorkspaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/workspaces")
@Tag(name = "工作空间模块")
public class WorkspaceController {

    @Autowired
    private WorkspaceService workspaceService;

    @Operation(summary = "创建工作空间")
    @PostMapping
    public WorkspaceResponse create(@RequestBody WorkspaceRequest request, Principal principal) {
        String username = principal.getName();   // 从 SecurityContext 获取当前登录用户
        return workspaceService.createWorkspace(request, username);
    }

    @Operation(summary = "获取我的工作空间")
    @GetMapping
    public List<WorkspaceResponse> getMyWorkspaces(Principal principal) {
        String username = principal.getName();
        return workspaceService.getMyWorkspaces(username);
    }
}