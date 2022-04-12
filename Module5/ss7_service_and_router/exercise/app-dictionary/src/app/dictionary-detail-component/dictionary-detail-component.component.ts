import { Component, OnInit } from '@angular/core';
import {DictionaryServiceService} from '../service/dictionary-service.service';
import {ActivatedRoute} from '@angular/router';


@Component({
  selector: 'app-dictionary-detail-component',
  templateUrl: './dictionary-detail-component.component.html',
  styleUrls: ['./dictionary-detail-component.component.css']
})
export class DictionaryDetailComponentComponent implements OnInit {
  word: string;
  mean: string;
  constructor(private dictionaryService: DictionaryServiceService, private activatedRoute : ActivatedRoute ) { }

  ngOnInit() {
    const wordTranslate = this.activatedRoute.snapshot.params.word;
    this.word = wordTranslate;
    this.mean = this.dictionaryService.translate(wordTranslate);
  }


}
