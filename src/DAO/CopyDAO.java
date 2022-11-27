package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import Pojo.Console;
import Pojo.Copy;
import Pojo.Player;
import Pojo.VideoGame;



public class CopyDAO extends DAO<Copy> {
	public CopyDAO(Connection conn) {
		super(conn);		
	}

	@Override
	public boolean create(Copy obj) {
		boolean	success = false;
		String query="INSERT INTO Copy (idUser,IdVideoGame,IdConsole,IsLock) VALUES(?,?,?,?)";
		try {
			PreparedStatement pstmt = (PreparedStatement) this.connect.prepareStatement(query);


	        pstmt.setInt(1,obj.getPlayer().getId());
	        pstmt.setInt(2, obj.getVideoGame().getId());
	        pstmt.setInt(3,obj.getConsole().getId());
	        pstmt.setInt(4,0);
	        



	        pstmt.executeUpdate();
	        pstmt.close();


			success = true;



		}
		catch(SQLException e) {
			e.printStackTrace();
		}

		return success;
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
		boolean success=false;
		
		String query="UPDATE Copy SET IsLock="+obj.getIsLock()+" WHERE UVid="+obj.getId();
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
	public Copy find(int id) {
		Copy copy = null;
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from (("
				+ "(Copy INNER JOIN VideoGame on Copy.IdVideoGame = VideoGame.Vid)"
				+ "INNER JOIN Console on Console.Cid = Copy.IdConsole)"
				+ "Inner JOIN User on User.Uid = Copy.IdUser)"
				+ "where Copy.UVid="+id;
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			if(result.first()) {
				
				//for videoGame
				String gameName =result.getString("GameName");
				int creditPrice=result.getInt("CreditPrice");
				int idVideoGame = result.getInt("Vid");
				//for player
				String name=result.getString("LastName");
				String firstName=result.getString("FirstName");
				String adresse=result.getString("Adresse");
				int idPlayer = result.getInt("Uid");
				int credit=result.getInt("Credits");
				LocalDate anniversary = result.getDate("Anniversary").toLocalDate();
				LocalDate dateRegistration = result.getDate("DateRegistration").toLocalDate();
				int rank = result.getInt("Rank");
				// for console
				String NameConsole =result.getString("NameConsole");
				int idConsole  = result.getInt("Cid");
				//for copy
				int idCopy  = result.getInt("Uvid");
				int isLock  = result.getInt("IsLock");
				Player player = new Player (name,firstName,rank,adresse,credit,anniversary,dateRegistration,idPlayer);
				Console console = new Console(NameConsole,idConsole);
				VideoGame videoGame =new VideoGame(creditPrice,gameName,idVideoGame);
				
				
				return copy= new Copy(player,videoGame,console,idCopy,isLock);
				
			}
				
			
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

	@Override
	public ArrayList<Copy> findAll() {
		ArrayList<Copy>copys = new ArrayList<Copy>();
		
		Connection conn=ProjetConnection.getInstance();
		String query="select * from (("
				+ "(Copy INNER JOIN VideoGame on Copy.IdVideoGame = VideoGame.Vid)"
				+ "INNER JOIN Console on Console.Cid = Copy.IdConsole)"
				+ "Inner JOIN User on User.Uid = Copy.IdUser)"
				+ "where Copy.IsLock="+0;
		try {
			ResultSet result=conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY).executeQuery(query);
			while(result.next()) {
				
				//for videoGame
				String gameName =result.getString("GameName");
				int creditPrice=result.getInt("CreditPrice");
				int idVideoGame = result.getInt("Vid");
				//for player
				String name=result.getString("LastName");
				String firstName=result.getString("FirstName");
				String adresse=result.getString("Adresse");
				int idPlayer = result.getInt("Uid");
				int credit=result.getInt("Credits");
				LocalDate anniversary = result.getDate("Anniversary").toLocalDate();
				LocalDate dateRegistration = result.getDate("DateRegistration").toLocalDate();
				int rank = result.getInt("Rank");
				// for console
				String NameConsole =result.getString("NameConsole");
				int idConsole  = result.getInt("Cid");
				//for copy
				int idCopy  = result.getInt("Uvid");
				Player player = new Player (name,firstName,rank,adresse,credit,anniversary,dateRegistration,idPlayer);
				Console console = new Console(NameConsole,idConsole);
				VideoGame videoGame =new VideoGame(creditPrice,gameName,idVideoGame);
				
				
				copys.add(new Copy(player,videoGame,console,idCopy,0));
				
			}
				
			return copys;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	
		return null;
	}

}
