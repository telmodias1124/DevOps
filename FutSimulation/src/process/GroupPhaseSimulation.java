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
		
		gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(0),gp.getGroupA().get(1)));
		gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(0),gp.getGroupA().get(2)));
		gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(0),gp.getGroupA().get(3)));
		gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(1),gp.getGroupA().get(2)));
		gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(1),gp.getGroupA().get(3)));
		gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(2),gp.getGroupA().get(3)));
		
		gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(0),gp.getGroupB().get(1)));
		gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(0),gp.getGroupB().get(2)));
		gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(0),gp.getGroupB().get(3)));
		gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(1),gp.getGroupB().get(2)));
		gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(1),gp.getGroupB().get(3)));
		gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(2),gp.getGroupB().get(3)));
		
		gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(0),gp.getGroupC().get(1)));
		gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(0),gp.getGroupC().get(2)));
		gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(0),gp.getGroupC().get(3)));
		gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(1),gp.getGroupC().get(2)));
		gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(1),gp.getGroupC().get(3)));
		gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(2),gp.getGroupC().get(3)));
		
		gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(0),gp.getGroupD().get(1)));
		gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(0),gp.getGroupD().get(2)));
		gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(0),gp.getGroupD().get(3)));
		gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(1),gp.getGroupD().get(2)));
		gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(1),gp.getGroupD().get(3)));
		gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(2),gp.getGroupD().get(3)));
		
		
		
	}
}
