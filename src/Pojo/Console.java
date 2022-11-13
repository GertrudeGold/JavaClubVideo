package Pojo;

import java.util.ArrayList;

public class Console {
private String nameConsole;
private ArrayList<VideoGame> games;
private int id;
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






}