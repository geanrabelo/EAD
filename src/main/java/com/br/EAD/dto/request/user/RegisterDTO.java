package com.br.EAD.dto.request.user;

import com.br.EAD.enums.Profile;
import jakarta.validation.constraints.NotBlank;

public record RegisterDTO(
        @NotBlank(message = "This field cannot be empty")
        String name,
        @NotBlank(message = "This field cannot be empty")
        String email,
        @NotBlank(message = "This field cannot be empty")
        String password,
        @NotBlank(message = "This field cannot be empty")
        Profile profile){
}
