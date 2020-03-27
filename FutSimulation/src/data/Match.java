package data;

import java.util.ArrayList;

public class Match {
	
	private Team teamA;
	private Team teamB;
	private int scoreA;
	private int scoreB;
	private int penA;
	private int penB;
	private Team winner;
	private Team loser;
	private boolean draw;
	private boolean overtime;
	private boolean penalty;
	public String recap;
	public ArrayList<String> alrecap = new ArrayList<String>();
	
	public Match() {
		this.scoreA = 0;
		this.scoreB = 0;
		this.penA = 0;
		this.penB = 0;
		this.draw = false;
		this.overtime = false;
		this.penalty = false;
		this.recap="";
	}
	
	public Match(Team teamA, Team teamB) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.draw = false;
		this.overtime = false;
		this.penalty = false;
		this.scoreA = 0;
		this.scoreB = 0;
		this.penA = 0;
		this.penB = 0;
		this.recap="";
	}
	
	public Match(Team teamA, Team teamB, int scoreA, int scoreB, Team winner, Team loser) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
		this.loser = loser;
		this.winner = winner;
		this.draw = false;
		this.overtime = false;
		this.recap="";
	}
	public Team getTeamA() {
		return teamA;
	}
	public void setTeamA(Team teamA) {
		this.teamA = teamA;
	}
	public Team getTeamB() {
		return teamB;
	}
	public void setTeamB(Team teamB) {
		this.teamB = teamB;
	}
	public int getScoreA() {
		return scoreA;
	}
	public void setScore(Team t) {
		if(t.equals(this.teamA)) {
			this.scoreA++;
		}else {
			this.scoreB++;
		}
		t.setGoals(t.getGoals()+1);
	}
	public void setScoreA(int scoreA) {
		this.scoreA = scoreA;
	}
	public int getScoreB() {
		return scoreB;
	}
	public void setScoreB(int scoreB) {
		this.scoreB = scoreB;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public Team getLoser() {
		return loser;
	}

	public void setLoser(Team loser) {
		this.loser = loser;
	}
	public boolean isDraw() {
		return draw;
	}

	public void setDraw(boolean draw) {
		this.draw = draw;
	}

	public boolean isOvertime() {
		return overtime;
	}

	public void setOvertime(boolean overtime) {
		this.overtime = overtime;
	}

	public int getPenA() {
		return penA;
	}

	public void setPenA(int penA) {
		this.penA = penA;
	}

	public int getPenB() {
		return penB;
	}

	public void setPenB(int penB) {
		this.penB = penB;
	}

	public boolean isPenalty() {
		return penalty;
	}

	public void setPenalty(boolean penalty) {
		this.penalty = penalty;
	}
	
	
}
