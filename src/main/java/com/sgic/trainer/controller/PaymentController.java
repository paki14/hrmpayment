package com.sgic.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sgic.trainer.dto.PaymentSaveDto;
import com.sgic.trainer.entity.Payment;
import com.sgic.trainer.maper.PaymentDtoMapper;
import com.sgic.trainer.service.PaymentService;
import com.sgic.trainer.service.TrainingScheduleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	@Autowired 
	private TrainingScheduleService trainingScheduleService;
	@PostMapping("/paymentprocess")
	public HttpStatus addPaymentDetails(@RequestBody PaymentSaveDto paymentSaveDto) {
		if (paymentService.addPaymentDetails(PaymentDtoMapper.mapPaymentSaveDtoToPayment(paymentSaveDto),trainingScheduleService.getTrainningScheduleById(paymentSaveDto.getTrainingSchedule()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/paymentprocess/{id}")
	public HttpStatus editPayment(@RequestBody PaymentSaveDto paymentSaveDto, @PathVariable Integer id) {
		if(paymentService.editPaymentDetails(PaymentDtoMapper.mapPaymentSaveDtoToPayment(paymentSaveDto), trainingScheduleService.getTrainningScheduleById(paymentSaveDto.getTrainingSchedule()), id)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	@GetMapping("/paymentprocess")
	public ResponseEntity<List<Payment>> getPaymentDetails() {
		return new ResponseEntity<>(paymentService.getAllPaymentDetails(), HttpStatus.OK);

	}

	@GetMapping("/paymentprocess/{id}")
	public ResponseEntity<Payment> getPaymentByTrainingScheduleId(@PathVariable Integer id){
		return new ResponseEntity<Payment>(paymentService.getPaymentByTrainingScheduleId(id),HttpStatus.OK);
	}
}
