import { Component, OnInit } from '@angular/core';
import Chart from 'chart.js/auto';
import { Mail } from '../mail';
import { MailserService } from '../services/mailser.service';
import { StatserService } from '../services/statser.service';
import { Tab } from '../tab';



@Component({
  selector: 'app-resultat',
  templateUrl: './resultat.component.html',
  styleUrls: ['./resultat.component.css']
})
export class ResultatComponent implements OnInit {
  mails:Mail []=[];
  ngOnInit(): void {
    this.mailser.getmails().subscribe({
      next:(data) => {
this.mails=data;}}
      )
  }
  constructor(private mailser:MailserService){}
  


}
