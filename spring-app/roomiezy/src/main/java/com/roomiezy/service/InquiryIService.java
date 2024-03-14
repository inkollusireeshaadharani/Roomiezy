package com.roomiezy.service;

import java.util.List;
import java.util.Optional;

import com.roomiezy.model.Inquiry;

public interface InquiryIService {
	public Inquiry save(Inquiry inquiry);
	public List<Inquiry> findAll();
	public Optional<Inquiry> findById(int id);
	public Inquiry updateById(Inquiry inquiry, int id);
	public Inquiry deleteById(int id);
	public Inquiry createInquiry(Inquiry inquiry,int userId, int vacancyId);
	public List<Inquiry> getAllInquiries(int userId);
	public List<Inquiry> getAllInquiriesForVacancy(int vacancyId);
}