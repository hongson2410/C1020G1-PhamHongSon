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
}
