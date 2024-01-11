import { Component } from '@angular/core';
import { ManagetraineeService } from '../managetrainee.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { Addtrainee } from '../addtrainee';

@Component({
  selector: 'app-add-trainee',
  templateUrl: './add-trainee.component.html',
  styleUrls: ['./add-trainee.component.css']
})
export class AddTraineeComponent {

  sinkemail: any = {};

  szid: Addtrainee = new Addtrainee();

  constructor(private emailservice: ManagetraineeService, private router: Router) {

  }

  createsink = new FormGroup(
    {
      zid: new FormControl(''),
      email: new FormControl(''),

    })

  getZid() {
    return this.createsink.get("zid");
  }

  getEmail() {
    return this.createsink.get("email");
  }

  gotolistcomponent() {
    this.router.navigate(['/managetrainee']);
  }

  saveCombination() {
    this.emailservice.createsink(this.sinkemail).subscribe(data => {
      console.log(data)
    });
    this.gotolistcomponent();
  }

  formSubmit() {
    this.sinkemail = this.createsink.value;
    this.saveCombination();
  }


}
