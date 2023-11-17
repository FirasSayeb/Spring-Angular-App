import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Migration } from './migration';

@Injectable({
  providedIn: 'root'
})
export class RechercheService {
  private getUrl = "http://localhost:8070/MigrationOrder";
  private postUrl="http://localhost:8070/MigrationOrder";
  constructor(private httpClient:HttpClient ){}
  getMigration(){ 
    return this.httpClient.get<Migration[]>(this.getUrl); 
  }
  rechercheMigration(migration:Migration):Observable<Migration>{
    return this.httpClient.post<Migration>(this.postUrl,migration); 
   }
   
  

}
