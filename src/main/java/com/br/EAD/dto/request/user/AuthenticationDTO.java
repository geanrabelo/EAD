package com.br.EAD.dto.request.user;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationDTO(
        @NotBlank(message = "This field cannot be empty")
        String email,
        @NotBlank(message = "This field cannot be empty")
        String password) {
}
