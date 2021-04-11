package application;

import java.util.Scanner;

import dao.PlayoffTeamsDao;
import dao.SponsorsDao;
import dao.PlayersDao;
import entity.Players;
import entity.PlayoffTeams;
import entity.Sponsors;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
public class Menu {
	
	private PlayoffTeamsDao playoffTeamsDao = new PlayoffTeamsDao();
<<<<<<< Updated upstream
	private PlayersDao playersDao = new PlayersDao();
	private SponsorsDao sponsorsDao = new SponsorsDao();
=======
	//private PlayersDao playerDao = new PlayersDao();
	//private ScannerDao scannerDao = new ScannerDao();
>>>>>>> Stashed changes
	
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
				else if(selection.equals("2")) {
					displayTeam();
				}
<<<<<<< Updated upstream
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
=======
				else if(selection.equals("3")) {
					createTeam();
				}
				else if(selection.equals("4")) {
					deleteTeam();
				}
				else if(selection.equals("5")) {
					//displayPlayers();
				}
				else if(selection.equals("6")) {
					//displayPlayer();
				}
				else if(selection.equals("7")) {
					//createPlayer();
				}
				else if(selection.equals("8")) {
					//deletePlayer();
				}
				else if(selection.equals("9")) {
					//displaySponsors();
				}
				else if(selection.equals("10")) {
					//displaySponsor();
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
	
	//display all teams using function defined in playoffteams file, based off the menu.start option
=======
	//display all teams using function defined in playoffteams file, based off the menu.start option(1)
>>>>>>> Stashed changes
	private void displayTeams() throws SQLException {
		List<PlayoffTeams> playoffTeams = playoffTeamsDao.getTeams();
		for(PlayoffTeams playoffTeam: playoffTeams) {
			System.out.println(playoffTeam.getId() + ": " + playoffTeam.getTeamName() + ": " + playoffTeam.getTeamRank() + ": " + playoffTeam.getWins() + ": "
			+ playoffTeam.getLosses() + ": " + playoffTeam.getConference());
		}
		
	}
<<<<<<< Updated upstream
	
	//display a team using function defined in playoffteams file, based off the menu.start option
=======
	//display a teams using function defined in playoffteams file, based off the menu.start option(2)
>>>>>>> Stashed changes
	private void displayTeam() throws SQLException {
		System.out.println("Enter Team Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		PlayoffTeams team = playoffTeamsDao.getTeamById(id);
		System.out.println(team.getId() + ": " + team.getTeamName() + ": " + team.getTeamRank() + ": " + team.getWins() + ": " + team.getLosses() + ": " 
		+ team.getConference());
	}
	
<<<<<<< Updated upstream
	//create a team using function defined in playoffteams file, based off the menu.start option
	private void createTeam() throws SQLException {
		System.out.println("Enter new team name:");
		String teamName = scanner.nextLine();
		playoffTeamsDao.createNewTeam(teamName);
	}
	
	//delete a team using function defined in playoffteams file, bsaed off the menu.start option
	private void deleteTeam() throws SQLException {
		System.out.println("Enter team id to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		playoffTeamsDao.deleteTeamById(id);
		
	}
	
	//display all players using function defined in players file, based off the menu.start option
	private void displayPlayers() throws SQLException {
		List<Players> players = PlayersDao.getPlayers();
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
	private void createPlayer() {
		System.out.println("Enter name of new player: ");
		String playerName = scanner.nextLine();
		System.out.println("Enter rank of new player");
		
		
		
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
		Sponsors sponsor = SponsorsDao.getSponsorById(id);
		System.out.println(sponsor.getId() + ": " + sponsor.getSponsorName() + ": ");
=======
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
>>>>>>> Stashed changes
	}
	
	
}
