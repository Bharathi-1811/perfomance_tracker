import { Component } from '@angular/core';
import { SearchTrainee } from './SearchTrainee';
import { SearchserviceService } from './searchservice.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-admin-dashboard',
  templateUrl: './admin-dashboard.component.html',
  styleUrls: ['./admin-dashboard.component.css']
})
export class AdminDashboardComponent {
  i : number = 1;
  trainees:SearchTrainee[] =[];
  searchtext:any;
  constructor(public search:SearchserviceService,private router:Router){
    
  }
  ngOnInit(): void{

    this.search.getSearchTrainee().subscribe((data)=>{
      console.log(data);
      this.trainees = data;
      
      // console.log(this.trainees);
    });

  }

  viewTrainee(value:number)
  {
    this.router.navigate(['/admintraineeview',value]);
  }

}