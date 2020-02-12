package process;

import java.util.ArrayList;
import java.util.Random;

import data.GroupPhase;
import data.Match;
import data.Standing;
import data.Team;

public class GroupPhaseSimulation {
	public GroupPhase gp;
	private MatchSimulation ms;
	private Random r;
	public ArrayList<Team> al;
	private ArrayList<Team> allTirage;
	private Standing standingGroupA, standingGroupB, standingGroupC, standingGroupD; 
	
	
	
	public GroupPhaseSimulation() {
		
		this.r = new Random();
		this.gp = new GroupPhase();
		this.ms = new MatchSimulation();
		this.standingGroupA = new Standing();
		this.standingGroupB = new Standing();
		this.standingGroupC = new Standing();
		this.standingGroupD = new Standing();
		
	}
	public void simulate() {
		createGroups(al);
		createMatchGroupe(gp);
		simulateMatchGroupe();
		updateStandings();
	}
	/* ou passer l'arraylist des equipes */
	private void createGroups(ArrayList<Team> alTeams) {
		allTirage = (ArrayList<Team>)al.clone();
		int tirage;
		for(int i=0; i<4; i++) {
			//allTirage.get(r.nextInt(16));
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupA().add(allTirage.get(tirage));
			allTirage.remove(tirage);
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupB().add(allTirage.get(tirage));
			allTirage.remove(tirage);
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupC().add(allTirage.get(tirage));
			allTirage.remove(tirage);
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupD().add(allTirage.get(tirage));
			allTirage.remove(tirage);
		}
	}
	
	private void createMatchGroupe(GroupPhase gp) {
		for(int i=0; i<4; i++) {
			for(int j=i+1; j<4; j++) {
				gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(i),gp.getGroupA().get(j)));
				gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(i),gp.getGroupB().get(j)));
				gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(i),gp.getGroupC().get(j)));
				gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(i),gp.getGroupD().get(j)));

			}
		}
		
	}
	
	public void simulateMatchGroupe() {
		for(int i=0; i<gp.getListMatchGroupA().size(); i++) {
			
			ms.setGame(gp.getListMatchGroupA().get(i));
			ms.simulate();
			ms.setGame(gp.getListMatchGroupB().get(i));
			ms.simulate();
			ms.setGame(gp.getListMatchGroupC().get(i));
			ms.simulate();
			ms.setGame(gp.getListMatchGroupD().get(i));
			ms.simulate();
			
		}
	}
	
	
	
	private void sortGroupByPoints(ArrayList<Team> alT, Standing s) {
		Team t;
		int i=0;
		allTirage = (ArrayList<Team>)alT;
		while(allTirage.size() > 0 ) {
			t = allTirage.get(0);
			for(Team t2 : allTirage) {
				if (t2.getNbPoints() > t.getNbPoints()) {
					t = t2;
				}
			}
			switch(i) {
			case 0 :
				s.setFirst(t);
				break;
			case 1 :
				s.setSecond(t);
				break;
			case 2 :
				s.setThird(t);
				break;
			case 3 :
				s.setFourth(t);
				break;
			default :
				System.out.println("Erreur dans le classement");
			}
			i++;
			//System.out.println("Team : " + t.getTeamName() + " points : " + t.getNbPoints());
			allTirage.remove(t);
		}
		//System.out.println("");
	}
	
	private void updateStandings() {
		sortGroupByPoints(this.gp.getGroupA(), this.standingGroupA);
		sortGroupByPoints(this.gp.getGroupB(), this.standingGroupB);
		sortGroupByPoints(this.gp.getGroupC(), this.standingGroupC);
		sortGroupByPoints(this.gp.getGroupD(), this.standingGroupD);
		
		System.out.println("First : " + this.standingGroupA.getFirst().getTeamName() + " points : " + this.standingGroupA.getFirst().getNbPoints());
		System.out.println("First : " + this.standingGroupA.getSecond().getTeamName() + " points : " + this.standingGroupA.getSecond().getNbPoints());
		System.out.println("First : " + this.standingGroupA.getThird().getTeamName() + " points : " + this.standingGroupA.getThird().getNbPoints());
		System.out.println("First : " + this.standingGroupA.getFourth().getTeamName() + " points : " + this.standingGroupA.getFourth().getNbPoints());
		System.out.println("");
		
		System.out.println("First : " + this.standingGroupB.getFirst().getTeamName() + " points : " + this.standingGroupB.getFirst().getNbPoints());
		System.out.println("First : " + this.standingGroupB.getSecond().getTeamName() + " points : " + this.standingGroupB.getSecond().getNbPoints());
		System.out.println("First : " + this.standingGroupB.getThird().getTeamName() + " points : " + this.standingGroupB.getThird().getNbPoints());
		System.out.println("First : " + this.standingGroupB.getFourth().getTeamName() + " points : " + this.standingGroupB.getFourth().getNbPoints());
		System.out.println("");
		
		System.out.println("First : " + this.standingGroupC.getFirst().getTeamName() + " points : " + this.standingGroupC.getFirst().getNbPoints());
		System.out.println("First : " + this.standingGroupC.getSecond().getTeamName() + " points : " + this.standingGroupC.getSecond().getNbPoints());
		System.out.println("First : " + this.standingGroupC.getThird().getTeamName() + " points : " + this.standingGroupC.getThird().getNbPoints());
		System.out.println("First : " + this.standingGroupC.getFourth().getTeamName() + " points : " + this.standingGroupC.getFourth().getNbPoints());
		System.out.println("");

		System.out.println("First : " + this.standingGroupD.getFirst().getTeamName() + " points : " + this.standingGroupD.getFirst().getNbPoints());
		System.out.println("First : " + this.standingGroupD.getSecond().getTeamName() + " points : " + this.standingGroupD.getSecond().getNbPoints());
		System.out.println("First : " + this.standingGroupD.getThird().getTeamName() + " points : " + this.standingGroupD.getThird().getNbPoints());
		System.out.println("First : " + this.standingGroupD.getFourth().getTeamName() + " points : " + this.standingGroupD.getFourth().getNbPoints());
		System.out.println("");
	}
}
