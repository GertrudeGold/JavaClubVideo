package DAO;

import java.sql.Connection;

import Pojo.VideoGame;

public class VideoGameDAO extends DAO<VideoGame> {
	public VideoGameDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(VideoGame obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(VideoGame obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(VideoGame obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public VideoGame find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public VideoGame findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
