package DAO;

import java.sql.Connection;

public class VideoGameDAO extends DAO<VideoGameDAO> {
	public VideoGameDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(VideoGameDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(VideoGameDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(VideoGameDAO obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VideoGameDAO find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoGameDAO findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
