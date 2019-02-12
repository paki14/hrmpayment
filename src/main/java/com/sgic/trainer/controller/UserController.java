package com.sgic.trainer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sgic.trainer.entity.User;
import com.sgic.trainer.service.UserService;

public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public HttpStatus addUser(@RequestBody User user) {
		if(userService.addUser(user)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser(){
		return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Integer id){
		return new ResponseEntity<>(userService.getUserByID(id),HttpStatus.OK);
	}
	
	@GetMapping("/user/{name}")
	public ResponseEntity<User> getUserById(@PathVariable String name){
		return new ResponseEntity<>(userService.getUserByName(name),HttpStatus.OK);
	}
	
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
		return true;
	}
	
	@PutMapping("/user/{id}")
	public HttpStatus editUser(@RequestBody User user,@PathVariable Integer id) {
		if(userService.editUser(user, id)) {
			return HttpStatus.CREATED;
		}
		return HttpStatus.BAD_REQUEST;
	}
}
