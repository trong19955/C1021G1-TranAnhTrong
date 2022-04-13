import {Component, OnInit} from '@angular/core';
import {CustomerService} from "../../service/customer.service";
import {AbstractControl, FormControl, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {CustomerTypeService} from "../../service/customer-type.service";
import {CustomerType} from "../../model/customer-type";

import {differenceInYears} from "date-fns";

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  customerForm = new FormGroup({
    id: new FormControl('',
      Validators.compose([Validators.required, Validators.pattern("^CUS-\\d{4}$")])),

    customerName: new FormControl('',
      Validators.required),

    dateOfBirth: new FormControl('',
      Validators.compose([Validators.required, Validators.pattern("^(\\d){4}-(\\d){2}-(\\d){2}$")])),

    sex: new FormControl(),

    identityNumber: new FormControl('',
      Validators.compose([Validators.required, Validators.pattern("^((\\d){9}|(\\d){12})$")])),

    phoneNumber: new FormControl('',
      Validators.compose([Validators.required, Validators.pattern("^(\\(84\\)\\+|0)(90|91)(\\d){7}$")])),

    email: new FormControl('',
      Validators.compose([Validators.required, Validators.email])),

    address: new FormControl('',
      Validators.required),

    customerType: new FormControl('',
      Validators.required)
  });

  customerTypes: CustomerType[];
  id: string;

  constructor(
    private customerService: CustomerService,
    private customerTypeService: CustomerTypeService,
    private activatedRoute: ActivatedRoute,
    private router: Router
  ) {
  }

  ngOnInit() {
    this.customerTypeService.getAllCustomerTypes().subscribe(customerTypes => {
      this.customerTypes = customerTypes;

      this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
        this.id = paramMap.get('id');
        this.getCustomer(this.id);
      });

    });
  }

  getCustomer(id: string) {
    return this.customerService.findCustomerById(id).subscribe(customer => {
      this.customerForm.setValue(customer);
      console.log(customer);
    }, error => {
      console.log(error);
    })
  }

  updateCustomer() {
    const customer = this.customerForm.value;
    console.log(customer);

    // if (this.customerForm.valid) {
      this.customerService.updateCustomer(customer).subscribe(() => {
        console.log('update customer success!');
        this.router.navigateByUrl('/customer').then(r => console.log('back to customer list!'));
      }, error => {
        console.log(error);
      })
    // }
  }

  // checkDateOfBirth(abstractControl: AbstractControl): any {
  //
  //   const dateOfBirth = abstractControl.value;
  //   const now = new Date();
  //   const birthday = new Date(dateOfBirth);
  //
  //   const years = differenceInYears(now,birthday);
  //   console.log(years);
  //
  //   return years >= 18 ? null : {not18YearsOld: true};
  // }

}
