package com.example.demo.Student;
import com.example.demo.Student.StudentRepository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService{
    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository)
    {
        this.studentRepository = studentRepository;
    }
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    public void addNewStudent(Student student)
    {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent())
        {
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
        System.out.println(student);
    }

    public void deleteStudent(Long id)
    {
        boolean exists = studentRepository.existsById(id);

        if(!exists)
        {
            throw new IllegalStateException("student with id " + id + " does not exist");
        }
        studentRepository.deleteById(id);

    }
    public Student findStudentById(Long id)
    {
       return  studentRepository.findStudentById(id).orElseThrow(() -> new UserNotFoundException ("the user you looking for is not found"));
    }
    public Student updateStudent(Student student)
    {
        return studentRepository.save(student);
    }
}