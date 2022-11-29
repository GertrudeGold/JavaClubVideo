package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Pojo.Administrator;
import Pojo.Booking;
import Pojo.Copy;
import Pojo.Loan;
import Pojo.Player;
import Pojo.User;
public class UserDAO extends DAO<User> {
	public UserDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(User obj) {
		
		boolean	success = false;
			String query="INSERT INTO User (FirstName,LastName,Anniversary,Rank,Adresse,Credits,DateRegistration,Email,Password,LastGainForAnniversary) VALUES(?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement pstmt = (PreparedStatement) this.connect.prepareStatement(query);

				
		        pstmt.setString(1,obj.getFirstName());
		        pstmt.setString(2, obj.getLastName());
		        pstmt.setObject(3,obj.getAnniversary());
		        pstmt.setInt(4,obj.getRank());
		        pstmt.setString(5,obj.getAdresse());
		        pstmt.setInt(6,obj.getCredit());
		        pstmt.setObject(7,obj.getDateRegister());
		        pstmt.setString(8,obj.getEmail());
		        pstmt.setString(9,obj.getPassword());
		        pstmt.setObject(10,obj.getLastGainForAnniversary());


		        pstmt.executeUpdate();
		        pstmt.close();


				success = true;



			}
			catch(SQLException e) {
				e.printStackTrace();
			}

			return success;
	}

	@Override
	public boolean delete(User obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(User obj) {
		boolean success=false;
		
		String query="UPDATE User SET Credits="+obj.getCredit()+",LastGainForAnniversary=(#"+ obj.getLastGainForAnniversary()+"#) WHERE Uid="+obj.getId();
		try {
			PreparedStatement pstmt = (PreparedStatement) this.connect.prepareStatement(query);
	        pstmt.executeUpdate();
	        pstmt.close();
	        success=true;
	        
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return success; 
	}

	@Override
	public User find(int id) {
		User user = null;
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from User where Uid="+id;
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				String name=result.getString("LastName");
				String firstName=result.getString("FirstName");
				String adresse=result.getString("Adresse");
				
				int credit=result.getInt("Credits");
				LocalDate anniversary = result.getDate("Anniversary").toLocalDate();
				LocalDate dateRegistration = result.getDate("DateRegistration").toLocalDate();
				int rank = result.getInt("Rank");
				LocalDate LastGainForAnniversary = result.getDate("LastGainForAnniversary").toLocalDate();
				if(rank == 0) {
					
					return user = new Player (name,firstName,rank,adresse,credit,anniversary,dateRegistration, id,LastGainForAnniversary);
				}
				if(rank == 1 ) {
					return user = new Administrator(name,firstName,rank,adresse,credit,anniversary,dateRegistration,id);
				}
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	

	@Override
	public ArrayList<User> findAll() {
		ArrayList<User> users = new ArrayList<User>();
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from User";
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				String name=result.getString("LastName");
				String firstName=result.getString("FirstName");
				String adresse=result.getString("Adresse");
				String email=result.getString("Email");
				int id = result.getInt("Uid");
				int credit=result.getInt("Credits");
				LocalDate anniversary = result.getDate("Anniversary").toLocalDate();
				LocalDate dateRegistration = result.getDate("DateRegistration").toLocalDate();
				int rank = result.getInt("Rank");
				LocalDate LastGainForAnniversary = result.getDate("LastGainForAnniversary").toLocalDate();
				if(rank == 0) {
					Player player= new Player (name,firstName,rank,adresse,credit,anniversary,dateRegistration,email, id,LastGainForAnniversary);
					users.add(player);
				} 
				if(rank == 1 ) {
					Administrator administrator = new Administrator (name,firstName,rank,adresse,credit,anniversary,dateRegistration,email, id,LastGainForAnniversary);
					users.add(administrator);
				}
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return users;
	}
	
	
	public User login(String email, String password) {

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
				LocalDate LastGainForAnniversary = result.getDate("LastGainForAnniversary").toLocalDate();
				if(rank == 0) {
					ArrayList<Copy> copys = new ArrayList<Copy>();
					ArrayList<Booking> bookings = new ArrayList<Booking>();
					ArrayList<Loan> loans = new ArrayList<Loan>();
					String query2="select * from Location where IdUser="+id;
					try {
						ResultSet result2=conn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY).executeQuery(query2);
						while(result2.next()) {
							 Loan loan = new Loan();
							 loan = loan.find(result2.getInt("Lid"));
							 loans.add(loan);
						}
						}
						catch(SQLException e) {
							e.printStackTrace();
						}
					String query3="select * from Copy where IdUser="+id;
					try {
						ResultSet result3=conn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY).executeQuery(query3);
						while(result3.next()) {
							Copy copy = new Copy();
							copy.find(result3.getInt("UVid"));
							copys.add(copy);
						}
						}
						catch(SQLException e) {
							e.printStackTrace();
						}
					String query4="select * from Reservation where IdUser="+id;
					try {
						ResultSet result4=conn.createStatement(
								ResultSet.TYPE_SCROLL_INSENSITIVE,
								ResultSet.CONCUR_READ_ONLY).executeQuery(query4);
						while(result4.next()) {
							Booking booking = new Booking();
							booking.find(result4.getInt("Rid"));
							bookings.add(booking);
						}
						}
						catch(SQLException e) {
							e.printStackTrace();
						}
					
					return user = new Player (name,firstName,rank,adresse,credit,anniversary,dateRegistration,copys, bookings, loans, id,LastGainForAnniversary);
				}
				if(rank == 1 ) {
					return user = new Administrator(name,firstName,rank,adresse,credit,anniversary,dateRegistration,id);
				}
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
