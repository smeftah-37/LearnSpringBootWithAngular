import { Component, OnInit } from '@angular/core';
import { CoursesService } from './courses.service';
import { Student } from './student';
import { response } from 'express';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'courses',
  template: `<h2>angular</h2>`
})
export class CourseComponent implements OnInit {
  public students: Student[] = [];
  constructor(private studentService: CoursesService)
  {
  }
  ngOnInit(): void {
      // this.getStudent();
  }
  public getStudent(): void{
    this.studentService.getStudent().subscribe((response: Student[]) =>
    {
      this.students = response;
    },(error: HttpErrorResponse) => {
      alert(error.message);
    })
  }
}
