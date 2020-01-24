package data;

public class Match {
	
	private Team teamA;
	private Team teamB;
	private int scoreA;
	private int scoreB;
	private Team winner;
	private Team loser;
	
	public Match() {}
	
	public Match(Team teamA, Team teamB, int scoreA, int scoreB, Team winner, Team loser) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
		this.loser = loser;
		this.winner = winner;
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
	
	
}
