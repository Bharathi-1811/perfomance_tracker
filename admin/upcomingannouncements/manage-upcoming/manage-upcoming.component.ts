import { Component } from '@angular/core';
import { Upcomingtest } from 'src/app/admin/upcomingannouncements/upcomingtest';
import { UpcomingService } from '../upcoming.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manage-upcoming',
  templateUrl: './manage-upcoming.component.html',
  styleUrls: ['./manage-upcoming.component.css']
})
export class ManageUpcomingComponent {

  tracs!:Upcomingtest[];
  past!:Upcomingtest[];
  ongoing!:Upcomingtest[];

  constructor(private perservice:UpcomingService, private router:Router)
  {

  }
  ngOnInit():void{
    this.getAllcom();
    this.getAllPast();
    this.getOnGoing();
  }
  private getAllcom()
  {
     this.perservice.getcomAll().subscribe(data=>
      {
        this.tracs=data;
        console.log(this.tracs);
      });
      
  }

  private getAllPast()
  {
     this.perservice.getPastAll().subscribe(data=>
      {
        this.past=data;
        console.log(this.tracs);
      });
      
  }

  private getOnGoing()
  {
     this.perservice.getOnGoing().subscribe(data=>
      {
        this.ongoing=data;
        console.log(this.tracs);
      });
      
  }

  updatecombination(id : number){
    this.router.navigate(['/updateupcomingtest',id]);
  }
  
  deletecom(id : number){
    this.perservice.deletecom(id).subscribe(data=> {
      console.log(data);
      this.getAllcom();
    });
  }
  
}
