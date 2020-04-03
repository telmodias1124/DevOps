package tests;

import gui.MainFrame;
import gui.StartFrame;
import process.KnockoutPhaseSimulation;

/** CLASS THAT TEST THE SCORES IN THE TOURNAMENT **/
//This class is used to test the whole tornament 
//quarter finals = 8 equipe 4 match
//semi final = 4 equipe 2 match 
//final = 2 equipes 1 match

public class TournamentScoresTest {
	
	MainFrame mf1;
	
	public static void TournamentTeamsTest(KnockoutPhaseSimulation kss) {
		boolean tournament = true;
		boolean Quarter = true;
		boolean Semi = true;
		boolean Final = true;
		
		
		if(kss.kp.getListQuarter().size()!=4) {
			Quarter = false;
		} 
		
		
		if(kss.kp.getListSemi().size()!=2) {
			Semi = false;
		}
		/** RECUPERATION DU SCORE **/
		if(kss.kp.getFinalMatch().getTeamA().getGoals()==0 && kss.kp.getFinalMatch().getTeamB().getGoals()==0) {
			/** VERIFICATION DES PENALTIS **/
			if(kss.kp.getFinalMatch().getPenA()==0 && kss.kp.getFinalMatch().getPenB()==0) {
				Final = false;
			}				
		}
		
		if(Final == false || Quarter == false || Semi == false ) {
			tournament = false; 
		} 
		if(Quarter == false ) {
			tournament = false;	
		} 
		
		System.out.println(tournament);
		System.out.println(Quarter);
		System.out.println(Semi);
		System.out.println(Final);
}
	
	public static void main(String[] args) {
		
		StartFrame startFrame = new StartFrame();
		startFrame.createMainFrame();
		
		TournamentTeamsTest(startFrame.kss);
		startFrame.dispose();
		
	}



}