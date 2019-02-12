package com.sgic.trainer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sgic.trainer.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findUserById(Integer id);

	User findByname(String name);
}
