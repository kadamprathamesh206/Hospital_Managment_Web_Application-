import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class FeedbackService {

  constructor(
    private http: HttpClient
  ) { }

  getAllFeddbacks() {
    return this.http.get("http://localhost:8086/feedBack/getAllFeedBack");
  }

  addFeedback(obj: any) {
    return this.http.post("http://localhost:8086/feedBack/createFeedback", obj);
  }

}
