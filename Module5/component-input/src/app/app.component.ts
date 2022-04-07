import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: '<h1>Welcome to !</h1>\n' +
    '<button (click)="increment()">Increment</button>\n' +
    '<button (click)="decrement()">decrement</button>\n' +
    '<app-child [count] =Counter></app-child>',


  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'component-input';
  Counter = 5;
  increment(){
    this.Counter++;

  }
  decrement(){
    this.Counter--;


  }
}
