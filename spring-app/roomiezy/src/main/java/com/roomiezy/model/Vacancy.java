package com.roomiezy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Vacancy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int vacancyId;
	@Column
	private String city;
	@Column(unique = true)
	private String requirement;
    @Column
    private String image;
	@Column
	private String address;
	@Column
	private String description;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
	
	public int getVacancyId() {
		return vacancyId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setVacancyId(int vacancyId) {
		this.vacancyId = vacancyId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getRequirement() {
		return requirement;
	}
	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Vacancy(String city, String requirement, String image, String address, String description) {
	
		this.city = city;
		this.requirement = requirement;
		this.image = image;
		this.address = address;
		this.description = description;
	}
	public Vacancy() {
		
	}
	@Override
	public String toString() {
		return "Vacancy [vacancyId=" + vacancyId + ", city=" + city + ", requirement=" + requirement + ", image="
				+ image + ", address=" + address + ", description=" + description + ", user=" + user + "]";
	}
	
	
}
