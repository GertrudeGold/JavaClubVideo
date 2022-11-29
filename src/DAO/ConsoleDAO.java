package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Console;
import Pojo.VideoGame;



public class ConsoleDAO extends DAO<Console> {
	public ConsoleDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Console obj) {		
		return false;
	}

	@Override
	public boolean delete(Console obj) {		
		return false;
	}

	@Override
	public boolean update(Console obj) {	
		return false;
	}

	@Override
	public Console find(int id) {
		Console console;
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from Console where Cid ="+id;
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				
				String NameConsole =result.getString("NameConsole");
				
				
				console = new Console(NameConsole,id);
				
			}
				
			return null;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	

	@Override
	public ArrayList<Console> findAll() {
		ArrayList<Console>consoles = new ArrayList<Console>();
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from Console ";
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				
				String NameConsole =result.getString("NameConsole");
				
				int id  = result.getInt("Cid");
				consoles.add(new Console(NameConsole,id));
				
			}
				
			return consoles;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}
				
			
	
	
	
}