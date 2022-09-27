package com.hospaital_managment.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospaital_managment.main.model.Feedback;
import com.hospaital_managment.main.service.FeedbackService;


/*
 *  All doctor operations are performed using this url.
 */
@RestController
@RequestMapping("/feedBack")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

    /*
     * to create a new feedback
     */
	@PostMapping("/createFeedback")
	public ResponseEntity<Feedback> newFeedback(@RequestBody Feedback feedback) {
		Feedback createdFeedback=	this.feedbackService.createFeedback(feedback);

		return new ResponseEntity<Feedback>(createdFeedback,HttpStatus.CREATED);
	}

	
	/*
	 * to get feedback details
	 */
	@GetMapping("/getAllFeedBack")
	public ResponseEntity<List<Feedback>> feedbackList(){
        List<Feedback>	feedbackList=	this.feedbackService.feedBackList();
        
		return new ResponseEntity<List<Feedback>>(feedbackList,HttpStatus.OK);

	}

}
