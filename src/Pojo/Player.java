package Pojo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Player extends User{
	private ArrayList<Copy> copy;
	private ArrayList<Booking> booking;
	private ArrayList<Loan> loan;

	public Player(String firstName, String lastName, int rank, String adresse, int credit,
			LocalDate anniversary, LocalDate dateRegister,ArrayList<Copy> copy,ArrayList<Booking> booking,
			ArrayList<Loan> loan, int id) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister,id);
		// TODO Auto-generated constructor stub
	}
	public Player(String firstName, String lastName, int rank, String adresse, int credit,
			LocalDate anniversary, LocalDate dateRegister, String email, String password) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, email, password);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Copy> getCopy() {
		return copy;
	}

	public void setCopy(ArrayList<Copy> copy) {
		this.copy = copy;
	}

	public ArrayList<Booking> getBooking() {
		return booking;
	}

	public void setBooking(ArrayList<Booking> booking) {
		this.booking = booking;
	}

	public ArrayList<Loan> getLoan() {
		return loan;
	}

	public void setLoan(ArrayList<Loan> loan) {
		this.loan = loan;
	}
	
	

}
