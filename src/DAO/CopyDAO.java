package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Copy;



public class CopyDAO extends DAO<Copy> {
	public CopyDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Copy obj) {
		boolean	success = false;
		String query="INSERT INTO Copy (idUser,IdVideoGame,IdConsole,Available) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = (PreparedStatement) this.connect.prepareStatement(query);


	        pstmt.setInt(1,obj.getPlayer().getId());
	        pstmt.setInt(2, obj.getVideoGame().getId());
	        pstmt.setInt(3,obj.getConsole().getId());
	        pstmt.setInt(4,0);
	        



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
	public boolean delete(Copy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Copy obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Copy find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Copy> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
