package DAO;

import java.sql.Connection;
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

}
