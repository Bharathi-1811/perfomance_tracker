import { Component } from '@angular/core';
import { FormArray, FormBuilder, FormControl, FormGroup, ValidatorFn } from '@angular/forms';
import { Router } from '@angular/router';
import { BatchService } from '../../batch/batch.service';
import { Batch } from '../../batch/batch';
import { BatchtraineeserviceService } from '../batchtraineeservice.service';
import { BatchTraineeCombo } from '../BatchTraineeCombo';
import { map } from 'rxjs/operators';

export class TraineeList{
  zid!:string;
}

@Component({
  selector: 'app-create-batch-trainee-combo',
  templateUrl: './create-batch-trainee-combo.component.html',
  styleUrls: ['./create-batch-trainee-combo.component.css']
})
export class CreateBatchTraineeComboComponent {

  com: any = {};
  batch!: Batch[];
  batchId!:number;
  traineeArr!: BatchTraineeCombo[];
  form!: FormGroup;

  traineesList:TraineeList[]=[]

  constructor(private batchTraineeService: BatchtraineeserviceService, private router: Router, private batchService: BatchService, private formBuilder: FormBuilder) {
    
  }




  ngOnInit(): void {

    this.batchService.getBatchList().subscribe(data => {
      this.batch = data;
      console.log(this.batch);
    });

    this.batchTraineeService.getTraineeCombo().subscribe(data => {
      // console.log(data);
      this.traineeArr = data;
      this.traineeArr.forEach(() => this.traineeFormArray.push(new FormControl(false)));
      console.log(this.traineeArr);
    })
    
    
    this.form = this.formBuilder.group({
      batchId: new FormControl(''),
      trainees: new FormArray([])
    });
   
  }

  get traineeFormArray() {
    return this.form.controls.trainees as FormArray;
  }

  comSubmit() {

    this.traineesList = this.form.value.trainees.map((checked: any, i: number) => checked ? this.traineeArr[i].zid : null)
      .filter((v: null) => v !== null);
    console.log(this.traineesList);
    console.log(this.form.value.batchId);
    this.batchId = this.form.value.batchId;



    this.batchTraineeService.addTraineeCombo(this.batchId,this.traineesList).subscribe(data=>{
      console.log(data);
      this.router.navigate(['managebatchtraineecombo']);
    });


    
  }


}