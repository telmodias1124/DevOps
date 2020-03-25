package process;

import java.util.Random;

import data.Match;
import data.Player;
import data.Team;

public class MatchSimulation {
	private Match game;
	private int numberLaps;
	private int nbActions, nbActionsMax;
	private Random random;
	private int nbActionEqA, nbActionEqB, diffLevel;
	private boolean lel =false;
	
	public MatchSimulation() {
		this.random = new Random();
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
			if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getLvlAttack()) {
				if(random.nextInt(101) + this.calLuck(-5,11) > game.getTeamB().getLvlDefense()) {
					game.setScoreA(game.getScoreA()+1);
					game.getTeamA().setGoals(game.getTeamA().getGoals() + 1);
					//System.out.println("Goal team A");
				}
			}
		}
		for(int i=0; i<this.nbActionEqB; i++) {
			if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getLvlAttack()) {
				if(random.nextInt(101) + this.calLuck(-5,11) > game.getTeamA().getLvlDefense()) {
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
			if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getLvlAttack()) {
				if(random.nextInt(101) + this.calLuck(-5,11) > game.getTeamB().getLvlDefense()) {
					game.setScoreA(game.getScoreA()+1);
					game.getTeamA().setGoals(game.getTeamA().getGoals() + 1);
					//System.out.println("Goal team A");
				}
			}
		}
		for(int i=0; i<this.nbActionEqB; i++) {
			if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getLvlAttack()) {
				if(random.nextInt(101) + this.calLuck(-5,11) > game.getTeamA().getLvlDefense()) {
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
            if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getStarter().get(i%11).getPlayerStatistic().getShoot()) {
                if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getGoalKeeper().getPlayerStatistic().getDef()) {
                	goalsA++;
                }
            }

            if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getStarter().get(i%11).getPlayerStatistic().getShoot()) {
                if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getGoalKeeper().getPlayerStatistic().getDef()) {
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
	
	public void  simulate2() {
		nbActionsMax = 90;
		nbActions = 0;
		game.recap += "Début du match entre "+game.getTeamA().getTeamName()+" et "+game.getTeamB().getTeamName()+"\n";
		//Coup d'envoi aléatoire comme en vrai
		if(random.nextInt(101) < 50) {
			mid(game.getTeamA(), game.getTeamB());
		}
		else {
			mid(game.getTeamB(), game.getTeamA());
		}
		
	}
	
	
	private void att(Team tAtt, Team tDef) {
		
		/*tir [Soit ballon récupérer par defense en défense, soit but, soit sortie, soit défense du gardien, soit faute]
		passe [Soit ballon récupérer par défense au defense, soit passe réussie, soit sortie, soit faute] hors jeu faible %
		dribble [Soit ballon récupérer par défense au defense, soit dribble réussie, soit sortie, soit faute]*/
		
		if(this.nbActions>this.nbActionsMax) {
			game.recap +="Fin du match !"+"\n";
			game.recap +="Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
			game.recap +=""+"\n";
			this.lel =true;
			return;
		}
		else if(this.nbActions == 45) {
			game.recap +="Mi_temps !"+"\n";
			game.recap +="Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
			game.recap +=""+"\n";
			if(random.nextInt(101) < 50) {
				mid(game.getTeamA(), game.getTeamB());
			}
			else {
				mid(game.getTeamB(), game.getTeamA());
			}
		}
				
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 40) {
				//System.out.println("Fonction att, kick tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				kick(tAtt, tDef, "att");
			} else if (r < 70){
				//System.out.println("Fonction att, dribble tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				dribble(tAtt, tDef, "att");
			} else {
				//System.out.println("Fonction att, pass tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				pass(tAtt, tDef, "att");
			}
		}
		
		
	} 
	
	private void mid(Team tAtt, Team tDef) {
		if(this.nbActions>this.nbActionsMax) {
			game.recap +="Fin du match !"+"\n";
			game.recap +="Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
			game.recap +=""+"\n";
			this.lel =true;
			return;
		}
		else if(this.nbActions == 45) {
			game.recap +="Mi_temps !"+"\n";
			game.recap +="Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
			game.recap +=""+"\n";
			if(random.nextInt(101) < 50) {
				mid(game.getTeamA(), game.getTeamB());
			}
			else {
				mid(game.getTeamB(), game.getTeamA());
			}
		}
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 10) {
				//System.out.println("Fonction mid, kick tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				kick(tAtt, tDef, "mid");
			} else if (r < 45){
				//System.out.println("Fonction mid, dribble tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				dribble(tAtt, tDef, "mid");
			} else {
				//System.out.println("Fonction mid, pass tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				pass(tAtt, tDef, "mid");
			}
		}
		
	}
	
	private void def(Team tAtt, Team tDef) {
		if(this.nbActions>this.nbActionsMax) {
			game.recap +="Fin du match !"+"\n";
			game.recap +="Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
			game.recap +=""+"\n";
			this.lel =true;
			return;
		}
		else if(this.nbActions == 45) {
			game.recap +="Mi_temps !"+"\n";
			game.recap +="Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
			game.recap +=""+"\n";
			if(random.nextInt(101) < 50) {
				mid(game.getTeamA(), game.getTeamB());
			}
			else {
				mid(game.getTeamB(), game.getTeamA());
			}
		}
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 10) {
				//System.out.println("Fonction def, kick tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				kick(tAtt, tDef, "def");
			} else if (r < 35){
				//System.out.println("Fonction def, dribble tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				dribble(tAtt, tDef, "def");
			} else {
				//System.out.println("Fonction def, pass tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//System.out.println("");
				pass(tAtt, tDef, "def");
			}
		}
		
	}
	
	private void kick(Team tAtt, Team tDef, String position) {
		//System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		//System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		//System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		game.recap +="Fonction kick, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName()+"\n";
		int attaquant, defense, goalKeeper;
		//this.numberLaps = this.r.nextInt(15)+35;
		switch(position) {
		case "att" : 
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			defense = calculateKickDef(tDef, position);
			goalKeeper = calculateGoalKeeper(tDef);
			//System.out.println("ATTAQUANT : "+attaquant+" DEFENSE : "+defense);
			//System.out.println("");
					
			if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
				//attaque passe la défense
				game.recap +=nbActions+"min - Tir de l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+"\n";
				if(attaquant + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//System.out.println("ATTAQUANT : "+attaquant+" GOAL : "+goalKeeper);
					//System.out.println("");
					//but
					game.setScore(tAtt);

					game.recap +=nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " !"+"\n";
					game.recap +=nbActions+"min - Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
					this.nbActions++;
					//System.out.println("BOOLEAN -------------------------- "+this.lel);
					mid(tDef, tAtt);
				}else {
					if(random.nextInt(101)<50) {
						//Gardien arrete la balle

						game.recap +=nbActions+"min - Arrêt du gardien pour l'équipe "+ tDef.getTeamName() + " et passe aux défenseurs"+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}else {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner

							game.recap +=nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre

							game.recap +=nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tDef, tAtt, "def");
						}
					}
				}
			}else {
				game.recap +=nbActions+"min - Tantative de récupération du ballon par l'équipe "+ tDef.getTeamName()+"\n";
				if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
					//Defense recupere le ballon

					game.recap +=nbActions+"min - Ballon récupérer par l'équipe "+ tDef.getTeamName()+"\n";
					this.nbActions++;
					def(tDef, tAtt);
				} else {
					
					if(random.nextInt(101) + this.calLuck(-5,11) < 75) {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							game.recap +=nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							game.recap +=nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tDef, tAtt, "def");
						}
					} else {
						//faute coup franc	
						game.recap +=nbActions+"min - Faute par l'équipe "+ tDef.getTeamName()+"\n";
						game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						freeKick(tAtt, tDef, "att");
					}
				}
			}
			break;
		case "mid" : 
			//Moyenne du tir de l'équipe milieu et 1/3 atta
			attaquant = calculateKickAtt(tAtt, position);
			//Moyenne defense de l'équipe milieu et 1/3 def sans gardien
			defense = calculateKickDef(tDef, position);
			goalKeeper = calculateGoalKeeper(tDef);
			//System.out.println("ATTAQUANT : "+attaquant+" DEFENSE : "+defense);
			//System.out.println("");
							
			if(random.nextInt(101) > defense + this.calLuck(-5,11)) {
				//attaque passe la défense
				game.recap +=nbActions+"min - Tir de l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+"\n";
				if(attaquant + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//System.out.println("ATTAQUANT : "+attaquant+" GOAL : "+goalKeeper);
					//System.out.println("");
					//but
					game.setScore(tAtt);
					game.recap +=nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " !"+"\n";
					game.recap +=nbActions+"min - Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
					this.nbActions++;
					//System.out.println("BOOLEAN -------------------------- "+this.lel);
					mid(tDef, tAtt);
				}else {
					if(random.nextInt(101)<50) {
						//Gardien arrete la balle
						game.recap +=nbActions+"min - Arrêt du gardien pour l'équipe "+ tDef.getTeamName() + " et passe aux défenseurs"+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}else {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							game.recap +=nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							game.recap +=nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tDef, tAtt, "def");
						}
					}
				}
			}else {
				game.recap +=nbActions+"min - Tantative de récupération du ballon par l'équipe "+ tDef.getTeamName()+"\n";
				if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
					//Defense recupere le ballon
					game.recap +=nbActions+"min - Ballon récupérer par l'équipe "+ tDef.getTeamName()+"\n";
					this.nbActions++;
					def(tDef, tAtt);
				} else {
					if(random.nextInt(101) + this.calLuck(-5,11) < 75) {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							game.recap +=nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							game.recap +=nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName()+"\n";
							this.nbActions++;
							freeKick(tDef, tAtt, "def");
						}
					} else {
						//faute coup franc	
						game.recap +=nbActions+"min - Faute par l'équipe "+ tDef.getTeamName()+"\n";
						game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						freeKick(tAtt, tDef, "att");
					}
				}
			}
			break;
		case "def" : 
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			defense = calculateKickDef(tDef, position);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101) + this.calLuck(-5,11) <80) {
				game.recap +=nbActions+"min - Tentative de dégagement par l'équipe "+ tAtt.getTeamName()+"\n";
				//On regarde si le degagement réussi
				if(random.nextInt(101) + this.calLuck(-5,11) < attaquant) {
					//On regarde si la defense intercepte
					if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
						//Dégagement long ou moyen
						if(random.nextInt(101) + this.calLuck(-5,11) < 60) {
							//Récupération ou perte de balle a la retombé
							if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
								game.recap +=nbActions+"min - Dégagement réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
								this.nbActions++;
								//System.out.println("BOOLEAN -------------------------- "+this.lel);
								mid(tAtt, tDef);
							} else {
								game.recap +=nbActions+"min - Dégagement raté pour l'équipe "+ tAtt.getTeamName()+"\n";
								this.nbActions++;
								//System.out.println("BOOLEAN -------------------------- "+this.lel);
								mid(tDef, tAtt);
							}
						} else {
							//Récupération ou perte de balle a la retombé
							if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
								game.recap +=nbActions+"min - Dégagement long réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
								this.nbActions++;
								att(tAtt, tDef);
							} else {
								game.recap +=nbActions+"min - Dégagement long raté pour l'équipe "+ tAtt.getTeamName()+"\n";
								this.nbActions++;
								def(tDef, tAtt);
							}
						}
					}
					else {
						//Récupération de la balle
						game.recap +=nbActions+"min - Défense récupère la balle sur le dégagement "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						att(tDef, tAtt);
					}
				}
				else {
					game.recap +=nbActions+"min - Le ballon par vers la touche suite au dégagement de l'équipe "+ tDef.getTeamName()+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
			}
			else {
				//Faute coup franc
				game.recap +=nbActions+"min - Faute par l'équipe "+ tDef.getTeamName()+"\n";
				game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
				this.nbActions++;
				freeKick(tAtt, tDef, "def");
			}
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
		shoot = (sumShoot1 + (sumShoot2/3))/4;
		mental = (sumMental1 + (sumMental2/3))/4;
		physique = (sumPhysique1 + (sumPhysique2/3))/4;
		//System.out.println("");
		//System.out.println("SumShoot 1 : "+sumShoot1+"  SumShoot 2 : "+sumShoot2);
		//System.out.println("SumMental 1 : "+sumMental1+"  SumMental 2 : "+sumMental2);
		//System.out.println("SumPhysique 1 : "+sumPhysique1+"  SumPhysique 2 : "+sumPhysique2);
		//System.out.println("Shoot : "+shoot+"  Mental : "+mental+"  Physqiue : "+physique);
		
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
		defense = (sumDefense1 + (sumDefense2/3 ))/4;
		mental = (sumMental1 + (sumMental2/3 ))/4;
		physique = (sumPhysique1 + (sumPhysique2/3 ))/4;
		pace = (sumPace1 + (sumPace2/3 ))/4;
		
		
		
		return ((defense*80) + (mental*5) + (physique*10) + (pace*5))/100;
	}
	
	private int calculateGoalKeeper(Team tDef) {
		int defense = 0;
		int pace = 0; 
		int physique = 0;
		int mental = 0;
		defense = tDef.getGoalKeeper().getPlayerStatistic().getDef();
		pace = tDef.getGoalKeeper().getPlayerStatistic().getPace();
		physique = tDef.getGoalKeeper().getPlayerStatistic().getPhysique();
		mental = tDef.getGoalKeeper().getPlayerStatistic().getMental();
		
		//System.out.println("Defense : "+defense+" pace : "+pace+" physique : "+physique+" mental : "+mental);
		//System.out.println("");
		
		return ((defense*50) + (mental*5) + (physique*5) + (pace*40))/100;
	}
	
	private void freeKick(Team tAtt, Team tDef, String position) {
		game.recap +="Fonction freeKick, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName()+"\n";
		int attaquant, defense;
		
		switch(position) {
		case "att" : 
			//En attaque souvent tenter le tir direct donc j'ai mis 80 mais a voir
			//Choix entre tenter tir direct ou faire une passe
			game.recap +="L'équipe hésite en la passe et le tir, tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName()+"\n";
			if(random.nextInt(101) < 80) {
				//Tente le tir
				attaquant = calculateKickAtt(tAtt, position);
				defense = calculateKickDef(tDef, position);
				game.recap +=nbActions+"min - L'équipe "+ tAtt.getTeamName() + " tente le tir direct"+"\n";
				if(random.nextInt(101) > defense + this.calLuck(-5,11)) {
					if(attaquant + this.calLuck(-5,11) > calculateGoalKeeper(tDef) + this.calLuck(-5,21)) {
						//but
						game.setScore(tAtt);
						game.recap +=nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " !"+"\n";
						game.recap +=nbActions+"min - Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals()+"\n";
						this.nbActions++;
						//System.out.println("BOOLEAN -------------------------- "+this.lel);
						mid(tDef, tAtt);
					}else {
						
						if(random.nextInt(101)<50) {
							//Gardien arrete la balle
							game.recap +=nbActions+"min - Ballon arrêté par le gardion de l'équipe "+ tDef.getTeamName() + "Remet en jeu en passant aux défenseurs"+"\n";
							this.nbActions++;
							pass(tDef, tAtt, "def");
						}else {
							game.recap +=nbActions+"min - Le ballon sort sur le tir"+"\n";
							//ballon sort corner ou 6metre
							if(random.nextInt(101)<50) {
								//corner
								game.recap +=nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+"\n";
								this.nbActions++;
								freeKick(tAtt, tDef, "att");
							}else {
								//6metre
								game.recap +=nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName()+"\n";
								this.nbActions++;
								freeKick(tDef, tAtt, "def");
							}
						}
					}
				} else {
					//tir va dans le mur de jouer
					game.recap +=nbActions+"min - Le tir va dans le mur de jouer l'équipe "+ tDef.getTeamName()+" récupère la balle"+"\n";
					this.nbActions++;
					def(tDef, tAtt);
				}
				
			} else {
				//Fait une passe donc passe juste dans laction attaque car presque impossible de se faire intercepter la passe d'un freeKick
				//ballon intercepté, faible chance
				game.recap +=nbActions+"min - L'équipe "+ tAtt.getTeamName() + " tente la passe"+"\n";
				if(random.nextInt(101)<95) {
					game.recap +=nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
					this.nbActions++;
					att(tAtt, tDef);
				}else {
					game.recap +=nbActions+"min - Passe raté pour l'équipe "+ tAtt.getTeamName()+", l'équipe "+ tDef.getTeamName()+" récupère la balle"+"\n";
					this.nbActions++;
					def(tDef, tAtt);
				}
				
			}
			break;
		case "mid" : 
			//Au milieu on va dire 50/50 car je sais pas trop
			attaquant = calculateKickAtt(tAtt, position);
			defense = calculateKickDef(tDef, position);
			//Choix entre tenter tir direct ou faire une passe
			if(random.nextInt(101) < 40) {
				game.recap +=nbActions+"min - Tentative de dégagement par l'équipe "+ tAtt.getTeamName()+"\n";
				//On regarde si la passe réussi
				if(random.nextInt(101) + this.calLuck(-5,11) < attaquant) {
					//Récupération ou perte de balle a la retombé
					if(random.nextInt(101)  < defense + this.calLuck(-5,11)) {
						game.recap +=nbActions+"min - Dégagement long réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						att(tAtt, tDef);
					} else {
						game.recap +=nbActions+"min - Dégagement long raté pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						def(tDef, tAtt);
					}
				}
				//Passe raté
				else {
					game.recap +=nbActions+"min - Le ballon par vers la touche suite au dégagement de l'équipe "+ tDef.getTeamName()+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
				
			} else {
				//ballon intercepté, faible chance
				game.recap +=nbActions+"min - L'équipe "+ tAtt.getTeamName() + " tente la passe"+"\n";
				if(random.nextInt(101)<=95) {
					game.recap +=nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
					this.nbActions++;
					//System.out.println("BOOLEAN -------------------------- "+this.lel);
					mid(tAtt, tDef);
				}else {
					game.recap +=nbActions+"min - Passe raté pour l'équipe "+ tAtt.getTeamName()+", l'équipe "+ tDef.getTeamName()+" récupère la balle"+"\n";
					this.nbActions++;
					//System.out.println("BOOLEAN -------------------------- "+this.lel);
					mid(tDef, tAtt);
				}
			}
			break;
		case "def" : 
			//Au milieu on va dire 50/50 car je sais pas trop
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			defense = calculateKickDef(tDef, position);
			//Choix entre tenter tir direct ou faire une passe
			if(random.nextInt(101) < 30) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//Dégagement long ou moyen
					if(random.nextInt(101)  < 60 ) {
						//Récupération ou perte de balle a la retombé
						if(random.nextInt(101)  < defense + this.calLuck(-5,11)) {
							game.recap +=nbActions+"min - Dégagement réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							//System.out.println("BOOLEAN -------------------------- "+this.lel);
							mid(tAtt, tDef);
						} else {
							game.recap +=nbActions+"min - Dégagement raté pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							//System.out.println("BOOLEAN -------------------------- "+this.lel);
							mid(tDef, tAtt);
						}
					} else {
						//Récupération ou perte de balle a la retombé
						if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
							game.recap +=nbActions+"min - Dégagement long réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							att(tAtt, tDef);
						} else {
							game.recap +=nbActions+"min - Dégagement long raté pour l'équipe "+ tAtt.getTeamName()+"\n";
							this.nbActions++;
							def(tDef, tAtt);
						}
					}
				}else {
					game.recap +=nbActions+"min - Le ballon par vers la touche suite au dégagement de l'équipe "+ tDef.getTeamName()+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
				
			} else {
				//ballon intercepté, faible chance
				if(random.nextInt(101)<=98) {
					game.recap +=nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
					this.nbActions++;
					def(tAtt, tDef);
				}else {
					game.recap +=nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
					this.nbActions++;
					att(tDef, tAtt);
				}
			}
			break;
		}
	}
	
	
	private void pass(Team tAtt, Team tDef, String position) {
		game.recap +="Fonction pass, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName()+"\n";
		int attaquant, defense;
		switch(position) {		
		case "att" : 
			attaquant = calculatePassAtt(tAtt, position);
			defense = calculatePassDef(tDef, position);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  < 80  + this.calLuck(-5,11)) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense+ this.calLuck(-5,11)) {
						//Passe réussi action continue
						game.recap +=nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.recap +=nbActions+"min - Passe interceptée par l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						def(tDef, tAtt);
					}
				}
				else {
					game.recap +=nbActions+"min - Passe raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain"+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
					
				}
			}
			else {
				//Faute coup franc
				game.recap +=nbActions+"min - Faute de l'équipe "+ tDef.getTeamName()+"\n";
				game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
				this.nbActions++;
				freeKick(tAtt, tDef, "att");
			}
			break;
		case "mid" : 
			attaquant = calculatePassAtt(tAtt, position);
			defense = calculatePassDef(tDef, position);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  < 60+ this.calLuck(-5,11)) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  < defense+ this.calLuck(-5,11)) {
						//Passe réussi action continue
						game.recap +=nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.recap +=nbActions+"min - Passe interceptée par l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						//System.out.println("BOOLEAN -------------------------- "+this.lel);
						mid(tDef, tAtt);
					}
				}
				else {
					game.recap +=nbActions+"min - Passe raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain"+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "mid");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "mid");
					}
				}
			}
			else {
				//Faute coup franc
				game.recap +=nbActions+"min - Faute de l'équipe "+ tDef.getTeamName()+"\n";
				game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
				this.nbActions++;
				freeKick(tAtt, tDef, "mid");
			}
			break;
		case "def" : 
			attaquant = calculatePassAtt(tAtt, position);
			defense = calculatePassDef(tDef, position);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  < 80 + this.calLuck(-5,11)) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  < defense+ this.calLuck(-5,11)) {
						//Passe réussi action continue
						game.recap +=nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						//System.out.println("BOOLEAN -------------------------- "+this.lel);
						mid(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.recap +=nbActions+"min - Passe interceptée par l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						att(tDef, tAtt);
					}
				}
				else {
					game.recap +=nbActions+"min - Passe raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain"+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "att");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "def");
					}
				}
			}
			else {
				//Faute coup franc
				game.recap +=nbActions+"min - Faute de l'équipe "+ tDef.getTeamName()+"\n";
				game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
				this.nbActions++;
				freeKick(tAtt, tDef, "def");
			}
			break;
		}
	}
	
	private int calculatePassAtt(Team tAtt, String position) {
		int sumPass1=0;
		int sumMental1=0;
		int sumPhysique1=0;
		int sumPass2=0;
		int sumMental2=0;
		int sumPhysique2=0;
		int pass=0;
		int mental=0;
		int physique=0;
		
		switch(position) {
		case "att" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("A")) {
					sumPass1 += p.getPlayerStatistic().getPass();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
				}
				else if(p.getPosition().equals("M")) {
					sumPass2 += p.getPlayerStatistic().getPass();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
				}
			}
			break;
		case "mid" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("M")) {
					sumPass1 += p.getPlayerStatistic().getPass();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
				}
				else if(p.getPosition().equals("A")) {
					sumPass2 += p.getPlayerStatistic().getPass();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
				}
			}
			
			break;
		case "def" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("D")) {
					sumPass1 += p.getPlayerStatistic().getPass();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
				}
				else if(p.getPosition().equals("M")) {
					sumPass2 += p.getPlayerStatistic().getPass();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
				}
			}
			break;
		}
		
		// Divide by 4 because 3 attack players and we divided 1/3 of the attack of the medium players
		pass = (sumPass1 + (sumPass2/3 ))/4;
		mental = (sumMental1 + (sumMental2/3 ))/4;
		physique = (sumPhysique1 + (sumPhysique2/3 ))/4;
		
		
		
		return ((pass*85) + (mental*10) + (physique*5))/100;
	}
	
	private int calculatePassDef(Team tDef, String position) {
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
		defense = (sumDefense1 + (sumDefense2/3 ))/4;
		mental = (sumMental1 + (sumMental2/3 ))/4;
		physique = (sumPhysique1 + (sumPhysique2/3 ))/4;
		pace = (sumPace1 + (sumPace2/3 ))/4;
		
		
		
		return ((defense*75) + (mental*5) + (physique*5) + (pace*15))/100;
	}
	
	private void dribble(Team tAtt, Team tDef, String position) {
		game.recap +="Fonction dribble, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName()+"\n";
		int attaquant, defense;
		switch(position) {
		case "att" : 
			attaquant = calculateDribbleAtt(tAtt, position);
			defense = calculateDribbleDef(tDef, position);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101) <80  + this.calLuck(-5,11)) {
				//On regarde si le drible réussi
				if(random.nextInt(101)  < attaquant + this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
						//Dribble réussi action continue
						game.recap +=nbActions+"min - Dribble réussi par l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.recap +=nbActions+"min - Ballon récupéré par l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						def(tDef, tAtt);
					}
				}
				else {
					game.recap +=nbActions+"min - Dribble raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain"+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
			}
			else {
				//Faute coup franc
				game.recap +=nbActions+"min - Faute de l'équipe "+ tDef.getTeamName()+"\n";
				game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
				this.nbActions++;
				freeKick(tAtt, tDef, "att");
			}
			break;
		case "mid" : 
			attaquant = calculateDribbleAtt(tAtt, position);
			defense = calculateDribbleDef(tDef, position);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  <80 + this.calLuck(-5,11)) {
				//On regarde si le drible réussi
				if(random.nextInt(101)  < attaquant + this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
						//Dribble réussi action continue
						game.recap +=nbActions+"min - Dribble réussi par l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.recap +=nbActions+"min - Ballon récupéré par l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						//System.out.println("BOOLEAN -------------------------- "+this.lel);
						mid(tDef, tAtt);
					}
				}
				else {
					game.recap +=nbActions+"min - Dribble raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain"+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "mid");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "mid");
					}
				}
			}
			else {
				//Faute coup franc
				game.recap +=nbActions+"min - Faute de l'équipe "+ tDef.getTeamName()+"\n";
				game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
				this.nbActions++;
				freeKick(tAtt, tDef, "mid");
			}
			break;
		case "def" : 
			attaquant = calculateDribbleAtt(tAtt, position);
			defense = calculateDribbleDef(tDef, position);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  <80 + this.calLuck(-5,11)) {
				//On regarde si le drible réussi
				if(random.nextInt(101)  < attaquant + this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
						//Dribble réussi action continue
						game.recap +=nbActions+"min - Dribble réussi par l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						//System.out.println("BOOLEAN -------------------------- "+this.lel);
						mid(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.recap +=nbActions+"min - Ballon récupéré par l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						att(tDef, tAtt);
					}
				}
				else {
					game.recap +=nbActions+"min - Dribble raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain"+"\n";
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+"\n";
						this.nbActions++;
						pass(tDef, tAtt, "att");
					}
					else {
						//Touche pour att
						game.recap +=nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+"\n";
						this.nbActions++;
						pass(tAtt, tDef, "def");
					}
				}
			}
			else {
				//Faute coup franc
				game.recap +=nbActions+"min - Faute de l'équipe "+ tDef.getTeamName()+"\n";
				game.recap +=nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+"\n";
				this.nbActions++;
				freeKick(tAtt, tDef, "def");
			}
			break;
		}
	}
	
	private int calculateDribbleAtt(Team tAtt, String position) {
		int sumDrible1=0;
		int sumMental1=0;
		int sumPhysique1=0;
		int sumPace1=0;
		int sumDrible2=0;
		int sumMental2=0;
		int sumPhysique2=0;
		int sumPace2=0;
		int dribble=0;
		int mental=0;
		int physique=0;
		int pace=0;
		
		switch(position) {
		case "att" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("A")) {
					sumDrible1 += p.getPlayerStatistic().getDribble();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
					sumPace1 += p.getPlayerStatistic().getPace();
				}
				else if(p.getPosition().equals("M")) {
					sumDrible2 += p.getPlayerStatistic().getDribble();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
					sumPace2 += p.getPlayerStatistic().getPace();
				}
			}
			break;
		case "mid" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("M")) {
					sumDrible1 += p.getPlayerStatistic().getDribble();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
					sumPace1 += p.getPlayerStatistic().getPace();
				}
				else if(p.getPosition().equals("A")) {
					sumDrible2 += p.getPlayerStatistic().getDribble();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
					sumPace2 += p.getPlayerStatistic().getPace();
				}
			}
			
			break;
		case "def" : 
			for(Player p : tAtt.getStarter()) {
				if(p.getPosition().equals("D")) {
					sumDrible1 += p.getPlayerStatistic().getDribble();
					sumMental1 += p.getPlayerStatistic().getMental();
					sumPhysique1 += p.getPlayerStatistic().getPhysique();
					sumPace1 += p.getPlayerStatistic().getPace();
				}
				else if(p.getPosition().equals("M")) {
					sumDrible2 += p.getPlayerStatistic().getDribble();
					sumMental2 += p.getPlayerStatistic().getMental();
					sumPhysique2  += p.getPlayerStatistic().getPhysique();
					sumPace2 += p.getPlayerStatistic().getPace();
				}
			}
			break;
		}
		
		// Divide by 4 because 3 attack players and we divided 1/3 of the attack of the medium players
		dribble = (sumDrible1 + (sumDrible2/3 ))/4;
		mental = (sumMental1 + (sumMental2/3 ))/4;
		physique = (sumPhysique1 + (sumPhysique2/3 ))/4;
		pace = (sumPace1 + (sumPace2/3 ))/4;
		
		
		
		return ((dribble*80) + (mental*5) + (physique*10) + (pace*5))/100;
	}
	
	private int calculateDribbleDef(Team tDef, String position) {
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
		defense = (sumDefense1 + (sumDefense2/3 ))/4;
		mental = (sumMental1 + (sumMental2/3 ))/4;
		physique = (sumPhysique1 + (sumPhysique2/3 ))/4;
		pace = (sumPace1 + (sumPace2/3 ))/4;
		
		
		
		return ((defense*75) + (mental*5) + (physique*10) + (pace*10))/100;
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
		this.numberLaps = this.random.nextInt(15)+35;
	}
	private int calLuck(int min, int max) {
		return this.random.nextInt(max)+min;
	}
	
	public Match getGame() {
		return game;
	}

	public void setGame(Match game) {
		this.game = game;
	}
}
