package com.pengtan.aicollab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Schema(description = "工作空间响应")
public class WorkspaceResponse {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
}