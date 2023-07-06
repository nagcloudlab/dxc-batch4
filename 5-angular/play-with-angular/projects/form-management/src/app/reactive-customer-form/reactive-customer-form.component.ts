import {Component} from '@angular/core';
import {AbstractControl, FormArray, FormBuilder, FormControl, FormGroup, NgForm, Validators} from "@angular/forms";

import {filter, zip} from 'rxjs'

@Component({
  selector: 'app-reactive-customer-form',
  templateUrl: './reactive-customer-form.component.html',
  styleUrls: ['./reactive-customer-form.component.css']
})
export class ReactiveCustomerFormComponent {

  customerForm!: FormGroup

  constructor(private formBuilder: FormBuilder) {
  }


  ngOnInit() {

    this.customerForm = this.formBuilder.group({
      firstName: ['Nag', [Validators.required, Validators.minLength(3)]],
      lastName: ['N', Validators.required],
      email: ['nag@cloudlab.con', [Validators.required,Validators.email,this.emailDomainValidator]],
      mobile: ['',Validators.pattern('[0-9]{10}')],
      notiType: ['email', ],
      addressFormArray: this.formBuilder.array([])
    })

    // this.customerForm.valueChanges
    //   .subscribe({
    //     next: (value) => {
    //       console.log(value)
    //     }
    //   })
    // this.customerForm.statusChanges
    //   .subscribe({
    //     next: (status) => {
    //       console.log(status)
    //     }
    //   })

    // this.customerForm.get('firstName')!.valueChanges
    // .subscribe({
    //     next: (value) => {
    //       console.log(value)
    //     }
    //   })
    // this.customerForm.get('firstName')!.statusChanges
    // .subscribe({
    //   next: (status) => {
    //     console.log(status)
    //   }
    // })

    //
    // zip([
    //   this.customerForm.get<string>("firstName")?.statusChanges,
    //   this.customerForm.get<string>("firstName")?.valueChanges
    // ])
    //   .pipe(filter((e: any) => e[0] === "VALID"))
    //   .subscribe({
    //     next: (e: any) => {
    //       console.log(e[1])
    //     }
    //   })


    this.customerForm.get("notiType")!.valueChanges
    .subscribe({
        next: (value) => {
          if(value === "text"){
            this.customerForm.get("mobile")!.setValidators([Validators.required, Validators.pattern('[0-9]{10}')]);
          }
          else{
            this.customerForm.get("mobile")!.clearValidators();
          }
          this.customerForm.get("mobile")!.updateValueAndValidity();
        }
      })


  }

  handleSubmit(event: SubmitEvent) {
    event.preventDefault();
    if (this.customerForm.valid) {
      console.log(this.customerForm.value);
    }
  }

  getFormGroup(control: AbstractControl) {
    return control as FormGroup;
  }

  emailDomainValidator(control: FormControl) {
    const email = control.value;
    const domain = email.split('@')[1];
    if(domain==="cloudlab.con"){
      return null;
    }
    else{
      return {emailDomain: true};
    }
  }

  createAddressFormGroup(): FormGroup {
    return this.formBuilder.group({
      city: ['', [Validators.required, Validators.minLength(3)]],
      country: ['', [Validators.required, Validators.minLength(3)]]
    })
  }

  get addressFormArray() {
    return this.customerForm.get('addressFormArray') as FormArray;
  }


  handleNewAddress() {
    this.addressFormArray.push(this.createAddressFormGroup());
  }

  handleRemoveAddress(index: number) {
    this.addressFormArray.removeAt(index);
  }




}



