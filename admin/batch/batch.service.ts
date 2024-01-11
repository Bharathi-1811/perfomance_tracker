import { Injectable } from '@angular/core';
import { Batch } from './batch';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BatchService {

  private baseURL = "http://localhost:8090/api/v1/batch";

  constructor(private httpclient:HttpClient) { }
  
  getBatchList(): Observable<Batch[]>{
    return this.httpclient.get<Batch[]>(`${this.baseURL}`);
  }

  createBatch(batch: Batch): Observable<Object>{
    return this.httpclient.post(`${this.baseURL}`, batch);
  }

  getBatchById(id : number): Observable<Batch>{
    return this.httpclient.get<Batch>(`${this.baseURL}`+`/${id}`);
  }
  updateBatch(id : number, batch:Batch): Observable<Object>{
    return this.httpclient.put(`${this.baseURL}`+`/${id}`,batch);
    
  }
  deleteBatch(id : number):Observable<Object>{
    return this.httpclient.delete(`${this.baseURL}`+`/${id}`);
  }

}
