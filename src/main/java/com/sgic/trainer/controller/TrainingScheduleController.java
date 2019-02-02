package com.sgic.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.trainer.entity.TrainingSchedule;
import com.sgic.trainer.service.TrainingScheduleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TrainingScheduleController {
	@Autowired
	private TrainingScheduleService trainingScheduleService;

	@PostMapping("/paymentInitiate")
	public HttpStatus addPaymentInitiation(@RequestBody TrainingSchedule initiatePayment) {
		if (trainingScheduleService.addTrainingSchedule(initiatePayment)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/paymentInitiate")
	public ResponseEntity<List<TrainingSchedule>> getTrainingSchedule() {
		return new ResponseEntity<>(
				trainingScheduleService.getAllTrainingSchedule(),
				HttpStatus.OK);

	}
	
	
}
