package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.PlayoffTeams;

public class PlayoffTeamsDao {
	
	private Connection connection;
	private final String GET_TEAMS_QUERY = "SELECT * FROM playoff_teams";
	
	
	public PlayoffTeamsDao () {
		connection = DBConnection.getConnection();
	}
	
	public List<PlayoffTeams> getTeams() throws SQLException {
		ResultSet rs = connection.prepareStatement(GET_TEAMS_QUERY).executeQuery();
		List<PlayoffTeams> playoffTeams = new ArrayList<PlayoffTeams>();
		
		while(rs.next()) {
			playoffTeams.add(populateTeam(rs.getInt(1)));
		}
	}
	
}
