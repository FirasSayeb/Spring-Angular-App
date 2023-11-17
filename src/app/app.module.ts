import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { ReactiveFormsModule } from '@angular/forms';
import { RechercheComponent } from './recherche/recherche.component';
import { ResultatComponent } from './resultat/resultat.component';
import { MailComponent } from './mail/mail.component';
import { StatistiquesComponent } from './statistiques/statistiques.component';
import { NgChartsModule } from 'ng2-charts';





@NgModule({ 
  declarations: [
    AppComponent,
    LoginComponent,
    RechercheComponent,
    ResultatComponent,
    MailComponent,
    StatistiquesComponent,
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgChartsModule,
    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
