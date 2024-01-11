import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { UpcomingService } from '../../upcomingannouncements/upcoming.service';
import { Upcomingtest } from '../../upcomingannouncements/upcomingtest';

@Component({
  selector: 'app-result-manage',
  templateUrl: './result-manage.component.html',
  styleUrls: ['./result-manage.component.css']
})
export class ResultManageComponent {

  tracs!:Upcomingtest[];
  constructor(private perservice:UpcomingService,private router: Router) {

  }
  ngOnInit(): void {
    this.getAllcom();
  }
  private getAllcom() {
    this.perservice.getcomAll().subscribe(data => {
      this.tracs = data;
      console.log(this.tracs);
    });

  }
  view(id:number) {
    this.router.navigate(['/viewresult',id]);
  }

  resultadd(id:number) {
    this.router.navigate(['/addresult',id]);
  }


}
