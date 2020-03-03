package data;

import java.util.ArrayList;

public class Team {
	
	private String teamName;
	private ArrayList<Player> starter;
	private ArrayList<Player> bench;
	private int lvlEq;
	private int lvlAttack;
	private int lvlDefense;
	private int nbPoints;
	private int goals;
	private String flagPath;
	
	public Team() {}
	
	public Team(String teamName) {
		this.teamName = teamName;
		this.starter = new ArrayList<Player>();
		this.bench =  new ArrayList<Player>();
		this.nbPoints = 0;
		this.goals = 0;
		this.flagPath = "images/bresil.png";
	}
	
	public Team(String teamName, ArrayList<Player> starter, ArrayList<Player> bench) {
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

	public int getLvlAttack() {
		return lvlAttack;
	}

	public void setLvlAttack(int lvlAttack) {
		this.lvlAttack = lvlAttack;
	}

	public int getLvlDefense() {
		return lvlDefense;
	}

	public void setLvlDefense(int lvlDefense) {
		this.lvlDefense = lvlDefense;
	}

	public int getLvlEq() {
		return lvlEq;
	}

	public void setLvlEq(int lvlEq) {
		this.lvlEq = lvlEq;
	}

	public int getNbPoints() {
		return nbPoints;
	}

	public void setNbPoints(int nbPoints) {
		this.nbPoints = nbPoints;
	}

	public int getGoals() {
		return goals;
	}

	public void setGoals(int goals) {
		this.goals = goals;
	}
	

	public String getFlagPath() {
		return flagPath;
	}

	public void setFlagPath(String flagPath) {
		this.flagPath = flagPath;
	}

	public Player getGoalKeeper() {
		for(Player p : starter) {
			if(p.getPosition() == "G") {
				return p;
			}
		}
		return null;
	}
}
