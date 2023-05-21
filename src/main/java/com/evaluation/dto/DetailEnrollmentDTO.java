package com.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DetailEnrollmentDTO {

    @JsonBackReference
    //@JsonIncludeProperties(value = {"idRegister"})
    private RegisterEnrollmentDTO register;

    @NotNull
    //@JsonIncludeProperties(value = {"courseId"})
    private CourseDTO courseEnrollment;

    @NotNull
    @NotEmpty
    private String aula;

}