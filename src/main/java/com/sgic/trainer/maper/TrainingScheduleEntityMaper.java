package com.sgic.trainer.maper;

import java.util.ArrayList;
import java.util.List;

import com.sgic.trainer.dto.TrainingScheduleDto;
import com.sgic.trainer.entity.TrainingSchedule;

public class TrainingScheduleEntityMaper {
	public static TrainingScheduleDto mapTraininScheduleToTrainingScheduleDto(TrainingSchedule trainingSchedule) {
		TrainingScheduleDto trainingScheduleDto = new TrainingScheduleDto();
		trainingScheduleDto.setAmounToPaid(trainingSchedule.getAmounToPaid());
		trainingScheduleDto.setDate(trainingSchedule.getDate());
		trainingScheduleDto.setId(trainingSchedule.getId());
		trainingScheduleDto.setTotalCoveredhours(trainingSchedule.getTotalCoveredhours());
		trainingScheduleDto.setTrainingTopic(trainingSchedule.getTrainingTopic());
		trainingScheduleDto.setTrainer(trainingSchedule.getTrainer());
		trainingScheduleDto.setStatus(trainingSchedule.getStatus());
		return trainingScheduleDto;
	}

	public static List<TrainingScheduleDto> mapTrainingScheduleListToPaymentInitiationDtoList(
			List<TrainingSchedule> trainingScheduleList) {
		List<TrainingScheduleDto> paymentInitiationDtoList = new ArrayList<TrainingScheduleDto>();
		if (trainingScheduleList != null) {
			for (TrainingSchedule trainingSchedule : trainingScheduleList)
				paymentInitiationDtoList.add(mapTraininScheduleToTrainingScheduleDto(trainingSchedule));

		}
		return paymentInitiationDtoList;
	}
}
