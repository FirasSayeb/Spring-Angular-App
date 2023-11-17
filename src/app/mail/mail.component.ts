import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Mail } from '../mail';
import { Migration } from '../migration';
import { MailserService } from '../services/mailser.service';
import{Output,EventEmitter} from '@angular/core';


@Component({
  selector: 'app-mail',
  templateUrl: './mail.component.html',
  styleUrls: ['./mail.component.css']
})
export class MailComponent  {
  private postUrl = "http://localhost:8070/mail";
  private getUrl="http://localhost:8070/getMails";
 
 
  @Output() newItemEvent = new EventEmitter<Migration>();
  
  constructor(private router:Router,private mailser:MailserService){}
 getEvent(value:any){
  this.newItemEvent.emit(value);
 }
  

onsubmit(f:NgForm){
  let mail:Mail=f.value; 
  console.log(f.value);
  this.mailser.postmail(mail).subscribe({
    next:(data) =>{
      
    console.log(mail);
    alert("Mail send successfully")
    
this.router.navigate(['/customers']);

 
},error:(error) => {console.log(error);}


});}


}