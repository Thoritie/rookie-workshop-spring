package com.kaweel.rookieworkshopspring.student;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")

public class Controller {
    @Autowired
    StudentService studentService;

    @GetMapping("/{name}")
    public ResponseEntity<Student> getByName(@PathVariable String name) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getByName(name));
    }

}
