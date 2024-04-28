import { Component } from '@angular/core';
import { Student } from './course/student';
import { CoursesService } from './course/courses.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {

  title = 'first-angular';
  students: Student[] = []; // Define students array to hold the student data

  constructor(private coursesService: CoursesService) {}

  ngOnInit(): void {
    this.getStudents(); // Fetch students data when component initializes
  }

  getStudents(): void {
    this.coursesService.getStudent().subscribe(
      (response: Student[]) => {
        this.students = response; // Assign response to students array
      },
      (error) => {
        console.error('Error fetching students:', error);
      }
    );
  }
}
