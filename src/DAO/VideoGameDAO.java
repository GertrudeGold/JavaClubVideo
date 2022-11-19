package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Pojo.Console;
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
		boolean success=false;
		String query="Update VideoGame SET CreditPrice="+obj.getCreditPrice()+" WHERE Vid="+obj.getId();
		try {
			
			PreparedStatement pstmt = (PreparedStatement) this.connect.prepareStatement(query);
	        
	        pstmt.executeUpdate();
	        pstmt.close();
	        success=true;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public VideoGame find(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<VideoGame> findAll() {
		ArrayList<VideoGame>videoGames = new ArrayList<VideoGame>();
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from VideoGame ";
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				ArrayList<Console> consoles= new ArrayList<Console>();
				String gameName =result.getString("GameName");
				int creditPrice=result.getInt("CreditPrice");
				int id  = result.getInt("Vid");
				String query2="select Console.Cid, Console.NameConsole from (Console INNER JOIN ConsolesOfVideoGame on Console.Cid = ConsolesOfVideoGame.idConsole)"
						+ "WHERE ConsolesOfVideoGame.idVideoGame="+id;
				ResultSet result2=conn.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeQuery(query2);
				while(result2.next()) {
					
					int cid = result2.getInt("Cid");
					String cName = result2.getString("NameConsole");
					Console console = new Console(cName,cid);
					consoles.add(console);
				}
				
				videoGames.add(new VideoGame(creditPrice,gameName,consoles,id));
				
			}
				
			return videoGames;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
