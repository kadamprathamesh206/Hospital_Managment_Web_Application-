import { Component, OnInit } from '@angular/core';
import { FeedbackService } from 'src/app/services/feedback.service';

@Component({
  selector: 'app-view-feedbacks',
  templateUrl: './view-feedbacks.component.html',
  styleUrls: ['./view-feedbacks.component.scss']
})
export class ViewFeedbacksComponent implements OnInit {

  feedbacksList: any = [];

  constructor(
    private feedbackService: FeedbackService,
  ) { }

  ngOnInit(): void {
    this.feedbackService.getAllFeddbacks().subscribe((res: any) => {
      if (res) {
        this.feedbacksList = res;
      }
    });
  }

}
