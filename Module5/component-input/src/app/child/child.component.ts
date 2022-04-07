import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';

@Component({
  selector: 'app-child',
  template: '<h2>Child Component</h2>' +
    'current count is {{count}}',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit, OnChanges {
@Input()
  count: number | undefined;
  constructor() { }

  ngOnInit(): void {
  }
  ngOnChanges(changes: SimpleChanges) {
    for(let property in changes){
      if(property === 'count'){}
      console.log('Previous', changes[property].previousValue);
      console.log('Current', changes[property].currentValue);
      console.log('firstChange', changes[property].firstChange);
    }
  }

}
