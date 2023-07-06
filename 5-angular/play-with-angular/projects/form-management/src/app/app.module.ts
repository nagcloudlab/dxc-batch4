import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { ReactiveCustomerFormComponent } from './reactive-customer-form/reactive-customer-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CustomerFormComponent,
    ReactiveCustomerFormComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
