package dao;

import entity.Players;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PlayersDao {

	private Connection connection;
	private final String GET_PLAYERS_QUERY = "SELECT * FROM players";

	public PlayersDao() {
		connection = DBConnection.getConnection();
	}
	
	//get all players with proper syntax according to our players table parameters
	public List<Players> getPlayers() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_PLAYERS_QUERY).executeQuery();
		List<Players> players = new ArrayList<Players>();
		
		while(rs.next()) {
			players.add(populatePlayers(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getDouble(6),rs.getInt(7), rs.getDouble(8)));
		}
		
		return players;
	}
	
	//get a player with proper syntax according to our players table parameters
	private Players populatePlayers(int id, int teamId, String playerName, int playerRank, String team, double averagePoints, int gamesPlayed, double minutesPerGame) {
		return new Players(id, teamId, playerName, playerRank, team, averagePoints, gamesPlayed, minutesPerGame);
	}
}
