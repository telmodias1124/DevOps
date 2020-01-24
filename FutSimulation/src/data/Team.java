package data;

import java.util.ArrayList;

public class Team {
	
	private String teamName;
	private ArrayList<Player> starter;
	private ArrayList<Player> bench;
	
	public Team() {}
	
	public Team(String teamName, ArrayList<Player> starter, ArrayList<Player> bench) {
		super();
		this.teamName = teamName;
		this.starter = starter;
		this.bench = bench;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public ArrayList<Player> getStarter() {
		return starter;
	}
	public void setStarter(ArrayList<Player> starter) {
		this.starter = starter;
	}
	public ArrayList<Player> getBench() {
		return bench;
	}
	public void setBench(ArrayList<Player> bench) {
		this.bench = bench;
	}

	
}
