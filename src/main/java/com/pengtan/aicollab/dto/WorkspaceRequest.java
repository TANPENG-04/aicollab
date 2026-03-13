package com.pengtan.aicollab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "创建工作空间请求")
public class WorkspaceRequest {
    @Schema(example = "毕业设计小组")
    private String name;
}