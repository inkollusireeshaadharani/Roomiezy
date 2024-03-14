package com.roomiezy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roomiezy.dao.UserIDao;
import com.roomiezy.dao.VacancyIDao;
import com.roomiezy.exceptions.UserNotFoundException;
import com.roomiezy.model.User;
import com.roomiezy.model.Vacancy;

@Service
public class VacancyService implements VacancyIService {
	
	@Autowired
	private UserIDao userdao;
	
	@Autowired
	@Qualifier("vacancyJpa")
	private VacancyIDao dao;
	
	@Override
	public Vacancy save(Vacancy vacancy) {
		System.out.println("Inside vacancy");
		return dao.save(vacancy);
	}

	@Override
	public List<Vacancy> findAll() {
		System.out.println("Inside vacancy");
		return dao.findAll();
	}

	@Override
	public Optional<Vacancy> findById(int id) {
		System.out.println("Inside vacancy");
		return dao.findById(id);
	}

	@Override
	public Vacancy updateById(Vacancy updatedVacancy, int id) {
		System.out.println("Inside vacancy");
		Optional<Vacancy> opt = dao.findById(id);
		Vacancy existingVacancy = null;
		if(opt.isPresent()) {
			existingVacancy = opt.get();
			existingVacancy.setCity(updatedVacancy.getCity());
			existingVacancy.setAddress(updatedVacancy.getAddress());
			existingVacancy.setDescription(updatedVacancy.getDescription());
			existingVacancy.setImage(updatedVacancy.getImage());
			existingVacancy.setRequirement(updatedVacancy.getRequirement());
		}
		else {
			throw new RuntimeException("id = "+id+" not found");
		}
		return dao.save(existingVacancy);
	}

	@Override
	public Vacancy deleteById(int id) {
		System.out.println("Inside vacancy");
		Optional<Vacancy> opt = dao.findById(id);
		if(opt.isPresent()) {
			return dao.deleteById(id);
		}
		else {
			throw new RuntimeException("id = "+id+" not found");
		}
	}
	
	 public Vacancy createVacancy(Vacancy vacancy, int userId) {
		 Optional<User> user=userdao.findById(userId);
		 if(user.isPresent()) {
			 vacancy.setUser(user.get());
			 user.get().getVacancies().add(vacancy);
		 }
		 else {
			 System.out.println("User not found");
		 }
		 Vacancy savedVacancy = dao.save(vacancy);
	     return savedVacancy;
     }
	 
	 public List<Vacancy> getAllVacancies(int id) {
         return dao.findByUserId(id);
     }

	 @Override
		public Optional<Vacancy> findByCity(String cityname) {
			System.out.println("Inside vacancy");
			return dao.findByCity(cityname);
		}


	
	
}
