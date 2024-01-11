import { AfterViewInit, Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import * as Highcharts from 'highcharts';
import { ResultService } from '../result.service';
import { Piechart } from './Piechart';

@Component({
  selector: 'app-trainee-graph-piechart',
  templateUrl: './trainee-graph-piechart.component.html',
  styleUrls: ['./trainee-graph-piechart.component.css']
})
export class TraineeGraphPiechartComponent implements OnInit, AfterViewInit {
  private chart!: Highcharts.Chart;

  pie:Piechart = new Piechart;

  id!:number;
  constructor(private router:Router,private route:ActivatedRoute, private resultService:ResultService) { }
  ngOnInit() {
    this.id = this.route.snapshot.params['id']; 
    this.resultService.getTraineePieChart(this.id).subscribe(data=>{
      this.pie = data;
      console.log(this.pie);
      this.chart = new Highcharts.Chart({
        chart: {
          renderTo: 'pie-chart',
          type: 'pie',
          options3d: {
            enabled: true,
            alpha: 45,
            beta: 0,
          },
        },
        title: {
          text: 'Pass Or Fail',
        },
        accessibility: {
          point: {
            valueSuffix: '%',
          },
        },
       tooltip: {
          pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>',
        },
        plotOptions: {
          pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            depth: 35,
            dataLabels: {
              enabled: true,
              format: '{point.name}',
            },
          },
        },
        series: [
          {
           type: 'pie',
           name: 'Percentage',
            data: [
              {
               name: 'Passed',
                y: this.pie.passed,
                sliced: true,
                selected: true,
              },
              {
                name: 'Failed',
                 y: this.pie.failed,
               },
            ],
          },
        ],
      });
  });
}
  ngAfterViewInit() {
    

 }

 back(){
  this.router.navigate(['manageresult']);
 }
}
