package tests;

import gui.MainFrame;
import gui.StartFrame;
import process.KnockoutPhaseSimulation;

/** CLASS THAT TEST THE TOURNAMENT AND TEST IF THERE IS A WINNER **/
//This class is used to test the whole tornament 
//quarter finals = 8 equipe 4 match
//semi final = 4 equipe 2 match 
//final = 2 equipes 1 match

public class TournamentTest {
	

	MainFrame mf1;
	
	public static void TournamentTeamsTest(KnockoutPhaseSimulation kss) {
		boolean tournament = true;
		boolean Quarter = true;
		boolean Semi = true;
		boolean Final = true;
		boolean Winner = true;
		
		
		if(kss.kp.getListQuarter().size()!=4) {
			Quarter = false;
		} 
		
		
		if(kss.kp.getListSemi().size()!=2) {
			Semi = false;
		}
		
		if(kss.kp.getFinalMatch().getTeamA().getTeamName()==null && kss.kp.getFinalMatch().getTeamB().getTeamName()==null) {
			Final = false;
		}
		if(Final == false || Quarter == false || Semi == false ) {
			tournament = false; 
		} 
		if(Quarter == false ) {
			tournament = false;	
		}
		/** TEST IF THERE IS A WINNER IF NOT WHOLE PROGRAMM IS BUGGED **/
		if(kss.kp.getFinalMatch().getWinner()==null && kss.kp.getFinalMatch().getLoser()==null) {
			Winner = false;
		}
		
		System.out.println(tournament); //IF SAYS TRUE : OK
		System.out.println(Quarter); //IF SAYS TRUE : OK
		System.out.println(Semi); //IF SAYS TRUE : OK
		System.out.println(Final); //IF SAYS TRUE : OK
		System.out.println(Winner); //IF SAYS TRUE : OK
}
	
	public static void main(String[] args) {
		
	
		StartFrame startFrame = new StartFrame();
		startFrame.createMainFrame();
		
		TournamentTeamsTest(startFrame.kss);
		
		startFrame.dispose();
	}



}
