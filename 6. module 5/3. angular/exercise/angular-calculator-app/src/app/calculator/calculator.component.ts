import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  public screen = '';
  constructor() { }

  ngOnInit(): void {
  }
  public number(num: string){
    this.screen += num;
  }
  public calculate(){
    this.screen = eval(this.screen);
  }
  public reset(){
    this.screen = '';
  }
}
