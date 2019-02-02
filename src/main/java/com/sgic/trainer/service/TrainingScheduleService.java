package com.sgic.trainer.service;

import java.util.List;
import com.sgic.trainer.entity.TrainingSchedule;

public interface TrainingScheduleService {
	boolean addTrainingSchedule(TrainingSchedule trainingSchedule);

	boolean updateTrainingSchedule(TrainingSchedule trainingSchedule, Integer id);

	List<TrainingSchedule> getAllTrainingSchedule();

	boolean paymentPaid(TrainingSchedule trainingSchedule,Integer id);

	boolean paymentCompleted(TrainingSchedule trainingSchedule,Integer id);

}
