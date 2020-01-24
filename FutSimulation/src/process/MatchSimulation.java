package process;

import java.util.Random;

import data.Match;

public class MatchSimulation {
	private Match game;
	private int numberLaps;
	private int luck;
	private Random r;
	private int lvlEqA, lvlEqB, nbActionEqA, nbActionEqB, diffLevel;
	
	
	public MatchSimulation() {
		this.r = new Random();
	}
	
	public void simulate() {
		calNbLaps();
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
