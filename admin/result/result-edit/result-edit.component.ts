import { Component } from '@angular/core';
import { Result } from '../result-view/result';
import { ResultService } from '../result.service';
import { FormGroup, FormControl } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-result-edit',
  templateUrl: './result-edit.component.html',
  styleUrls: ['./result-edit.component.css']
})
export class ResultEditComponent {

  // result!:Result[];

  result: Result = new Result();
  id!:number;
  value!:number;


  constructor(private resultService: ResultService,
    private router: Router,private route: ActivatedRoute) { }


  ngOnInit(): void {
    this.value = this.route.snapshot.params['value'];
    this.id = this.route.snapshot.params['id'];
    this.resultService.getResultByRid(this.value).subscribe(data => {
      this.result = data;

    }, error => console.log(error));
  
  }

  resultEdit = new FormGroup(
  {
    zid: new FormControl(''),
    mark: new FormControl(''),
  })

  getZid()
  {
    return this.resultEdit.get('topicId');
  }
  getMark() {
    return this.resultEdit.get('topicName');
  }

  gotoAddResult() {
    this.router.navigate(['/addresult',this.id]);
  }

  onSubmit() {
  
    this.resultService.updateResultByRid(this.value,this.result).subscribe(data => {
      console.log(data);
      },
      error => console.log(error));
      this.gotoAddResult();
  }



}
