import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BatchTopicCombination } from './batch-topic-combination';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BatchtopiccomboService {


  private baseURL="http://localhost:8090/api/v1/batchtopiccombination";


  constructor(private http:HttpClient) { }

  createCombination(combine:BatchTopicCombination):Observable<object>
  {
    return this.http.post<BatchTopicCombination[]>(`${this.baseURL}`,combine);
  }

  getAllBatchTopicCombination():Observable<BatchTopicCombination[]>
  {
    return this.http.get<BatchTopicCombination[]>(`${this.baseURL}`);
  }

  getBatchTopicCombinationById(id:number):Observable<BatchTopicCombination>
  {
    return this.http.get<BatchTopicCombination>(`${this.baseURL}`+`/${id}`);
  }

  updateBatchTopicCombination(id:number,combine:BatchTopicCombination):Observable<object>
  {
    return this.http.put(`${this.baseURL}`+`/${id}`,combine)
  }

  DeleteBatchTopicCombinationById(id:number):Observable<Object>
  {
    return this.http.delete(`${this.baseURL}`+`/${id}`);
  }
}
