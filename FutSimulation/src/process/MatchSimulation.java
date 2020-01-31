package process;

import java.util.Random;

import org.graalvm.compiler.core.amd64.AMD64ArithmeticLIRGenerator.Maths;

import data.Match;
import data.Player;
import data.Team;

public class MatchSimulation {
	private Match game;
	private int numberLaps;
	private int luck;
	private Random r;
	private int nbActionEqA, nbActionEqB, diffLevel;
	
	
	public MatchSimulation() {
		this.r = new Random();
	}
	
	public void simulate() {
		calNbLaps();
		calLuck();
		setTeamStats(game.getTeamA());
		setTeamStats(game.getTeamB());
		setLvlEq(game.getTeamA());
		setLvlEq(game.getTeamB());
		setNbTeamActions();
		
	}
	private void setNbTeamActions() {
		int lvlEqA, lvlEqB;
		lvlEqA = game.getTeamA().getLvlEq();
		lvlEqB = game.getTeamB().getLvlEq();
		if(lvlEqA > lvlEqB) {
			diffLevel = lvlEqA - lvlEqB;
			nbActionEqA = (numberLaps/2) + ( (numberLaps/2)*(diffLevel/50)) ;
			nbActionEqB = (numberLaps/2) - (numberLaps/2)*(diffLevel/50);
		}
		else {
			diffLevel = lvlEqB - lvlEqA;
			nbActionEqA = (numberLaps/2) - ( (numberLaps/2)*(diffLevel/50)) ;
			nbActionEqB = (numberLaps/2) + (numberLaps/2)*(diffLevel/50);
		}
	}
	
	private void setTeamStats(Team t) {
		int sumAttAtt=0;
		int sumAttMid=0;
		int sumDefDef=0;
		int sumDefMid=0;
		
		for(Player p : t.getStarter()) {
			if(p.getPosition().equals("A")) {
				sumAttAtt += p.getPlayerStatistic().getAtt();
			}
			else if(p.getPosition().equals("M")) {
				sumAttMid += p.getPlayerStatistic().getAtt();
				sumDefMid += p.getPlayerStatistic().getDef();
			}
			else if(p.getPosition().equals("D")) {
				sumDefDef += p.getPlayerStatistic().getDef();
			}
		}
		// Divide by 4 because 3 attack players and we divided 1/3 of the attack of the medium players
		t.setLvlAttack(sumAttAtt + ((1/3) * sumAttMid )/4);
		t.setLvlDefense(sumDefDef + ((1/3) * sumDefMid )/4);
	}
	private void setLvlEq(Team t) {
		t.setLvlEq((t.getLvlAttack() + t.getLvlDefense()) / 2);
	}
	
	private void calNbLaps() {
		this.numberLaps = this.r.nextInt(13)+18;
	}
	private void calLuck() {
		this.luck = this.r.nextInt(5)-2;
	}
	
	public Match getGame() {
		return game;
	}

	public void setGame(Match game) {
		this.game = game;
	}
	
}
