import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { User } from '../user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  user:User =new User();
  constructor(private loginService:LoginService,private router:Router){}
   saveUser(){
    this.loginService.saveUser(this.user).subscribe((data: any) => {
      console.log('response',data); 
      alert("Add User avec Success")
      this.router.navigateByUrl("/users"); 
    })
      
 
  }
Login(){
  console.log(this.user);
  this.loginService.loginUser(this.user).subscribe((data:any)=>{
    alert("login successfuly")
    this.router.navigate(['/customers']); 
  },error=>alert("Sorry verify your parametres "))
  
}
}
