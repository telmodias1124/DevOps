package process;

import java.awt.Frame;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import data.Match;
import data.Player;
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
		Team bel = null, fr = null;
		
		GroupPhaseSimulation groupePhase = new GroupPhaseSimulation();
		groupePhase.setAlTeams(al);
		groupePhase.simulate();
		
		groupePhase.gp.getListMatchGroupA().get(0);
		/*for(Team t : al) {
			if(t.getTeamName().equals("Belgium")) {
				bel = t;
			}
			if(t.getTeamName().equals("France")) {
				fr = t;
			}
		}
		
		for(Player p : bel.getStarter()) {
			System.out.println("Nom "+p.getFirstName()+" Position "+p.getPosition()+" Att "+p.getPlayerStatistic().getShoot());
		}
		//System.out.println(""+p.getFirstName()+" Position "+p.getPosition()+" Att "+p.getPlayerStatistic().getShoot());
		for(Player p : fr.getStarter()) {
			System.out.println("Nom "+p.getFirstName()+" Position "+p.getPosition()+" Att "+p.getPlayerStatistic().getShoot());
		}
		
		Match match = new Match(bel, fr);
		MatchSimulation ms = new MatchSimulation();
		
		match.setOvertime(true);
		ms.setGame(match);
		ms.simulate2();
	
				
		
		for(String n : ms.getGame().alrecap) {
			   System.out.println(n);
		}*/
		
		
		
		System.out.println(groupePhase.groupToString());
		System.out.println(groupePhase.matchsToString());
		System.out.println(groupePhase.standingToString());
		
		/*for(String n : groupePhase.gp.getListMatchGroupC().get(2).alrecap) {
			   System.out.println(n);
		}*/
		
		KnockoutPhaseSimulation ks = new KnockoutPhaseSimulation();
		ks.setListQuarter(groupePhase.gp.getStandingGroupA(), groupePhase.gp.getStandingGroupB(), groupePhase.gp.getStandingGroupC(), groupePhase.gp.getStandingGroupD());
		ks.simulate();
		System.out.println(ks.quartersToString());
		System.out.println(ks.semiToString());
		System.out.println(ks.finalToString());
		
		
		MainFrame mf = new MainFrame();
		mf.createGroupPhasePanel(groupePhase.gp, ks.kp);
		mf.createMatchView(groupePhase.gp.getListMatchGroupA().get(0));
		//mf.createKnockout();
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
		}
		
		for(Match t : groupePhase.gp.getListMatchGroupC()) {
			
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
			
		}
		

		for(Team t : groupePhase.gp.getGroupA()) {
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
