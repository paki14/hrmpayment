package com.sgic.trainer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.sgic.trainer.entity.User;
import com.sgic.trainer.repository.UserRepository;

public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean addUser(User user) {
		userRepository.save(user);
		return true;
	}

	@Override
	public boolean editUser(User user, Integer id) {
		if (userRepository.getOne(id) != null) {
			userRepository.save(user);
			return true;
		}
		return false;
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUser(Integer id) {
		if (userRepository.getOne(id) != null) {
			userRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public User getUserByName(String name) {
		return userRepository.findByname(name);
	}

	@Override
	public User getUserByID(Integer id) {
		return userRepository.findUserById(id);
	}

}
