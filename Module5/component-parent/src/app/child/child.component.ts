import {Component, EventEmitter, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent implements OnInit {
  count = 5;
  @Output()
  countChanged: EventEmitter<number> = new EventEmitter<number>();

  increament(){
    this.count++;
    this.countChanged.emit(this.count);
  }
  decrement(){
    this.count--;
    this.countChanged.emit(this.count);
  }


  constructor() {
  }

  ngOnInit(): void {
  }


}
