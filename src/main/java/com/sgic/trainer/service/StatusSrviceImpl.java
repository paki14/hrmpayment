package com.sgic.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.trainer.entity.Status;
import com.sgic.trainer.repository.StatusRepository;
@Service
public class StatusSrviceImpl implements StatusService{
	@Autowired
	private StatusRepository statusRepository;

	@Override
	public List<Status> getAllStatus() {
		return statusRepository.findAll();
	}

	@Override
	public boolean save(Status status) {
		statusRepository.save(status);
		return true;
	}

	@Override
	public boolean delete(int id) {
		statusRepository.deleteById(id);
		return true;
	}

	@Override
	public boolean editStatus(Status status, Integer id) {
		if (statusRepository.getOne(id) != null) {
			status.setId(id);
			statusRepository.save(status);
			return true;
		}
		return false;
	}
	
	public Status getStatusById(Integer id) {
	  Status status = statusRepository.findById(id).get();
      return status;
	}
}
