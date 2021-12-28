import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class TodoService {
  private url = 'http://localhost:3000/todo';

  constructor(private http: HttpClient) {
  }


}
