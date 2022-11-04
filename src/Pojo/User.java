package Pojo;

import java.time.LocalDate;

import DAO.UserDAO;


public abstract class User {
private String firstName;
private String lastName;
private int rank;
private int gender;
private String adresse;
private int credit;
private int id;
private LocalDate anniversary;
private LocalDate dateRegister;
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public int getRank() {
	return rank;
}
public void setRank(int rank) {
	this.rank = rank;
}
public int getGender() {
	return gender;
}
public void setGender(int gender) {
	this.gender = gender;
}
public String getAdresse() {
	return adresse;
}
public void setAdresse(String adresse) {
	this.adresse = adresse;
}
public int getCredit() {
	return credit;
}
public void setCredit(int credit) {
	this.credit = credit;
}
public LocalDate getAnniversary() {
	return anniversary;
}
public void setAnniversary(LocalDate anniversary) {
	this.anniversary = anniversary;
}
public LocalDate getDateRegister() {
	return dateRegister;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public void setDateRegister(LocalDate dateRegister) {
	this.dateRegister = dateRegister;
}
public User(String firstName, String lastName, int rank, int gender, String adresse, int credit, LocalDate anniversary,
		LocalDate dateRegister, int id ) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.rank = rank;
	this.gender = gender;
	this.adresse = adresse;
	this.credit = credit;
	this.anniversary = anniversary;
	this.dateRegister = dateRegister;
	this.id = id;
}

public static  User login(String email, String password) {
	
	return UserDAO.login(email,password);
}
}
