package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import Pojo.Booking;



public class BookingDAO extends DAO<Booking> {
	public BookingDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Booking obj) {		
		return false;
	}

	@Override
	public boolean delete(Booking obj) {		
		return false;
	}

	@Override
	public boolean update(Booking obj) {	
		return false;
	}

	@Override
	public Booking find(int id) {
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Booking> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
				
			
	
	
	
}