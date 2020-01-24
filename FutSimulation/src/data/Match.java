package data;

public class Match {
	
	private String teamA;
	private String teamB;
	private int scoreA;
	private int scoreB;
	private String winner;
	private String loser;
	
	public Match() {}
	
	public Match(String teamA, String teamB, int scoreA, int scoreB, String winner, String loser) {
		this.teamA = teamA;
		this.teamB = teamB;
		this.scoreA = scoreA;
		this.scoreB = scoreB;
		this.loser = loser;
		this.winner = winner;
	}
	public String getTeamA() {
		return teamA;
	}
	public void setTeamA(String teamA) {
		this.teamA = teamA;
	}
	public String getTeamB() {
		return teamB;
	}
	public void setTeamB(String teamB) {
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

	public String getWinner() {
		return winner;
	}

	public void setWinner(String winner) {
		this.winner = winner;
	}

	public String getLoser() {
		return loser;
	}

	public void setLoser(String loser) {
		this.loser = loser;
	}
	
	
}
