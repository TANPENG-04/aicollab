package com.pengtan.aicollab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "文档响应")
public class DocumentResponse {
    private Long id;
    private String title;
    private String content;
    private Long workspaceId;
    private LocalDateTime createdAt;
}