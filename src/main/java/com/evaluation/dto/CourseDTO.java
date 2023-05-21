package com.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDTO {

    private Integer idCourse;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String nameCourse;

    @NotNull
    @NotEmpty
    @Size(min = 1, max = 50)
    private String siglasCourse;

    @NotNull
    private boolean statusCourse;
}
