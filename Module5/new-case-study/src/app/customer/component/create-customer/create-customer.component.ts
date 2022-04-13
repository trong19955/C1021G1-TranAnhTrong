import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {CustomerService} from '../../service/customer.service';
import {CustomerType} from '../../model/customer-type';
import {CustomerTypeService} from '../../service/customer-type.service';
import {Router} from "@angular/router";
import {differenceInYears} from 'date-fns';

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  customerForm: FormGroup = new FormGroup({
    id: new FormControl('',
      Validators.compose([Validators.required,Validators.pattern("^CUS-\\d{4}$")])),

    customerName: new FormControl('',
      Validators.required),

    dateOfBirth: new FormControl('',
      Validators.compose([Validators.required,Validators.pattern("^(\\d){4}-(\\d){2}-(\\d){2}$"),this.checkDateOfBirth])),

    sex: new FormControl(),

    identityNumber: new FormControl('',
      Validators.compose([Validators.required,Validators.pattern("^((\\d){9}|(\\d){12})$")])),

    phoneNumber: new FormControl('',
      Validators.compose([Validators.required,Validators.pattern("^(\\(84\\)\\+|0)(90|91)(\\d){7}$")])),

    email: new FormControl('',
      Validators.compose([Validators.required,Validators.email])),

    address: new FormControl('',
      Validators.required),

    customerType: new FormControl('',
      Validators.required)
  });

  customerTypes: CustomerType[];

  constructor(
    private customerService: CustomerService,
    private customerTypeService: CustomerTypeService,
    private router: Router
  ) { }

  ngOnInit() {
    this.getAllCustomerTypes();
  }

  getAllCustomerTypes() {
    this.customerTypeService.getAllCustomerTypes().subscribe(customerTypes => {
      this.customerTypes = customerTypes;
    });
  }

  addCustomer() {
    const customer = this.customerForm.value;
    console.log(customer);

    // if (this.customerForm.valid) {
      this.customerService.saveCustomer(customer).subscribe(() => {
        this.customerForm.reset();
        console.log('add customer success!');
        this.router.navigateByUrl('/customer').then(r => console.log('back to customer list!'));

      }, error => {
        console.log(error);
      })
    }
  // }

  checkDateOfBirth(abstractControl: AbstractControl): any {
    //dua phuong thuc checkDateOfBirth vao trong validator thi chi can abstractControl.value
    //thi se hieu la value tai the html do

    const dateOfBirth = abstractControl.value;
    const now = new Date();
    const birthday = new Date(dateOfBirth);

    const years = differenceInYears(now,birthday);
    console.log(years);

    return years >= 18 ? null : {not18YearsOld: true};
  }
}
