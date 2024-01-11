import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ResultService } from '../result.service';
import { Result } from '../result-view/result';

@Component({
  selector: 'app-result-add',
  templateUrl: './result-add.component.html',
  styleUrls: ['./result-add.component.css']
})
export class ResultAddComponent {

  result!:Result[];
  id!:number;
  constructor(private route:ActivatedRoute,private resultService:ResultService,private router:Router)
  {

  }

  ngOnInit():void
  {
    this.id = this.route.snapshot.params['id']; 
    this.getResultByTestId(this.id);
  }
  
  getResultByTestId(id:number)
  {
    this.resultService.getResultByTestId(this.id).subscribe(data=>{
      this.result = data;
    });
  }
  edit(value:number)
  {
    this.router.navigate(['/editresult',this.id,value]);
  }
  
  handleImport($event:any)
  {
    console.log($event);
  }
  handleExport()
  {

  }

  //


  // selectedFiles: FileList;
  // currentFile: File;
  // progress = 0;
  // message = '';

  // fileInfos: Observable<any>;

  // constructor(private uploadService: UploadFileService) { }

  // selectFile(event) {
  //   this.selectedFiles = event.target.files;
  // }

  // upload() {
  //   this.progress = 0;
  
  //   this.currentFile = this.selectedFiles.item(0);
  //   this.uploadService.upload(this.currentFile).subscribe(
  //     event => {
  //       if (event.type === HttpEventType.UploadProgress) {
  //         this.progress = Math.round(100 * event.loaded / event.total);
  //       } else if (event instanceof HttpResponse) {
  //         this.message = event.body.message;
  //         this.fileInfos = this.uploadService.getFiles();
  //       }
  //     },
  //     err => {
  //       this.progress = 0;
  //       this.message = 'Could not upload the file!';
  //       this.currentFile = undefined;
  //     });
  
  //   this.selectedFiles = undefined;
  // }


}
