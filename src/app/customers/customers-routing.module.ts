import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MailComponent } from '../mail/mail.component';
import { MailsComponent } from '../mails/mails.component';
import { RechercheComponent } from '../recherche/recherche.component';
import { ResultatComponent } from '../resultat/resultat.component';
import { StatistiquesComponent } from '../statistiques/statistiques.component';

import { CustomersComponent } from './customers.component';


const routes: Routes = [{ path: '', component: CustomersComponent },
{path:'recherche',component:RechercheComponent},
{ path: 'mails', loadChildren: () => import('../mails/mails.module').then(m => m.MailsModule) },
{path:'statistiques',component:StatistiquesComponent}
]; 

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule { }
