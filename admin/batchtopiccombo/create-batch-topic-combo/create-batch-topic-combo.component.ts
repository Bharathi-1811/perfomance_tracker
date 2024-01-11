import { Component } from '@angular/core';
import { BatchtopiccomboService } from '../batchtopiccombo.service';
import { Router } from '@angular/router';
import { BatchTopicCombination } from '../batch-topic-combination';
import { FormControl, FormGroup } from '@angular/forms';
import { BatchService } from '../../batch/batch.service';
import { TopicService } from '../../topic/topic.service';
import { Batch } from '../../batch/batch';
import { Topic } from '../../topic/topic';

@Component({
  selector: 'app-create-batch-topic-combo',
  templateUrl: './create-batch-topic-combo.component.html',
  styleUrls: ['./create-batch-topic-combo.component.css']
})
export class CreateBatchTopicComboComponent {


  com: any = {};
  batch!: Batch[];
  topic!: Topic[];

  combine: BatchTopicCombination = new BatchTopicCombination();

  constructor(private perservice: BatchtopiccomboService, private router: Router, private batchService: BatchService, private topicService: TopicService) {

  }

  ngOnInit(): void {

    this.batchService.getBatchList().subscribe(data => {
      this.batch = data;
      console.log(this.batch);
    });
    this.topicService.getTopicList().subscribe(data => {
      this.topic = data;
      console.log(this.topic);
    });
  }

  createcombination = new FormGroup(
    {
      batchId: new FormControl(''),
      topicId: new FormControl('')

    })

  getBatchId() {
    return this.createcombination.get("batchId");
  }
  getTopicId() {
    return this.createcombination.get("topicId");
  }
  gotocomlistcomponent() {
    this.router.navigate(['/managebtcombination']);
  }

  saveCombination() {
    this.perservice.createCombination(this.com).subscribe(data => {
      console.log(data)
    });
    this.gotocomlistcomponent();
  }

  comSubmit() {
    this.com = this.createcombination.value;
    console.log(this.com);
    this.saveCombination();

  }
}
