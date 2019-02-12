package com.sgic.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.trainer.entity.Payment;
import com.sgic.trainer.entity.TrainingSchedule;
import com.sgic.trainer.enums.PaymentStatus;
import com.sgic.trainer.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public boolean addPaymentDetails(Payment payment, TrainingSchedule trainingSchedule) {
		if (trainingSchedule != null) {
			trainingSchedule.setStatus(PaymentStatus.DEPOSITED);
			payment.setTrainingSchedule(trainingSchedule);
			paymentRepository.save(payment);
			return true;
		}
		return false;
	}

	@Override
	public boolean editPaymentDetails(Payment payment, TrainingSchedule trainingSchedule, Integer id) {
		if (paymentRepository.getOne(id) != null) {
			trainingSchedule.setStatus(PaymentStatus.DEPOSITED);
			payment.setTrainingSchedule(trainingSchedule);
			paymentRepository.save(payment);
			return true;
		}
		return false;
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		return paymentRepository.findAll();
	}

	@Override
	public boolean deleatePaymentDetails(Integer id) {
		if (paymentRepository.getOne(id) != null) {
			paymentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Payment getPaymentByTrainingScheduleId(Integer id) {
		return paymentRepository.findByTrainingScheduleId(id);
	}

}
