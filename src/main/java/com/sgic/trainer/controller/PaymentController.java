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

import com.sgic.trainer.entity.Payment;
import com.sgic.trainer.service.PaymentService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	@PostMapping("/payment")
	public HttpStatus addPaymentDetails(@RequestBody Payment payment) {
		if (paymentService.addPaymentDetails(payment)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@GetMapping("/payment")
	public ResponseEntity<List<Payment>> getPaymentDetails() {
		return new ResponseEntity<>(paymentService.getAllPaymentDetails(), HttpStatus.OK);

	}
}
