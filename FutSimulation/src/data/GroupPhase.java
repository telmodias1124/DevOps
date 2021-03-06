package data;

import java.util.ArrayList;

public class GroupPhase {

	public ArrayList<Team> groupA;
	public ArrayList<Team> groupB;
	public ArrayList<Team> groupC;
	public ArrayList<Team> groupD;
	
	private ArrayList<Match> listMatchGroupA;
	private ArrayList<Match> listMatchGroupB;
	private ArrayList<Match> listMatchGroupC;
	private ArrayList<Match> listMatchGroupD;
	
	private Standing standingGroupA, standingGroupB, standingGroupC, standingGroupD; 
	
	public GroupPhase() {
		this.groupA = new ArrayList<Team>();
		this.groupB = new ArrayList<Team>();
		this.groupC = new ArrayList<Team>();
		this.groupD = new ArrayList<Team>();
		
		this.listMatchGroupA = new ArrayList<Match>();
		this.listMatchGroupB = new ArrayList<Match>();
		this.listMatchGroupC = new ArrayList<Match>();
		this.listMatchGroupD = new ArrayList<Match>();
		
		this.standingGroupA = new Standing();
		this.standingGroupB = new Standing();
		this.standingGroupC = new Standing();
		this.standingGroupD = new Standing();
	}
	
	public GroupPhase(ArrayList<Team> groupA, ArrayList<Team> groupB, ArrayList<Team> groupC, ArrayList<Team> groupD,
			ArrayList<Match> listMatchGroupA, ArrayList<Match> listMatchGroupB, ArrayList<Match> listMatchGroupC,
			ArrayList<Match> listMatchGroupD) {
		super();
		this.groupA = groupA;
		this.groupB = groupB;
		this.groupC = groupC;
		this.groupD = groupD;
		this.listMatchGroupA = listMatchGroupA;
		this.listMatchGroupB = listMatchGroupB;
		this.listMatchGroupC = listMatchGroupC;
		this.listMatchGroupD = listMatchGroupD;
		
		this.standingGroupA = new Standing();
		this.standingGroupB = new Standing();
		this.standingGroupC = new Standing();
		this.standingGroupD = new Standing();
	}

	public ArrayList<Team> getGroupA() {
		return groupA;
	}

	public void setGroupA(ArrayList<Team> groupA) {
		this.groupA = groupA;
	}

	public ArrayList<Team> getGroupB() {
		return groupB;
	}

	public void setGroupB(ArrayList<Team> groupB) {
		this.groupB = groupB;
	}

	public ArrayList<Team> getGroupC() {
		return groupC;
	}

	public void setGroupC(ArrayList<Team> groupC) {
		this.groupC = groupC;
	}

	public ArrayList<Team> getGroupD() {
		return groupD;
	}

	public void setGroupD(ArrayList<Team> groupD) {
		this.groupD = groupD;
	}

	public ArrayList<Match> getListMatchGroupA() {
		return listMatchGroupA;
	}

	public void setListMatchGroupA(ArrayList<Match> listMatchGroupA) {
		this.listMatchGroupA = listMatchGroupA;
	}

	public ArrayList<Match> getListMatchGroupB() {
		return listMatchGroupB;
	}

	public void setListMatchGroupB(ArrayList<Match> listMatchGroupB) {
		this.listMatchGroupB = listMatchGroupB;
	}

	public ArrayList<Match> getListMatchGroupC() {
		return listMatchGroupC;
	}

	public void setListMatchGroupC(ArrayList<Match> listMatchGroupC) {
		this.listMatchGroupC = listMatchGroupC;
	}

	public ArrayList<Match> getListMatchGroupD() {
		return listMatchGroupD;
	}

	public void setListMatchGroupD(ArrayList<Match> listMatchGroupD) {
		this.listMatchGroupD = listMatchGroupD;
	}
	
	public Standing getStandingGroupA() {
		return standingGroupA;
	}
	public void setStandingGroupA(Standing standingGroupA) {
		this.standingGroupA = standingGroupA;
	}
	public Standing getStandingGroupB() {
		return standingGroupB;
	}
	public void setStandingGroupB(Standing standingGroupB) {
		this.standingGroupB = standingGroupB;
	}
	public Standing getStandingGroupC() {
		return standingGroupC;
	}
	public void setStandingGroupC(Standing standingGroupC) {
		this.standingGroupC = standingGroupC;
	}
	public Standing getStandingGroupD() {
		return standingGroupD;
	}
	public void setStandingGroupD(Standing standingGroupD) {
		this.standingGroupD = standingGroupD;
	}
	
	public Team getTeamGroupA(String name) {
		
		for(Team team : groupA) {
			if(team.getTeamName().equals(name)) {
				return team;
			}
		}
		return null;
	}
	
	public Team getTeamGroupB(String name) {
			
			for(Team team : groupB) {
				if(team.getTeamName().equals(name)) {
					return team;
				}
			}
			return null;
		}
	
	public Team getTeamGroupC(String name) {
		
		for(Team team : groupC) {
			if(team.getTeamName().equals(name)) {
				return team;
			}
		}
		return null;
	}
	
	public Team getTeamGroupD(String name) {
		
		for(Team team : groupD) {
			if(team.getTeamName().equals(name)) {
				return team;
			}
		}
		return null;
	}
	
	
}
