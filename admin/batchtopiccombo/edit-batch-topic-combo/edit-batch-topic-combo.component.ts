import { Component } from '@angular/core';
import { BatchtopiccomboService } from '../batchtopiccombo.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BatchTopicCombination } from '../batch-topic-combination';
import { Batch } from '../../batch/batch';
import { Topic } from '../../topic/topic';
import { BatchService } from '../../batch/batch.service';
import { TopicService } from '../../topic/topic.service';

@Component({
  selector: 'app-edit-batch-topic-combo',
  templateUrl: './edit-batch-topic-combo.component.html',
  styleUrls: ['./edit-batch-topic-combo.component.css']
})
export class EditBatchTopicComboComponent {


  futureData: BatchTopicCombination = new BatchTopicCombination();
  id !: number;
  batch!: Batch[];
  topic!: Topic[];

  constructor(private perservice: BatchtopiccomboService,private batchService:BatchService,private topicService: TopicService, private route: ActivatedRoute, private router: Router) {
    
  }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.perservice.getBatchTopicCombinationById(this.id).subscribe(data => {
      this.futureData = data;
      console.log(this.futureData);
    }, error => console.log(error));

    this.batchService.getBatchList().subscribe(data => {
      this.batch = data;
      console.log(this.batch);
    });
    this.topicService.getTopicList().subscribe(data => {
      this.topic = data;
      console.log(this.topic);
    });

  }

  updatecombination = new FormGroup(
    {
      batchTopicId: new FormControl(''),
      batchId: new FormControl(''),
      topicId: new FormControl(''),
    })

  getBatchTopicId() {
    return this.updatecombination.get("batchTopicId");
  }
  getBatchId() {
    return this.updatecombination.get("batchId");
  }
  getTopicId() {
    return this.updatecombination.get("topicId");
  }

  gotolistpage() {
    this.router.navigate(['/managebtcombination']);
  }

  updateSubmit() {
    this.perservice.updateBatchTopicCombination(this.id,this.futureData).subscribe(data =>
    {
      console.log(data);
    });

    this.gotolistpage();
  }

}
