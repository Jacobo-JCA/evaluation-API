package com.evaluation.controller;

import com.evaluation.dto.RegisterEnrollmentDTO;
import com.evaluation.entity.RegisterEnrollment;
import com.evaluation.service.IRegisterEnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/enrollments")
public class RegisterEnrollmentController {

    private final IRegisterEnrollmentService service;

    @Qualifier("registerMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<RegisterEnrollmentDTO>> readAll() throws Exception {
        List<RegisterEnrollmentDTO> list = service.readAll().stream()
                                                            .map(this::convertToDto)
                                                            .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegisterEnrollmentDTO> readById(@PathVariable("id") Integer id) throws Exception {
        RegisterEnrollment obj = service.readById(id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RegisterEnrollmentDTO> create(@Valid @RequestBody RegisterEnrollmentDTO dto) throws Exception {
        RegisterEnrollment obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RegisterEnrollmentDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody RegisterEnrollmentDTO dto) throws Exception {
        dto.setIdRegister(id);
        RegisterEnrollment obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    ////////////////////////consult

    @GetMapping("/relation/courses/students")
    public ResponseEntity<Map<String, String>> relationOnCoursesStudent() throws Exception {
        Map<String, String> relation = service.relationOnCourseStudent();
        return new ResponseEntity<>(relation, HttpStatus.OK);
    }


    //////////////////////////////////////////
    public RegisterEnrollmentDTO convertToDto(RegisterEnrollment obj) {
        return mapper.map(obj, RegisterEnrollmentDTO.class);
    }

    public RegisterEnrollment convertToEntity(RegisterEnrollmentDTO dto) {
        return mapper.map(dto, RegisterEnrollment.class);
    }

}
