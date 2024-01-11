import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {
  transform(value: any, args?: any): any {
    if(!value) return null;
    if(!args) return value;
    
    args=args.toLowerCase();
    return value.filter(function(trainee:any){
      return JSON.stringify(trainee).toLowerCase().includes(args);
    }) 
  }
}
