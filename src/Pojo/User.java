package Pojo;

import java.time.LocalDate;

import DAO.DAO;
import DAO.DAOFactory;
import DAO.UserDAO;


public abstract class User {
private String firstName;
private String lastName;
private int rank;
private String adresse;
private int credit;
private int id;
private LocalDate anniversary;
private LocalDate dateRegister;
private String email;
private String password;
private LocalDate lastGainForAnniversary;

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

public LocalDate getLastGainForAnniversary() {
	return lastGainForAnniversary;
}
public void setLastGainForAnniversary(LocalDate lastGainForAnniversary) {
	this.lastGainForAnniversary = lastGainForAnniversary;
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
public User(String firstName, String lastName, int rank,String adresse, int credit, LocalDate anniversary,
		LocalDate dateRegister, int id ,LocalDate lastGainForAnniversary) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.rank = rank;
	this.adresse = adresse;
	this.credit = credit;
	this.anniversary = anniversary;
	this.dateRegister = dateRegister;
	this.id = id;
	this.lastGainForAnniversary = lastGainForAnniversary;
}
public User(String firstName, String lastName, int rank, String adresse, int credit, LocalDate anniversary,
		LocalDate dateRegister, String email, String password,LocalDate lastGainForAnniversary) {
	super();
	this.firstName = firstName;
	this.lastName = lastName;
	this.rank = rank;
	this.adresse = adresse;
	this.credit = credit;
	this.lastGainForAnniversary = lastGainForAnniversary;
	this.anniversary = anniversary;
	this.dateRegister = dateRegister;
	this.email = email;
	this.password = password;
}
public User() {
	super();
}
public void calculateBalance(int ammount) {
	int currentCredit = this.getCredit();
	int diff = currentCredit-ammount;
	this.setCredit(diff);
	this.Update(this);
}

public static  User login(String email, String password) {
	DAOFactory adf = new DAOFactory();
	DAO<User> userDao = adf.getUserDAO();
	return ((UserDAO) userDao).login(email,password);
}
public boolean Register(User user) {
	DAOFactory adf = new DAOFactory();
	DAO<User> userDao = adf.getUserDAO();
	return userDao.create(user);
}
public boolean Update(User user) {
	DAOFactory adf = new DAOFactory();
	DAO<User> userDao = adf.getUserDAO();
	return userDao.update(user);
}
public User find(int id) {
	DAOFactory adf = new DAOFactory();
	DAO<User> userDao = adf.getUserDAO();
	return userDao.find(id);
}
}
