package Pojo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

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
	private int isReady;
	private int maxCredit;
	private LocalDate mostOldReservationDate;
	private LocalDate mostOldRegister;
	private LocalDate mostOld;
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
	
	public int getIsReady() {
		return isReady;
	}
	public void setIsReady(int isReady) {
		this.isReady = isReady;
	}
	
	public Booking(int id, LocalDate dateReservation, Player player, VideoGame videoGame, Console console,
			int isReady) {
		super();
		this.id = id;
		this.dateReservation = dateReservation;
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
		this.isReady = isReady;
	
	}
	
	public Booking(LocalDate dateReservation, Player player, VideoGame videoGame, Console console, int isReady) {
		super();
		this.dateReservation = dateReservation;
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
		this.isReady = isReady;
	}
	public Booking() {
		super();
	}
	
	public Booking find(int id) {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		return bookingDao.find(id);
		
	}
	public static ArrayList<Booking> findAll() {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		return bookingDao.findAll();
		
	}
	public static ArrayList<Booking> findAllNotReeady() {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		ArrayList<Booking> bookingsNotReady = new ArrayList<Booking>();
		for(Booking booking :bookingDao.findAll() )
		{
			if(booking.isReady == 0 ) {
				bookingsNotReady.add(booking);
			}
		}
		return bookingsNotReady;
		
	}
	public static ArrayList<Booking> findAllOfAnUser(Player player) {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		for(Booking booking :bookingDao.findAll() )
		{
			if(booking.getPlayer().getId()== player.getId() ) {
				bookings.add(booking);
			}
		}
		return bookings;
		
	}
	public boolean create(Booking booking) {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		return bookingDao.create(booking);
		
	}
	public boolean update(Booking booking) {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		return bookingDao.update(booking);
		
	}
	public boolean delete(Booking booking) {
		DAOFactory adf = new DAOFactory();
		DAO<Booking> bookingDao = adf.getBookingDAO();
		return bookingDao.delete(booking);
		
	}
	public  Booking findPriorityBooking(ArrayList<Booking> bookings) {
			Booking goodBooking=null;
			maxCredit = 0;
			mostOldReservationDate = LocalDate.now().plusYears(900);
			mostOldRegister = LocalDate.now().plusYears(900);
			mostOld= LocalDate.now().plusYears(900);
			for(Booking booking : bookings ) {
				if(booking.getPlayer().getCredit() > maxCredit) {
					maxCredit = booking.getPlayer().getCredit();
				}
			}
			for(Booking booking : bookings ) {
				if(booking.getDateReservation().isBefore(mostOldReservationDate)) {
					mostOldReservationDate = booking.getDateReservation();
				}
			}
			for(Booking booking : bookings ) {
				if(booking.getPlayer().getDateRegister().isBefore(mostOldRegister)) {
					mostOldRegister = booking.getPlayer().getDateRegister();
				}
			}
			for(Booking booking : bookings ) {
				if(booking.getPlayer().getAnniversary().isBefore(mostOld)) {
					mostOld = booking.getPlayer().getAnniversary();
				}
			}
			
			ArrayList<Booking> filteredBookingListByCredit= (ArrayList<Booking>) bookings.stream()
					.filter(booking -> booking.getPlayer().getCredit() >= maxCredit)
					.collect(Collectors.toList());
			if(filteredBookingListByCredit.size() >1) {
				ArrayList<Booking> filteredBookingListByOlderReservation= (ArrayList<Booking>) filteredBookingListByCredit.stream()
						.filter(booking -> booking.getDateReservation().isBefore(mostOldReservationDate) || booking.getDateReservation().isEqual(mostOldReservationDate) )
						.collect(Collectors.toList());
				if(filteredBookingListByOlderReservation.size() >1) {
					ArrayList<Booking> filteredBookingListByOlderRegister= (ArrayList<Booking>) filteredBookingListByOlderReservation.stream()
							.filter(booking -> booking.getPlayer().getDateRegister().isBefore(mostOldRegister) || booking.getPlayer().getDateRegister().isEqual(mostOldRegister) )
							.collect(Collectors.toList());
					if(filteredBookingListByOlderRegister.size() >1) {
						ArrayList<Booking> filteredBookingListByOlder= (ArrayList<Booking>) filteredBookingListByOlderRegister.stream()
								.filter(booking -> booking.getPlayer().getAnniversary().isBefore(mostOld) || booking.getPlayer().getAnniversary().isEqual(mostOld) )
								.collect(Collectors.toList());
						if(filteredBookingListByOlder.size()>1) {
							int index = (int)(Math.random() * filteredBookingListByOlder.size());
							goodBooking=  filteredBookingListByOlder.get(index);
						}else {
							goodBooking = filteredBookingListByOlder.get(0);
						}
					}else {
						goodBooking = filteredBookingListByOlderRegister.get(0);
					}
				}else {
					goodBooking = filteredBookingListByOlderReservation.get(0);
				}
			}else {
				goodBooking = filteredBookingListByCredit.get(0);
			}
				
		
		
		return goodBooking;
	}
}
