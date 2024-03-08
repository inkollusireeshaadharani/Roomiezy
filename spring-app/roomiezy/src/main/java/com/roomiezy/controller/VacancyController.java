package com.roomiezy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roomiezy.exceptions.UserNotFoundException;
import com.roomiezy.model.Vacancy;
import com.roomiezy.service.VacancyIService;

@RestController
public class VacancyController {
	@Autowired
	private VacancyIService service;
	
	
	@GetMapping(path="/vacancy")
	public List<Vacancy> retrieveAllVacancies(){
		System.out.println("Inside retrieveAllVacancies() of VacancyController");
		return service.findAll();
	}
	
	@GetMapping(path="/vacancy/{id}")
	public Vacancy retrieveVacancy(@PathVariable("id") int id){
		System.out.println("Inside retrieveVacancy() of VacancyController "+id);
		Optional<Vacancy> opt = service.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			System.out.println("Throwing Exception");
			return null;
//			throw new UserNotFoundException("id = "+id+" not found");
		}		
	}
	
	@PostMapping(path="/vacancy/{userId}", consumes = "application/json")
	public Vacancy createVacancy(@RequestBody Vacancy vacancy,@PathVariable("userId") int id, Model model) throws MethodArgumentNotValidException {
		System.out.println("Inside createVacancy() of VacancyController");
//		service.save(vacancy);
		return service.createVacancy(vacancy,id);
//		return "added";
	}
	
	@PutMapping(path="/vacancy/{id}", consumes = "application/json")
	public Vacancy updateVacancy(@PathVariable int id, @RequestBody Vacancy updatedVacancy, Model model) throws MethodArgumentNotValidException {
	    System.out.println("Inside updateVacancy() of VacancyController");
	    try {
	    	return service.updateById(updatedVacancy, id);
	    }
	    catch(UserNotFoundException e) {
	    	throw new RuntimeException("id = "+id+" not found");
	    } 
	}

	
	@DeleteMapping(path="/vacancy/{id}")
	public String deleteVacancy(@PathVariable("id") int id) {
		System.out.println("Inside deleteVacancy() of VacancyController");
		service.deleteById(id);
		return "deleted";
	}
}
