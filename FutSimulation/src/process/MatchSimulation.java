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
		/*game.alrecap.add("Att A : " + this.game.getTeamA().getLvlAttack());
		game.alrecap.add("Deff A : " + this.game.getTeamA().getLvlDefense());
		game.alrecap.add("Att B : " + this.game.getTeamB().getLvlAttack());
		game.alrecap.add("Deff B : " + this.game.getTeamB().getLvlDefense());
		game.alrecap.add("Nb tour A : " + this.nbActionEqA);
		game.alrecap.add("Nb tour B : " + this.nbActionEqA);*/
		for(int i=0; i<this.nbActionEqA; i++) {
			if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamA().getLvlAttack()) {
				if(random.nextInt(101) + this.calLuck(-5,11) > game.getTeamB().getLvlDefense()) {
					game.setScoreA(game.getScoreA()+1);
					game.getTeamA().setGoals(game.getTeamA().getGoals() + 1);
					//game.alrecap.add("Goal team A");
				}
			}
		}
		for(int i=0; i<this.nbActionEqB; i++) {
			if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getLvlAttack()) {
				if(random.nextInt(101) + this.calLuck(-5,11) > game.getTeamA().getLvlDefense()) {
					game.setScoreB(game.getScoreB()+1);
					game.getTeamB().setGoals(game.getTeamB().getGoals() + 1);
					//game.alrecap.add("Goal team B");
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
					//game.alrecap.add("Goal team A");
				}
			}
		}
		for(int i=0; i<this.nbActionEqB; i++) {
			if(random.nextInt(101) + this.calLuck(-5,11) < game.getTeamB().getLvlAttack()) {
				if(random.nextInt(101) + this.calLuck(-5,11) > game.getTeamA().getLvlDefense()) {
					game.setScoreB(game.getScoreB()+1);
					game.getTeamB().setGoals(game.getTeamB().getGoals() + 1);
					//game.alrecap.add("Goal team B");
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
		game.alrecap.add("Début du match entre "+game.getTeamA().getTeamName()+" et "+game.getTeamB().getTeamName());
		//Coup d'envoi aléatoire comme en vrai
		if(random.nextInt(101) < 50) {
			game.alrecap.add("Coup d'envoi pour l'équipe "+game.getTeamA().getTeamName());
			mid(game.getTeamA(), game.getTeamB());
		}
		else {
			game.alrecap.add("Coup d'envoi pour l'équipe "+game.getTeamB().getTeamName());
			mid(game.getTeamB(), game.getTeamA());
		}
		
		if(game.getScoreA() > game.getScoreB()) {
			game.setLoser(game.getTeamB());
			game.setWinner(game.getTeamA());
			game.alrecap.add("Le vainqueur du match est l'équipe "+game.getTeamA().getTeamName()+", l'équipe "+game.getTeamB().getTeamName()+" a perdu le match");
			if(!game.isOvertime()) {
				game.getTeamA().setNbPoints(game.getTeamA().getNbPoints() + 3);
			}
		}
		else if(game.getScoreA() < game.getScoreB()){
			game.setLoser(game.getTeamA());
			game.setWinner(game.getTeamB());
			game.alrecap.add("Le vainqueur du match est l'équipe "+game.getTeamB().getTeamName()+", l'équipe "+game.getTeamA().getTeamName()+" a perdu le match");
			if(!game.isOvertime()) {
				game.getTeamB().setNbPoints(game.getTeamB().getNbPoints() + 3);
			}
		}
		else {
			if(!game.isOvertime()) {
				game.alrecap.add("Le match fini sur une égalité entre l'équipe "+game.getTeamA().getTeamName()+" et l'équipe "+game.getTeamB().getTeamName());
				game.setDraw(true);
				game.getTeamA().setNbPoints(game.getTeamA().getNbPoints() + 1);
				game.getTeamB().setNbPoints(game.getTeamB().getNbPoints() + 1);
			}
			else {
				game.alrecap.add("Fin du temps réglementaire les équipes sont à égalités, prolongation à venir");
				overtime();
			}
		}
	}
	
	
	private void att(Team tAtt, Team tDef) {
		
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
			game.alrecap.add("");
			this.lel =true;
			return;
		}
		else if(this.nbActions == 45) {
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
			game.alrecap.add("");
			this.nbActions++;
			if(random.nextInt(101) < 50) {
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA()+" engage à son tour");
				mid(game.getTeamA(), game.getTeamB());
			}
			else {
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB()+" engage à son tour");
				mid(game.getTeamB(), game.getTeamA());
			}
		}
				
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 40) {
				//game.alrecap.add("Fonction att, kick tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				kick(tAtt, tDef, "att");
			} else if (r < 70){
				//game.alrecap.add("Fonction att, dribble tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				dribble(tAtt, tDef, "att");
			} else {
				//game.alrecap.add("Fonction att, pass tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				pass(tAtt, tDef, "att");
			}
		}
		
		
	} 
	
	private void mid(Team tAtt, Team tDef) {
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
			game.alrecap.add("");
			this.lel =true;
			return;
		}
		else if(this.nbActions == 45) {
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
			game.alrecap.add("");
			this.nbActions++;
			if(random.nextInt(101) < 50) {
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA()+" engage à son tour");
				mid(game.getTeamA(), game.getTeamB());
			}
			else {
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB()+" engage à son tour");
				mid(game.getTeamB(), game.getTeamA());
			}
		}
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 10) {
				//game.alrecap.add("Fonction mid, kick tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				kick(tAtt, tDef, "mid");
			} else if (r < 45){
				//game.alrecap.add("Fonction mid, dribble tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				dribble(tAtt, tDef, "mid");
			} else {
				//game.alrecap.add("Fonction mid, pass tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				pass(tAtt, tDef, "mid");
			}
		}
		
	}
	
	private void def(Team tAtt, Team tDef) {
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
			game.alrecap.add("");
			this.lel =true;
			return;
		}
		else if(this.nbActions == 45) {
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
			game.alrecap.add("");
			this.nbActions++;
			if(random.nextInt(101) < 50) {
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA()+" engage à son tour");
				mid(game.getTeamA(), game.getTeamB());
			}
			else {
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB()+" engage à son tour");
				mid(game.getTeamB(), game.getTeamA());
			}
		}
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 10) {
				//game.alrecap.add("Fonction def, kick tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				kick(tAtt, tDef, "def");
			} else if (r < 35){
				//game.alrecap.add("Fonction def, dribble tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				dribble(tAtt, tDef, "def");
			} else {
				//game.alrecap.add("Fonction def, pass tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
				//game.alrecap.add("");
				pass(tAtt, tDef, "def");
			}
		}
		
	}
	
	private void kick(Team tAtt, Team tDef, String position) {
		//game.alrecap.add("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		//game.alrecap.add("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		//game.alrecap.add("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
		//game.alrecap.add("Fonction kick, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
		int attaquant, defense, goalKeeper;
		//this.numberLaps = this.r.nextInt(15)+35;
		switch(position) {
		case "att" : 
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			defense = calculateKickDef(tDef, position);
			goalKeeper = calculateGoalKeeper(tDef);
			//game.alrecap.add("ATTAQUANT : "+attaquant+" DEFENSE : "+defense);
			//game.alrecap.add("");
					
			if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
				//attaque passe la défense
				game.alrecap.add(nbActions+"min - Tir de l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+" depuis la surface");
				if(attaquant + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//game.alrecap.add("ATTAQUANT : "+attaquant+" GOAL : "+goalKeeper);
					//game.alrecap.add("");
					//but
					game.setScore(tAtt);

					game.alrecap.add(nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " !");
					game.alrecap.add(nbActions+"min - Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
					game.alrecap.add(nbActions+"Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement !");
					this.nbActions++;
					//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
					mid(tDef, tAtt);
				}else {
					if(random.nextInt(101)<50) {
						//Gardien arrete la balle

						game.alrecap.add(nbActions+"min - Arrêt du gardien pour l'équipe "+ tDef.getTeamName() + " et passe aux défenseurs");
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}else {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner

							game.alrecap.add(nbActions+"min - Le gardien la touche mais le ballon sort du terrain.");
							game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							game.alrecap.add(nbActions+"min - Le tireur a un pied carré, le ballon ne va même pas dans le cadre");
							game.alrecap.add(nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName());
							this.nbActions++;
							freeKick(tDef, tAtt, "def");
						}
					}
				}
			}else {
				game.alrecap.add(nbActions+"min - Tentative de récupération du ballon par l'équipe "+ tDef.getTeamName()+" dans sa surface");
				if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
					//Defense recupere le ballon

					game.alrecap.add(nbActions+"min - Ballon récupérer par l'équipe "+ tDef.getTeamName()+" dans sa surface");
					this.nbActions++;
					def(tDef, tAtt);
				} else {
					
					if(random.nextInt(101) + this.calLuck(-5,11) < 75) {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							game.alrecap.add(nbActions+"min - Le ballon est dévié par l'équipe "+ tDef.getTeamName()+" dans sa surface");
							game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							game.alrecap.add(nbActions+"min - Le ballon sort suite à la pression du défenseur de l'équipe "+ tDef.getTeamName());
							game.alrecap.add(nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName());
							this.nbActions++;
							freeKick(tDef, tAtt, "def");
						}
					} else {
						//faute coup franc	
						game.alrecap.add(nbActions+"min - Faute par l'équipe "+ tDef.getTeamName());
						game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
			//game.alrecap.add("ATTAQUANT : "+attaquant+" DEFENSE : "+defense);
			//game.alrecap.add("");
							
			if(random.nextInt(101) > defense + this.calLuck(-5,11)) {
				//attaque passe la défense
				game.alrecap.add(nbActions+"min - Tir de l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+" depuis le milieu du terrain");
				if(attaquant + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//game.alrecap.add("ATTAQUANT : "+attaquant+" GOAL : "+goalKeeper);
					//game.alrecap.add("");
					//but
					game.setScore(tAtt);
					game.alrecap.add(nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " après une grosse frappe depuis le milieu du terrain !");
					game.alrecap.add(nbActions+"min - Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
					game.alrecap.add(nbActions+"Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement !");
					this.nbActions++;
					//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
					mid(tDef, tAtt);
				}else {
					if(random.nextInt(101)<50) {
						//Gardien arrete la balle
						game.alrecap.add(nbActions+"min - Arrêt du gardien pour l'équipe "+ tDef.getTeamName() + " et passe aux défenseurs");
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}else {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							game.alrecap.add(nbActions+"min - Le gardien la touche mais le ballon sort du terrain.");
							game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							freeKick(tAtt, tDef, "att");
						}else {
							//6metre
							game.alrecap.add(nbActions+"min - Le tireur a un pied carré, le ballon ne va même pas dans le cadre");
							game.alrecap.add(nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName());
							this.nbActions++;
							freeKick(tDef, tAtt, "def");
						}
					}
				}
			}else {
				game.alrecap.add(nbActions+"min - Tentative de récupération du ballon par l'équipe "+ tDef.getTeamName()+" dans le milieu de terrain");
				if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
					//Defense recupere le ballon
					game.alrecap.add(nbActions+"min - Ballon récupérer par l'équipe "+ tDef.getTeamName()+" au milieu du terrain");
					this.nbActions++;
					def(tDef, tAtt);
				} else {
					if(random.nextInt(101) + this.calLuck(-5,11) < 75) {
						//ballon sort touche
						if(random.nextInt(101)<50) {
							//touche
							game.alrecap.add(nbActions+"min - Le ballon est dévié par l'équipe "+ tDef.getTeamName()+" au milieu du terrain");
							game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							pass(tAtt, tDef, "att");
						}else {
							//6metre
							game.alrecap.add(nbActions+"min - Le ballon sort suite à la pression du défenseur de l'équipe "+ tDef.getTeamName());
							game.alrecap.add(nbActions+"min - Touche pour l'équipe"+ tDef.getTeamName());
							this.nbActions++;
							pass(tDef, tAtt, "def");
						}
					} else {
						//faute coup franc	
						game.alrecap.add(nbActions+"min - Faute par l'équipe "+ tDef.getTeamName());
						game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
				game.alrecap.add(nbActions+"min - Tentative de dégagement de l'équipe "+ tAtt.getTeamName()+" depuis son camp");
				//On regarde si le degagement réussi
				if(random.nextInt(101) + this.calLuck(-5,11) < attaquant) {
					//On regarde si la defense intercepte
					if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
						//Dégagement long ou moyen
						if(random.nextInt(101) + this.calLuck(-5,11) < 60) {
							//Récupération ou perte de balle a la retombé
							if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
								game.alrecap.add(nbActions+"min - Dégagement réussi pour l'équipe "+ tAtt.getTeamName()+" il récupère le ballon au milieu du terrain");
								this.nbActions++;
								//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
								mid(tAtt, tDef);
							} else {
								game.alrecap.add(nbActions+"min - Dégagement raté pour l'équipe "+ tAtt.getTeamName()+", l'équipe "+tDef.getTeamName()+" récupère le ballon au milieu du terrain");
								this.nbActions++;
								//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
								mid(tDef, tAtt);
							}
						} else {
							//Récupération ou perte de balle a la retombé
							if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
								game.alrecap.add(nbActions+"min - Dégagement long réussi pour l'équipe "+ tAtt.getTeamName()+" il récupère le ballon en attaque");
								this.nbActions++;
								att(tAtt, tDef);
							} else {
								game.alrecap.add(nbActions+"min - Dégagement long raté pour l'équipe "+ tAtt.getTeamName()+", l'équipe "+tDef.getTeamName()+" récupère le ballon en défense terrain");
								this.nbActions++;
								def(tDef, tAtt);
							}
						}
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - "+tDef.getTeamName()+" récupère la balle sur le dégagement de "+ tAtt.getTeamName());
						this.nbActions++;
						att(tDef, tAtt);
					}
				}
				else {
					game.alrecap.add(nbActions+"min - Le ballon par vers la touche dans son camp suite au dégagement de l'équipe "+ tDef.getTeamName());
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+ " dans son camp");
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+" en attaque");
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute par l'équipe "+ tDef.getTeamName());
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+" depuis son camp");
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
		//game.alrecap.add("");
		//game.alrecap.add("SumShoot 1 : "+sumShoot1+"  SumShoot 2 : "+sumShoot2);
		//game.alrecap.add("SumMental 1 : "+sumMental1+"  SumMental 2 : "+sumMental2);
		//game.alrecap.add("SumPhysique 1 : "+sumPhysique1+"  SumPhysique 2 : "+sumPhysique2);
		//game.alrecap.add("Shoot : "+shoot+"  Mental : "+mental+"  Physqiue : "+physique);
		
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
		
		//game.alrecap.add("Defense : "+defense+" pace : "+pace+" physique : "+physique+" mental : "+mental);
		//game.alrecap.add("");
		
		return ((defense*50) + (mental*5) + (physique*5) + (pace*40))/100;
	}
	
	private void freeKick(Team tAtt, Team tDef, String position) {
		//game.alrecap.add("Fonction freeKick, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
		int attaquant, defense;
		
		switch(position) {
		case "att" : 
			//En attaque souvent tenter le tir direct donc j'ai mis 80 mais a voir
			//Choix entre tenter tir direct ou faire une passe
			game.alrecap.add("L'équipe "+tAtt.getTeamName()+" hésite en la passe et le tir");
			if(random.nextInt(101) < 80) {
				//Tente le tir
				attaquant = calculateKickAtt(tAtt, position);
				defense = calculateKickDef(tDef, position);
				game.alrecap.add(nbActions+"min - L'équipe "+ tAtt.getTeamName() + " tente le tir direct");
				if(random.nextInt(101) > defense + this.calLuck(-5,11)) {
					if(attaquant + this.calLuck(-5,11) > calculateGoalKeeper(tDef) + this.calLuck(-5,21)) {
						//but
						game.setScore(tAtt);
						game.alrecap.add(nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " !");
						game.alrecap.add(nbActions+"min - Score "+ tAtt.getTeamName() + ": "+ tAtt.getGoals() + " - "+tDef.getTeamName() + ": "+ tDef.getGoals());
						this.nbActions++;
						//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
						mid(tDef, tAtt);
					}else {
						
						if(random.nextInt(101)<50) {
							//Gardien arrete la balle
							game.alrecap.add(nbActions+"min - Ballon arrêté par le gardion de l'équipe "+ tDef.getTeamName() + "Remet en jeu en passant aux défenseurs");
							this.nbActions++;
							pass(tDef, tAtt, "def");
						}else {
							game.alrecap.add(nbActions+"min - Le ballon sort sur le tir");
							//ballon sort corner ou 6metre
							if(random.nextInt(101)<50) {
								//corner
								game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName());
								this.nbActions++;
								freeKick(tAtt, tDef, "att");
							}else {
								//6metre
								game.alrecap.add(nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName());
								this.nbActions++;
								freeKick(tDef, tAtt, "def");
							}
						}
					}
				} else {
					//tir va dans le mur de jouer
					game.alrecap.add(nbActions+"min - Le tir va dans le mur de jouer l'équipe "+ tDef.getTeamName()+" récupère la balle");
					this.nbActions++;
					def(tDef, tAtt);
				}
				
			} else {
				//Fait une passe donc passe juste dans laction attaque car presque impossible de se faire intercepter la passe d'un freeKick
				//ballon intercepté, faible chance
				game.alrecap.add(nbActions+"min - L'équipe "+ tAtt.getTeamName() + " tente la passe");
				if(random.nextInt(101)<95) {
					game.alrecap.add(nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName());
					this.nbActions++;
					att(tAtt, tDef);
				}else {
					game.alrecap.add(nbActions+"min - Passe raté pour l'équipe "+ tAtt.getTeamName()+", l'équipe "+ tDef.getTeamName()+" récupère la balle");
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
				game.alrecap.add(nbActions+"min - Tentative de dégagement par l'équipe "+ tAtt.getTeamName());
				//On regarde si la passe réussi
				if(random.nextInt(101) + this.calLuck(-5,11) < attaquant) {
					//Récupération ou perte de balle a la retombé
					if(random.nextInt(101)  < defense + this.calLuck(-5,11)) {
						game.alrecap.add(nbActions+"min - Dégagement long réussi pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						att(tAtt, tDef);
					} else {
						game.alrecap.add(nbActions+"min - Dégagement long raté pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						def(tDef, tAtt);
					}
				}
				//Passe raté
				else {
					game.alrecap.add(nbActions+"min - Le ballon par vers la touche suite au dégagement de l'équipe "+ tDef.getTeamName());
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
				
			} else {
				//ballon intercepté, faible chance
				game.alrecap.add(nbActions+"min - L'équipe "+ tAtt.getTeamName() + " tente la passe");
				if(random.nextInt(101)<=95) {
					game.alrecap.add(nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName());
					this.nbActions++;
					//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
					mid(tAtt, tDef);
				}else {
					game.alrecap.add(nbActions+"min - Passe raté pour l'équipe "+ tAtt.getTeamName()+", l'équipe "+ tDef.getTeamName()+" récupère la balle");
					this.nbActions++;
					//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
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
							game.alrecap.add(nbActions+"min - Dégagement réussi pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
							mid(tAtt, tDef);
						} else {
							game.alrecap.add(nbActions+"min - Dégagement raté pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
							mid(tDef, tAtt);
						}
					} else {
						//Récupération ou perte de balle a la retombé
						if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
							game.alrecap.add(nbActions+"min - Dégagement long réussi pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							att(tAtt, tDef);
						} else {
							game.alrecap.add(nbActions+"min - Dégagement long raté pour l'équipe "+ tAtt.getTeamName());
							this.nbActions++;
							def(tDef, tAtt);
						}
					}
				}else {
					game.alrecap.add(nbActions+"min - Le ballon par vers la touche suite au dégagement de l'équipe "+ tDef.getTeamName());
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
				
			} else {
				//ballon intercepté, faible chance
				if(random.nextInt(101)<=98) {
					game.alrecap.add(nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName());
					this.nbActions++;
					def(tAtt, tDef);
				}else {
					game.alrecap.add(nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName());
					this.nbActions++;
					att(tDef, tAtt);
				}
			}
			break;
		}
	}
	
	
	private void pass(Team tAtt, Team tDef, String position) {
		game.alrecap.add("Fonction pass, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
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
						game.alrecap.add(nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Passe interceptée par l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						def(tDef, tAtt);
					}
				}
				else {
					game.alrecap.add(nbActions+"min - Passe raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain");
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
					
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute de l'équipe "+ tDef.getTeamName());
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
						game.alrecap.add(nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Passe interceptée par l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
						mid(tDef, tAtt);
					}
				}
				else {
					game.alrecap.add(nbActions+"min - Passe raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain");
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "mid");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "mid");
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute de l'équipe "+ tDef.getTeamName());
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
						game.alrecap.add(nbActions+"min - Passe réussi pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
						mid(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Passe interceptée par l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						att(tDef, tAtt);
					}
				}
				else {
					game.alrecap.add(nbActions+"min - Passe raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain");
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "att");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "def");
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute de l'équipe "+ tDef.getTeamName());
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
		game.alrecap.add("Fonction dribble, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
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
						game.alrecap.add(nbActions+"min - Dribble réussi par l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Ballon récupéré par l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						def(tDef, tAtt);
					}
				}
				else {
					game.alrecap.add(nbActions+"min - Dribble raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain");
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "def");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "att");
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute de l'équipe "+ tDef.getTeamName());
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
						game.alrecap.add(nbActions+"min - Dribble réussi par l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						att(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Ballon récupéré par l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
						mid(tDef, tAtt);
					}
				}
				else {
					game.alrecap.add(nbActions+"min - Dribble raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain");
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "mid");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "mid");
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute de l'équipe "+ tDef.getTeamName());
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
						game.alrecap.add(nbActions+"min - Dribble réussi par l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						//game.alrecap.add("BOOLEAN -------------------------- "+this.lel);
						mid(tAtt, tDef);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Ballon récupéré par l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						att(tDef, tAtt);
					}
				}
				else {
					game.alrecap.add(nbActions+"min - Dribble raté par l'équipe "+ tAtt.getTeamName()+" et le ballon sort du terrain");
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName());
						this.nbActions++;
						pass(tDef, tAtt, "att");
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName());
						this.nbActions++;
						pass(tAtt, tDef, "def");
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute de l'équipe "+ tDef.getTeamName());
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName());
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
		//game.alrecap.add(sumAttAtt);
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
