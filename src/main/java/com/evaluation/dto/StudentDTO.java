package com.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StudentDTO {

    private Integer idStudent;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String nameStudent;

    @NotNull
    @NotEmpty
    @Size(min = 3, max = 50)
    private String apellidoStudent;

    @NotNull
    @NotEmpty
    @Size(min = 10, max = 10)
    private String DNI;

    @NotNull
    @Min(1)
    @Max(99)
    private int ageStudent;
}
