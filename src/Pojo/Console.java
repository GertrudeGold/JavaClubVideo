package Pojo;

import java.io.Serializable;
import java.util.ArrayList;

import DAO.ConsoleDAO;
import DAO.DAO;
import DAO.DAOFactory;
import DAO.VideoGameDAO;

public class Console implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = -5637886907182228802L;
private String nameConsole;
private ArrayList<VideoGame> games;
private int id;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNameConsole() {
	return nameConsole;
}
public void setNameConsole(String nameConsole) {
	this.nameConsole = nameConsole;
}
public ArrayList<VideoGame> getGames() {
	return games;
}
public void setGames(ArrayList<VideoGame> games) {
	this.games = games;
}
public Console(String nameConsole, ArrayList<VideoGame> games) {
	super();
	this.nameConsole = nameConsole;
	this.games = games;
}
public Console(String nameConsole) {
	super();
	this.nameConsole = nameConsole;
}
public Console(String nameConsole, int id) {
	super();
	this.nameConsole = nameConsole;
	this.id = id;
}

public Console() {
	super();
}
public static  ArrayList<Console> findAll() {
	DAOFactory adf = new DAOFactory();
	DAO<Console> consoleDao = adf.getConsoleDAO();
	return ((ConsoleDAO) consoleDao).findAll();
}

@Override
public String toString() {
	return this.nameConsole ;
}





}