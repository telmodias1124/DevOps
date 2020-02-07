package process;

import java.util.ArrayList;

import data.ClassFactory;
import data.Player;
import data.PlayerStatistic;
import data.Team;
import data.TeamData;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TeamData td = new TeamData();
		ArrayList<Team> al = new ArrayList<Team>();
		
		
		
		
		td.createTeams(al);
		
		GroupPhaseSimulation groupePhase = new GroupPhaseSimulation();
		groupePhase.al=al;
		
		groupePhase.simulate();
		
		for(Team t : groupePhase.gp.getGroupA()) {
			System.out.println("Groupe A FirstName: " + t.getTeamName());
		}
		
		for(Team t : groupePhase.gp.getGroupB()) {
			System.out.println("Groupe B FirstName: " + t.getTeamName());
		}
		
		for(Team t : groupePhase.gp.getGroupC()) {
			System.out.println("Groupe C FirstName: " + t.getTeamName());
		}
		
		for(Team t : groupePhase.gp.getGroupD()) {
			System.out.println("Groupe D FirstName: " + t.getTeamName());
		}
		//Team t = al.get(0);
		/*System.out.println("FirstName: " + t.getTeamName());
		System.out.println("Starter Team :");
		for(Player p : t.getStarter()) {
			System.out.println("Last Name: " + p.getFirstName() + ", LastName: " + p.getLastName() + " Position: " + p.getPosition());
		}
		System.out.println("Bench Team :");
		for(Player p : t.getBench()) {
			System.out.println("Last Name: " + p.getFirstName() + ", LastName: " + p.getLastName() + " Position: " + p.getPosition());
		}
		for(Team t : al) {
			System.out.println("Name: " + t.getTeamName());
			for(Player p : t.getStarter()) {
				System.out.println("Last Name: " + p.getFirstName() + ", LastName: " + p.getLastName() + " Position: " + p.getPosition());
			}
			for(Player p : t.getBench()) {
				System.out.println("Last Name: " + p.getFirstName() + ", LastName: " + p.getLastName() + " Position: " + p.getPosition());
		}
		}*/
	}

}
