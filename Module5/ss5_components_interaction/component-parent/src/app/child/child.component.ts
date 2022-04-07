import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-child',
  template: '<h2>Child Component</h2>' +
    'current count is {{count}}',
  styleUrls: ['./child.component.css']
})
export class ChildComponent  {

 @Input('mycount')
 count: number =8;

}
