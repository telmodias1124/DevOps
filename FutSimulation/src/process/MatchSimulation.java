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
            if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getStarter().get(i%11).getPlayerStatistic().getShoot()) {
                if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getGoalKeeper().getPlayerStatistic().getDef()) {
                	goalsA++;
                }
            }

            if(r.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getStarter().get(i%11).getPlayerStatistic().getShoot()) {
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
	
	private void att(Team tAtt, Team tDef) {
		/*tir [Soit ballon récupérer par defense en défense, soit but, soit sortie, soit défense du gardien, soit faute]
		passe [Soit ballon récupérer par défense au defense, soit passe réussie, soit sortie, soit faute] hors jeu faible %
		dribble [Soit ballon récupérer par défense au defense, soit dribble réussie, soit sortie, soit faute]*/
				
		Random random = new Random();
		int r = random.nextInt(101);
		if(r < 50) {
			kick(tAtt, tDef, "att");
		} else if (r < 80){
			//dribble();
		} else {
			//pass();
		}
		
	} 
	
	private void mid(Team tAtt, Team tDef) {
		/*tir [Soit ballon récupérer par defense en défense, soit but, soit sortie, soit défense du gardien, soit faute]
		passe [Soit ballon récupérer par défense au mid, soit passe réussie, soit sortie, soit faute]
		dribble [Soit ballon récupérer par défense au mid, soit dribble réussie, soit sortie, soit faute]*/
		Random random = new Random();
		int r = random.nextInt(101);
		if(r < 10) {
			kick(tAtt, tDef, "mid");
		} else if (r < 55){
			//dribble();
		} else {
			//pass();
		}
	}
	
	private void def(Team tAtt, Team tDef) {
		/*tir [Soit ballon récupérer par defense en att, soit but, soit sortie, soit défense du gardien, soit faute]
		passe [Soit ballon récupérer par défense au att, soit passe réussie, soit sortie, soit faute]
		dribble [Soit ballon récupérer par défense au att, soit dribble réussie, soit sortie, soit faute]*/
		Random random = new Random();
		int r = random.nextInt(101);
		if(r < 5) {
			kick(tAtt, tDef, "def");
		} else if (r < 50){
			//dribble();
		} else {
			//pass();
		}
	}
	
	private void kick(Team tAtt, Team tDef, String position) {
		int attaquant, defense;
		 Random random = new Random();
		//this.numberLaps = this.r.nextInt(15)+35;
		switch(position) {
		case "att" : 
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			defense = calculateKickDef(tDef, position);
					
			if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
				//attaque passe la défense
				if(attaquant + this.calLuck(-5,11) < tDef.getGoalKeeper().getPlayerStatistic().getDef()) {
					//but
					game.setScoreA(game.getScoreA()+1);
					game.getTeamA().setGoals(game.getTeamA().getGoals() + 1);
					mid(tDef, tAtt);
				}else {
					if(random.nextInt(101)<50) {
						//Gardien arrete la balle
						pass(tDef, tAtt, "def");
					}else {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							freeKick(tDef, tAtt, "def");
						}
					}
				}
			}else {
				if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
					//Defense recupere le ballon
					def(tDef, tAtt);
				} else {
					if(random.nextInt(101) + this.calLuck(-5,11) < 75) {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							freeKick(tDef, tAtt, "def");
						}
					} else {
						//faute coup franc
						freeKick(tAtt, tDef, "att");				
					}
				}
			}
			break;
		case "mid" : 
			
			break;
		case "def" : 
			
			break;
		}
	}
	
	
	private int calculateKickAtt(Team tAtt, String position) {
		int sumShoot1=0;
		int sumMental1=0;
		int sumPhysique1=0;
		int sumShoot2=0;
		int sumMental2=0;
		int sumPhysique2=0;
		int shoot=0;
		int mental=0;
		int physique=0;
		
		switch(position) {
		case "att" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("A")) {
					sumShoot1 += p.getPlayerStatistic().getShoot();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
				}
				else if(p.getPosition().equals("M")) {
					sumShoot2 += p.getPlayerStatistic().getShoot();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
				}
			}
			break;
		case "mid" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("M")) {
					sumShoot1 += p.getPlayerStatistic().getShoot();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
				}
				else if(p.getPosition().equals("A")) {
					sumShoot2 += p.getPlayerStatistic().getShoot();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
				}
			}
			
			break;
		case "def" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("D")) {
					sumShoot1 += p.getPlayerStatistic().getShoot();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
				}
				else if(p.getPosition().equals("M")) {
					sumShoot2 += p.getPlayerStatistic().getShoot();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
				}
			}
			break;
		}
		
		// Divide by 4 because 3 attack players and we divided 1/3 of the attack of the medium players
		shoot = (sumShoot1 + ((1/3) * sumShoot2 ))/4;
		mental = (sumMental1 + ((1/3) * sumMental2 ))/4;
		physique = (sumPhysique1 + ((1/3) * sumPhysique2 ))/4;
		
		
		
		return ((shoot*80) + (mental*5) + (physique*15))/100;
	}
	
	private int calculateKickDef(Team tDef, String position) {
		int sumDefense1=0;
		int sumMental1=0;
		int sumPhysique1=0;
		int sumPace1=0;
		int sumDefense2=0;
		int sumMental2=0;
		int sumPhysique2=0;
		int sumPace2=0;
		int defense=0;
		int mental=0;
		int physique=0;
		int pace =0;
		
		switch(position) {
		case "att" : 
			for(Player p : tDef.getStarter()) {
				if(p.getPosition().equals("D")) {
					sumDefense1 += p.getPlayerStatistic().getShoot();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
					sumPace1 += p.getPlayerStatistic().getPace();
				}
				else if(p.getPosition().equals("M")) {
					sumDefense2 += p.getPlayerStatistic().getShoot();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
					sumPace2 += p.getPlayerStatistic().getPace();
				}
			}
			break;
		case "mid" : 
			for(Player p : tDef.getStarter()) {
				if(p.getPosition().equals("M")) {
					sumDefense1 += p.getPlayerStatistic().getShoot();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
					sumPace1 += p.getPlayerStatistic().getPace();
				}
				else if(p.getPosition().equals("D")) {
					sumDefense2 += p.getPlayerStatistic().getShoot();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
					sumPace2 += p.getPlayerStatistic().getPace();
				}
			}
			
			break;
		case "def" : 
			for(Player p : tDef.getStarter()) {
				if(p.getPosition().equals("A")) {
					sumDefense1 += p.getPlayerStatistic().getShoot();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
					sumPace1 += p.getPlayerStatistic().getPace();
				}
				else if(p.getPosition().equals("M")) {
					sumDefense2 += p.getPlayerStatistic().getShoot();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
					sumPace2 += p.getPlayerStatistic().getPace();
				}
			}
			
			
			break;
		}
		
		// Divide by 4 because 3 attack players and we divided 1/3 of the attack of the medium players
		defense = (sumDefense1 + ((1/3) * sumDefense2 ))/4;
		mental = (sumMental1 + ((1/3) * sumMental2 ))/4;
		physique = (sumPhysique1 + ((1/3) * sumPhysique2 ))/4;
		pace = (sumPace1 + ((1/3) * sumPace2 ))/4;
		
		
		
		return ((defense*80) + (mental*5) + (physique*10) + (pace*5))/100;
	}
	

	
	private void freeKick(Team tAtt, Team tDef, String position) {
		switch(position) {
		
		case "att" : 
		
			break;
		case "mid" : 
			
			break;
		case "def" : 
			
			break;
		}
	}
	
	private void pass(Team tAtt, Team tDef, String position) {
		switch(position) {
		
		case "att" : 
		
			break;
		case "mid" : 
			
			break;
		case "def" : 
			
			break;
		}
	}
	
	private void dribble(Team tAtt, Team tDef, String position) {
		switch(position) {
		
		case "att" : 
		
			break;
		case "mid" : 
			
			break;
		case "def" : 
			
			break;
		}
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
				sumAttAtt += p.getPlayerStatistic().getShoot();
			}
			else if(p.getPosition().equals("M")) {
				sumAttMid += p.getPlayerStatistic().getShoot();
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
		this.numberLaps = this.r.nextInt(15)+35;
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
