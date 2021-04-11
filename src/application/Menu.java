package application;

import java.util.Scanner;

import dao.PlayoffTeamsDao;
import dao.SponsorsDao;
import dao.PlayersDao;
import entity.Players;
import entity.PlayoffTeams;
import entity.Sponsors;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
public class Menu {
	
	private PlayoffTeamsDao playoffTeamsDao = new PlayoffTeamsDao();
	private PlayersDao playersDao = new PlayersDao();
	private SponsorsDao sponsorsDao = new SponsorsDao();
	
	private Scanner scanner = new Scanner(System.in);
	
	
	private List<String> options = Arrays.asList("Display Teams",
			 "Display Team",
			 "Create Team",
			 "Delete Team",
			 "Display Players",
			 "Display Player",
			 "Create player",
			 "Delete Player",
			 "Display Sponsors",
			 "Display Sponsor");
	public void start() {
		String selection = "";
		 
		do {
			
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					displayTeams();
				}
				if(selection.equals("2")) {
					displayTeam();
				}
				if(selection.equals("3")) {
					createTeam();
				}
				if(selection.equals("4")) {
					deleteTeam();
				}
				if(selection.equals("5")) {
					displayPlayers();
				}
				if(selection.equals("6")) {
					displayPlayer();
				}
				if(selection.equals("7")) {
					createPlayer();
				}
				if(selection.equals("8")) {
					//deletePlayer();
				}
				if(selection.equals("9")) {
					displaySponsors();
				}
				if(selection.equals("10")) {
					displaySponsor();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			System.out.println("Press 'enter' to continue");
			scanner.nextLine();
			
		} while (!selection.equals("-1"));
	}

	private void printMenu() {
		System.out.println("Select an option\n-------------------");
		for(int i = 0; i<options.size(); i++){
			System.out.println(i + 1 + ") " + options.get(i));
		}
	}
	
	//display all teams using function defined in playoffteams file, based off the menu.start option
	private void displayTeams() throws SQLException {
		List<PlayoffTeams> playoffTeams = playoffTeamsDao.getTeams();
		for(PlayoffTeams playoffTeam: playoffTeams) {
			System.out.println(playoffTeam.getId() + ": " + playoffTeam.getTeamName() + ": " + playoffTeam.getTeamRank() + ": " + playoffTeam.getWins() + ": "
			+ playoffTeam.getLosses() + ": " + playoffTeam.getConference());
		}
		
	}
	
	//display a team using function defined in playoffteams file, based off the menu.start option
	private void displayTeam() throws SQLException {
		System.out.println("Enter Team Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		PlayoffTeams team = playoffTeamsDao.getTeamById(id);
		System.out.println(team.getId() + ": " + team.getTeamName() + ": " + team.getTeamRank() + ": " + team.getWins() + ": " + team.getLosses() + ": " 
		+ team.getConference());
		
		
	}
	
	//create a team using function designed in playoffteams file, based off the menu.star
		private void createTeam() throws SQLException {
			System.out.println("Enter an Id: ");
			int id = Integer.parseInt(scanner.nextLine());
			System.out.println("Team Rank: ");
			int teamRank = Integer.parseInt(scanner.nextLine());
			System.out.println("Team Name: ");
			String teamName = scanner.nextLine();
			System.out.println("Number of Team Wins: ");
			int wins = Integer.parseInt(scanner.nextLine());
			System.out.println("Number of Team Losses: ");
			int losses = Integer.parseInt(scanner.nextLine());
			System.out.println("Team Conference ('E' or 'W' for East or West): ");
			String conference  = scanner.nextLine(); 
			playoffTeamsDao.createTeam(id, teamRank, teamName, wins, losses, conference);
			System.out.println("Team successfully created!");
		}
		//delete a team using function defined in playoffteams file, based off the menu.start(4)
		private void deleteTeam() throws SQLException {
			System.out.println("Enter Team Id to delete: ");
			int id = Integer.parseInt(scanner.nextLine());
			playoffTeamsDao.deleteTeamById(id);
			System.out.println("Team successfully deleted!");
		}
	
	//display all players using function defined in players file, based off the menu.start option
	private void displayPlayers() throws SQLException {
		List<Players> players = playersDao.getPlayers();
		for(Players player: players) {
			System.out.println(player.getId() + ": " + player.getTeamId() + ": " + player.getPlayerName() + ": " + player.getPlayerRank() + ": " + player.getTeam() + 
			": " + player.getAveragePoints() + ": " + player.getGamesPlayed() + ": " + player.getMinutesPerGame());
		}
			
	}
	
	//display a player using function defined in players file, based off the menu.start option
	private void displayPlayer() throws SQLException {
		System.out.println("Enter Player Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Players player = playersDao.getPlayerById(id);
		System.out.println(player.getId() + ": " + player.getTeamId() + ": " + player.getPlayerName() + ": " + player.getPlayerRank() + ": " + player.getTeam() + 
			": " + player.getAveragePoints() + ": " + player.getGamesPlayed() + ": " + player.getMinutesPerGame());
	}
	
	//create a player using function defined in players file, based off the menu.start option
	private void createPlayer() throws SQLException {		
		System.out.println("Enter Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter Player's Team Id (must be ID of an existing team (relationship with a team)): ");
		int teamId = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter Player Name: ");
		String playerName = scanner.nextLine();
		
		System.out.println("Enter Player Rank: ");
		int playerRank = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter Player's Team (Limit - 3 characters long; must be name of an existing team (relationship with a team)): ");
		String team = scanner.nextLine();
		
		System.out.println("Enter Average Points: ");
		double averagePoints = Double.parseDouble(scanner.nextLine());
		
		System.out.println("Enter Games Played (MAX: 82): ");
		int gamesPlayed = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Enter Minutes Per Game: ");
		double minutesPerGame = Double.parseDouble(scanner.nextLine());
		
		playersDao.createNewPlayer(id, teamId, playerName, playerRank, team, averagePoints, gamesPlayed, minutesPerGame);
		}
	
	//display all sponsors using function defined in sponsors file, based off the menu.start option
	private void displaySponsors() throws SQLException {
		List<Sponsors> sponsors = sponsorsDao.getSponsors();
		for(Sponsors sponsor: sponsors) {
			System.out.println(sponsor.getId() + ": " + sponsor.getSponsorName() + ": ");
		}
		
	}
	
	//display a sponsor using function defined in sponsors file, based off the menu.start option
	private void displaySponsor() throws SQLException {
		System.out.println("Enter Sponsor Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		Sponsors sponsor = sponsorsDao.getSponsorById(id);
		System.out.println(sponsor.getId() + ": " + sponsor.getSponsorName() + ": ");
	}
	
	
}
