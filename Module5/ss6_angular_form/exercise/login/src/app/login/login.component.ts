import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  get loginForm(): FormGroup {
    return this._loginForm;
  }

  private _loginForm = new FormGroup({
      email: new FormControl('',
        [Validators.pattern('^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$')]),
      password: new FormControl('',
        [Validators.minLength(6)]),
    }
  );

  get email() {
    return this.loginForm.get('email');
  }
  get password(){
    return this._loginForm.get('password');
  }
  constructor() {
  }

  ngOnInit(): void {
  }

  onSubmit() {
    console.log(this._loginForm.value);
  }
}
