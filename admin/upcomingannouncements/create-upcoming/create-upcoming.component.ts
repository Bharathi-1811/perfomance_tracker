import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { UpcomingService } from '../upcoming.service';
import { Router } from '@angular/router';
import { Upcomingtest } from 'src/app/admin/upcomingannouncements/upcomingtest';
import { BatchService } from '../../batch/batch.service';
import { Batch } from '../../batch/batch';
import { BatchtopiccomboService } from '../../batchtopiccombo/batchtopiccombo.service';
import { BatchTopicCombination } from '../../batchtopiccombo/batch-topic-combination';

@Component({
  selector: 'app-create-upcoming',
  templateUrl: './create-upcoming.component.html',
  styleUrls: ['./create-upcoming.component.css']
})
export class CreateUpcomingComponent implements OnInit {

  combination: any = {};
  retestNo:any;
  trac: Upcomingtest = new Upcomingtest();
  combo!: BatchTopicCombination[];

  constructor(private perservice: UpcomingService,private btService:BatchtopiccomboService,private router: Router) {

  }
  ngOnInit(): void {
    this.btService.getAllBatchTopicCombination().subscribe(data=>{
        console.log(data);
        this.combo = data;
    })
  }

  createcom = new FormGroup(
    {
      combinationId: new FormControl(''),
      retestNo: new FormControl(''),
      selectDate: new FormControl('')
    });

  getCombinationId() {
    return this.createcom.get("combinationId");
  }
  getRetestNo() {
    return this.createcom.get("retestNo");
  }
  getSelectDate() {
    return this.createcom.get("selectDate");
  }

  gotolistcomponent() {
    this.router.navigate(['/manageupcomingtest']);
  }

  onSelected(value: any):void
  { 
    this.getBatchTopicRetestNo(value);
  }

  saveCombination() {
    this.perservice.createcom(this.combination).subscribe(data => {
      console.log(data)
    });
    this.gotolistcomponent();
  }
  getBatchTopicRetestNo(value:number) : void
  {
    this.perservice.getRetestNo(value).subscribe(data=>{
        this.retestNo = data;
        console.log(this.retestNo);
    });
  }

  formSubmit() {
    this.combination = this.createcom.value;
    this.saveCombination();
  }

}
