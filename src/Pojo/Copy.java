package Pojo;

import java.io.Serializable;
import java.util.ArrayList;

import DAO.DAO;
import DAO.DAOFactory;

public class Copy implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8998077995170703837L;
	private Player player;
	private VideoGame videoGame;
	private Console console;
	private Loan loan; 
	private int id;
	private int isLock;
	
	public int getIsLock() {
		return isLock;
	}
	public void setIsLock(int isLock) {
		this.isLock = isLock;
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
	public Loan getLoan() {
		return loan;
	}
	public void setLoan(Loan loan) {
		this.loan = loan;
	}
	public Copy(Player player, VideoGame videoGame, Console console, Loan loan) {
		super();
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
		this.loan = loan;
	}
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Copy(Player player, VideoGame videoGame, Console console, int isLock) {
		super();
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;		
		this.isLock = isLock;
	}

	
	public Copy(Player player, VideoGame videoGame, Console console, int id,int isLock) {
		super();
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
		this.id = id;
		this.isLock = isLock;
	}
	
	public Copy() {
		super();
	}
	public boolean Create(Copy copy) {
		DAOFactory adf = new DAOFactory();
		DAO<Copy> copyDao = adf.getCopyDAO();
		return copyDao.create(copy);
		
	}
	public boolean update(Copy copy) {
		DAOFactory adf = new DAOFactory();
		DAO<Copy> copyDao = adf.getCopyDAO();
		return copyDao.update(copy);
		
	}
	public Copy find(int id) {
		DAOFactory adf = new DAOFactory();
		DAO<Copy> copyDao = adf.getCopyDAO();
		return copyDao.find(id);
		
	}
	public static ArrayList<Copy> findallUnlock() {
		ArrayList<Copy> copys = new ArrayList<Copy>();
		DAOFactory adf = new DAOFactory();
		DAO<Copy> copyDao = adf.getCopyDAO();
		for(Copy copy :copyDao.findAll() )
		{
			if(copy.isLock == 0) {
				copys.add(copy) ;
			}
		}
		return copys;
		
	}
	public  Copy findACopyForAReservation(Booking booking) {
	
		DAOFactory adf = new DAOFactory();
		DAO<Copy> copyDao = adf.getCopyDAO();
		
		for(Copy copy :copyDao.findAll() )
		{
			if(copy.getIsLock() == booking.getId() ) {
				return copy;
			}
		}
		return null ;
		
	}

}
