import {Injectable} from '@angular/core';
import {Dictionary} from "../model/dictionary";

@Injectable({
  providedIn: 'root'
})
export class DictionaryService {
  dictionary: Dictionary[] = [
    {
      id: 1,
      word: 'student',
      mean: 'hoc sinh'
    },
    {
      id: 2,
      word: 'table',
      mean: 'cai ban'
    },
    {
      id: 3,
      word: 'teacher',
      mean: 'giao vien'
    },
    {
      id: 4,
      word: 'book',
      mean: 'quyen sach'
    }
  ];

  constructor() {
  }

  getAll() {
    return this.dictionary;
  }

  getById(id: number) {
    return this.dictionary.find(x => x.id === id);
  }
}
