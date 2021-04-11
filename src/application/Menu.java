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
	}
	
	
}
