package com.evaluation.service;

import com.evaluation.entity.Student;

import java.util.List;

public interface IStudentService extends ICRUD<Student, Integer>{

    List<Student> getOrderAge();

    /*public String showRelationShip();*/
}
