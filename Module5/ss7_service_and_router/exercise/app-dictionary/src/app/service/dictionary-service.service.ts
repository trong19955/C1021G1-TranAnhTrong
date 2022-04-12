import { Injectable } from '@angular/core';
import {Iword} from '../iword';

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  wordList: Iword[];

  constructor() {
    this.wordList = [];
    this.wordList.push({word: 'hello', mean: 'xin chào'});
    this.wordList.push({word: 'coat', mean: 'áo khoác'});
    this.wordList.push({word: 'pig', mean: 'heo'});
  }

  getAll() {
    return this.wordList;
  }

  translate(word: string) {
    for (let w of this.wordList) {
      if (w.word.toLowerCase() === word.toLowerCase()) {
        return w.mean;
      }
    }
  }
}
