package Pojo;

import java.util.ArrayList;

import DAO.DAO;
import DAO.DAOFactory;
import DAO.UserDAO;
import DAO.VideoGameDAO;

public class VideoGame {
private int creditPrice;
private String GameName;
private ArrayList<Console> consoles;
private int id;
public int getCreditPrice() {
	return creditPrice;
}
public void setCreditPrice(int creditPrice) {
	this.creditPrice = creditPrice;
}
public String getGameName() {
	return GameName;
}
public void setGameName(String gameName) {
	GameName = gameName;
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
	GameName = gameName;
	this.consoles = consoles;
	this.id = id;
}
public VideoGame(int creditPrice, String gameName, int id) {
	super();
	this.creditPrice = creditPrice;
	GameName = gameName;
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

}
