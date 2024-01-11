import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { BatchtraineeserviceService } from '../batchtraineeservice.service';

@Component({
  selector: 'app-manage-batch-trainee-combo',
  templateUrl: './manage-batch-trainee-combo.component.html',
  styleUrls: ['./manage-batch-trainee-combo.component.css']
})
export class ManageBatchTraineeComboComponent {

  alldata !:any[];
  

  constructor(private router:Router,private batchTraineeService: BatchtraineeserviceService)
  {

  }
  ngOnInit():void{
    this.getTraineeBatchAll();
  }

  private getTraineeBatchAll()
  {
     this.batchTraineeService.getTraineeAll().subscribe(data=>
      {
        console.log(data);
        this.alldata=data;
        // console.log(this.alldata);
      });
  }


  edit(id : number){
    console.log(id);
    // this.router.navigate(['/edit',id]);
  }
  
  delete(id : number){
    console.log(id);
  }
  

}
