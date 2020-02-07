package process;

import java.util.ArrayList;
import java.util.Random;

import data.GroupPhase;
import data.Match;
import data.Team;

public class GroupPhaseSimulation {
	public GroupPhase gp;
	private MatchSimulation ms;
	private Random r;
	public ArrayList<Team> al;
	private ArrayList<Team> allTirage;
	
	
	
	public GroupPhaseSimulation() {
		
		this.r = new Random();
		this.gp = new GroupPhase();
		this.ms = new MatchSimulation();
		
		
	}
	public void simulate() {
		createGroups(al);
		createMatchGroupe(gp);
	}
	/* ou passer l'arraylist des equipes */
	private void createGroups(ArrayList<Team> alTeams) {
		allTirage = (ArrayList<Team>)al.clone();
		int tirage;
		for(int i=0; i<4; i++) {
			//allTirage.get(r.nextInt(16));
			
			tirage = r.nextInt(allTirage.size());
			System.out.println(tirage);
			System.out.println(allTirage.get(tirage).getTeamName());
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
	
	private void simulateMatchGroupe(GroupPhase gp) {
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
}
