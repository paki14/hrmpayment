package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.Trainer;

public interface TrainerService {
	boolean addTrainer(Trainer trainer);

	boolean editTrainer(Trainer trainer, Integer id);

	List<Trainer> getAllTrainers();

	boolean deleteTrainer(Integer id);

	Trainer getTrainerById(Integer id);
}
