package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Loan;

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
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Loan obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Loan find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Loan> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
