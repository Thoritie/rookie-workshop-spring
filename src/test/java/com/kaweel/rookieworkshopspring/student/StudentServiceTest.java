package com.kaweel.rookieworkshopspring.student;

import com.kaweel.rookieworkshopspring.config.handle.BusinessException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @InjectMocks
    StudentService studentService;

    @Mock
    StudentRepository studentRepository;

    @Test
    @DisplayName("Should found student by name")
    public void foundByName() {
        Student student = new Student();
        student.setName("Ink");

        BDDMockito.given(this.studentRepository.findByName(Mockito.anyString())).willReturn(Optional.of(student));
        Student ink = this.studentService.getByName("Ink");
        Assertions.assertEquals("Ink", ink.getName());
    }

    @Test
    @DisplayName("When search 'something' should not found")
    public void notfoundByName() {
        Student student = new Student();
        student.setName("Ink");

        BDDMockito.given(this.studentRepository.findByName(Mockito.anyString())).willReturn(Optional.empty());
        Assertions.assertThrows(BusinessException.class, () -> this.studentService.getByName("Ink"));
    }

}
