import { Component, HostBinding, Input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admin-topnav',
  templateUrl: './admin-topnav.component.html',
  styleUrls: ['./admin-topnav.component.css']
})
export class AdminTopnavComponent {

  constructor(private router: Router)
  {

  }

  public data =["Profile"];
  public value:string="";


  setElement($event: string)
  {
    this.value = $event;
    if(this.value == "Profile")
    {
        this.router.navigate(["/profile"])
    }
    console.log(this.value)
    
  }

  toggleControl = new FormControl(false);

  @Input() collapsed = false;
  @Input() screenWidth = 0;

  getNavbar(): string {
    let styleClass = '';
    if (this.collapsed && this.screenWidth > 768) {
      styleClass = 'nav-trimmed';
    }
    else if (this.collapsed && this.screenWidth <= 768 && this.screenWidth > 0) {
      styleClass = 'nav-md-screen';
    }
    return styleClass;
 
 }

}
