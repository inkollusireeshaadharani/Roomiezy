package com.roomiezy.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.roomiezy.exceptions.UserNotFoundException;
import com.roomiezy.model.Inquiry;
import com.roomiezy.service.InquiryIService;

@RestController
@CrossOrigin("*")
public class InquiryController {
	@Autowired
	private InquiryIService service;
	
	@GetMapping(path="/inquiries")
	public List<Inquiry> retrieveAllInquiries(){
		System.out.println("Inside retrieveAllInquiries() of InquiryController");
		return service.findAll();
	}
	
	@GetMapping(path="/inquiries/{id}")
	public Inquiry retrieveInquiry(@PathVariable("id") int id){
		System.out.println("Inside retrieveInquiry() of InquiryController "+id);
		Optional<Inquiry> opt = service.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			System.out.println("Throwing Exception");
			return null;
//			throw new UserNotFoundException("id = "+id+" not found");
		}		
	}
	
	@PostMapping(path="/inquiries/{userId}/vacancy/{vacancyId}", consumes = "application/json")
	public Inquiry createInquiry(@RequestBody Inquiry inquiry,@PathVariable("userId") int userId,@PathVariable("vacancyId") int vacancyId, Model model) throws MethodArgumentNotValidException {
		System.out.println("Inside createInquiry() of InquiryController");
		return service.createInquiry(inquiry,userId,vacancyId);
	}
	
	@PutMapping(path="/inquiries/{id}", consumes = "application/json")
	public Inquiry updateInquiry(@PathVariable int id, @RequestBody Inquiry updatedInquiry, Model model) throws MethodArgumentNotValidException {
	    System.out.println("Inside updateInquiry() of InquiryController");
	    try {
	    	return service.updateById(updatedInquiry, id);
	    }
	    catch(UserNotFoundException e) {
	    	throw new RuntimeException("id = "+id+" not found");
	    } 
	}

	
	@DeleteMapping(path="/inquiries/{id}")
	public String deleteInquiry(@PathVariable("id") int id) {
		System.out.println("Inside deleteInquiry() of InquiryController");
		service.deleteById(id);
		return "deleted";
	}
	
	
	
	
	
}