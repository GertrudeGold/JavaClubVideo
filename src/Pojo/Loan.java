package Pojo;

import java.io.Serializable;
import java.time.LocalDate;

import DAO.DAO;
import DAO.DAOFactory;

public class Loan implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -643330995158694544L;
	private LocalDate dateStartLoan;
	private LocalDate dateEndLoan;
	private int onGoing;
	private Player player;
	private Copy copy;
	private int id;
	
	public LocalDate getDateStartLoan() {
		return dateStartLoan;
	}
	public void setDateStartLoan(LocalDate dateStartLoan) {
		this.dateStartLoan = dateStartLoan;
	}
	public LocalDate getDateEndLoan() {
		return dateEndLoan;
	}
	public void setDateEndLoan(LocalDate dateEndLoan) {
		this.dateEndLoan = dateEndLoan;
	}
	public int getOnGoing() {
		return onGoing;
	}
	public void setOnGoing(int onGoing) {
		this.onGoing = onGoing;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Copy getCopy() {
		return copy;
	}
	public void setCopy(Copy copy) {
		this.copy = copy;
	}
	public Loan(LocalDate dateStartLoan, LocalDate dateEndLoan, int onGoing, Player player, Copy copy, int id) {
		super();
		this.dateStartLoan = dateStartLoan;
		this.dateEndLoan = dateEndLoan;
		this.onGoing = onGoing;
		this.player = player;
		this.copy = copy;
		this.id = id;
	}
	public Loan(LocalDate dateStartLoan, LocalDate dateEndLoan, int onGoing, Player player, Copy copy) {
		super();
		this.dateStartLoan = dateStartLoan;
		this.dateEndLoan = dateEndLoan;
		this.onGoing = onGoing;
		this.player = player;
		this.copy = copy;
	}
	public boolean Create(Loan loan) {
		DAOFactory adf = new DAOFactory();
		DAO<Loan> loanDAO = adf.getLoanDAO();
		return loanDAO.create(loan);
		
	}
	

}
