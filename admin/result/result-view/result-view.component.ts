import { AfterViewInit, Component } from '@angular/core';
import { ViewChild, ElementRef, VERSION, } from '@angular/core';
import * as  Highcharts from 'highcharts';
import More from 'highcharts/highcharts-more';
More(Highcharts);
import Tree from 'highcharts/modules/treemap';
Tree(Highcharts);
import Heatmap from 'highcharts/modules/heatmap';
Heatmap(Highcharts);
// Load the exporting module.
import Exporting from 'highcharts/modules/exporting';
import { ActivatedRoute, Router } from '@angular/router';
import { Result } from './result';
import { ResultService } from '../result.service';
import { ViewResult } from './view-result';
// Initialize exporting module.
Exporting(Highcharts);



@Component({
    selector: 'app-result-view',
    templateUrl: './result-view.component.html',
    styleUrls: ['./result-view.component.css']
})
export class ResultViewComponent implements AfterViewInit {
    // private chart!: Highcharts.Chart;
    view:ViewResult[] =[]; 

    id!:number;
    // name = `Angular! v${VERSION.full}`;
    @ViewChild("container", { read: ElementRef }) container!: ElementRef;

    constructor(private router:Router,private route:ActivatedRoute,private resultService:ResultService) { }

    ngAfterViewInit(): void {
        console.log("Chart Initiating : "+this.view);
        
        // Highcharts.chart(this.container.nativeElement, {
        //     colorAxis: {
        //         minColor: '#FFFFFF',
        //         // maxColor: Highcharts.getOptions().colors[0],
        //     },
        //     series: [{
        //         type: 'treemap',
        //         //layoutAlgorithm: 'squarified',
        //         data: this.view,
        //     }],
        //     title: {
        //         text: 'Highcharts Treemap'
        //     }
        // })
    }


    
    ngOnInit() {
        this.id = this.route.snapshot.params['id'];
        this.resultService.getViewResultTestId(this.id).subscribe(data=>{
            this.view = data;
           console.log("initiating : "+this.view[0]);
           
            Highcharts.chart(this.container.nativeElement, {
                colorAxis: {
                    minColor: '#FFFFFF',
                    // maxColor: Highcharts.getOptions().colors[0],
                },
                series: [{
                    type: 'treemap',
                    //layoutAlgorithm: 'squarified',
                    data: this.view,
                }],
                title: {
                    text: 'Highcharts Treemap'
                }
            })
            
        });
    }

    piechart()
    {
        this.router.navigate(['traineepiechart',this.id]);
    }

}
