package com.exam.demothymeleaf.service.impl;

import com.exam.demothymeleaf.entity.StudentEntity;
import com.exam.demothymeleaf.repository.StudentRepo;
import com.exam.demothymeleaf.service.StudentService;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public List<StudentEntity> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public void createNewStudent(StudentEntity studentEntity) {
        if (ObjectUtils.isEmpty(studentEntity)) {
            throw new NullPointerException("Student is empty");
        }
        studentRepo.save(studentEntity);
    }

    @Override
    public void deleteStudentById(Long id) throws Exception {
        Optional<StudentEntity> studentEntity = studentRepo.findById(id);
        if (!studentEntity.isPresent()) {
            throw new Exception("Student is empty");
        }
        studentRepo.deleteById(id);
    }
}
