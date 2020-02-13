package data;

import java.util.ArrayList;
import java.util.LinkedList;

public class KnockoutPhase {
	
	private LinkedList<Match> listQuarter;
	private ArrayList<Match> listSemi;
	private Match finalMatch;
	
	public KnockoutPhase() {}

	public LinkedList<Match> getListQuarter() {
		return listQuarter;
	}

	public void setListQuarter(LinkedList<Match> listQuarter) {
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
	
	

}
