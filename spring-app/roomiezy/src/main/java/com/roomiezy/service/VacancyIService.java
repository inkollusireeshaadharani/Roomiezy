package com.roomiezy.service;

import java.util.List;
import java.util.Optional;

import com.roomiezy.model.Vacancy;

public interface VacancyIService {
	public Vacancy save(Vacancy vacancy);
	public List<Vacancy> findAll();
	public Optional<Vacancy> findById(int id);
	public Vacancy updateById(Vacancy vacancy, int id);
	public Vacancy deleteById(int id);
	public Vacancy createVacancy(Vacancy vacancy,int userId);
	public List<Vacancy> getAllVacancies(int id);
}
