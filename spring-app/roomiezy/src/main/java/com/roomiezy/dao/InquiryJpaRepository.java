package com.roomiezy.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.roomiezy.model.Inquiry;

@Repository("inquiryJpa")
public interface InquiryJpaRepository extends JpaRepository<Inquiry, Integer>, InquiryIDao {
	public List<Inquiry> findByUserId(int id);
	public List<Inquiry> findByVacancyVacancyId(int id);
}