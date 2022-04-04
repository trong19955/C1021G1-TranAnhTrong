import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-word',
  templateUrl: './word.component.html',
  styleUrls: ['./word.component.css']
})
export class WordComponent{
  en = 'hello';
  vn = 'xin chao';
  imageUrl ='https://play-lh.googleusercontent.com/lMoItBgdPPVDJsNOVtP26EKHePkwBg-PkuY9NOrc-fumRtTFP4XhpUNk_22syN4Datc'
  forgot = false;

  toggleForgot(){
    this.forgot = !this.forgot;
  }
}
