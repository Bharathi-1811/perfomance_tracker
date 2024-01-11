import { Component } from '@angular/core';
import { BatchService } from '../batch.service';
import { Batch } from '../batch';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-update-batch',
  templateUrl: './update-batch.component.html',
  styleUrls: ['./update-batch.component.css']
})
export class UpdateBatchComponent {

  id!: number;

  constructor(private batchService: BatchService,
  private route: ActivatedRoute,
  private router: Router) { }
  upcomingdata: Batch = new Batch();

  updateBatch = new FormGroup(
    {
      batchId: new FormControl(''),
      name: new FormControl(''),
      year: new FormControl('')
    })

  getBatchId() {
    return this.updateBatch.get('BatchId');
  }

  getName() {
    return this.updateBatch.get('name');
  }
  getYear() {
    return this.updateBatch.get('year');
  }
  ngOnInit(): void {

    this.id = this.route.snapshot.params['id'];

    this.batchService.getBatchById(this.id).subscribe(data => {
      this.upcomingdata = data;
    }, error => console.log(error));
  }
  onSubmit() {
    this.batchService.updateBatch(this.id, this.upcomingdata).subscribe(data => {
      this.goToEmployeeList();
    },
      error => console.log(error));
     
  }

  goToEmployeeList() {
    this.router.navigate(['/managebatch']);
  }


}
