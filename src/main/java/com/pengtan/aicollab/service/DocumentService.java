package com.pengtan.aicollab.service;

import com.pengtan.aicollab.dto.DocumentRequest;
import com.pengtan.aicollab.dto.DocumentResponse;
import com.pengtan.aicollab.entity.Document;
import com.pengtan.aicollab.entity.User;
import com.pengtan.aicollab.entity.Workspace;
import com.pengtan.aicollab.repository.DocumentRepository;
import com.pengtan.aicollab.repository.UserRepository;
import com.pengtan.aicollab.repository.WorkspaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository documentRepository;
    @Autowired
    private WorkspaceRepository workspaceRepository;
    @Autowired
    private UserRepository userRepository;

    public DocumentResponse createDocument(DocumentRequest request, String username) {
        User creator = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("用户不存在"));

        Workspace workspace = workspaceRepository.findById(request.getWorkspaceId())
                .orElseThrow(() -> new RuntimeException("工作空间不存在"));

        Document document = new Document();
        document.setTitle(request.getTitle());
        document.setContent(request.getContent());
        document.setWorkspace(workspace);
        document.setCreatedBy(creator);

        documentRepository.save(document);

        DocumentResponse response = new DocumentResponse();
        response.setId(document.getId());
        response.setTitle(document.getTitle());
        response.setContent(document.getContent());
        response.setWorkspaceId(workspace.getId());
        response.setCreatedAt(document.getCreatedAt());
        return response;
    }
    public List<DocumentResponse> getDocumentsByWorkspace(Long workspaceId) {
        List<Document> documents = documentRepository.findByWorkspaceId(workspaceId);
        return documents.stream().map(doc -> {
            DocumentResponse response = new DocumentResponse();
            response.setId(doc.getId());
            response.setTitle(doc.getTitle());
            response.setContent(doc.getContent());
            response.setWorkspaceId(doc.getWorkspace().getId());
            response.setCreatedAt(doc.getCreatedAt());
            return response;
        }).toList();
    }
}