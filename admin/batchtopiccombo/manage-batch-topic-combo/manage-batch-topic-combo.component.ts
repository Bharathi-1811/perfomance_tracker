import { Component } from '@angular/core';
import { BatchtopiccomboService } from '../batchtopiccombo.service';
import { Router } from '@angular/router';
import { BatchTopicCombination } from '../batch-topic-combination';

@Component({
  selector: 'app-manage-batch-topic-combo',
  templateUrl: './manage-batch-topic-combo.component.html',
  styleUrls: ['./manage-batch-topic-combo.component.css']
})
export class ManageBatchTopicComboComponent {

  coms!:BatchTopicCombination[];


  constructor(private perservice:BatchtopiccomboService, private router:Router)
  {

  }
  ngOnInit():void{
    this.getcombination();
  }
  private getcombination()
  {
     this.perservice.getAllBatchTopicCombination().subscribe(data=>
      {
        console.log(data);
        this.coms=data;
        // console.log(this.coms);
      });
  }

  updatecombination(id : number){
    this.router.navigate(['/updatebtcombination',id]);
  }
  
  deletecombination(id : number){
    this.perservice.DeleteBatchTopicCombinationById(id).subscribe(data=> {
      console.log(data);
      this.getcombination();
    });
  }

}
