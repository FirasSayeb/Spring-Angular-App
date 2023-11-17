import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MailComponent } from '../mail/mail.component';
import { ResultatComponent } from '../resultat/resultat.component';
import { MailsComponent } from './mails.component';

const routes: Routes = [{ path: '', component: MailsComponent },
{path:'mail',component:MailComponent},
{path:'historique',component:ResultatComponent}];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MailsRoutingModule { }
