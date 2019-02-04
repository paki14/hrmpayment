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

import com.sgic.trainer.dto.TrainingScheduleSaveDto;
import com.sgic.trainer.entity.TrainingSchedule;
import com.sgic.trainer.maper.TrainingScheduleDtoMaper;
import com.sgic.trainer.service.TrainerService;
import com.sgic.trainer.service.TrainingScheduleService;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TrainingScheduleController {
	@Autowired
	private TrainingScheduleService trainingScheduleService;
	@Autowired
	private TrainerService trainerService;

	@PostMapping("/payment")
	public HttpStatus addPaymentInitiation(@RequestBody TrainingScheduleSaveDto trainingScheduleSaveDto) {
		if (trainingScheduleService.addTrainingSchedule(
				TrainingScheduleDtoMaper.mapTrainingScheduleSaveDtoToTrainingSchedule(trainingScheduleSaveDto),
				trainerService.getTrainerById(trainingScheduleSaveDto.getTrainer()))) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	@PutMapping("/payment/{id}")
	public HttpStatus editPaymentInitiation(@RequestBody TrainingScheduleSaveDto trainingScheduleSaveDto , @PathVariable Integer id) {
		if (trainingScheduleService.updateTrainingSchedule(
				TrainingScheduleDtoMaper.mapTrainingScheduleSaveDtoToTrainingSchedule(trainingScheduleSaveDto),
				trainerService.getTrainerById(trainingScheduleSaveDto.getTrainer()),id)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}

	
	@GetMapping("/payment")
	public ResponseEntity<List<TrainingSchedule>> getTrainingSchedule() {
		return new ResponseEntity<>(trainingScheduleService.getAllTrainingSchedule(), HttpStatus.OK);

	}
	@GetMapping("/payment/{id}")
	public ResponseEntity<TrainingSchedule> getTrainingScheduleById(@PathVariable Integer id) {
		return new ResponseEntity<>(trainingScheduleService.getTrainningScheduleById(id), HttpStatus.OK);

	}

	@PutMapping("/payment/processed/{id}")
	public HttpStatus paymentProcess(@RequestBody TrainingScheduleSaveDto trainingScheduleSaveDto,
			@PathVariable Integer id) {
		if (trainingScheduleService.paymentProcesses(
				TrainingScheduleDtoMaper.mapTrainingScheduleSaveDtoToTrainingSchedule(trainingScheduleSaveDto),
				trainerService.getTrainerById(trainingScheduleSaveDto.getTrainer()), id)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@PutMapping("/payment/completed/{id}")
	public HttpStatus paymentCompleted(@RequestBody TrainingScheduleSaveDto trainingScheduleSaveDto,
			@PathVariable Integer id) {
		if (trainingScheduleService.paymentCompleted(
				TrainingScheduleDtoMaper.mapTrainingScheduleSaveDtoToTrainingSchedule(trainingScheduleSaveDto),
				trainerService.getTrainerById(trainingScheduleSaveDto.getTrainer()), id)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
