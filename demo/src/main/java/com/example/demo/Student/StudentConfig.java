package com.example.demo.Student;

import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
        //     // Student safae = new Student("safae","safae@gmail.com",LocalDate.of(2002,04,18),"Math","image.png");
        //     // Student islam = new Student("islam","islam@gmail.com",LocalDate.of(2002,04,18),"data scienst","image.png");
        //  repository.saveAll(List.of(safae,islam));   
        };



    }
    
}
