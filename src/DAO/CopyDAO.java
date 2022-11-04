package DAO;

import java.sql.Connection;



public class CopyDAO extends DAO<CopyDAO> {
	public CopyDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(CopyDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(CopyDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(CopyDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CopyDAO find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CopyDAO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
