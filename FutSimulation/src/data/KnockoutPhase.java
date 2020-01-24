package data;

import java.util.ArrayList;

public class KnockoutPhase {
	
	private ArrayList<Match> listQuarter;
	private ArrayList<Match> listSemi;
	private Match finalMatch;
	
	private ArrayList<Match> listTeamQuarter;
	private ArrayList<Match> listTeamSemi;
	private ArrayList<Team> listTeamFinal;
	
	public KnockoutPhase() {}
	
	public KnockoutPhase(ArrayList<Match> listQuarter, ArrayList<Match> listSemi, Match finalMatch,
			ArrayList<Match> listTeamQuarter, ArrayList<Match> listTeamSemi, ArrayList<Team> listTeamFinal) {
		this.listQuarter = listQuarter;
		this.listSemi = listSemi;
		this.finalMatch = finalMatch;
		this.listTeamQuarter = listTeamQuarter;
		this.listTeamSemi = listTeamSemi;
		this.listTeamFinal = listTeamFinal;
	}

	public ArrayList<Match> getListQuarter() {
		return listQuarter;
	}

	public void setListQuarter(ArrayList<Match> listQuarter) {
		this.listQuarter = listQuarter;
	}

	public ArrayList<Match> getListSemi() {
		return listSemi;
	}

	public void setListSemi(ArrayList<Match> listSemi) {
		this.listSemi = listSemi;
	}

	public Match getFinalMatch() {
		return finalMatch;
	}

	public void setFinalMatch(Match finalMatch) {
		this.finalMatch = finalMatch;
	}

	public ArrayList<Match> getListTeamQuarter() {
		return listTeamQuarter;
	}

	public void setListTeamQuarter(ArrayList<Match> listTeamQuarter) {
		this.listTeamQuarter = listTeamQuarter;
	}

	public ArrayList<Match> getListTeamSemi() {
		return listTeamSemi;
	}

	public void setListTeamSemi(ArrayList<Match> listTeamSemi) {
		this.listTeamSemi = listTeamSemi;
	}

	public ArrayList<Team> getListTeamFinal() {
		return listTeamFinal;
	}

	public void setListTeamFinal(ArrayList<Team> listTeamFinal) {
		this.listTeamFinal = listTeamFinal;
	}
	
	
	
	

}
