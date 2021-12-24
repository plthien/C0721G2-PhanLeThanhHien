import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-img-slider',
  templateUrl: './img-slider.component.html',
  styleUrls: ['./img-slider.component.css']
})
export class ImgSliderComponent implements OnInit {
  listImage = [
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=1',
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=2',
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=3',
    'https://via.placeholder.com/1280x420/e91e63/ffffff?text=4'
  ];

  img: string;

  constructor() {
  }

  ngOnInit(): void {
    this.img = this.listImage[0];
  }

  previous(img: string) {
    let index = this.listImage.indexOf(img);
    if (index > 0) {
      this.img = this.listImage[index - 1];
    } else if (index === 0) {
      this.img = this.listImage[this.listImage.length - 1]
    }
  }

  next(img: string) {
    let index = this.listImage.indexOf(img);
    if (index < this.listImage.length - 1 ){
      this.img = this.listImage[index + 1];
    } else if (index === this.listImage.length - 1){
      this.img = this.listImage[0];
    }
  }
}
