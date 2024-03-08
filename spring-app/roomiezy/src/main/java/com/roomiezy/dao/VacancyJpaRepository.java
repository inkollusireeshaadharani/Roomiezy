package com.roomiezy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.roomiezy.model.Vacancy;

@Repository("vacancyJpa")
public interface VacancyJpaRepository extends VacancyIDao, JpaRepository<Vacancy, Integer> {
	List<Vacancy> findByUserId(int userId);
}
