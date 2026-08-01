package com.example.class10_dto;

import com.example.class10_dto.dto.StudentGpaRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Class10DtoApplication {

    public static void main(String[] args) {
        SpringApplication.run(Class10DtoApplication.class, args);


        Student student = new Student();
        student.setId(1);
        student.setName("john");
        student.setCgpa(3.76);

        StudentGpaRecord record = new StudentGpaRecord(student.getName(), student.getCgpa());
    }

}
