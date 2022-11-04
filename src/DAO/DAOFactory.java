package DAO;

import java.sql.Connection;

import Pojo.Booking;
import Pojo.Copy;
import Pojo.Loan;
import Pojo.User;
import Pojo.VideoGame;



public class DAOFactory extends AbstractDAOFactory{
protected static final Connection conn = ProjetConnection.getInstance();
	
	@Override
	public DAO<User> getUserDAO(){
		return new UserDAO(conn);
	}
	@Override
	public DAO<Booking> getBookingDAO(){
		return new BookingDAO(conn);
	}
	@Override
	public DAO<Loan> getLoanDAO(){
		return new LoanDAO(conn);
	}
	@Override
	public DAO<VideoGame> getVideoGameDAO(){
		return new VideoGameDAO(conn);
	}
	@Override
	public DAO<Copy> getCopyDAO(){
		return new CopyDAO(conn);
	}
	
}