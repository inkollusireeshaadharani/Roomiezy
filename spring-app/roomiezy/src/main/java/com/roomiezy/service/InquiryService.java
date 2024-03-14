package com.roomiezy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.roomiezy.dao.InquiryIDao;
import com.roomiezy.dao.UserIDao;
import com.roomiezy.dao.VacancyIDao;
import com.roomiezy.model.Inquiry;
import com.roomiezy.model.User;
import com.roomiezy.model.Vacancy;

@Service
public class InquiryService implements InquiryIService {

	@Autowired
	@Qualifier("inquiryJpa")
	private InquiryIDao dao;
	
	@Autowired
	@Qualifier("userJpa")
	private UserIDao userdao;
	
	@Autowired
	@Qualifier("vacancyJpa")
	private VacancyIDao vacancydao;
	
	@Override
	public Inquiry save(Inquiry inquiry) {
		System.out.println("Inside save inquiry");
		return dao.save(inquiry);
	}

	@Override
	public List<Inquiry> findAll() {
		System.out.println("Inside inquiry findall");
		return dao.findAll();
	}

	@Override
	public Optional<Inquiry> findById(int inquiryId) {
		System.out.println("Inside Inquiry findbyid");
		return dao.findById(inquiryId);
	}

	@Override
	public Inquiry updateById(Inquiry inquiry, int id) {
		System.out.println("Inside Inquiry");
		Optional<Inquiry> opt = dao.findById(id);
		Inquiry existingInquiry = null;
		if(opt.isPresent()) {
			existingInquiry = opt.get();
			existingInquiry.setApproved(inquiry.isApproved());
//			existingInquiry.setInquiryId(inquiry.getInquiryId());
			existingInquiry.setSatisfying(inquiry.getSatisfying());
		}
		else {
			throw new RuntimeException("id = "+id+" not found");
		}
		return dao.save(existingInquiry);
	}

	@Override
	public Inquiry deleteById(int id) {
		System.out.println("Inside vacancy");
		Optional<Inquiry> opt = dao.findById(id);
		if(opt.isPresent()) {
			return dao.deleteById(id);
		}
		else {
			throw new RuntimeException("id = "+id+" not found");
		}
	}

	@Override
	public Inquiry createInquiry(Inquiry inquiry, int userId, int vacancyId) {
		Optional<User> user=userdao.findById(userId);
		if(user.isPresent()) {
			 inquiry.setUser(user.get());
			 inquiry.setVacancy(vacancydao.findById(vacancyId).get());
		}
		else {
			throw new RuntimeException();
		}
		return dao.save(inquiry);
	}

	@Override
	public List<Inquiry> getAllInquiries(int userId) {
		return dao.findByUserId(userId);
	}

	@Override
	public List<Inquiry> getAllInquiriesForVacancy(int vacancyId) {
		return dao.findByVacancyVacancyId(vacancyId);
	}

}