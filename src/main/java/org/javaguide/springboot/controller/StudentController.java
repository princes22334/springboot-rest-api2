package org.javaguide.springboot.controller;

import org.javaguide.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//we can define base url for all rest Apis using @RequestMapping
@RequestMapping("/")
public class StudentController {

    //SPRING BOOT Rest Api that handles Http Post Request - Create new Resource
    // http://localhost:8080/student/create
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring Boot Rest Api that handles Http Put Request - Updating existing Resources
    @PutMapping("/student/{id}/update")     //{id} - url template variable
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int studentId){
        System.out.println(student.getFirstName());
        System.out.println(student.getLastName());
        return student;
    }

    //Spring Boot Rest Api that handles Http Delete Request - delete existing resources
    @DeleteMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable("id") int studentId){
        return "Student deleted Successfully: "+studentId;
    }

    //Response Entity represents the whole Http Response(status code, body and header)
    @GetMapping("/student/response")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(1, "Ankita", "Singh");
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    //Return header by Using Response Entity Class
    //headers are in the form of key-value Pair
    @GetMapping("/student/header")
    public ResponseEntity<Student> getStudents(){
        Student student = new Student(1, "Ankita", "Singh");
        //  return new ResponseEntity<>(student, HttpStatus.OK);
        return ResponseEntity.ok().header("custom-header", "Ramesh").body(student);
    }











}
