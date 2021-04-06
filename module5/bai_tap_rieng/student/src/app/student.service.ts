import {Injectable} from '@angular/core';
import {IStudent} from './student-info/model/IStudent';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private API_URL = 'http://localhost:3000/students';

  constructor(private httpClient: HttpClient) {
  }

  getAllStudent(): Observable<IStudent[]> {
    return this.httpClient.get<IStudent[]>(this.API_URL);
  }

  addStudent(student: IStudent): Observable<void> {
    return this.httpClient.post<void>(this.API_URL, student);
  }

  findStudent(id: number): Observable<IStudent> {
    return this.httpClient.get<IStudent>(`${this.API_URL}/${id}`);
  }

  deleteStudent(id: number): Observable<any> {
    return this.httpClient.delete(
      `${this.API_URL}/${id}`
    );
  }

  updateStudent(student: IStudent): Observable<IStudent> {
    return this.httpClient.patch<IStudent>(
      `${this.API_URL}/${student.id}`, student);
  }
}
