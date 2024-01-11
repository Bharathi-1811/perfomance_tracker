import { Component } from '@angular/core';
import { BatchService } from '../batch.service';
import { Router } from '@angular/router';
import { Batch } from '../batch';

@Component({
  selector: 'app-manage-batch',
  templateUrl: './manage-batch.component.html',
  styleUrls: ['./manage-batch.component.css']
})
export class ManageBatchComponent {

  batches!: Batch[];

  constructor(private batchService: BatchService,
    private router : Router) {}
  
  ngOnInit(): void {
   this.getBatch();
}
  private getBatch() {
    this.batchService.getBatchList().subscribe(data => {
      this.batches = data;
      console.log(this.batches);
    });
  }

  updateBatch(id : number){
    this.router.navigate(['updatebatch',id]);
  }

  deleteBatch(id : number){
    this.batchService.deleteBatch(id).subscribe(data => {
      console.log(data);
      this.getBatch();
    })
  }

}
