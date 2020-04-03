package tests;

import java.util.ArrayList;

import data.Player;
import data.PlayerStatistic;
import data.Team;
import data.TeamData;

public class PlayersStatsTest {
	
	private PlayerStatistic ps;
	
	//private test test;
	
	TeamData Td = new TeamData();
	
	TeamData teamd = new TeamData();
	ArrayList<Team> teamall = new ArrayList<Team>();
	
	//Resultat attendu stat minimum
	private int LowestStat = 0;
	
	//Resultat attendu stat maximum
	private int HighestStat = 100;
	
	public boolean Browse() {
		
		boolean ok = true;
		int i = 0;
		teamd.createTeams(teamall);
		while(ok && i<16) {
			//Test pour les attaquants
			for(Player p : teamall.get(i).getStarter()) {
				ps = p.getPlayerStatistic();
				if(ps.getDef()>HighestStat && ps.getDef()<LowestStat) {
					ok = false;
				}
				if(ps.getDribble()>HighestStat && ps.getDribble()<LowestStat) {
					ok = false;
				}
				if(ps.getMental()>HighestStat && ps.getMental()<LowestStat) {
					ok = false;
				}
				if(ps.getPass()>HighestStat && ps.getPass()<LowestStat) {
					ok = false;
				}
				if(ps.getPhysique()>HighestStat && ps.getPhysique()<LowestStat) {
					ok = false;
				}
				if(ps.getShoot()>HighestStat && ps.getShoot()<LowestStat) {
					ok = false;
				}
			}
			//Test pour les remplaçants
			for(Player pb : teamall.get(i).getBench()) {
				ps = pb.getPlayerStatistic();
				if(ps.getDef()>HighestStat && ps.getDef()<LowestStat) {
					ok = false;
				}
				if(ps.getDribble()>HighestStat && ps.getDribble()<LowestStat) {
					ok = false;
				}
				if(ps.getMental()>HighestStat && ps.getMental()<LowestStat) {
					ok = false;
				}
				if(ps.getPass()>HighestStat && ps.getPass()<LowestStat) {
					ok = false;
				}
				if(ps.getPhysique()>HighestStat && ps.getPhysique()<LowestStat) {
					ok = false;
				}
				if(ps.getShoot()>HighestStat && ps.getShoot()<LowestStat) {
					ok = false;
				}
			
				
			}
				
			i++;
		}
			return ok ;
	}
	
	
	private String CompareStats() {
		if(ps.getShoot() >= LowestStat && ps.getShoot() <= HighestStat && ps.getDef() >= LowestStat && ps.getDef() <= HighestStat ){
			return ("Correct");
		}
			return ("Wrong");
	}
}
