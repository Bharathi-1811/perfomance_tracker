import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Addtrainee } from './addtrainee';

@Injectable({
  providedIn: 'root'
})
export class ManagetraineeService {

  private baseURL="http://localhost:8090/trainee";


  constructor(private http:HttpClient) { }

  createsink(szid:Addtrainee):Observable<object>
  {
    return this.http.post(`${this.baseURL}`+`/add`,szid);
  }

  getsinkAll():Observable<Addtrainee[]>
  {
    return this.http.get<Addtrainee[]>(`${this.baseURL}`+`/get`);
  }

  getsinkById(id:number):Observable<Addtrainee>
  {
    return this.http.get<Addtrainee>(`${this.baseURL}`+`/get/${id}`);
  }

  updatesink(id:number,szid:Addtrainee):Observable<object>
  {
    return this.http.put(`${this.baseURL}`+`/update/${id}`,szid)
  }

  deletesink(id:number):Observable<Object>
  {
    return this.http.delete(`${this.baseURL}`+`/delete/${id}`);
  }
  sendEmail(trainee:Addtrainee[]):Observable<object>
  {
    return this.http.post(`${this.baseURL}`+`/sendemail`,trainee);
  }


}


