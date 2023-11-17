import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { Dates } from '../dates';
import { Tab } from '../tab';


@Injectable({
  providedIn: 'root'
})
export class StatserService {

  private postUrl="http://localhost:8070/statistiques";
  constructor(private httpClient:HttpClient ){}
  postdate(date:any):Observable<object>{
    return this.httpClient.post(this.postUrl,date)
  }

  getstat(date:any):Observable<Array<Tab>>{
    return this.httpClient.get<Array<Tab>>(`${this.postUrl}/${date}`).pipe(map((
      d:Array<Tab>) => d ));
  }
}
