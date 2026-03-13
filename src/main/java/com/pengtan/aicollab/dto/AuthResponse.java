package com.pengtan.aicollab.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "认证响应")
public class AuthResponse {
    @Schema(example = "eyJhbGciOiJIUzI1NiJ9...")
    private String token;
    @Schema(example = "testuser")
    private String username;

    public AuthResponse(String token, String username) {
        this.token = token;
        this.username = username;
    }
}