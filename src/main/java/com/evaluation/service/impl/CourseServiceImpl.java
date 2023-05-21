package com.evaluation.service.impl;

import com.evaluation.entity.Course;
import com.evaluation.repository.ICourseRepo;
import com.evaluation.repository.IGenericRepo;
import com.evaluation.service.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl extends CRUDImpl<Course, Integer> implements ICourseService {

    private final ICourseRepo repo;
    @Override
    protected IGenericRepo<Course, Integer> getRepo() {
        return repo;
    }

}
