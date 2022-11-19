package Pojo;

import java.io.Serializable;
import java.util.ArrayList;

import DAO.DAO;
import DAO.DAOFactory;
import DAO.UserDAO;
import DAO.VideoGameDAO;

public class VideoGame implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 5427188907476174030L;
private int creditPrice;
private String gameName;
private ArrayList<Console> consoles;
private int id;
public int getCreditPrice() {
	return creditPrice;
}
public void setCreditPrice(int creditPrice) {
	this.creditPrice = creditPrice;
}
public String getGameName() {
	return gameName;
}
public void setGameName(String gameName) {
	this.gameName = gameName;
}
public ArrayList<Console> getConsoles() {
	return consoles;
}
public void setConsoles(ArrayList<Console> consoles) {
	this.consoles = consoles;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public VideoGame(int creditPrice, String gameName, ArrayList<Console> consoles, int id) {
	super();
	this.creditPrice = creditPrice;
	this.gameName = gameName;
	this.consoles = consoles;
	this.id = id;
}
public VideoGame(int creditPrice, String gameName, int id) {
	super();
	this.creditPrice = creditPrice;
	this.gameName = gameName;
	this.id = id;
}
public static  ArrayList<VideoGame> findAll() {
	DAOFactory adf = new DAOFactory();
	DAO<VideoGame> videoGameDao = adf.getVideoGameDAO();
	return ((VideoGameDAO) videoGameDao).findAll();
}
public boolean update(VideoGame videoGame) {
	DAOFactory adf = new DAOFactory();
	DAO<VideoGame> videoGameDao = adf.getVideoGameDAO();
	return videoGameDao.update(videoGame);
}
@Override
public String toString() {
	return this.gameName;
}

}
