package com.roomiezy.dao;

import java.util.List;
import java.util.Optional;

import com.roomiezy.model.User;

public interface UserIDao {
	public User save(User user);
	public List<User> findAll();
	public Optional<User> findById(int id);
	public User deleteById(int id);
}
