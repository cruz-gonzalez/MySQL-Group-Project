package application;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
public class Menu {
	
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList("Display Teams,",
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
			
			if(selection.equals("1")) {
				displayTeams();
			}
			if(selection.equals("2")) {
				//displayTeam();
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
	
}
