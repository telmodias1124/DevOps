package process;

import java.util.Random;

import data.Match;
import data.Player;
import data.Team;

public class MatchSimulation {
	private Match game;
	private int numberLaps;
	private Random r;
	private int nbActionEqA, nbActionEqB, diffLevel;
	
	
	public MatchSimulation() {
		this.r = new Random();
	}
	
	public void simulate() {
		calNbLaps();
		setTeamStats(game.getTeamA());
		setTeamStats(game.getTeamB());
		setLvlEq(game.getTeamA());
		setLvlEq(game.getTeamB());
		setNbTeamActions();
		/*System.out.println("Att A : " + this.game.getTeamA().getLvlAttack());
		System.out.println("Deff A : " + this.game.getTeamA().getLvlDefense());
		System.out.println("Att B : " + this.game.getTeamB().getLvlAttack());
		System.out.println("Deff B : " + this.game.getTeamB().getLvlDefense());
		System.out.println("Nb tour A : " + this.nbActionEqA);
		System.out.println("Nb tour B : " + this.nbActionEqA);*/
		for(int i=0; i<this.nbActionEqA; i++) {
			if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getLvlAttack()) {
				if(r.nextInt(101) + this.calLuck(-5,11) > game.getTeamB().getLvlDefense()) {
					game.setScoreA(game.getScoreA()+1);
					game.getTeamA().setGoals(game.getTeamA().getGoals() + 1);
					//System.out.println("Goal team A");
				}
			}
		}
		for(int i=0; i<this.nbActionEqB; i++) {
			if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getLvlAttack()) {
				if(r.nextInt(101) + this.calLuck(-5,11) > game.getTeamA().getLvlDefense()) {
					game.setScoreB(game.getScoreB()+1);
					game.getTeamB().setGoals(game.getTeamB().getGoals() + 1);
					//System.out.println("Goal team B");
				}
			}
		}
		if(game.getScoreA() > game.getScoreB()) {
			game.setLoser(game.getTeamB());
			game.setWinner(game.getTeamA());
			if(!game.isOvertime()) {
				game.getTeamA().setNbPoints(game.getTeamA().getNbPoints() + 3);
			}
		}
		else if(game.getScoreA() < game.getScoreB()){
			game.setLoser(game.getTeamA());
			game.setWinner(game.getTeamB());
			if(!game.isOvertime()) {
				game.getTeamB().setNbPoints(game.getTeamB().getNbPoints() + 3);
			}
		}
		else {
			if(!game.isOvertime()) {
				game.setDraw(true);
				game.getTeamA().setNbPoints(game.getTeamA().getNbPoints() + 1);
				game.getTeamB().setNbPoints(game.getTeamB().getNbPoints() + 1);
			}
			else {
				overtime();
			}
		}
	}
	
	
	private void overtime() {
		this.nbActionEqA = this.nbActionEqA / 3;
		this.nbActionEqB = this.nbActionEqB / 3;
		
		for(int i=0; i<this.nbActionEqA; i++) {
			if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getLvlAttack()) {
				if(r.nextInt(101) + this.calLuck(-5,11) > game.getTeamB().getLvlDefense()) {
					game.setScoreA(game.getScoreA()+1);
					game.getTeamA().setGoals(game.getTeamA().getGoals() + 1);
					//System.out.println("Goal team A");
				}
			}
		}
		for(int i=0; i<this.nbActionEqB; i++) {
			if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getLvlAttack()) {
				if(r.nextInt(101) + this.calLuck(-5,11) > game.getTeamA().getLvlDefense()) {
					game.setScoreB(game.getScoreB()+1);
					game.getTeamB().setGoals(game.getTeamB().getGoals() + 1);
					//System.out.println("Goal team B");
				}
			}
		}
		if(game.getScoreA() > game.getScoreB()) {
			game.setLoser(game.getTeamB());
			game.setWinner(game.getTeamA());
		}
		else if(game.getScoreA() < game.getScoreB()){
			game.setLoser(game.getTeamA());
			game.setWinner(game.getTeamB());
		}
		else {
			game.setPenalty(true);
			penalty();
		}
	}

	private void penalty() {
		int goalsA = 0, goalsB = 0, i = 0;
        while (i<5 || goalsA==goalsB) {
            if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getStarter().get(i%11).getPlayerStatistic().getAtt()) {
                if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getGoalKeeper().getPlayerStatistic().getDef()) {
                	goalsA++;
                }
            }

            if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getStarter().get(i%11).getPlayerStatistic().getAtt()) {
                if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getGoalKeeper().getPlayerStatistic().getDef()) {
                	goalsB++;
                }
            }
            i++;
        }
        if(goalsA > goalsB) {
        	game.setWinner(game.getTeamA());
        	game.setLoser(game.getTeamB());
        }
        else {
        	game.setWinner(game.getTeamB());
        	game.setLoser(game.getTeamA());
        }
        game.setPenA(goalsA);
        game.setPenB(goalsB);
	}
	
	private void setNbTeamActions() {
		int lvlEqA = 0, lvlEqB = 0;
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
		//System.out.println(sumAttAtt);
		// Divide by 4 because 3 attack players and we divided 1/3 of the attack of the medium players
		t.setLvlAttack((sumAttAtt + ((1/3) * sumAttMid ))/4);
		t.setLvlDefense((sumDefDef + ((1/3) * sumDefMid ))/4);
	}
	private void setLvlEq(Team t) {
		t.setLvlEq((t.getLvlAttack() + t.getLvlDefense()) / 2);
	}
	
	private void calNbLaps() {
		this.numberLaps = this.r.nextInt(13)+18;
	}
	private int calLuck(int min, int max) {
		return this.r.nextInt(max)+min;
	}
	
	public Match getGame() {
		return game;
	}

	public void setGame(Match game) {
		this.game = game;
	}
}
