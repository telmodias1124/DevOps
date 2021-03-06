package data;

import java.util.ArrayList;

public class ClassFactory {
	
	public static Team creatTeam(String teamName, ArrayList<Player> starter, ArrayList<Player> bench) {
		return new Team(teamName, starter, bench);
	}

	public static Player creatPlayer(String lastName, String firstName, PlayerStatistic playerStatistic, String position) {
		return new Player(lastName, firstName, playerStatistic, position);
	}
	
	public static PlayerStatistic creatPlayerStatistic(int att, int def, int endurance, int vitesse, int lvlTech, int mental, int physique) {
		return new  PlayerStatistic(att, def, endurance, vitesse, lvlTech, mental, physique);
	}
	
	public static Match creatMatch(Team teamA, Team teamB, int scoreA, int scoreB, Team winner, Team loser) {
		return new Match(teamA, teamB, scoreA, scoreB, winner, loser);
	}
	
	public static GroupPhase creatGroupPhase(ArrayList<Team> groupA, ArrayList<Team> groupB, ArrayList<Team> groupC, ArrayList<Team> groupD,
			ArrayList<Match> listMatchGroupA, ArrayList<Match> listMatchGroupB, ArrayList<Match> listMatchGroupC,
			ArrayList<Match> listMatchGroupD) {
		return new GroupPhase(groupA, groupB, groupC, groupD, listMatchGroupA, listMatchGroupB, listMatchGroupC, listMatchGroupD);
	}
}
