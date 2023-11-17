import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MailsRoutingModule } from './mails-routing.module';
import { MailsComponent } from './mails.component';


@NgModule({
  declarations: [
    MailsComponent
  ],
  imports: [
    CommonModule,
    MailsRoutingModule
  ]
})
export class MailsModule { }
