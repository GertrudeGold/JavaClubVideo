package Pojo;

import java.io.Serializable;

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
	public Copy(Player player, VideoGame videoGame, Console console, Loan loan, int id) {
		super();
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
		this.loan = loan;
		this.id = id;
	}
	public Copy(Player player, VideoGame videoGame, Console console) {
		super();
		this.player = player;
		this.videoGame = videoGame;
		this.console = console;
	}
	public boolean Create(Copy copy) {
		DAOFactory adf = new DAOFactory();
		DAO<Copy> copyDao = adf.getCopyDAO();
		return copyDao.create(copy);
		
	}

}
