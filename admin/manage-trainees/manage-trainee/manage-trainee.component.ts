import { Component } from '@angular/core';
import { ManagetraineeService } from '../managetrainee.service';
import { Router } from '@angular/router';
import { Addtrainee } from '../addtrainee';
import {MatSnackBar} from '@angular/material/snack-bar';

@Component({
  selector: 'app-manage-trainee',
  templateUrl: './manage-trainee.component.html',
  styleUrls: ['./manage-trainee.component.css']
})
export class ManageTraineeComponent {

  szid !:Addtrainee[];
  trainee!:Addtrainee[];
  msg!:any;
  constructor(private emailservice:ManagetraineeService, private router:Router,private snackBar:MatSnackBar)
  {

  }
  ngOnInit():void{
    this.getsinkAll();
  }
  private getsinkAll()
  {
     this.emailservice.getsinkAll().subscribe(data=>
      {
        this.szid=data;
      });
  }


  updatesink(id : number){
    this.router.navigate(['/updatetrainee',id]);
  }
  
  deletesink(id : number){
    this.emailservice.deletesink(id).subscribe(data=> {
      console.log(data);
      this.getsinkAll();
    });
  }
  
  selectedCheckboxes: any[] = [];

  selectUnselectAll(event: any) {
    for (let i = 0; i < this.szid.length; i++) {
      this.szid[i]['isSelected'] = event.target.checked;

    }
  }

  singleChange(event: any, zid: any) {

    let id = this.szid.findIndex(item => item.zid == zid);
    this.szid[id]['isSelected'] = event.target.checked;
  }

  getSelectedCheckboxes() {

    this.selectedCheckboxes = this.szid.filter(check => check.isSelected);
    console.log(this.selectedCheckboxes);
    this.trainee = this.selectedCheckboxes;
    
    this.emailservice.sendEmail(this.trainee).subscribe(data=>{
        this.msg = data;
        // this.snackBar.open(this.msg, 'Dismiss', {

        //   duration: 3000,

        //   verticalPosition: 'bottom',

        //   panelClass: ['snackbar-success'],

        // });
    });
  }
}
