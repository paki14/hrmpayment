package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.Payment;
import com.sgic.trainer.entity.TrainingSchedule;

public interface PaymentService {
	boolean addPaymentDetails(Payment payment, TrainingSchedule trainingSchedule);

	boolean editPaymentDetails(Payment payment, TrainingSchedule trainingSchedule, Integer id);

	List<Payment> getAllPaymentDetails();

	boolean deleatePaymentDetails(Integer id);

	Payment getPaymentByTrainingScheduleId(Integer id);
}
