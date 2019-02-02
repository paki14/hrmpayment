package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.Payment;

public interface PaymentService {
	boolean addPaymentDetails(Payment payment);
	boolean editPaymentDetails(Payment payment,Integer id);
	List<Payment> getAllPaymentDetails();
	boolean deleatePaymentDetails(Integer id);

}
