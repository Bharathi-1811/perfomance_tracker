import { Injectable } from '@angular/core';
import { SearchTrainee } from './SearchTrainee';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class SearchserviceService {

  constructor(private http:HttpClient) { }
  
  url:string="http://localhost:8090/trainee";
  getSearchTrainee():Observable<SearchTrainee[]>{
    return this.http.get<SearchTrainee[]>(`${this.url}`+`/searchtrainee`);
}
}