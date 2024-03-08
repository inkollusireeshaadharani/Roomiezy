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
			throw new UserNotFoundException("id = "+id+" not found");
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
			throw new UserNotFoundException("id = "+id+" not found");
		}
	}
	
	 public Vacancy createVacancy(Vacancy vacancy, int userId) {
         // Fetch the user from the database using userId
         // Set the user in the vacancy and save
         // ...
		 Optional<User> user=userdao.findById(userId);
		 if(user.isPresent()) {
			 System.out.println(user.get());
			 vacancy.setUser(user.get());
			 vacancy.getUser().setId(userId);
		 }
		 else {
			 System.out.println("QWERTYUIOJFDSADCFVBNMQWERTYUIOSDFGH");
		 }

         return dao.save(vacancy);
     }
	 
	 public List<Vacancy> getAllVacancies(int id) {
         return dao.findByUserId(id);
     }

	


	
	
}
