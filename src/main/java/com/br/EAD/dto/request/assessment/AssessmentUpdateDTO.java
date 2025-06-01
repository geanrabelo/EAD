package com.br.EAD.dto.request.assessment;

import com.br.EAD.enums.Type;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record AssessmentUpdateDTO(
                                  @NotNull(message = "This field cannot be empty")
                                  Long id,
                                  @NotBlank(message = "This field cannot be empty")
                                  String tittle,
                                  @NotBlank(message = "This field cannot be empty")
                                  Type type,
                                  @NotNull(message = "This field cannot be empty")
                                  UUID courseId) {
}
