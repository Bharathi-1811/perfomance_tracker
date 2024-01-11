import { Component, OnInit } from '@angular/core';
import { TopicService } from '../topic.service';
import { Router } from '@angular/router';
import { Topic } from '../topic';

@Component({
  selector: 'app-manage-topic',
  templateUrl: './manage-topic.component.html',
  styleUrls: ['./manage-topic.component.css']
})
export class ManageTopicComponent implements OnInit{

  topics!: Topic[];

  constructor(private topicservice: TopicService,private router: Router){
  
  }
  
  ngOnInit(): void {
    this.getTopics();
  }

  private getTopics() {
    this.topicservice.getTopicList().subscribe(data => {
        this.topics = data;
    });
  }

  updateTopic(id : number){
    this.router.navigate(['/updatetopic',id]);
  }

  deleteTopic(id : number){
    this.topicservice.deleteTopicById(id).subscribe(data=>{
      this.getTopics();
    });
    
  }


}
