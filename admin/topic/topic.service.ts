import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Topic } from './topic';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TopicService {


  private baseURL = "http://localhost:8090/api/v1/topic";

  constructor(private httpclient:HttpClient) { 

  }

  createTopic(topic: Topic): Observable<Object>{
    return this.httpclient.post(`${this.baseURL}`,topic);
  }

  getTopicList(): Observable<Topic[]>{
    return this.httpclient.get<Topic[]>(`${this.baseURL}`);
  }

  getTopicById(id : number): Observable<Topic>{
    return this.httpclient.get<Topic>(`${this.baseURL}`+`/${id}`);
  }
  updateTopic(id : number, topic:Topic): Observable<Object>{
    return this.httpclient.put(`${this.baseURL}`+`/${id}`,topic);
    
  }
  deleteTopicById(id : number):Observable<Object>{
    return this.httpclient.delete(`${this.baseURL}`+`/${id}`);
  }


}
