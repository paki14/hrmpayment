package com.sgic.trainer.service;

import java.util.List;

import com.sgic.trainer.entity.User;

public interface UserService {
	boolean addUser(User user);

	boolean editUser(User user, Integer id);

	List<User> getAllUsers();

	boolean deleteUser(Integer id);

	User getUserByName(String name);

	User getUserByID(Integer id);

}
