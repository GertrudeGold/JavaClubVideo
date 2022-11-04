package DAO;

import java.sql.Connection;

public class LoanDAO extends DAO<LoanDAO> {
	public LoanDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(LoanDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(LoanDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(LoanDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoanDAO find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanDAO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
