import {Component, OnInit} from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  get registrationForm(): FormGroup {
    return this._registrationForm;
  }

  private _registrationForm = new FormGroup({
    email: new FormControl('',
      [Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]),

    groupPassword: new FormGroup({
      password: new FormControl('',
        [Validators.required, Validators.minLength(6)]),

      confirmPassword: new FormControl('',
        [Validators.required, Validators.minLength(6)])

    }, this.checkPassword),
    country: new FormControl('', [Validators.required]),
    age: new FormControl('', [Validators.min(18)]),
    gender: new FormControl('', [Validators.required]),
    phone: new FormControl('', [Validators.pattern('^\\+84\\d{9,10}$')]),
  });


  get email() {
    return this.registrationForm.get('email');
  }

  get country() {
    return this.registrationForm.get('country');
  }

  get age() {
    return this.registrationForm.get('age');
  }
get phone(){
    return this.registrationForm.get('phone');
}
  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this._registrationForm.value);
  }

  checkPassword(abstractControl: AbstractControl): any {
    const password = abstractControl.value.password;
    const confirmPassword = abstractControl.value.confirmPassword;
    return password === confirmPassword ? null : {notConfirm: true};
  }
}
