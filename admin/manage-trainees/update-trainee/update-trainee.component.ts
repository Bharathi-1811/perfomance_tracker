import { Component } from '@angular/core';
import { ManagetraineeService } from '../managetrainee.service';
import { FormGroup, FormControl } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Addtrainee } from '../addtrainee';

@Component({
  selector: 'app-update-trainee',
  templateUrl: './update-trainee.component.html',
  styleUrls: ['./update-trainee.component.css']
})
export class UpdateTraineeComponent {

  upcomingData: Addtrainee = new Addtrainee();
  id !: number;


  constructor(private emailservice: ManagetraineeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = this.route.snapshot.params['id'];
    this.emailservice.getsinkById(this.id).subscribe(data => {
      this.upcomingData = data;
    }, error => console.log(error));
  }


  updatesink = new FormGroup(
    {
      zid: new FormControl(''),
      email: new FormControl('')
    })

  getZid() {
    return this.updatesink.get("zid");
  }

  getEmail() {
    return this.updatesink.get("email");
  }


  gotolist() {
    this.router.navigate(['/managetrainee']);
  }

  onSubmit() {
    this.emailservice.updatesink(this.id, this.upcomingData).subscribe(data => {
    });

    this.gotolist();
  }

}
