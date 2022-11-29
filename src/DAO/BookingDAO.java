package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Pojo.Booking;
import Pojo.Console;
import Pojo.Copy;
import Pojo.Loan;
import Pojo.Player;
import Pojo.VideoGame;



public class BookingDAO extends DAO<Booking> {
	public BookingDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Booking obj) {		
		boolean	success = false;
		String query="INSERT INTO Reservation (DateReservation,IdUser,IdVideoGame,IdConsole,IsReady) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = (PreparedStatement) this.connect.prepareStatement(query);

			
	        pstmt.setObject(1,obj.getDateReservation());
	        pstmt.setInt(2, obj.getPlayer().getId());
	        pstmt.setInt(3,obj.getVideoGame().getId());
	        pstmt.setInt(4,obj.getConsole().getId());
	        pstmt.setInt(5,obj.getIsReady());


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
	public boolean delete(Booking obj) {		
		boolean success=false;
		
		String query="Delete FROM Reservation  WHERE Rid="+obj.getId();
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
	public boolean update(Booking obj) {	
		boolean success=false;
		
		String query="UPDATE Reservation SET IsReady="+obj.getIsReady()+" WHERE Rid="+obj.getId();
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
	public Booking find(int id) {
		Booking booking = null;
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from (("
				+ "(Reservation INNER JOIN VideoGame on Reservation.IdVideoGame = VideoGame.Vid)"
				+ "INNER JOIN Console on Console.Cid = Reservation.IdConsole)"
				+ "Inner JOIN User on User.Uid = Reservation.IdUser)"
				+ "where Reservation.Rid="+id;
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				//for videoGame
				String gameName =result.getString("GameName");
				int creditPrice=result.getInt("CreditPrice");
				int idVideoGame = result.getInt("Vid");
				//for player
				String name=result.getString("LastName");
				String firstName=result.getString("FirstName");
				String adresse=result.getString("Adresse");
				int idPlayer = result.getInt("Uid");
				int credit=result.getInt("Credits");
				LocalDate anniversary = result.getDate("Anniversary").toLocalDate();
				LocalDate dateRegistration = result.getDate("DateRegistration").toLocalDate();
				int rank = result.getInt("Rank");
				// for console
				String NameConsole =result.getString("NameConsole");
				int idConsole  = result.getInt("Cid");
				//for booking
				int idBooking  = result.getInt("Rid");
				LocalDate dateReservation  =result.getDate("DateReservation").toLocalDate();
				Player player = new Player (name,firstName,rank,adresse,credit,anniversary,dateRegistration,idPlayer);
				Console console = new Console(NameConsole,idConsole);
				VideoGame videoGame =new VideoGame(creditPrice,gameName,idVideoGame);
				int isReady = result.getInt("IsReady");
				
				return booking= new Booking(idBooking,dateReservation,player,videoGame,console,isReady);
				
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	

	@Override
	public ArrayList<Booking> findAll() {
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from (("
				+ "(Reservation INNER JOIN VideoGame on Reservation.IdVideoGame = VideoGame.Vid)"
				+ "INNER JOIN Console on Console.Cid = Reservation.IdConsole)"
				+ "Inner JOIN User on User.Uid = Reservation.IdUser)";
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				//for videoGame
				String gameName =result.getString("GameName");
				int creditPrice=result.getInt("CreditPrice");
				int idVideoGame = result.getInt("Vid");
				//for player
				String name=result.getString("LastName");
				String firstName=result.getString("FirstName");
				String adresse=result.getString("Adresse");
				int idPlayer = result.getInt("Uid");
				int credit=result.getInt("Credits");
				LocalDate anniversary = result.getDate("Anniversary").toLocalDate();
				LocalDate dateRegistration = result.getDate("DateRegistration").toLocalDate();
				int rank = result.getInt("Rank");
				// for console
				String NameConsole =result.getString("NameConsole");
				int idConsole  = result.getInt("Cid");
				//for booking
				int idBooking  = result.getInt("Rid");
				LocalDate dateReservation  =result.getDate("DateReservation").toLocalDate();
				Player player = new Player (name,firstName,rank,adresse,credit,anniversary,dateRegistration,idPlayer);
				Console console = new Console(NameConsole,idConsole);
				VideoGame videoGame =new VideoGame(creditPrice,gameName,idVideoGame);
				int isReady = result.getInt("IsReady");
				
				bookings.add(new Booking(idBooking,dateReservation,player,videoGame,console,isReady)); 
				
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return bookings;
	}
				
			
	
	
	
}