package com.evaluation.service.impl;

import com.evaluation.entity.Student;
import com.evaluation.repository.IGenericRepo;
import com.evaluation.repository.IStudentRepo;
import com.evaluation.service.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl extends CRUDImpl<Student, Integer> implements IStudentService {

    private final IStudentRepo repo;

    @Override
    protected IGenericRepo<Student, Integer> getRepo() {
        return repo;
    }

    @Override
    public List<Student> getOrderAge() {
        List<Student> list = repo.findAll().stream()
                .sorted(Comparator.comparingInt(Student::getAge).reversed())
                .toList();
        return list;
    }

    /*@Override
    public String showRelationShip() {
        Map<String, String> relation = repo.findAll().stream()
                .collect();
        return "?";
    }*/

}
