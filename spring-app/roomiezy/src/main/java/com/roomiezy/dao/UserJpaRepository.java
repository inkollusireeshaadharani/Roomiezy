package com.roomiezy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.roomiezy.model.User;

@Repository("userJpa")
public interface UserJpaRepository extends JpaRepository<User, Integer>, UserIDao {
//	@Query
//	public String updateById(User user, int id);
}
