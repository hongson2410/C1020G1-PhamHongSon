import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PackageServiceService {
  public API_PACKAGE: string = 'http://localhost:3000/packages';
  public API_PRODUCT: string ='http://localhost:3000/products';

  constructor(public httpClient: HttpClient) {
  }

  getAllPackage(): Observable<any> {
    return this.httpClient.get(this.API_PACKAGE);
  }

  getAllProduct(): Observable<any> {
    return this.httpClient.get(this.API_PRODUCT);
  }

  getPackageByID(id: number):Observable<any>{
    return this.httpClient.get(this.API_PACKAGE + '/' + id);
  }

  deletePackage(id: number): Observable<any> {
    return this.httpClient.delete((this.API_PACKAGE + '/' + id));
  }

  addNewPackage(pack): Observable<any> {
    return this.httpClient.post(this.API_PACKAGE, pack);
  }
}
