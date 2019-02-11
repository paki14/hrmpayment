package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.entity.TrainingSchedule;

public interface TrainingScheduleService {
	boolean addTrainingSchedule(TrainingSchedule trainingSchedule, Trainer trainer);

	boolean updateTrainingSchedule(TrainingSchedule trainingSchedule, Trainer trainer, Integer id);

	List<TrainingSchedule> getAllTrainingSchedule();

	boolean paymentProcesses(TrainingSchedule trainingSchedule, Trainer trainer, Integer id);

	boolean paymentCompleted(TrainingSchedule trainingSchedule, Trainer trainer, Integer id);

	boolean paymentNotCompleted(TrainingSchedule trainingSchedule, Trainer trainer, Integer id);

	TrainingSchedule getTrainningScheduleById(Integer id);
}
