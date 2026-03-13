package com.pengtan.aicollab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "登录请求")
public class LoginRequest {
    @Schema(example = "testuser")
    private String username;
    @Schema(example = "123456")
    private String password;
}