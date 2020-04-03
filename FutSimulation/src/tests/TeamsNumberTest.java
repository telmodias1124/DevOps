package tests;

import java.util.ArrayList;

import data.Team;
import data.TeamData;

public class TeamsNumberTest {

	static TeamData teamd = new TeamData();
	static ArrayList<Team> teamall = new ArrayList<Team>();

	
	//Resultat attendu nombre d'équipes
	private static int TeamsNumber = 16;
	
	private static String TeamsNumberCount() {
	
			teamd.createTeams(teamall);
			if(teamall.size()==TeamsNumber) {
			return ("Correct");
		}
		return ("Issue");
		
	}

	public static void main(String[] args) {
		PlayersNumberTest Pnt = new PlayersNumberTest();
	//	TournamentTest Tt = new TournamentTest();
		PlayersStatsTest Pst = new PlayersStatsTest();
		
		/** Test du nombre d'équipes **/
		System.out.println(TeamsNumberCount());
		
		/** Test du nombre de joueurs par équipes **/
		System.out.println(Pnt.TeamsNumberCount());
		
		/** Test des statistiques joueurs **/
		System.out.println(Pst.Browse());
		
		/** Test du tournoi **/
	//	System.out.println(Tt.TournamentTeamsTest());
		
	}

}