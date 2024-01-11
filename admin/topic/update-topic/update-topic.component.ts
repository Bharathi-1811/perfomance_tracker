import { Component, OnInit } from '@angular/core';
import { TopicService } from '../topic.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup } from '@angular/forms';
import { Topic } from '../topic';

@Component({
  selector: 'app-update-topic',
  templateUrl: './update-topic.component.html',
  styleUrls: ['./update-topic.component.css']
})
export class UpdateTopicComponent implements OnInit {

  topic: Topic = new Topic();
  id!:number;


  constructor(private topicService: TopicService,
    private router: Router,private route: ActivatedRoute) { }


  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];

    this.topicService.getTopicById(this.id).subscribe(data => {
      this.topic = data;

    }, error => console.log(error));
  
  }
  

  updateTopic = new FormGroup(
  {
    topicId: new FormControl(''),
    topicName: new FormControl(''),
  })

  getTopicId()
  {
    return this.updateTopic.get('topicId');
  }
  getTopicName() {
    return this.updateTopic.get('topicName');
  }

  gotoTopicList() {
    this.router.navigate(['/managetopic']);
  }

  onSubmit() {
  
    this.topicService.updateTopic(this.id,this.topic).subscribe(data => {
      console.log(data);
      },
      error => console.log(error));
      this.gotoTopicList();
  }

}