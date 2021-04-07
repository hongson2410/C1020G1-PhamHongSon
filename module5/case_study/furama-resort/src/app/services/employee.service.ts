import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  public API: string = 'http://localhost:3000/employees';

  constructor(public httpClient: HttpClient) {
  }

  getAllEmployee(): Observable<any> {
    return this.httpClient.get(this.API);
  }

  addNewEmployee(employee): Observable<any> {
    return this.httpClient.post(this.API, employee);
  }

  getEmployeeById(id: number): Observable<any> {
    return this.httpClient.get(this.API + '/' + id);
  }

  deleteEmployee(id: number): Observable<any> {
    return this.httpClient.delete((this.API + '/' + id));
  }

  updateEmployee(employee): Observable<any> {
    return this.httpClient.patch(this.API + '/' + employee.id, employee);
  }
}
