package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PlayerSponsor;


public class PlayerSponsorDao {
	
	private Connection connection;
	//private PlayerSponsorDao playerSponsorDao = new PlayerSponsorDao();
	private final String GET_PLAYER_SPONSOR_QUERY = "SELECT * FROM player_sponsor";
	private final String GET_PLAYER_SPONSOR_BY_ID_QUERY = "SELECT * FROM players_sponsor WHERE player_id = ?";
	
	//constructor so that the connection can be used outside of the private definition within this class (line 14)
	public PlayerSponsorDao() {
		connection = DBConnection.getConnection();
	}
	//get list of all playersponsors from the database
	public List<PlayerSponsor> getPlayerSponsors() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_PLAYER_SPONSOR_QUERY).executeQuery();
		List<PlayerSponsor> playerSponsors = new ArrayList<PlayerSponsor>();
		
		while(rs.next()) {
			playerSponsors.add(populatePlayerSponsor(rs.getInt(1), rs.getInt(2)));
		}
		
		return playerSponsors;
	}
	
	private PlayerSponsor populatePlayerSponsor(int playerId, int sponsorId) {
		return new PlayerSponsor(playerId, sponsorId);
	}

}
