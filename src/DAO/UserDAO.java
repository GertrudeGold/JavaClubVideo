package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Pojo.Administrator;
import Pojo.Player;
import Pojo.User;
public class UserDAO extends DAO<User> {
	public UserDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public static User login(String email, String password) {

		User user = null;
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from User where Email='"+email+"' and Password = '"+password+"'";
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				String name=result.getString("LastName");
				String firstName=result.getString("FirstName");
				String adresse=result.getString("Adresse");
				int id = result.getInt("Uid");
				int credit=result.getInt("Credits");
				LocalDate anniversary = result.getDate("Anniversary").toLocalDate();
				LocalDate dateRegistration = result.getDate("DateRegistration").toLocalDate();
				int rank = result.getInt("Rank");
				int gender = result.getInt("Gender");
				if(rank == 0) {
					return user = new Player (name,firstName,rank,gender,adresse,credit,anniversary,dateRegistration,null, null, null, id);
				}
				if(rank == 1 ) {
					return user = new Administrator(name,firstName,rank,gender,adresse,credit,anniversary,dateRegistration,id);
				}
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
