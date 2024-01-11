import { Component, HostBinding} from '@angular/core';
import { FormControl } from '@angular/forms';
import { NavigationEnd, NavigationStart, Router } from '@angular/router';

interface SideNavToggle {
  screenWidth: number;
  collapsed: boolean;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'result';


  //to display header and footer based on trainee/admin
  showHead: boolean = true;
  showTrainee:boolean = false;
  showAdmin:boolean = false;

  constructor(private router:Router)
  {
      router.events.forEach((event)=>{

        if(event instanceof NavigationStart)
        {
          if(event['url']=='/trainee' || event['url']=='/dashboard' || event['url']=='/announce' || event['url']=='/result' || event['url']=='/traineeviewprofile' || event['url']=='/traineeeditprofile' || event['url'].startsWith("/traineetopic") || event['url'].startsWith("/traineegraph") )
          {
            this.showHead = false;
            this.showTrainee = true;
            this.showAdmin = false;
          }
          else if(event['url']=='/dashboardsection' || event['url']=='/managetopic' || event['url']=='/createtopic' || event['url'].startsWith("/update") || 
            event['url']=='/manageupcomingtest' || event['url']=='/createupcomingtest' || event['url']=='/updateupcomingtest' || event['url']=='/createbatch' || event['url']=='/managebatch' || event['url'].startsWith("/updatebatch")
            ||  event['url']=='/managebtcombination' ||  event['url']=='/createbtcombination'  || event['url']=='/addresult' || event['url']=='/editresult'|| event['url']=='/manageresult' || event['url'].startsWith("/addresult") || event['url'].startsWith("/editresult")|| event['url'].startsWith("/viewresult") 
            || event['url']=='/addtrainee'|| event['url']=='/managetrainee' || event['url']=='/managebatchtraineecombo' || event['url']=='/addbatchtraineecombo' ||event['url'].startsWith("/admintraineeview")

            )
          {
            this.showHead = false;
            this.showTrainee = false;
            this.showAdmin = true;
          }
          else{
            this.showHead = true;
            this.showTrainee = false;
            this.showAdmin = false;
          }

            
        }

      })
  }


  isSideNavCollapsed = false;
  screenWidth = 0;

  onToggleSideNav(data: SideNavToggle): void {

    this.screenWidth = data.screenWidth;
    this.isSideNavCollapsed = data.collapsed;

  }

}

