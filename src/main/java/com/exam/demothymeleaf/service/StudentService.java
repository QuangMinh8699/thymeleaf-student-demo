package com.exam.demothymeleaf.service;

import com.exam.demothymeleaf.entity.StudentEntity;

import java.util.List;

public interface StudentService {

    List<StudentEntity> getAllStudent();

    void createNewStudent(StudentEntity studentEntity);

    void deleteStudentById(Long id) throws Exception;

}
