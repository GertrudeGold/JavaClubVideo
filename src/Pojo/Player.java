package Pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Player extends User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5129593058312925108L;
	private ArrayList<Copy> copys;
	private ArrayList<Booking> bookings;
	private ArrayList<Loan> loans;
	

	public Player(String firstName, String lastName, int rank, String adresse, int credit, LocalDate anniversary,
			LocalDate dateRegister, int id) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, id, dateRegister);
		// TODO Auto-generated constructor stub
	}
	public Player(String firstName, String lastName, int rank, String adresse, int credit,
			LocalDate anniversary, LocalDate dateRegister,ArrayList<Copy> copys,ArrayList<Booking> bookings,
			ArrayList<Loan> loans, int id,LocalDate lastGainForAnniversary) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister,id, lastGainForAnniversary);
	this.copys = copys;
	this.bookings = bookings;
	this.loans = loans;
	
	}
	public Player() {
		super();
	}
	public Player(String firstName, String lastName, int rank, String adresse, int credit, LocalDate anniversary,
			LocalDate dateRegister, int id, LocalDate lastGainForAnniversary) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, id, lastGainForAnniversary);
	}
	public Player(String firstName, String lastName, int rank, String adresse, int credit,
			LocalDate anniversary, LocalDate dateRegister, String email, String password, LocalDate lastGainForAnniversary) {
		super(firstName, lastName, rank, adresse, credit, anniversary, dateRegister, email, password, lastGainForAnniversary);
		// TODO Auto-generated constructor stub
	}

	public ArrayList<Copy> getCopy() {
		return copys;
	}

	public void setCopy(ArrayList<Copy> copys) {
		this.copys = copys;
	}

	public ArrayList<Booking> getBooking() {
		return bookings;
	}

	public void setBooking(ArrayList<Booking> bookings) {
		this.bookings = bookings;
	}

	public ArrayList<Loan> getLoan() {
		return loans;
	}

	public void setLoan(ArrayList<Loan> loans) {
		this.loans = loans;
	}
	public ArrayList<Loan> getOnGoingLoan(){
		ArrayList<Loan> loans = new ArrayList<Loan>();
		for(Loan loan : this.getLoan() ) {
			if(loan.getOnGoing() == 1 ) {
				loans.add(loan);
			}
			
		}
		return loans;
	}
	
	

}
