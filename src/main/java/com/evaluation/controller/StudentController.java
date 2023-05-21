package com.evaluation.controller;

import com.evaluation.dto.StudentDTO;
import com.evaluation.entity.Student;
import com.evaluation.service.IStudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final IStudentService service;

    @Qualifier("studentMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<StudentDTO>> readAll() throws Exception {
        List<StudentDTO> list = service.readAll().stream()
                                        .map(this::converToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> readById(@PathVariable("id") Integer id) throws Exception {
        Student obj = service.readById(id);
        StudentDTO dto = this.converToDTO(obj);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDTO> create(@Valid @RequestBody StudentDTO dto) throws Exception {
        Student obj = service.save(this.convertToEntity(dto));
        return new ResponseEntity<>(this.converToDTO(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody StudentDTO dto) throws Exception {
        dto.setIdStudent(id);
        Student obj = service.update(this.convertToEntity(dto), id);
        return new ResponseEntity<>(this.converToDTO(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    //////////consultas/////////

    @GetMapping("/find/order")
    public ResponseEntity<List<StudentDTO>> getAllSortAge() throws Exception {
        List<StudentDTO> list = service.getOrderAge().stream()
                .map(this::converToDTO).collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    //////////////////////
    public StudentDTO converToDTO(Student obj) {
        return mapper.map(obj, StudentDTO.class);
    }

    public Student convertToEntity(StudentDTO dto) {
        return mapper.map(dto, Student.class);
    }
}
