package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.Status;

public interface StatusService {

	public List<Status> getAllStatus();
	boolean save(Status status);
	boolean delete(int id);
	boolean editStatus(Status status, Integer id);
	Status getStatusById(Integer id);
}
