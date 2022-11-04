package DAO;

import java.sql.Connection;

import Pojo.Copy;



public class CopyDAO extends DAO<Copy> {
	public CopyDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Copy obj) {
		// TODO Auto-generated method stub
		return false;
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
	public Copy findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
