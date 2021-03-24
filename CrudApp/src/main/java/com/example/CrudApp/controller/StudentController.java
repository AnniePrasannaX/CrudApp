package com.example.CrudApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.CrudApp.domain.Student;
import com.example.CrudApp.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studService;
	
	@RequestMapping(method = RequestMethod.GET,value="/students")
    public List<Student> allStudents() {

        return studService.getAllStudentList();
    }

    @RequestMapping(method = RequestMethod.GET,value="/students/{id}")
    public Student getStudent(@PathVariable("id") String id) {
        return studService.getStudent(id);
    }


    @RequestMapping(method = RequestMethod.POST, value = "/add")
    public  List<Student> addStu(@RequestBody Student stud) {
        return studService.addStudent(stud);

    }


    @RequestMapping(method = RequestMethod.PUT, value = "/update/{id}")
    public void updateStu(@RequestBody Student stud, @PathVariable("id") String id) {
        studService.updateStud(stud, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{id}")
    public void deleteStu(@PathVariable("id") String id) {
        studService.deleteStudent(id);
    }

}
