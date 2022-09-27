import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { FeedbackService } from 'src/app/services/feedback.service';

@Component({
  selector: 'app-feedbacks',
  templateUrl: './feedbacks.component.html',
  styleUrls: ['./feedbacks.component.scss']
})
export class FeedbacksComponent implements OnInit {

  feedbackForm = new FormGroup({
    name: new FormControl("", [Validators.required]),
    email: new FormControl("", [Validators.required]),
    desc: new FormControl("", [Validators.required]),
    phone_no: new FormControl("", [Validators.required]),
  });

  constructor(
    private feedbackService: FeedbackService
  ) { }

  ngOnInit(): void {
  }

  submit() {
    const data = this.feedbackForm.getRawValue();
    console.log("submit", data);
    this.feedbackService.addFeedback(data).subscribe(res => {
      if (res) {
        window.alert("Feedback submitted sucessfully");
      }
    });
  }

}
