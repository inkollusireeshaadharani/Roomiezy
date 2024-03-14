package com.roomiezy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roomiezy.exceptions.UserNotFoundException;
import com.roomiezy.model.User;
import com.roomiezy.service.UserIService;

@RestController
@CrossOrigin("*")
public class UserController {
	@Autowired
	private UserIService service;
	
	@GetMapping(path="/users")
	public List<User> retrieveAllUsers(){
		System.out.println("Inside retrieveAllUsers() of UserController");
		return service.findAll();
	}
	
	@GetMapping(path="/users/{id}")
	public User retrieveUser(@PathVariable("id") int id){
		System.out.println("Inside retrieveUser() of UserController "+id);
		Optional<User> opt = service.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			System.out.println("Throwing Exception");
			throw new UserNotFoundException("id = "+id+" not found");
		}		
	}
	
	@PostMapping(path="/users", consumes = "application/json")
	public User createUser(@RequestBody User user, Model model) throws MethodArgumentNotValidException {
		System.out.println("Inside createUser() of UserController");
		
		return service.save(user);
	}
	
	@PutMapping(path="/users/{id}", consumes = "application/json")
	public User updateUser(@PathVariable int id, @RequestBody User updatedUser, Model model) throws MethodArgumentNotValidException {
	    System.out.println("Inside updateUser() of UserController");
	    try {
	    	return service.updateById(updatedUser, id);
	    }
	    catch(UserNotFoundException e) {
	    	throw new UserNotFoundException("id = "+id+" not found");
	    }
	}

	
	@DeleteMapping(path="/users/{id}")
	public String deleteUser(@PathVariable("id") int id) {
		System.out.println("Inside deleteUser() of UserController");
		service.deleteById(id);
		return "deleted";
	}
}
