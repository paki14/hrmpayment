package com.sgic.trainer.maper;

import com.sgic.trainer.dto.TrainingScheduleSaveDto;
import com.sgic.trainer.entity.Trainer;
import com.sgic.trainer.entity.TrainingSchedule;

public class TrainingScheduleDtoMaper {
	public static TrainingSchedule mapTrainingScheduleSaveDtoToTrainingSchedule(
			TrainingScheduleSaveDto trainingScheduleSaveDto) {
		TrainingSchedule trainingSchedule = new TrainingSchedule();
		Trainer trainer = new Trainer();
		trainingSchedule.setId(trainingScheduleSaveDto.getId());
		trainingSchedule.setTrainingTopic(trainingScheduleSaveDto.getTrainingTopic());
		trainingSchedule.setDate(trainingScheduleSaveDto.getDate());
		trainingSchedule.setStatus(trainingScheduleSaveDto.getStatus());
		trainingSchedule.setTotalCoveredhours(trainingScheduleSaveDto.getTotalCoveredhours());
		trainingSchedule.setAmounToPaid(trainingScheduleSaveDto.getAmounToPaid());
		trainer.setId(trainingScheduleSaveDto.getTrainer());
		trainingSchedule.setTrainer(trainer);
		return trainingSchedule;
	}
}
