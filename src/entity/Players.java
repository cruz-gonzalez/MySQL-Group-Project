package entity;

public class Players {
	private int id;
	private int teamId;
	private String playerName;
	private int playerRank;
	private String team;
	private int averagePoints;
	private int gamesPlayed;
	private int minutesPerGame;
	
	public Players(int id, int teamId, String playerName, int playerRank, String team, int averagePoints, int gamesPlayed, int minutesPerGame) {
		this.setId(id);
		this.setTeamId(teamId);
		this.setPlayerName(playerName);
		this.setPlayerRank(playerRank);
		this.setTeam(team);
		this.setAveragePoints(averagePoints);
		this.setGamesPlayed(gamesPlayed);
		this.setMinutesPerGame(minutesPerGame);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerRank() {
		return playerRank;
	}

	public void setPlayerRank(int playerRank) {
		this.playerRank = playerRank;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getAveragePoints() {
		return averagePoints;
	}

	public void setAveragePoints(int averagePoints) {
		this.averagePoints = averagePoints;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getMinutesPerGame() {
		return minutesPerGame;
	}

	public void setMinutesPerGame(int minutesPerGame) {
		this.minutesPerGame = minutesPerGame;
	}
}
