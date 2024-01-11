import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Result } from './result-view/result';
import { Observable } from 'rxjs';
import { ViewResult } from './result-view/view-result';
import { Piechart } from './graph-piechart/Piechart';

@Injectable({
  providedIn: 'root'
})
export class ResultService {

  private baseURL = "http://localhost:8090/api/v1/addresult";

  private URL = "http://localhost:8090/api/v1/viewresult";

  private baseUrl = "http://localhost:8090/api/v1/traineepiechart";
  constructor(private http:HttpClient) { }

  getResultByTestId(id:number):Observable<Result[]>
  {
    return this.http.get<Result[]>(`${this.baseURL}`+`/${id}`);
  }
  getResultByRid(id:number):Observable<Result>
  {
    return this.http.get<Result>(`${this.baseURL}`+`/rid/${id}`);
  }
  updateResultByRid(id:number,result:Result):Observable<Object>
  {
    return this.http.put(`${this.baseURL}`+`/${id}`,result)
  }
  // tree map
  getViewResultTestId(id:number):Observable<ViewResult[]>
  {
    return this.http.get<ViewResult[]>(`${this.URL}`+`/${id}`);
  }

  // pie chart
  getTraineePieChart(id:number):Observable<Piechart>
  {
    return this.http.get<Piechart>(`${this.baseUrl}`+`/${id}`);
  }
}
