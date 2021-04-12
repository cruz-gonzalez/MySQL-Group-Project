package dao;

import java.sql.Connection;

public class TeamSponsorDao {
	
	private Connection connection;
	private final String GET_TEAM_SPONSOR_QUERY = "SELECT * FROM team_sponsor";
	private final String GET_TEAM_SPONSOR_BY_ID_QUERY = "SELECT * from team_sponsor WHERE team_id = ?";
	
	public TeamSponsorDao() {
		connection = DBConnection.getConnection();
	}
	
	

}
