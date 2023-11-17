import {  HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map, Observable } from 'rxjs';
import { User } from './user';

@Injectable({
  providedIn: 'root'
})
export class LoginService { 

  private getUrl = "http://localhost:8070/users";
  private postUrl="http://localhost:8070/users";
  constructor(private httpClient:HttpClient ){}
  getUser():Observable<User[]>{
    return this.httpClient.get<User[]>(this.getUrl).pipe(map(response => response))
   
  }
  saveUser(user:User){
    return this.httpClient.post<User>(this.postUrl,user);
  } 
   loginUser(user:User){
    return this.httpClient.post<User>(this.postUrl,user); 
   }
}


