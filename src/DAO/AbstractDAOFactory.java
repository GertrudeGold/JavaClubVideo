package DAO;
import Pojo.Booking;
import Pojo.Copy;
import Pojo.User;
import Pojo.Loan;
import Pojo.VideoGame;


public abstract class AbstractDAOFactory {


	public static final int DAO_FACTORY = 0;
	public static final int XML_DAO_FACTORY = 1;

	
	
	public abstract DAO<User> getUserDAO();
	public abstract DAO<Copy> getCopyDAO();
	public abstract DAO<Loan> getLoanDAO();
	public abstract DAO<Booking> getBookingDAO();
	public abstract DAO<VideoGame> getVideoGameDAO();
	
	public static DAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}}
