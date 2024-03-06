package com.roomiezy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column
	private Long mobile;
	@Column
	private int age;
	@Column
	private String occupation;
	@Column(nullable = false)
	private String city;
	@Column
	private boolean status;
	
	@OneToMany(targetEntity = Vacancy.class, cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private List<Vacancy> vacancies;
	
	@OneToMany(targetEntity = Inquiry.class, cascade=CascadeType.ALL)
	@JoinColumn(name="id")
	private List<Inquiry> inquiries;
	
	
	//Getters and setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobile() {
		return mobile;
	}
	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public User(String name, String email, String password, Long mobile, int age, String occupation, String city,
			boolean status) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.mobile = mobile;
		this.age = age;
		this.occupation = occupation;
		this.city = city;
		this.status = status;
	}
	public User() {
		
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", mobile="
				+ mobile + ", age=" + age + ", occupation=" + occupation + ", city=" + city + ", status=" + status
				+ "]";
	}
	
}
