import { Component } from '@angular/core';
import { BatchService } from '../batch.service';
import { Router } from '@angular/router';
import { Batch } from '../batch';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-create-batch',
  templateUrl: './create-batch.component.html',
  styleUrls: ['./create-batch.component.css']
})
export class CreateBatchComponent {

  batch : Batch = new Batch();


  addForm=new FormGroup(
    {
    name:new FormControl(''), 
    year:new FormControl('')
  })

  getName()
  {
    return this.addForm.get('name');
  }
  getYear()
  {
    return this.addForm.get('year');
  }

  
  constructor(private batchService: BatchService,
    private router: Router){ }
  ngOnInit(): void {
    
  }

  saveBatch(){
    this.batchService.createBatch(this.batch).subscribe(data =>{
      console.log(data);
      this.goToEmployeeList();
    },error => console.log(error)); 
  }

  goToEmployeeList(){
    this.router.navigate(['/managebatch']);
  }
 onSubmit(){

    console.log(this.batch);
    this.saveBatch();
  }

}
