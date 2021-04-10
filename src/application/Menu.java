package application;

import java.util.Scanner;

import dao.PlayoffTeamsDao;
import entity.PlayoffTeams;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
public class Menu {
	
	private PlayoffTeamsDao playoffTeamsDao = new PlayoffTeamsDao();
	
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
					//createTeam();
				}
				if(selection.equals("4")) {
					//deleteTeam();
				}
				if(selection.equals("5")) {
					//displayPlayers();
				}
				if(selection.equals("6")) {
					//displayPlayer();
				}
				if(selection.equals("7")) {
					//createPlayer();
				}
				if(selection.equals("8")) {
				//	deletePlayer();
				}
				if(selection.equals("9")) {
					//displaySponsors();
				}
				if(selection.equals("10")) {
					//displaySponsor();
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
	//display a teams using function defined in playoffteams file, based off the menu.start option
	private void displayTeam() throws SQLException {
		System.out.println("Enter Team Id: ");
		int id = Integer.parseInt(scanner.nextLine());
		PlayoffTeams team = playoffTeamsDao.getTeamById(id);
		System.out.println(team.getId() + ": " + team.getTeamName() + ": " + team.getTeamRank() + ": " + team.getWins() + ": " + team.getLosses() + ": " 
		+ team.getConference());
		
		
	}
	
}
