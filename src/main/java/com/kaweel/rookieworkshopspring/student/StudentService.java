package com.kaweel.rookieworkshopspring.student;

import com.kaweel.rookieworkshopspring.config.handle.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student getByName(String name) {
        return this.studentRepository.findByName(name).orElseThrow(() -> {
            throw new BusinessException(HttpStatus.NOT_FOUND);
        });
    }
}
