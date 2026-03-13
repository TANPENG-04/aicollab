package com.pengtan.aicollab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "注册请求")
public class RegisterRequest {
    @Schema(example = "testuser")
    private String username;
    
    @Schema(example = "123456")
    private String password;
    
    @Schema(example = "test@163.com")
    private String email;
}