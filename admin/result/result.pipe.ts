import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'result'
})
export class ResultPipe implements PipeTransform {

  transform(value: number | string, ...args: unknown[]): any {
    
    if(value==0)
    {
      return "-";
    }
    if(value=="Fail")
    {
      return "Not Decided";
    }
  }

}
