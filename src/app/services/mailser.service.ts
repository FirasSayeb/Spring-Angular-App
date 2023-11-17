import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Mail } from '../mail';

@Injectable({
  providedIn: 'root'
})
export class MailserService {

  private getUrl = "http://localhost:8070/mails";
  private postUrl="http://localhost:8070/mail";
  constructor(private httpClient:HttpClient ){}
  postmail(mail:Mail):Observable<Mail>{
    return this.httpClient.post<Mail>(this.postUrl,mail)
   
  }
  getmails():Observable<Array<Mail>>{
    return this.httpClient.get<Array<Mail>>(this.getUrl);
  }
}
