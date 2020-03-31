package data;

import java.util.ArrayList;

public class Match {
	
	private Team teamA;
	private Team teamB;
	private int scoreA;
	private int scoreB;
	private int totalKickA;
	private int totalKickB;
	private int passA;
	private int passB;
	private int totalPassA;
	private int totalPassB;
	private int nbrActionsA;
	private int nbrActionsB;
	private int foulsA;
	private int foulsB;
	private int cornersA;
	private int cornersB;
	private int penA;
	private int penB;
	private Team winner;
	private Team loser;
	private boolean draw;
	private boolean overtime;
	private boolean penalty;
	public ArrayList<String> alrecap = new ArrayList<String>();
	
	public Match() {
		this.scoreA = 0;
		this.scoreB = 0;
		this.totalKickA = 0;
		this.totalKickB = 0;
		this.passA = 0;
		this.passB = 0;
		this.totalPassA = 0;
		this.totalPassB = 0;
		this.nbrActionsA = 0;
		this.nbrActionsB = 0;
		this.foulsA = 0;
		this.foulsB = 0;
		this.cornersA = 0;
		this.cornersB = 0;
		this.penA = 0;
		this.penB = 0;
		this.draw = false;
		this.overtime = false;
	}
	
	public Match(Team teamA, Team teamB) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.scoreA = 0;
		this.scoreB = 0;
		this.totalKickA = 0;
		this.totalKickB = 0;
		this.passA = 0;
		this.passB = 0;
		this.totalPassA = 0;
		this.totalPassB = 0;
		this.nbrActionsA = 0;
		this.nbrActionsB = 0;
		this.foulsA = 0;
		this.foulsB = 0;
		this.cornersA = 0;
		this.cornersB = 0;
		this.penA = 0;
		this.penB = 0;
		this.draw = false;
		this.overtime = false;
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
	}
	
		public Match(Team teamA, Team teamB, int scoreA, int scoreB, int totalKickA, int totalKickB, int passA, int passB,
			int totalPassA, int totalPassB, int nbrActionsA, int nbrActionsB, int foulsA, int foulsB, int cornersA,
			int cornersB, int penA, int penB, Team winner, Team loser, boolean draw, boolean overtime, boolean penalty,
			ArrayList<String> alrecap) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
		this.totalKickA = totalKickA;
		this.totalKickB = totalKickB;
		this.passA = passA;
		this.passB = passB;
		this.totalPassA = totalPassA;
		this.totalPassB = totalPassB;
		this.nbrActionsA = nbrActionsA;
		this.nbrActionsB = nbrActionsB;
		this.foulsA = foulsA;
		this.foulsB = foulsB;
		this.cornersA = cornersA;
		this.cornersB = cornersB;
		this.penA = penA;
		this.penB = penB;
		this.winner = winner;
		this.loser = loser;
		this.draw = draw;
		this.overtime = overtime;
		this.penalty = penalty;
		this.alrecap = alrecap;
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

	public int getTotalKickA() {
		return totalKickA;
	}

	public void setTotalKickA(int totalKickA) {
		this.totalKickA = totalKickA;
	}
	
	public void incrementTotalKickA() {
		this.totalKickA++;
	}

	public int getTotalKickB() {
		return totalKickB;
	}

	public void setTotalKickB(int totalKickB) {
		this.totalKickB = totalKickB;
	}
	
	public void incrementTotalKickB() {
		this.totalKickB++;
	}

	public int getPassA() {
		return passA;
	}

	public void setPassA(int passA) {
		this.passA = passA;
	}
	
	public void incrementPassA() {
		this.passA++;
	}

	public int getPassB() {
		return passB;
	}

	public void setPassB(int passB) {
		this.passB = passB;
	}
	
	public void incrementPassB() {
		this.passB++;
	}

	public int getTotalPassA() {
		return totalPassA;
	}

	public void setTotalPassA(int totalPassA) {
		this.totalPassA = totalPassA;
	}
	
	public void incrementTotalPassA() {
		this.totalPassA++;
	}

	public int getTotalPassB() {
		return totalPassB;
	}

	public void setTotalPassB(int totalPassB) {
		this.totalPassB = totalPassB;
	}

	public void incrementTotalPassB() {
		this.totalPassB++;
	}
	
	public int getNbrActionsA() {
		return nbrActionsA;
	}

	public void setNbrActionsA(int nbrActionsA) {
		this.nbrActionsA = nbrActionsA;
	}
	
	public void incrementNbrActionsA() {
		this.nbrActionsA++;
	}

	public int getNbrActionsB() {
		return nbrActionsB;
	}

	public void setNbrActionsB(int nbrActionsB) {
		this.nbrActionsB = nbrActionsB;
	}
	
	public void incrementNbrActionsB() {
		this.nbrActionsB++;
	}

	public int getFoulsA() {
		return foulsA;
	}

	public void setFoulsA(int foulsA) {
		this.foulsA = foulsA;
	}
	
	public void incrementFoulsA() {
		this.foulsA++;
	}

	public int getFoulsB() {
		return foulsB;
	}

	public void setFoulsB(int foulsB) {
		this.foulsB = foulsB;
	}
	
	public void incrementFoulsB() {
		this.foulsB++;
	}

	public int getCornersA() {
		return cornersA;
	}

	public void setCornersA(int cornersA) {
		this.cornersA = cornersA;
	}
	
	public void incrementCornersA() {
		this.cornersA++;
	}

	public int getCornersB() {
		return cornersB;
	}

	public void setCornersB(int cornersB) {
		this.cornersB = cornersB;
	}
	
	public void incrementCornersB() {
		this.cornersB++;
	}

	public ArrayList<String> getAlrecap() {
		return alrecap;
	}

	public void setAlrecap(ArrayList<String> alrecap) {
		this.alrecap = alrecap;
	}
	
	
}
