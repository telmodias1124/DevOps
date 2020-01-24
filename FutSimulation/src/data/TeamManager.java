package data;

import java.util.ArrayList;

public class TeamManager {
	
	private ArrayList<Team> listTeam;
	private int nbrTeam;

	public TeamManager(ArrayList<Team> listTeam, int nbrTeam) {
		this.listTeam = listTeam;
		this.nbrTeam = nbrTeam;
	}

	public ArrayList<Team> getListTeam() {
		return listTeam;
	}

	public int getNbrTeam() {
		return nbrTeam;
	}

	public void setNbrTeam(int nbrTeam) {
		this.nbrTeam = nbrTeam;
	}

	public void setListTeam(ArrayList<Team> listTeam) {
		this.listTeam = listTeam;
	}
	
	public Team getTeam(String name) {
		
		for(Team team : listTeam) {
			if(team.getTeamName().equals(name)) {
				return team;
			}
		}
		return null;
	}

}
