package dao;

import entity.Players;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayersDao {

	private Connection connection;
	private final String GET_PLAYERS_QUERY = "SELECT * FROM players";
	private final String GET_PLAYER_BY_ID_QUERY = "SELECT * FROM players WHERE id = ?";

	public PlayersDao() {
		connection = DBConnection.getConnection();
	}
	
	//get all players with proper syntax according to our players table parameters
	public List<Players> getPlayers() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_PLAYERS_QUERY).executeQuery();
		List<Players> players = new ArrayList<Players>();
		
		while(rs.next()) {
			players.add(populatePlayer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDouble(8)));
		}
		
		return players;
	}
	//get all players with proper syntax according to our players table parameters
	private Players getPlayerById(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(GET_PLAYER_BY_ID_QUERY);
		ps.setInt(1,id);
		ResultSet rs = ps.executeQuery();
		rs.next();
		return populatePlayer(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDouble(8));
	}
	
	//get a player with proper syntax according to our players table parameters
	private Players populatePlayer(int id, int teamId, String playerName, int playerRank, String team, double averagePoints, int gamesPlayed, double minutesPerGame) {
		return new Players(id, teamId, playerName, playerRank, team, averagePoints, gamesPlayed, minutesPerGame);
	}
}
