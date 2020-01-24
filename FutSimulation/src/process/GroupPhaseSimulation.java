package process;

import java.util.ArrayList;
import java.util.Random;

import data.GroupPhase;
import data.Team;

public class GroupPhaseSimulation {
	private GroupPhase gp;
	private MatchSimulation ms;
	private Random r;
	private ArrayList<Team> al;
	
	public GroupPhaseSimulation() {
		this.r = new Random();
		this.gp = new GroupPhase();
		this.ms = new MatchSimulation();
	}
	public void simulate() {
		
	}
	/* ou passer l'arraylist des equipes */
	private void createGroups(ArrayList<Team> alTeams) {
		
	}
}
