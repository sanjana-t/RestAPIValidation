package com.javatechie.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.api.dto.UserRequest;
import com.javatechie.api.entity.User;
import com.javatechie.api.repository.UserRepository;
import com.javatechie.api.exception.UserException;
@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(UserRequest userRequest) {
		User user= User.build(0 ,userRequest.getName(), userRequest.getEmail(), userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(),userRequest.getNationality());
		
		return repository.save(user);
	}
	
	public List<User> getAllUsers(){
		return repository.findAll();
	}
	
	public User getUser(int id) throws UserException {
		User user = repository.findByuserid(id);
		if(user!=null) {
			return user;
		}
		else {
			throw new UserException("User Not Found with id "+id);
		}
	}
	
}
