package com.example.demo.Student;
import java.time.Period;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name = "student_sequence",
        sequenceName = "student_sequence",
        allocationSize = 1
    )
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_sequence")
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private String filiere;
    private String imageUrl;
    @Transient
    private Integer age;

    public Student()
    {

    }
    public Student(Long id, String name, String email, LocalDate dob,String filiere,String imageUrl)
    {
        this.name = name;
        this.id = id;
        this.dob = dob;
        this.email = email;
        this.filiere = filiere;
        this.imageUrl = imageUrl;
    }
    public Student( String name, String email, LocalDate dob,String filiere,String imageUrl)
    {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.filiere = filiere;
        this.imageUrl = imageUrl;


    }

    public String getName()
    {
        return name;
    }
    public String getImage()
    {
        return imageUrl;
    }
    public String getFiliere()
    {
        return filiere;
    }
    public Long getId()
    {
        return id;
    }
    public String getEmail()
    {
        return email;
    }
    public LocalDate getDob()
    {
        return dob;
    }
    public Integer getAge()
    {
        return Period.between(dob,LocalDate.now()).getYears();
    }
    @Override
        public String toString(){
            return "Student{ id=" + id + ", name='" + name + '\'' + ", email=" + email + ", dob=" + dob + ", age=" + age + '}'; 
        }
}