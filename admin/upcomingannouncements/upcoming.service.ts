import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Upcomingtest } from 'src/app/admin/upcomingannouncements/upcomingtest';

@Injectable({
  providedIn: 'root'
})
export class UpcomingService {

  private baseURL="http://localhost:8090/api/v1/upcomingtest"


  constructor(private http:HttpClient) { }

  createcom(trac:Upcomingtest):Observable<object>
  {
    return this.http.post(`${this.baseURL}`,trac);
  }

  getcomAll():Observable<Upcomingtest[]>
  {
    return this.http.get<Upcomingtest[]>(`${this.baseURL}`);
  }

  getPastAll():Observable<Upcomingtest[]>
  {
    return this.http.get<Upcomingtest[]>(`${this.baseURL}`+`/getpast`);
  }
  
  getOnGoing():Observable<Upcomingtest[]>
  {
    return this.http.get<Upcomingtest[]>(`${this.baseURL}`+`/getongoing`);
  }

  getcomById(id:number):Observable<Upcomingtest>
  {
    return this.http.get<Upcomingtest>(`${this.baseURL}`+`/${id}`);
  }

  updatecom(id:number,trac:Upcomingtest):Observable<Object>
  {
    return this.http.put(`${this.baseURL}`+`/${id}`,trac);
  }

  deletecom(id:number):Observable<Object>
  {
    return this.http.delete(`${this.baseURL}`+`/${id}`);
  }

  //getRetestNo
  getRetestNo(id:number):Observable<Object>
  {
    return this.http.get(`${this.baseURL}`+`/getretestno/${id}`)
  }

}
