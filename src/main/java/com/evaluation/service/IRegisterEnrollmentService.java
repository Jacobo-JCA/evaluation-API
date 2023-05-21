package com.evaluation.service;

import com.evaluation.entity.RegisterEnrollment;

import java.util.Map;

public interface IRegisterEnrollmentService extends ICRUD<RegisterEnrollment, Integer>{
    Map<String, String> relationOnCourseStudent();
}
