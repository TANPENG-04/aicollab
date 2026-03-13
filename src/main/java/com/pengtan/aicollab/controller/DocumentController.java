package com.pengtan.aicollab.controller;

import com.pengtan.aicollab.dto.DocumentRequest;
import com.pengtan.aicollab.dto.DocumentResponse;
import com.pengtan.aicollab.service.DocumentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/documents")
@Tag(name = "文档模块")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Operation(summary = "创建文档")
    @PostMapping
    public DocumentResponse create(@RequestBody DocumentRequest request, Principal principal) {
        String username = principal.getName();
        return documentService.createDocument(request, username);
    }
    @Operation(summary = "获取工作空间下的所有文档")
    @GetMapping("/workspace/{workspaceId}")
    public List<DocumentResponse> getByWorkspace(@PathVariable Long workspaceId) {
        return documentService.getDocumentsByWorkspace(workspaceId);
    }
}