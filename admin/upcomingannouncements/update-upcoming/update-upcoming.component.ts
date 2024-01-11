import { Component } from '@angular/core';
import { UpcomingService } from '../upcoming.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Upcomingtest } from 'src/app/admin/upcomingannouncements/upcomingtest';
import { FormControl, FormGroup } from '@angular/forms';
import { BatchtopiccomboService } from '../../batchtopiccombo/batchtopiccombo.service';
import { BatchTopicCombination } from '../../batchtopiccombo/batch-topic-combination';

@Component({
  selector: 'app-update-upcoming',
  templateUrl: './update-upcoming.component.html',
  styleUrls: ['./update-upcoming.component.css']
})
export class UpdateUpcomingComponent {


  upcomingData: Upcomingtest = new Upcomingtest();
  combo : BatchTopicCombination[] = [];
  
  id !: number;
  

  constructor(private perservice: UpcomingService, private batchTopicComboService:BatchtopiccomboService,private route: ActivatedRoute, private router: Router) {


  }

  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];

    //getting particular update upcoming id (data)
    this.perservice.getcomById(this.id).subscribe(data => {
      this.upcomingData = data;
      console.log(data);
    }, error => console.log(error));

    //getting batch and topic from combo table
    this.batchTopicComboService.getAllBatchTopicCombination().subscribe(data=>{
      console.log(data);
      this.combo = data;
    });

  }


  updatecom = new FormGroup(
    {
      testId: new FormControl(''),
      combinationId: new FormControl(''),
      retestNo: new FormControl(''),
      selectDate: new FormControl('')    
    })

  getId() {
    return this.updatecom.get("testId");
  }
  getCombinationId() {
    return this.updatecom.get("combinationId");
  }
  getRetestNo() {
    return this.updatecom.get("retestNo");
  }
  getSelectDate() {
    return this.updatecom.get("selectDate");
  }

  gotolist() {
    this.router.navigate(['/manageupcomingtest']);
  }

  onSelected(value: any):void
  { 
    this.getBatchTopicRetestNo(value);
  }

  getBatchTopicRetestNo(value:number) : void
  {
    this.perservice.getRetestNo(value).subscribe(data=>{
     this.upcomingData.retestNo = parseInt(data.toString());
     console.log(this.upcomingData.retestNo);
    });
  }
  onSubmit() {
    this.perservice.updatecom(this.id, this.upcomingData).subscribe(data => {
    });
    this.gotolist();
  }

}
