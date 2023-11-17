import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { RechercheComponent } from './recherche/recherche.component';
import { ResultatComponent } from './resultat/resultat.component';





const routes: Routes = [ 
  {path:'Login',component:LoginComponent},  
 {path:'',redirectTo:'Login',pathMatch:'full'}, 
 {path:'recherche',component:RechercheComponent},
 {path:'historique',component:ResultatComponent},
  { path: 'customers', loadChildren: () => import('./customers/customers.module').then(m => m.CustomersModule) },
  { path: 'mails', loadChildren: () => import('./mails/mails.module').then(m => m.MailsModule) },
 

];  

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule { }
