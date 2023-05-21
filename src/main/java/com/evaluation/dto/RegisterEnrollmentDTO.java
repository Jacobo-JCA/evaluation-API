package com.evaluation.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterEnrollmentDTO {

    private Integer idRegister;

    @NotNull
    private LocalDateTime dateEnrollment;

    @NotNull
    private StudentDTO student;

    @JsonManagedReference
    private List<DetailEnrollmentDTO> details;

    @NotNull
    private boolean status;


}
