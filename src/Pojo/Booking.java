package Pojo;

import java.io.Serializable;
import java.time.LocalDate;

import DAO.DAO;
import DAO.DAOFactory;

public class Booking implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4503149377461984170L;
	
	private int id;
	private LocalDate dateReservation;
	private Player player;
	private VideoGame videoGame;
	private Console console;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDateReservation() {
		return dateReservation;
	}
	public void setDateReservation(LocalDate dateReservation) {
		this.dateReservation = dateReservation;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public VideoGame getVideoGame() {
		return videoGame;
	}
	public void setVideoGame(VideoGame videoGame) {
		this.videoGame = videoGame;
	}
	public Console getConsole() {
		return console;
	}
	public void setConsole(Console console) {
		this.console = console;
	}
	public Booking(int id, LocalDate dateReservation, Player player, VideoGame videoGame, Console console) {
		super();
		this.id = id;
		this.dateReservation = dateReservation;
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
	}
	public Booking(LocalDate dateReservation, Player player, VideoGame videoGame, Console console) {
		super();
		this.dateReservation = dateReservation;
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
	}
	public Booking() {
		super();
	}
	public Booking(int id, LocalDate dateReservation) {
		super();
		this.id = id;
		this.dateReservation = dateReservation;
	}
	public Booking find(int id) {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		return bookingDao.find(id);
		
	}
	public boolean create(Booking booking) {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		return bookingDao.create(booking);
		
	}

}
