import {Component} from '@angular/core';

@Component({
  selector: 'app-root',
  template: '<h1>Welcome to !</h1> ' +
    '<button (click)="increment()">Increment</button>' +
    '<button (click)="decrement()">Decrement</button>' +
    '<app-child [mycount]="Counter"></app-child>'
    ,

  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'component-parent';
  Counter = 5;


  increment() {
    this.Counter++;
  }

  decrement() {
    this.Counter--;
  }
}
