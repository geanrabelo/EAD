package com.br.EAD.dto.request.classroom;

import jakarta.validation.constraints.NotBlank;

public record ClassroomUpdateDTO(@NotBlank(message = "This field cannot be empty")
                                 String tittle,
                                 @NotBlank(message = "This field cannot be empty")
                                 String description,
                                 @NotBlank(message = "This field cannot be empty")
                                 String linkVideo) {
}
