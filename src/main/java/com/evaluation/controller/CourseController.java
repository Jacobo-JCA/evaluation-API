package com.evaluation.controller;

import com.evaluation.dto.CourseDTO;
import com.evaluation.entity.Course;
import com.evaluation.service.ICourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final ICourseService service;

    @Qualifier("courseMapper")
    private final ModelMapper mapper;

    @GetMapping
    public ResponseEntity<List<CourseDTO>> readAll() throws Exception {
        List<CourseDTO> list = service.readAll().stream()
                                                .map(this::convertToDto)
                                                .collect(Collectors.toList());
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseDTO> readByid(@PathVariable("id") Integer id) throws Exception {
        CourseDTO dto = this.convertToDto(service.readById(id));
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CourseDTO> create(@Valid @RequestBody CourseDTO dto) throws Exception{
        Course obj = service.save(convertToEntity(dto));
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseDTO> update(@PathVariable("id") Integer id, @Valid @RequestBody CourseDTO dto) throws Exception {
        dto.setIdCourse(id);
        Course obj = service.update(convertToEntity(dto), id);
        return new ResponseEntity<>(this.convertToDto(obj), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    ////////////convert
    public CourseDTO convertToDto(Course obj) {
        return mapper.map(obj, CourseDTO.class);
    }

    public Course convertToEntity(CourseDTO dto) {
        return mapper.map(dto, Course.class);
    }
}
