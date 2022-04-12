import { Component, OnInit } from '@angular/core';
import {Iword} from '../iword';
import {DictionaryServiceService} from '../service/dictionary-service.service';

@Component({
  selector: 'app-dictionay-page-component',
  templateUrl: './dictionay-page-component.component.html',
  styleUrls: ['./dictionay-page-component.component.css']
})
export class DictionayPageComponentComponent implements OnInit {
  dictionaries: Iword[] =[];
  constructor(private  dictionaryService: DictionaryServiceService) { }

  ngOnInit() {
    this.getAll()
  }
  getAll(){
    this.dictionaries = this.dictionaryService.getAll();
  }

}
