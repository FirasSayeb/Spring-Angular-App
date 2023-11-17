import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import Chart from 'chart.js/auto';
import { StatserService } from '../services/statser.service';
import { Tab } from '../tab';

@Component({
  selector: 'app-statistiques',
  templateUrl: './statistiques.component.html',
  styleUrls: ['./statistiques.component.css']
})
export class StatistiquesComponent implements OnInit {
  
  private postUrl = "http://localhost:8070/statistiques";
  constructor(private router:Router,private stats:StatserService){}
 
chart: any;
labeldata: any[]=[];
realdata:any[]=[];
barColors = ["red", "blue","green","orange","brown"];

ngOnInit(): void { 
}
getStat(t:NgForm){
  let date=t.value;
    console.log(t.value);
  this.stats.getstat(date.date1).subscribe((d)=>{
    console.log(d);
    d.forEach((type:Tab)=>
    {
      console.log(type.count);
      console.log(type.status);
this.labeldata.push(type.status);
this.realdata.push(type.count);
this.createChart(this.labeldata,this.realdata);
    })
  })
  
}

createChart(labeldata:any,realdata:any){

  this.chart = new Chart("MyChart", {
    type: "doughnut", //this denotes tha type of chart

    data: {// values on X-Axis
      labels:this.labeldata,
       datasets: [
        {
          label: "Status",
          data: this.realdata,
          backgroundColor: this.barColors ,
        },

      ]
    },
    options: {
      aspectRatio:2.5
    }
    
  });
}
}
