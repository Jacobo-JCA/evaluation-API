package com.evaluation.service.impl;

import com.evaluation.dto.DetailEnrollmentDTO;
import com.evaluation.entity.DetailEnrollment;
import com.evaluation.entity.RegisterEnrollment;
import com.evaluation.repository.IGenericRepo;
import com.evaluation.repository.IRegisterEnrollmentRepo;
import com.evaluation.service.IRegisterEnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@RequiredArgsConstructor
public class RegisterEnrollmentServiceImpl extends CRUDImpl<RegisterEnrollment, Integer> implements IRegisterEnrollmentService {

    private final IRegisterEnrollmentRepo repo;
    @Override
    protected IGenericRepo<RegisterEnrollment, Integer> getRepo() {
        return repo;
    }

    @Override
    public Map<String, String> relationOnCourseStudent() {
        Stream<List<DetailEnrollment>> stream = repo.findAll()
                .stream()
                .map(RegisterEnrollment::getDetails);
        Stream<DetailEnrollment> detailsEnrollmentStream = stream.flatMap(Collection::stream);

        Map<String, String> coursesStudents = detailsEnrollmentStream
                                            .collect(Collectors.groupingBy(e -> e.getCourse().getName(),
                                                    Collectors.mapping(s -> s.getRegister().getStudent().getName(),
                                                            Collectors.joining(", "))));
        return coursesStudents;
    }
}
