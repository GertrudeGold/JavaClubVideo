package DAO;

import java.sql.Connection;
import java.util.ArrayList;

import Pojo.Loan;

public class LoanDAO extends DAO<Loan> {
	public LoanDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Loan obj) {
		// TODO Auto-generated method stub
		return false;
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
