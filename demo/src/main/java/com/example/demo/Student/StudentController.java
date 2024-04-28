package com.example.demo.Student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;



/**
 *
 * @author smeftah-
 */
@RestController
@RequestMapping(path = "api/student")
public class StudentController{


    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }
    @GetMapping
    public List<Student> index() {
        return studentService.getStudent();
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Student>  getSudentById(@PathVariable("id") Long id) {
        Student student = studentService.findStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }
    @PutMapping("/update")
    public ResponseEntity<Student>  updateStuent(@RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(student);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);

        //TODO: process PUT request
        
    }
    @PostMapping("/add")
    public void regiserNewStudent(@RequestBody Student student)
    {
        this.studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id)
    {
        this.studentService.deleteStudent(id);
    }
   


}