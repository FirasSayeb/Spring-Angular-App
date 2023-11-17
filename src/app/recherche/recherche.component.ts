import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

import { Migration } from '../migration';
import { RechercheService } from '../recherche.service';
import { MailserService } from '../services/mailser.service';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent {
   migrations: any;
constructor(private rechercheservice:RechercheService,private router:Router,private http:HttpClient){}
Recherche(g:NgForm){
    let migration:Migration=g.value;
    console.log(g.value);
    this.rechercheservice.rechercheMigration(migration).subscribe({
      next:(data) => {
        console.log(data);
      console.log(migration);
      console.log(migration.MSISDN);
       this.migrations = data;
 

     console.log(this.migrations);
      
      /* this.rechercheservice.getMigration(migration.MSISDN).subscribe({next:(d) =>{
this.migrations=d;
      console.log(this.migrations); }});*/
   this.router.navigate(['/customers/mail']);
  },error:(error) => {console.log(error);alert("Sorry verify your parametres");}
  });}
  

}


