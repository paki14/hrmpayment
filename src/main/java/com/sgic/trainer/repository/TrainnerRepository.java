package com.sgic.trainer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.trainer.entity.Trainer;

public interface TrainnerRepository extends JpaRepository<Trainer, Integer>{
 List<Trainer> findTrainerById(Integer id);
}
