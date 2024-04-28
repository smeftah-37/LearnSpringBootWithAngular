import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Student } from "./student";

@Injectable({
    providedIn: 'root'
})
export class CoursesService{
    private apiServerUrl = 'http://localhost:8080';
    constructor(private http: HttpClient){}
    public getStudent(): Observable<Student[]> {
        return this.http.get<any>(`${this.apiServerUrl}/api/student`);
    }
    public addStudent(student: Student): Observable<Student> {
        return this.http.post<any>(`${this.apiServerUrl}/api/student/add`,student);
    }
    public updateStudent(student: Student): Observable<Student> {
        return this.http.put<any>(`${this.apiServerUrl}/api/student/update`,student);
    }
    public deletetudent(studentId: number){
        return this.http.delete<any>(`${this.apiServerUrl}/api/student/studentId`);
    }


}