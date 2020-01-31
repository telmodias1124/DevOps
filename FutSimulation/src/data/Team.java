package data;

import java.util.ArrayList;

public class Team {
	
	private String teamName;
	private ArrayList<Player> starter;
	private ArrayList<Player> bench;
	private int lvlEq;
	private int lvlAttack;
	private int lvlDefense;
	
	public Team() {}
	
	public Team(String teamName) {
		this.teamName = teamName;
		this.starter = new ArrayList<Player>();
		this.bench =  new ArrayList<Player>();
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

	

	
}
