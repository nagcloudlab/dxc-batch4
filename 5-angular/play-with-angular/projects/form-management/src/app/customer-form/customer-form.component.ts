import { Component } from '@angular/core';
import {FormGroup, NgForm} from "@angular/forms";

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent {


  customer={
    fistName:'Nag',
    lastName:'N'
  }

  handleSubmit(event:SubmitEvent,customerForm:NgForm){
    event.preventDefault();
    if(customerForm.valid){
      console.log(customerForm.value);
      console.log(this.customer)
    }
  }

}
