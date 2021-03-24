package com.example.CrudApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.CrudApp.domain.Student;

@Service
public class StudentService {
	
	private List<Student> studList = new ArrayList<>(Arrays.asList(

            new Student("101","Chris", "Computer Science"),
            new Student("102","Rose", "Electronics"),
            new Student("103", "Evans", "Mechanical")

    ));
	
	public List<Student> getAllStudentList() {
        return studList;
    }

    public Student getStudent(String id) {
        return studList.stream().filter(student -> student.getId().equals(id)).findFirst().get();
    }


    public List<Student> addStudent(Student student) {
        studList.add(student);
        return studList;
    }


    public void updateStud(Student student, String id) {
        int counter = 0;
        for (Student stud : studList) {
            if (stud.getId().equals(id)) {
                studList.set(counter, stud);
            }
            counter++;
        }
    }

    public void deleteStudent(String id) {
        studList.removeIf(student -> student.getId().equals(id));
    }

}
