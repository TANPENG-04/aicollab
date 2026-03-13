package com.pengtan.aicollab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "创建文档请求")
public class DocumentRequest {
    @Schema(example = "毕设需求分析")
    private String title;
    
    @Schema(example = "这里是文档内容...")
    private String content;
    
    private Long workspaceId;   // 所属工作空间ID
}