package tests;

import java.util.ArrayList;

import data.Team;
import data.TeamData;

/** Test made for release 1 **/
public class PlayersNumberTest {
	
	TeamData teamd = new TeamData();
	ArrayList<Team> teamall = new ArrayList<Team>();
	
	//Resultat attendu titulaires 
	int PlayersNumberT = 11;
	
	//Resultat attendu remplacants
	int PlayersNumberB = 12;
	
	//Resultat attendu équipes
	int TeamsNumbers = 16;
	
	//Resultat du nombre total de joueurs attendu par équipes 
	int ExpectedNumberPerTeam = 23;
	
	
	public PlayersNumberTest() {
		
	}
	
	public boolean TeamsNumberCount() {
		boolean ok = true;
		int i = 0;
		teamd.createTeams(teamall);
		while(ok && i<16) {
			if(teamall.get(i).getStarter().size()!=PlayersNumberT) {
				ok = false; 
			}
			if(teamall.get(i).getBench().size()!=PlayersNumberB) {
				ok = false;
			}
			i++;
		}
			return ok ;
		
	}
	
	

}
