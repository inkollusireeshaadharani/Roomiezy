package com.roomiezy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Inquiry {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int inquiryId;
	
	@Column
	private boolean isApproved;
	
	@Column
	private String satisfying;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	@ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

	public int getInquiryId() {
		return inquiryId;
	}

	public void setInquiryId(int inquiryId) {
		this.inquiryId = inquiryId;
	}

	public boolean isApproved() {
		return isApproved;
	}

	public void setApproved(boolean isApproved) {
		this.isApproved = isApproved;
	}

	public String getSatisfying() {
		return satisfying;
	}

	public void setSatisfying(String satisfying) {
		this.satisfying = satisfying;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Vacancy getVacancy() {
		return vacancy;
	}

	public void setVacancy(Vacancy vacancy) {
		this.vacancy = vacancy;
	}

	public Inquiry(boolean isApproved, String satisfying, User user, Vacancy vacancy) {
		this.isApproved = isApproved;
		this.satisfying = satisfying;
		this.user = user;
		this.vacancy = vacancy;
	}

	public Inquiry() {
		super();
	}

	@Override
	public String toString() {
		return "Inquiry [inquiryId=" + inquiryId + ", isApproved=" + isApproved + ", satisfying=" + satisfying
				+ ", user=" + user + ", vacancy=" + vacancy + "]";
	}
	
}