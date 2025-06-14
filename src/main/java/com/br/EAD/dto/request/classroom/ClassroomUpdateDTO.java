package com.br.EAD.dto.request.classroom;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record ClassroomUpdateDTO(
         @NotNull(message = "This field cannot be empty")
         UUID id,
         @NotBlank(message = "This field cannot be empty")
         String tittle,
         @NotBlank(message = "This field cannot be empty")
         String description,
         @NotBlank(message = "This field cannot be empty")
         String linkVideo) {
}
