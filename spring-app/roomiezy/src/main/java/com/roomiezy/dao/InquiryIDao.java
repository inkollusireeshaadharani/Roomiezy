package com.roomiezy.dao;

import java.util.List;
import java.util.Optional;

import com.roomiezy.model.Inquiry;

public interface InquiryIDao {
	public Inquiry save(Inquiry inquiry);
	public List<Inquiry> findAll();
	public Optional<Inquiry> findById(int id);
	public Inquiry deleteById(int id);
	public List<Inquiry> findByUserId(int id);
	public List<Inquiry> findByVacancyVacancyId(int id);
}