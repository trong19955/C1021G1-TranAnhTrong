import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  nameCode: string | undefined;
  constructor() { }

  ngOnInit(): void {
  }
 code(color: string | undefined): void{
    color = this.nameCode;
 }
 changeValue($event:any){
    this.nameCode= ($event.target.value)
 }

}
