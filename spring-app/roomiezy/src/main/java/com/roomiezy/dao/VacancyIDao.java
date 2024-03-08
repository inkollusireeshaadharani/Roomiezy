package com.roomiezy.dao;

import java.util.List;
import java.util.Optional;
import com.roomiezy.model.Vacancy;

public interface VacancyIDao {

	public Vacancy save(Vacancy vacancy);
	public List<Vacancy> findAll();
	public Optional<Vacancy> findById(int id);
	public Vacancy deleteById(int id);
	public List<Vacancy> findByUserId(int id);
}
