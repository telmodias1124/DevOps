package process;

import java.util.ArrayList;

import data.Match;
import data.Standing;
import data.Team;
import data.TeamData;
import gui.MainFrame;

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
		System.out.println(groupePhase.groupToString());
		System.out.println(groupePhase.matchsToString());
		System.out.println(groupePhase.standingToString());
		
		KnockoutPhaseSimulation ks = new KnockoutPhaseSimulation();
		ks.setListQuarter(groupePhase.getStandingGroupA(), groupePhase.getStandingGroupB(), groupePhase.getStandingGroupC(), groupePhase.getStandingGroupD());
		ks.simulate();
		System.out.println(ks.quartersToString());
		System.out.println(ks.semiToString());
		System.out.println(ks.finalToString());
		
		
		MainFrame mf = new MainFrame();
		mf.createGroupPhasePanel(groupePhase.gp);
		mf.revalidate();
		mf.repaint();
		
		
		
		/*for(Team t : groupePhase.gp.getGroupA()) {
			System.out.println(t.getTeamName());
		}
		
		System.out.println("Groupe B:");
		for(Team t : groupePhase.gp.getGroupB()) {
			System.out.println("Groupe B FirstName: " + t.getTeamName());
		}
		
		for(Team t : groupePhase.gp.getGroupC()) {
			System.out.println("Groupe C FirstName: " + t.getTeamName());
		}
		
		for(Team t : groupePhase.gp.getGroupD()) {
			System.out.println("Groupe D FirstName: " + t.getTeamName());
		}
		
		for(Match t : groupePhase.gp.getListMatchGroupA()){
			if(!t.isDraw()) {
				System.out.println("Groupe A : Gagnant : " + t.getWinner().getTeamName() + " Perdant : " + t.getLoser().getTeamName() + " Score : " + t.getScoreA() +"-" + t.getScoreB());
			}
			else {
				System.out.println("Groupe A  : Draw : " + t.getTeamA().getTeamName() + "," + t.getTeamB().getTeamName() +" Score: " + t.getScoreA() + "-"+ t.getScoreB());

			}
		}
		
		for(Match t : groupePhase.gp.getListMatchGroupB()) {
			if(!t.isDraw()) {
				System.out.println("Groupe B : Gagnant : " + t.getWinner().getTeamName() + " Perdant : " + t.getLoser().getTeamName() + " Score : " + t.getScoreA() +"-" + t.getScoreB());
			}
			else {
				System.out.println("Groupe B : Draw : " + t.getTeamA().getTeamName() + "," + t.getTeamB().getTeamName() +" Score: " + t.getScoreA() + "-"+ t.getScoreB());
			}		
		}*/
		
		/*for(Match t : groupePhase.gp.getListMatchGroupC()) {
			
			if(!t.isDraw()) {
				System.out.println("Groupe C : Gagnant : " + t.getWinner().getTeamName() + " Perdant : " + t.getLoser().getTeamName() + " Score : " + t.getScoreA() +"-" + t.getScoreB());
			}
			else {
				System.out.println("Groupe C : Draw : " + t.getTeamA().getTeamName() + "," + t.getTeamB().getTeamName() +" Score: " + t.getScoreA() + "-"+ t.getScoreB());

			}	
			
		}
		
		for(Match t : groupePhase.gp.getListMatchGroupD()) {
			
			if(!t.isDraw()) {
				System.out.println("Groupe D : Gagnant : " + t.getWinner().getTeamName() + " Perdant : " + t.getLoser().getTeamName() + " Score : " + t.getScoreA() +"-" + t.getScoreB());
			}
			else {
				System.out.println("Groupe D : Draw : " + t.getTeamA().getTeamName() + "," + t.getTeamB().getTeamName() +" Score: " + t.getScoreA() + "-"+ t.getScoreB());

			}		
			
		}*/
		

		/*for(Team t : groupePhase.gp.getGroupA()) {
			System.out.println("Team : " + t.getTeamName() + " : " + t.getNbPoints() + " points");
		}*/
		
		/*System.out.println("Quarters : ");
		
		for(Match t : ks.kp.getListQuarter()) {
			if(!t.isDraw()) {
				System.out.println("Groupe D : Gagnant : " + t.getWinner().getTeamName() + " Perdant : " + t.getLoser().getTeamName() + " Score : " + t.getScoreA() +"-" + t.getScoreB());
			}	
		}
		System.out.println("");
		System.out.println("Semi : ");
		
		for(Match t : ks.kp.getListSemi()) {
			if(!t.isDraw()) {
				System.out.println("Groupe D : Gagnant : " + t.getWinner().getTeamName() + " Perdant : " + t.getLoser().getTeamName() + " Score : " + t.getScoreA() +"-" + t.getScoreB());
			}	
		}
		System.out.println("");
		System.out.println("Final : ");
		
		Match t = ks.kp.getFinalMatch();
		System.out.println("Team a :" + t.getTeamA().getTeamName());
		System.out.println("Team b :" + t.getTeamB().getTeamName());
		
		if(!t.isDraw()) {
			System.out.println("Groupe D : Gagnant : " + t.getWinner().getTeamName() + " Perdant : " + t.getLoser().getTeamName() + " Score : " + t.getScoreA() +"-" + t.getScoreB());
		}
		
		
		System.out.println(groupePhase.standingToString());*/
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
		
		/*MatchSimulation ms = new MatchSimulation();
		Match m = new Match();
		m.setTeamA(al.get(0));
		m.setTeamB(al.get(1));
		ms.setGame(m);
		ms.simulate();*/
		//System.out.println("Score A : " + ms.getGame().getScoreA() + " Score B :" + ms.getGame().getScoreB());
		//System.out.println("Winner : "+ms.getGame().getWinner().getTeamName()+ " Loser : "+ms.getGame().getLoser().getTeamName()+" Draw : "+ms.getGame().isDraw());
	}

}
