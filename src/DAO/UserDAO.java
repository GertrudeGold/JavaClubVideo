package DAO;

import java.sql.Connection;

public class UserDAO extends DAO<UserDAO> {
	public UserDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(UserDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(UserDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(UserDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDAO find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserDAO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
