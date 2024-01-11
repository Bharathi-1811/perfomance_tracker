import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { TopicService } from '../topic.service';
import { Router } from '@angular/router';
import { Topic } from '../topic';

@Component({
  selector: 'app-create-topic',
  templateUrl: './create-topic.component.html',
  styleUrls: ['./create-topic.component.css']
})
export class CreateTopicComponent {

 topic : any={};

  constructor(private topicService: TopicService,
    private router: Router) { }
  

  createTopic = new FormGroup(
  {
    topicName: new FormControl(''),
  })

  getTopicName() {
    return this.createTopic.get('topicName');
  }


  saveBatch() {
    this.topicService.createTopic(this.topic).subscribe(data => {
      console.log(data);
      this.gotoTopicList();
    },
      error => console.log(error));
  }

  gotoTopicList() {
    this.router.navigate(['/managetopic']);
  }

  onSubmit() {
    this.topic = this.createTopic.value;
    this.saveBatch();
  }
}
