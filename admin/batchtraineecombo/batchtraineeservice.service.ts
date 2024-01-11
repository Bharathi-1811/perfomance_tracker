import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { BatchTraineeCombo } from './BatchTraineeCombo';
import { TraineeList } from './create-batch-trainee-combo/create-batch-trainee-combo.component';

@Injectable({
  providedIn: 'root'
})
export class BatchtraineeserviceService {

  constructor(private http:HttpClient) { }

  private baseURL="http://localhost:8090/api/v1/batchtraineecombination";

  getTraineeCombo():Observable<BatchTraineeCombo[]>
  {
    return this.http.get<BatchTraineeCombo[]>(`${this.baseURL}`);
  }
  
  addTraineeCombo(batchId:number,t:TraineeList[]):Observable<object>
  {
    return this.http.post<TraineeList[]>(`${this.baseURL}/${batchId}`,t);
  }
  
  getTraineeAll():Observable<BatchTraineeCombo[]>
  {
    return this.http.get<BatchTraineeCombo[]>(`${this.baseURL}`+`/getall`);
  }

}
