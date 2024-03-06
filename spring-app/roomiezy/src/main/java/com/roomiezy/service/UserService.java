package com.roomiezy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roomiezy.dao.UserIDao;
import com.roomiezy.exceptions.UserNotFoundException;
import com.roomiezy.model.User;
@Service("service")
public class UserService implements UserIService {
	
	@Autowired
	@Qualifier("userJpa")
	private UserIDao dao;

	@Override
	public User save(User user) {
		System.out.println("Inside service");
		return dao.save(user);
	}

	@Override
	public List<User> findAll() {
		System.out.println("Inside service");
		return dao.findAll();
	}

	@Override
	public Optional<User> findById(int id) {
		return dao.findById(id);
	}

	@Override
	public User updateById(User updatedUser, int id) {
		Optional<User> opt = dao.findById(id);
		User existingUser = null;
		if(opt.isPresent()) {
			existingUser = opt.get();
			existingUser.setAge(updatedUser.getAge());
			existingUser.setCity(updatedUser.getCity());
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setMobile(updatedUser.getMobile());
			existingUser.setName(updatedUser.getName());
			existingUser.setOccupation(updatedUser.getOccupation());
			existingUser.setPassword(updatedUser.getPassword());
			existingUser.setStatus(updatedUser.isStatus());
		}
		else {
			throw new UserNotFoundException("id = "+id+" not found");
		}
		return dao.save(existingUser);
	}

	@Override
	public User deleteById(int id) {
		Optional<User> opt = dao.findById(id);
		if(opt.isPresent()) {
			return dao.deleteById(id);
		}
		else {
			throw new UserNotFoundException("id = "+id+" not found");
		}
	}

}
