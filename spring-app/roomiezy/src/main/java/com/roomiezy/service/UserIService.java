package com.roomiezy.service;

import org.springframework.stereotype.Service;

import com.roomiezy.model.User;

import java.util.List;
import java.util.Optional;


public interface UserIService {
	public User save(User user);
	public List<User> findAll();
	public Optional<User> findById(int id);
	public User updateById(User user, int id);
	public User deleteById(int id);
}
