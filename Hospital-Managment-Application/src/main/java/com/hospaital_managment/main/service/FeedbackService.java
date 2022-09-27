package com.hospaital_managment.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hospaital_managment.main.model.Feedback;
import com.hospaital_managment.main.repository.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;

	/*
	 * to create a new feedback
	 */
	public Feedback createFeedback(Feedback feedback) {
		Feedback created_feedback = this.feedbackRepository.save(feedback);
		return created_feedback;
	}

	/*
	 * to get feedback details
	 */
	public List<Feedback> feedBackList() {
		List<Feedback> feedBackList = this.feedbackRepository.findAll();
		return feedBackList;

	}

}
