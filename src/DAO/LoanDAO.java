package DAO;

import java.sql.Connection;
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

public class LoanDAO extends DAO<Loan> {
	public LoanDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Loan obj) {
		boolean	success = false;
		String query="INSERT INTO Location (DateStartReservation,DateEndReservation,Ongoing,IdUser,IdCopy) VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = (PreparedStatement) this.connect.prepareStatement(query);


	        pstmt.setObject(1,obj.getDateStartLoan());
	        pstmt.setObject(2, obj.getDateEndLoan());
	        pstmt.setInt(3,obj.getOnGoing());
	        pstmt.setInt(4,obj.getPlayer().getId());
	        pstmt.setInt(5,obj.getCopy().getId());
	        



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
	public boolean delete(Loan obj) {
		// TODO Auto-generated method stub
		return false;
	}

	

	@Override
	public boolean update(Loan obj) {
		boolean success=false;
		
		String query="UPDATE Location SET Ongoing="+obj.getOnGoing()+" WHERE Lid="+obj.getId();
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
	public Loan find(int id) {
		Loan loan = null;
		Player player = new Player();
		Copy copy = new Copy();
		Connection conn=ProjetConnection.getInstance();
		String query="select * from Location where Lid="+id;
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				
				int ongoing=result.getInt("Ongoing");
				LocalDate DateStartReservation = result.getDate("DateStartReservation").toLocalDate();
				LocalDate DateEndReservation = result.getDate("DateEndReservation").toLocalDate();
				 player = (Player) player.find(result.getInt("IdUser"));
				 copy = copy.find(result.getInt("IdCopy"));
				
					return loan = new Loan (DateStartReservation,DateEndReservation,ongoing,player,copy,id);
				
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}
	

	@Override
	public ArrayList<Loan> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
