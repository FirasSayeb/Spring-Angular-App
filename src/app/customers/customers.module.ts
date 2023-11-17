import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { CustomersRoutingModule } from './customers-routing.module';
import { CustomersComponent } from './customers.component';
import { FormsModule } from '@angular/forms';
import { NgChartsModule } from 'ng2-charts';

@NgModule({
  declarations: [
    CustomersComponent
  ],
  imports: [
    CommonModule,
    CustomersRoutingModule,
    FormsModule,
    HttpClientModule,
    NgChartsModule
  ]
})
export class CustomersModule { }
