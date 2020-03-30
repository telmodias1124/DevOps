package process;

import java.util.ArrayList;
import java.util.Random;

import data.Match;
import data.Player;
import data.Team;

public class MatchSimulation {
	private Match game;
	private int nbActions, nbActionsMax;
	private Random random;
	private boolean halfTime = false;
	private Team teamStart;
	//Release 1 algo
	//private int nbActionEqA, nbActionEqB, diffLevel, numberLaps;
	private ArrayList<Player> alPlayerStarterTeamA, alPlayerStarterTeamB, alPlayerBenchTeamA, alPlayerBenchTeamB;
	
	public MatchSimulation() {
		this.random = new Random();
	}
	
	private void overtime() {
		this.nbActions = 0;
		this.nbActionsMax = 30;
		Player player;
		
		game.alrecap.add("Début des prolongations");
		//Coup d'envoi aléatoire comme en vrai
		if(random.nextInt(101) < 50) {
			player = getRandomPlayer("A", game.getTeamA());
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamA().getTeamName());
			mid(game.getTeamA(), game.getTeamB(), player);
		}
		else {
			player = getRandomPlayer("A", game.getTeamB());
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamB().getTeamName());
			mid(game.getTeamB(), game.getTeamA(), player);
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
		game.alrecap.add("Egalité après les prolongations entre "+game.getTeamA().getTeamName()+" et "+game.getTeamB().getTeamName());
		game.alrecap.add("On va passer aux pénalties");
		int goalsA = 0, goalsB = 0, i = 0;
		Player playerTeamA, playerTeamB;
        while (i<5 || goalsA==goalsB) {
        	playerTeamA = game.getTeamA().getStarter().get(10 - (i%11));
        	playerTeamB = game.getTeamB().getStarter().get(10 - (i%11));
        	
            if(random.nextInt(101)  < playerTeamA.getPlayerStatistic().getShoot()+ this.calLuck(-5,11)) {
                if(random.nextInt(51)+50  > game.getTeamB().getGoalKeeper().getPlayerStatistic().getDef()+ this.calLuck(-5,11)) {
                	game.alrecap.add(playerTeamA.getLastName()+" marque le pénaltie");
                	goalsA++;
                }
                else {
                	game.alrecap.add(game.getTeamB().getGoalKeeper().getLastName()+" arrête le tir");
                }
            }
            else {
            	game.alrecap.add(playerTeamA.getLastName()+" tir à côté");
            }

            if(random.nextInt(101)  < playerTeamB.getPlayerStatistic().getShoot()+ this.calLuck(-5,11)) {
                if(random.nextInt(51)+50  > game.getTeamA().getGoalKeeper().getPlayerStatistic().getDef()+ this.calLuck(-5,11)) {
                	game.alrecap.add(playerTeamB.getLastName()+" marque le pénaltie");
                	goalsB++;
                }
                else {
                	game.alrecap.add(game.getTeamA().getGoalKeeper().getLastName()+" arrête le tir");
                }
            }
            else {
            	game.alrecap.add(playerTeamB.getLastName()+" tir à côté");
            }	
            i++;
        }
        if(goalsA > goalsB) {
        	game.alrecap.add("Le vainqueur du match est l'équipe "+game.getTeamA().getTeamName()+", l'équipe "+game.getTeamB().getTeamName()+" a perdu le match");
        	game.setWinner(game.getTeamA());
        	game.setLoser(game.getTeamB());
        }
        else {
        	game.alrecap.add("Le vainqueur du match est l'équipe "+game.getTeamB().getTeamName()+", l'équipe "+game.getTeamA().getTeamName()+" a perdu le match");
        	game.setWinner(game.getTeamB());
        	game.setLoser(game.getTeamA());
        }
        game.setPenA(goalsA);
        game.setPenB(goalsB);
	}
	
	public void  simulate() {
		Player player;
		this.nbActionsMax = 90;
		this.nbActions = 0;
		this.halfTime = false;
		
		alPlayerStarterTeamA =  (ArrayList<Player>)game.getTeamA().getStarter().clone();
		alPlayerStarterTeamB =  (ArrayList<Player>)game.getTeamB().getStarter().clone();
		alPlayerBenchTeamA =  (ArrayList<Player>)game.getTeamA().getBench().clone();
		alPlayerBenchTeamB =  (ArrayList<Player>)game.getTeamB().getBench().clone();
		
		
		game.alrecap.add("Début du match entre "+game.getTeamA().getTeamName()+" et "+game.getTeamB().getTeamName());
		//Coup d'envoi aléatoire comme en vrai
		if(random.nextInt(101) < 50) {
			player = getRandomPlayer("A", game.getTeamA());
			teamStart = game.getTeamA();
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamA().getTeamName());
			mid(game.getTeamA(), game.getTeamB(), player);
		}
		else {
			player = getRandomPlayer("A", game.getTeamB());
			teamStart = game.getTeamB();
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamB().getTeamName());
			mid(game.getTeamB(), game.getTeamA(), player);
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
				game.alrecap.add("Le match fini sur une égalité entre l'équipe "+game.getTeamA().getTeamName()+" et l'équipe ");
				game.setDraw(true);
				game.getTeamA().setNbPoints(game.getTeamA().getNbPoints() + 1);
				game.getTeamB().setNbPoints(game.getTeamB().getNbPoints() + 1);
			}
			else {
				game.alrecap.add("Fin du temps réglementaire les équipes sont à égalités, prolongation à venir ");
				overtime();
			}
		}
	}
	
	
	private void att(Team tAtt, Team tDef, Player player) {
		
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			return;
		}
		else if((this.nbActions > 45) && (this.halfTime == false)) {
			Player newPlayer;
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			this.halfTime=true;
			if(teamStart.getTeamName().equals(game.getTeamB())) {
				newPlayer = getRandomPlayer("A", game.getTeamA());
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamA(), game.getTeamB(), newPlayer);
			}
			else {
				newPlayer = getRandomPlayer("A", game.getTeamB());
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamB(), game.getTeamA(), newPlayer);
			}
		}
				
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 40) {
				kick(tAtt, tDef, "att", player);
			} else if (r < 70){
				dribble(tAtt, tDef, "att", player);
			} else {
				pass(tAtt, tDef, "att", player);
			}
		}
		
		
	} 
	
	private void mid(Team tAtt, Team tDef, Player player) {
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			return;
		}
		else if((this.nbActions > 45) && (this.halfTime == false)) {
			Player newPlayer;
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			this.halfTime=true;
			if(teamStart.getTeamName().equals(game.getTeamB())) {
				newPlayer = getRandomPlayer("A", game.getTeamA());
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamA(), game.getTeamB(), newPlayer);
			}
			else {
				newPlayer = getRandomPlayer("A", game.getTeamB());
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamB(), game.getTeamA(), newPlayer);
			}
		}
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 10) {
				kick(tAtt, tDef, "mid", player);
			} else if (r < 45){
				dribble(tAtt, tDef, "mid", player);
			} else {
				pass(tAtt, tDef, "mid", player);
			}
		}
		
	}
	
	private void def(Team tAtt, Team tDef, Player player) {
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			return;
		}
		else if((this.nbActions > 45) && (this.halfTime == false)) {
			Player newPlayer;
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			this.halfTime=true;
			if(teamStart.getTeamName().equals(game.getTeamB())) {
				newPlayer = getRandomPlayer("A", game.getTeamA());
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamA(), game.getTeamB(), newPlayer);
			}
			else {
				newPlayer = getRandomPlayer("A", game.getTeamB());
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamB(), game.getTeamA(), newPlayer);
			}
		}
		
		if(this.nbActions<=this.nbActionsMax) {
			int r = random.nextInt(101);
			if(r < 10) {
				kick(tAtt, tDef, "def", player);
			} else if (r < 35){
				dribble(tAtt, tDef, "def", player);
			} else {
				pass(tAtt, tDef, "def", player);
			}
		}
		
	}
	
	private void kick(Team tAtt, Team tDef, String position, Player player) {
		int attaquant, defense, goalKeeper;
		Player newPlayer;
		switch(position) {
		case "att" : 
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position, player);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			newPlayer = getRandomPlayer("D", tDef);
			defense = calculateKickDef(tDef, position, newPlayer);
			goalKeeper = calculateGoalKeeper(tDef);
					
			if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
				//attaque passe la défense
				game.alrecap.add(nbActions+"min - Tir de "+player.getLastName()+" pour l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+" depuis la surface");
				if(attaquant + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//but
					game.setScore(tAtt);

					game.alrecap.add(nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " marqué par "+player.getLastName());
					game.alrecap.add(nbActions+"min - Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
					newPlayer = getRandomPlayer("A", tDef);
					game.alrecap.add(nbActions+"Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement par "+newPlayer.getLastName());
					incrementAction();
					mid(tDef, tAtt, newPlayer);
				}else {
					if(random.nextInt(101)<50) {
						//Gardien arrete la balle
						newPlayer = getRandomPlayer("D", tDef);
						game.alrecap.add(nbActions+"min - Arrêt de "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName() + " et passe à "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "def", newPlayer);
					}else {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner

							game.alrecap.add(nbActions+"min - Le gardien la touche mais le ballon sort du terrain.");
							game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+" tapé par "+player.getLastName());
							incrementAction();
							freeKick(tAtt, tDef, "att", player);
						}else {
							//6metre
							game.alrecap.add(nbActions+"min - Le tir de "+player.getLastName()+" sort du terrain, le ballon ne va même pas dans le cadre");
							game.alrecap.add(nbActions+"min - Six mètre tiré par "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName());
							incrementAction();
							freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
						}
					}
				}
			}else {
				game.alrecap.add(nbActions+"min - Tentative de récupération du ballon par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" dans sa surface");
				if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
					//Defense recupere le ballon

					game.alrecap.add(nbActions+"min - Ballon récupérer par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" dans sa surface");
					incrementAction();
					def(tDef, tAtt, newPlayer);
				} else {
					
					if(random.nextInt(101)  < 75+ this.calLuck(-5,11)) {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							game.alrecap.add(nbActions+"min - Le ballon est dévié par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName()+" dans sa surface");
							game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+" tapé par "+player.getLastName());
							incrementAction();
							freeKick(tAtt, tDef, "att", player);
						}else {
							//6metre
							game.alrecap.add(nbActions+"min - Le ballon sort suite à la pression de "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
							game.alrecap.add(nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName()+" tapé par "+tDef.getGoalKeeper());
							incrementAction();
							freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
						}
					} else {
						//faute coup franc	
						game.alrecap.add(nbActions+"min - Faute commis par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
						getCard(newPlayer, tDef);
						injury(player, tAtt);
						game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName());
						incrementAction();
						freeKick(tAtt, tDef, "att", player);
					}
				}
			}
			break;
		case "mid" : 
			//Moyenne du tir de l'équipe milieu et 1/3 atta
			attaquant = calculateKickAtt(tAtt, position, player);
			//Moyenne defense de l'équipe milieu et 1/3 def sans gardien
			newPlayer = getRandomPlayer("M", tDef);
			defense = calculateKickDef(tDef, position, newPlayer);
			goalKeeper = calculateGoalKeeper(tDef);
							
			if(random.nextInt(101) > defense + this.calLuck(-5,11)) {
				//attaque passe la défense
				game.alrecap.add(nbActions+"min - Tir de "+player.getLastName()+" pour l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+" depuis le milieu du terrain");
				if(attaquant + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//but
					game.setScore(tAtt);
					game.alrecap.add(nbActions+"min - But de l'équipe "+ tAtt.getTeamName()+ " marqué par "+player.getLastName());
					game.alrecap.add(nbActions+"min - Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
					newPlayer = getRandomPlayer("A", tDef);
					game.alrecap.add(nbActions+"Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement par "+newPlayer.getLastName());
					incrementAction();
					mid(tDef, tAtt, newPlayer);
				}else {
					if(random.nextInt(101)<50) {
						//Gardien arrete la balle
						newPlayer = getRandomPlayer("D", tDef);
						game.alrecap.add(nbActions+"min - Arrêt de "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName() + " et passe "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "def", newPlayer);
					}else {
						//ballon sort corner ou 6metre
						if(random.nextInt(101)<50) {
							//corner
							game.alrecap.add(nbActions+"min - Le gardien la touche mais le ballon sort du terrain.");
							game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+" tapé par "+player.getLastName());
							incrementAction();
							freeKick(tAtt, tDef, "att", player);
						}else {
							//6metre
							game.alrecap.add(nbActions+"min - Le tir de "+player.getLastName()+" sort du terrain, le ballon ne va même pas dans le cadre");
							game.alrecap.add(nbActions+"min - Six mètre tiré par "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName());
							incrementAction();
							freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
						}
					}
				}
			}else {
				game.alrecap.add(nbActions+"min - Tentative de récupération du ballon par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName()+" dans le milieu de terrain");
				if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
					//Defense recupere le ballon
					game.alrecap.add(nbActions+"min - Ballon récupérer par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain");
					incrementAction();
					mid(tDef, tAtt, newPlayer);
				} else {
					if(random.nextInt(101) + this.calLuck(-5,11) < 75) {
						//ballon sort touche
						if(random.nextInt(101)<50) {
							game.alrecap.add(nbActions+"min - Le ballon est dévié par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain");
							game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+ " par "+player.getLastName());
							incrementAction();
							pass(tAtt, tDef, "mid", player);
						}else {
							game.alrecap.add(nbActions+"min - Le ballon sort suite à la pression de "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
							game.alrecap.add(nbActions+"min - Touche pour l'équipe"+ tDef.getTeamName() +" par "+newPlayer.getLastName());
							incrementAction();
							pass(tDef, tAtt, "mid", newPlayer);
						}
					} else {
						//faute coup franc	
						game.alrecap.add(nbActions+"min - Faute commis par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
						getCard(newPlayer, tDef);
						injury(player, tAtt);
						game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName());
						incrementAction();
						freeKick(tAtt, tDef, "mid", player);
					}
				}
			}
			break;
		case "def" : 
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position, player);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			newPlayer = getRandomPlayer("A", tDef);
			defense = calculateKickDef(tDef, position, newPlayer);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101) + this.calLuck(-5,11) <80) {
				game.alrecap.add(nbActions+"min - Tentative de dégagement par "+player.getLastName()+" de l'équipe "+ tAtt.getTeamName()+" depuis son camp");
				//On regarde si le degagement réussi
				if(random.nextInt(101) + this.calLuck(-5,11) < attaquant) {
					//On regarde si la defense intercepte
					if(random.nextInt(101) + this.calLuck(-5,11) > defense) {
						//Dégagement long ou moyen
						if(random.nextInt(101) + this.calLuck(-5,11) < 60) {
							//Récupération ou perte de balle a la retombé
							if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
								newPlayer = getRandomPlayer("M", tAtt);
								game.alrecap.add(nbActions+"min - Dégagement réussi par "+player.getLastName()+" pour l'équipe "+ tAtt.getTeamName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain");
								incrementAction();
								mid(tAtt, tDef,newPlayer);
							} else {
								newPlayer = getRandomPlayer("M", tDef);
								game.alrecap.add(nbActions+"min - Dégagement raté par "+player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain par "+newPlayer.getLastName()+" l'équipe "+tDef.getTeamName()+"");
								incrementAction();
								mid(tDef, tAtt, newPlayer);
							}
						} else {
							//Récupération ou perte de balle a la retombé
							if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
								newPlayer = getRandomPlayer("A", tAtt);
								game.alrecap.add(nbActions+"min - Dégagement long réussi par "+player.getLastName()+ "pour l'équipe "+ tAtt.getTeamName()+" "+newPlayer.getLastName()+" récupère le ballon en attaque");
								incrementAction();
								att(tAtt, tDef, newPlayer);
							} else {
								newPlayer = getRandomPlayer("D", tAtt);
								game.alrecap.add(nbActions+"min - Dégagement long raté par "+player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en défense terrain pour "+tDef.getTeamName());
								incrementAction();
								def(tDef, tAtt, newPlayer);
							}
						}
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - "+newPlayer.getLastName()+" récupère la balle avant le dégagement de "+ player.getLastName());
						incrementAction();
						att(tDef, tAtt, newPlayer);
					}
				}
				else {
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Le ballon sort suite à la pression de "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
						game.alrecap.add(nbActions+"min - Touche pour l'équipe"+ tDef.getTeamName() +" par "+newPlayer.getLastName()+" en attaque");
						incrementAction();
						pass(tDef, tAtt, "att", newPlayer);
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Le ballon est dévié par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName());
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+ " par "+player.getLastName()+" dans son camp");
						incrementAction();
						pass(tAtt, tDef, "def", player);
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - Faute commis par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName()+" depuis son camp");
				incrementAction();
				freeKick(tAtt, tDef, "def", player);
			}
			break;
		}
	}
	
	
	private int calculateKickAtt(Team tAtt, String position, Player player) {
		int shoot=0;
		int mental=0;
		int physique=0;
		
		
		shoot = player.getPlayerStatistic().getShoot();
		mental = player.getPlayerStatistic().getMental();
		physique = player.getPlayerStatistic().getPhysique();
		
		return ((shoot*80) + (mental*5) + (physique*15))/100;
	}
	
	private int calculateKickDef(Team tDef, String position, Player player) {
		int defense=0;
		int mental=0;
		int physique=0;
		int pace =0;
		
		
		defense = player.getPlayerStatistic().getDef();
		mental = player.getPlayerStatistic().getMental();
		physique = player.getPlayerStatistic().getPhysique();
		pace = player.getPlayerStatistic().getPace();
		
		
		
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
		
		
		return ((defense*50) + (mental*5) + (physique*5) + (pace*40))/100;
	}
	
	private void freeKick(Team tAtt, Team tDef, String position, Player player) {
		int attaquant, defense;
		Player newPlayer;
		switch(position) {
		case "att" : 
			//En attaque souvent tenter le tir direct donc j'ai mis 80 mais a voir
			//Choix entre tenter tir direct ou faire une passe
			game.alrecap.add("L'équipe "+tAtt.getTeamName()+" hésite en la passe et le tir");
			if(random.nextInt(101) < 80) {
				//Tente le tir
				attaquant = calculateKickAtt(tAtt, position, player);
				newPlayer = getRandomPlayer("D", tDef);
				defense = calculateKickDef(tDef, position, newPlayer);
				game.alrecap.add(nbActions+"min - " + player.getLastName() + " tente le tir direct");
				if(random.nextInt(101) > defense + this.calLuck(-5,11)) {
					if(attaquant + this.calLuck(-5,11) > calculateGoalKeeper(tDef) + this.calLuck(-5,21)) {
						//but
						game.setScore(tAtt);
						newPlayer = getRandomPlayer("A", tDef);
						game.alrecap.add(nbActions+"min - But de l'équipe "+ tAtt.getTeamName() + " !");
						game.alrecap.add("Quelle frappe enroulée de "+player.getLastName()+" sur le tir !");
						game.alrecap.add(nbActions+"min - Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
						game.alrecap.add("Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement par "+newPlayer.getLastName());
						incrementAction();
						mid(tDef, tAtt, newPlayer);
					}else {
						
						if(random.nextInt(101)<50) {
							//Gardien arrete la balle
							newPlayer = getRandomPlayer("D", tDef);
							game.alrecap.add(nbActions+"min - Ballon arrêté par "+tDef.getGoalKeeper().getLastName()+" de l'équipe "+ tDef.getTeamName() + ", remet en jeu en passant à "+newPlayer.getLastName());
							incrementAction();
							pass(tDef, tAtt, "def", newPlayer);
						}else {
							game.alrecap.add(nbActions+"min - Le ballon sort sur le tir de "+player.getLastName());
							//ballon sort corner ou 6metre
							if(random.nextInt(101)<50) {
								//corner
								game.alrecap.add(nbActions+"min - Le gardien la touche mais le ballon sort du terrain.");
								game.alrecap.add(nbActions+"min - Corner pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName());
								incrementAction();
								freeKick(tAtt, tDef, "att", player);
							}else {
								//6metre
								game.alrecap.add(nbActions+"min - Le tir de "+player.getLastName()+" passe totalement à côté de la cage");
								game.alrecap.add(nbActions+"min - Six mètre pour l'équipe "+ tDef.getTeamName());
								incrementAction();
								freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
							}
						}
					}
				} else {
					//tir va dans le mur de jouer
					game.alrecap.add(nbActions+"min - Le tir de "+player.getLastName()+" va dans le mur de joueur de l'équipe "+ tDef.getTeamName()+", "+newPlayer.getLastName()+" récupère la balle dans son camp");
					incrementAction();
					def(tDef, tAtt, newPlayer);
				}
				
			} else {
				//Fait une passe donc passe juste dans laction attaque car presque impossible de se faire intercepter la passe d'un freeKick
				//ballon intercepté, faible chance
				game.alrecap.add(nbActions+"min - "+ player.getLastName() + " tente la passe en attaque");
				if(random.nextInt(101)<95) {
					newPlayer = getRandomPlayer("A", tAtt);
					game.alrecap.add(nbActions+"min - Passe réussi par "+ player.getLastName() +" à "+newPlayer.getLastName()+", ballon dans la surface");
					incrementAction();
					att(tAtt, tDef, newPlayer);
				}else {
					newPlayer = getRandomPlayer("D", tDef);
					game.alrecap.add(nbActions+"min - Passe raté par "+ player.getLastName() +", "+ newPlayer.getLastName()+" récupère la balle dans son camp");
					incrementAction();
					def(tDef, tAtt, newPlayer);
				}
				
			}
			break;
		case "mid" : 
			//Au milieu on va dire 50/50 car je sais pas trop
			attaquant = calculateKickAtt(tAtt, position, player);
			newPlayer = getRandomPlayer("M", tDef);
			defense = calculateKickDef(tDef, position, newPlayer);
			game.alrecap.add("L'équipe "+tAtt.getTeamName()+" hésite en la passe et le dégagement");
			//Choix entre tenter tir direct ou faire une passe
			if(random.nextInt(101) < 40) {
				game.alrecap.add(nbActions+"min - Tentative de dégagement depuis le milieu du terrain par "+ player.getLastName());
				//On regarde si la passe réussi
				if(random.nextInt(101) + this.calLuck(-5,11) < attaquant) {
					//Récupération ou perte de balle a la retombé
					if(random.nextInt(101)  < defense + this.calLuck(-5,11)) {
						newPlayer = getRandomPlayer("A", tAtt);
						game.alrecap.add(nbActions+"min - Dégagement long réussi par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en attaque");
						incrementAction();
						att(tAtt, tDef, newPlayer);
					} else {
						newPlayer = getRandomPlayer("D", tDef);
						game.alrecap.add(nbActions+"min - Dégagement long raté par "+ player.getLastName()+", l'équipe "+tDef.getTeamName()+" récupère le ballon au milieu du terrain par l'intermédiaire de "+newPlayer.getLastName());
						incrementAction();
						def(tDef, tAtt, newPlayer);
					}
				}
				//Passe raté
				else {
					if(random.nextInt(101) < 50) {
						//Touche pour def
						newPlayer = getRandomPlayer("D", tDef);
						game.alrecap.add(nbActions+"min - Le ballon sort suite à la pression de "+newPlayer.getLastName());
						game.alrecap.add(nbActions+"min - Touche pour l'équipe"+ tDef.getTeamName()+ " au milieu du terrain, remis en jeu par "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "mid", newPlayer);
					}
					else {
						//Touche pour att
						newPlayer = getRandomPlayer("D", tDef);
						game.alrecap.add(nbActions+"min - Le ballon est dévié par "+ newPlayer.getLastName()+" au milieu du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+ " au milieu du terrain, remis en jeu par "+player.getLastName());
						incrementAction();
						pass(tAtt, tDef, "mid", player);
					}
				}
								
			} else {
				//ballon intercepté, faible chance
				game.alrecap.add(nbActions+"min - "+ player.getLastName() + " tente la passe depuis le milieu du terrain");
				if(random.nextInt(101)<=95) {
					newPlayer = getRandomPlayer("M", tAtt);
					game.alrecap.add(nbActions+"min - Passe réussi par "+ player.getLastName()+ " à "+newPlayer.getLastName()+", ballon au milieu du terrain");
					incrementAction();
					mid(tAtt, tDef, newPlayer);
				}else {
					game.alrecap.add(nbActions+"min - Passe raté par "+ player.getLastName()+", "+ newPlayer.getLastName()+" récupère la balle au milieu du terrain");
					incrementAction();
					mid(tDef, tAtt, newPlayer);
				}
			}
			break;
		case "def" : 
			//Au milieu on va dire 50/50 car je sais pas trop
			//Moyenne du tir de l'équipe attaquant et 1/3 millieu
			attaquant = calculateKickAtt(tAtt, position, player);
			//Moyenne defense de l'équipe defenseur et 1/3 millieu sans gardien
			newPlayer = getRandomPlayer("A", tDef);
			defense = calculateKickDef(tDef, position, newPlayer);
			//Choix entre tenter tir direct ou faire une passe
			if(random.nextInt(101) < 30) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//Dégagement long ou moyen
					if(random.nextInt(101) < 60) {
						//Récupération ou perte de balle a la retombé
						if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
							newPlayer = getRandomPlayer("M", tAtt);
							game.alrecap.add(nbActions+"min - Dégagement réussi par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain");
							incrementAction();
							mid(tAtt, tDef, newPlayer);
						} else {
							newPlayer = getRandomPlayer("M", tDef);
							game.alrecap.add(nbActions+"min - Dégagement raté par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain");
							incrementAction();
							mid(tDef, tAtt, newPlayer);
						}
					} else {
						//Récupération ou perte de balle a la retombé
						if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
							newPlayer = getRandomPlayer("A", tAtt);
							game.alrecap.add(nbActions+"min - Dégagement long réussi par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en attaque");
							incrementAction();
							att(tAtt, tDef, newPlayer);
						} else {
							newPlayer = getRandomPlayer("D", tDef);
							game.alrecap.add(nbActions+"min - Dégagement long raté par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en défense");
							incrementAction();
							def(tDef, tAtt, newPlayer);
						}
					}
				}else {
					game.alrecap.add(nbActions+"min - Le ballon par vers la touche suite au dégagement de "+player.getLastName());
					//Touche pour def
					newPlayer = getRandomPlayer("M", tDef);
					game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain, remis en jeu par"+newPlayer.getLastName());
					incrementAction();
					pass(tDef, tAtt, "mid", newPlayer);
					
				}
				
			} else {
				game.alrecap.add(nbActions+"min - L'équipe "+ tAtt.getTeamName()+ " tente la passe depuis leur camp");
				//ballon intercepté, faible chance
				if(random.nextInt(101)<=98) {
					newPlayer = getRandomPlayer("D", tAtt);
					game.alrecap.add(nbActions+"min - Passe réussi par "+ player.getLastName()+" à "+newPlayer.getLastName()+" ballon en défense");
					incrementAction();
					def(tAtt, tDef, newPlayer);
				}else {
					game.alrecap.add(nbActions+"min - Passe raté par "+ player.getLastName()+", "+ newPlayer.getLastName()+" récupère le ballon dans la surface");
					incrementAction();
					att(tDef, tAtt, newPlayer);
				}
			}
			break;
		}
	}
	
	
	private void pass(Team tAtt, Team tDef, String position, Player player) {
		//game.alrecap.add("Fonction pass, position "+position+" tAtt "+tAtt.getTeamName()+" , tDef "+tDef.getTeamName());
		int attaquant, defense;
		Player newPlayer;
		switch(position) {		
		case "att" : 
			attaquant = calculatePassAtt(tAtt, position, player);
			newPlayer = getRandomPlayer("D", tDef);
			defense = calculatePassDef(tDef, position, newPlayer);
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  < 80  + this.calLuck(-5,11)) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense+ this.calLuck(-5,11)) {
						//Passe réussi action continue
						newPlayer = getRandomPlayer("A", tAtt);
						game.alrecap.add(nbActions+"min - Passe réussi par "+player.getLastName()+" à "+newPlayer.getLastName()+", il conserve la balle en attaque");
						incrementAction();
						att(tAtt, tDef, newPlayer);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Passe interceptée par "+ newPlayer.getLastName()+", il récupère la balle dans sa surface");
						incrementAction();
						def(tDef, tAtt, newPlayer);
					}
				}
				else {
					
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Passe raté par "+player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+" dans leur camp, remis en jeu par "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "def", newPlayer);
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Passe déviée par "+ newPlayer.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+" en attaque, remis en jeu par "+player.getLastName());
						incrementAction();
						pass(tAtt, tDef, "att", player);
					}
					
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName() +" tente de récupérer la balle mais commet une faute");
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de marquer");
				incrementAction();
				freeKick(tAtt, tDef, "att", player);
			}
			break;
		case "mid" : 
			attaquant = calculatePassAtt(tAtt, position, player);
			newPlayer = getRandomPlayer("M", tDef);
			defense = calculatePassDef(tDef, position, newPlayer);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  < 60+ this.calLuck(-5,11)) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  < defense+ this.calLuck(-5,11)) {
						//Passe réussi action continue
						newPlayer = getRandomPlayer("A", tAtt);
						game.alrecap.add(nbActions+"min - Passe réussi par "+player.getLastName()+" à "+newPlayer.getLastName()+" il passe en attaque");
						incrementAction();
						att(tAtt, tDef, newPlayer);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Passe interceptée par "+ newPlayer.getLastName()+", il récupère la balle au milieu du terrain");
						incrementAction();
						mid(tDef, tAtt, newPlayer);
					}
				}
				else {
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Passe raté par "+player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain remis en jeu par "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "mid", newPlayer);
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Passe déviée par l'équipe "+ newPlayer.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+" au milieu du terrain remis en jeu par "+player.getLastName());
						incrementAction();
						pass(tAtt, tDef, "mid", player);
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+", par "+player.getLastName() +" au milieu du terrain");
				incrementAction();
				freeKick(tAtt, tDef, "mid", player);
			}
			break;
		case "def" : 
			attaquant = calculatePassAtt(tAtt, position, player);
			newPlayer = getRandomPlayer("A", tDef);
			defense = calculatePassDef(tDef, position, newPlayer);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  < 80 + this.calLuck(-5,11)) {
				//On regarde si la passe réussi
				if(random.nextInt(101)  < attaquant+ this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  < defense+ this.calLuck(-5,11)) {
						//Passe réussi action continue
						newPlayer = getRandomPlayer("M", tAtt);
						game.alrecap.add(nbActions+"min - Passe réussi par "+player.getLastName()+" à "+newPlayer.getLastName()+" il passe au milieu du terrain");
						incrementAction();
						mid(tAtt, tDef, newPlayer);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Passe interceptée par "+ newPlayer.getLastName()+" il récupère la balle et peut directement attaquer");
						incrementAction();
						att(tDef, tAtt, newPlayer);
					}
				}
				else {
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Passe raté par "+player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+" en attaque remis en jeu par "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "att", newPlayer);
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - Passe déviée par "+ newPlayer.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+" dans leur camp remis en jeu par "+player.getLastName());
						incrementAction();
						pass(tAtt, tDef, "def", player);
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de se dégager de son camp");
				incrementAction();
				freeKick(tAtt, tDef, "def", player);
			}
			break;
		}
	}
	
	private int calculatePassAtt(Team tAtt, String position, Player player) {
		int pass=0;
		int mental=0;
		int physique=0;
		
		pass = player.getPlayerStatistic().getPass();
		mental = player.getPlayerStatistic().getMental();
		physique = player.getPlayerStatistic().getPhysique();
		
		
		
		return ((pass*85) + (mental*10) + (physique*5))/100;
	}
	
	private int calculatePassDef(Team tDef, String position, Player player) {
		int defense=0;
		int mental=0;
		int physique=0;
		int pace =0;
		
		defense = player.getPlayerStatistic().getDef();
		mental = player.getPlayerStatistic().getMental();
		physique = player.getPlayerStatistic().getPhysique();
		pace = player.getPlayerStatistic().getPace();
		
		
		
		return ((defense*75) + (mental*5) + (physique*5) + (pace*15))/100;
	}
	
	
	private void dribble(Team tAtt, Team tDef, String position, Player player) {
		int attaquant, defense;
		Player newPlayer;
		switch(position) {
		case "att" : 
			attaquant = calculateDribbleAtt(tAtt, position, player);
			newPlayer = getRandomPlayer("D", tDef);
			defense = calculateDribbleDef(tDef, position, newPlayer);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101) <80  + this.calLuck(-5,11)) {
				//On regarde si le drible réussi
				if(random.nextInt(101)  < attaquant + this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
						//Dribble réussi action continue
						game.alrecap.add(nbActions+"min - Dribble réussi par "+ player.getLastName()+" il conserve la balle en attaque");
						incrementAction();
						att(tAtt, tDef, player);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Ballon récupéré par "+ newPlayer.getLastName()+" sur le dribble de "+player.getLastName()+", il récupère la balle dans sa surface");
						incrementAction();
						def(tDef, tAtt, newPlayer);
					}
				}
				else {
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Dribble raté par "+ player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+" dans leur camp remis en jeu par "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "def", newPlayer);
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - "+ player.getLastName()+" tente de dribbler "+newPlayer.getLastName()+" mais il sort le ballon du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+" en attaque remis en jeu par "+player.getLastName());
						incrementAction();
						pass(tAtt, tDef, "att", player);
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de marquer");
				incrementAction();
				freeKick(tAtt, tDef, "att", player);
			}
			break;
		case "mid" : 
			attaquant = calculateDribbleAtt(tAtt, position, player);
			newPlayer = getRandomPlayer("M", tDef);
			defense = calculateDribbleDef(tDef, position, newPlayer);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  <80 + this.calLuck(-5,11)) {
				//On regarde si le drible réussi
				if(random.nextInt(101)  < attaquant + this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
						//Dribble réussi action continue
						game.alrecap.add(nbActions+"min - Dribble réussi par "+ player.getLastName()+" il passe en attaque");
						incrementAction();
						att(tAtt, tDef, player);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Ballon récupéré par "+ newPlayer.getLastName()+" sur le dribble de "+player.getLastName()+", il récupère la balle au milieu du terrain");
						incrementAction();
						mid(tDef, tAtt, newPlayer);
					}
				}
				else {
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Dribble raté par "+ player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain remis en jeu par "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "mid", newPlayer);
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - "+ player.getLastName()+" tente de dribbler "+newPlayer.getLastName()+" mais il sort le ballon du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+" au milieu du terrain remis en jeu par "+player.getLastName());
						incrementAction();
						pass(tAtt, tDef, "mid", player);
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+", par "+player.getLastName() +" au milieu du terrain");
				incrementAction();
				freeKick(tAtt, tDef, "mid", player);
			}
			break;
		case "def" : 
			attaquant = calculateDribbleAtt(tAtt, position, player);
			newPlayer = getRandomPlayer("A", tDef);
			defense = calculateDribbleDef(tDef, position, newPlayer);
			
			//On va dire que ya peu de chance quil y ai une faute sur une passe
			if(random.nextInt(101)  <80 + this.calLuck(-5,11)) {
				//On regarde si le drible réussi
				if(random.nextInt(101)  < attaquant + this.calLuck(-5,11)) {
					//On regarde si la defense intercepte
					if(random.nextInt(101)  > defense + this.calLuck(-5,11)) {
						//Dribble réussi action continue
						game.alrecap.add(nbActions+"min - Dribble réussi par "+ player.getLastName()+" il passe au milieu");
						incrementAction();
						mid(tAtt, tDef, player);
					}
					else {
						//Récupération de la balle
						game.alrecap.add(nbActions+"min - Ballon récupéré par "+ newPlayer.getLastName() +" sur le dribble de "+player.getLastName()+", il récupère la balle dans sa surface");
						incrementAction();
						att(tDef, tAtt, newPlayer);
					}
				}
				else {
					if(random.nextInt(101) < 50) {
						//Touche pour def
						game.alrecap.add(nbActions+"min - Dribble raté par "+ player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tDef.getTeamName()+" en attaque remis en jeu par "+newPlayer.getLastName());
						incrementAction();
						pass(tDef, tAtt, "att", newPlayer);
					}
					else {
						//Touche pour att
						game.alrecap.add(nbActions+"min - "+ player.getLastName()+" tente de dribbler "+newPlayer.getLastName()+" mais il sort le ballon du terrain");
						game.alrecap.add(nbActions+"min - Touche pour l'équipe "+ tAtt.getTeamName()+" dans leur camp remis en jeu par "+player.getLastName());
						incrementAction();
						pass(tAtt, tDef, "def", player);
					}
				}
			}
			else {
				//Faute coup franc
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add(nbActions+"min - Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de se dégager de son camp");
				incrementAction();
				freeKick(tAtt, tDef, "def", player);
			}
			break;
		}
	}
	
	
	
	private int calculateDribbleAtt(Team tAtt, String position, Player player) {
		int dribble=0;
		int mental=0;
		int physique=0;
		int pace=0;
		
		dribble = player.getPlayerStatistic().getDribble();
		mental = player.getPlayerStatistic().getMental();
		physique = player.getPlayerStatistic().getPhysique();
		pace = player.getPlayerStatistic().getPace();
		
		
		
		return ((dribble*80) + (mental*5) + (physique*10) + (pace*5))/100;
	}
	
	private int calculateDribbleDef(Team tDef, String position, Player player) {
		int defense=0;
		int mental=0;
		int physique=0;
		int pace =0;
		
		defense = player.getPlayerStatistic().getDef();
		mental = player.getPlayerStatistic().getMental();
		physique = player.getPlayerStatistic().getPhysique();
		pace = player.getPlayerStatistic().getPace();
		
		
		
		return ((defense*75) + (mental*5) + (physique*10) + (pace*10))/100;
	}
	
	private Player getRandomPlayer(String position, Team team) {
		ArrayList<Player> def = new ArrayList<Player>();
		ArrayList<Player> mid = new ArrayList<Player>();
		ArrayList<Player> att = new ArrayList<Player>();
		ArrayList<Player> alPlayer = new ArrayList<Player>();
		Player player = new Player();
		
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			alPlayer = alPlayerStarterTeamA;
		}
		else {
			alPlayer = alPlayerStarterTeamB;
		}
		
		for(Player p : alPlayer) {
			if(p.getPosition().equals("A")) {
				att.add(p);
			}
			else if(p.getPosition().equals("M")) {
				mid.add(p);
			}
			else if(p.getPosition().equals("D")) {
				def.add(p);
			}
		}
				
		if(position.equals("A")) {
			player = att.get(random.nextInt(att.size()));
		}
		else if(position.equals("M")) {
			player = mid.get(random.nextInt(mid.size()));
		}
		else if(position.equals("D")) {
			player = def.get(random.nextInt(def.size()));
		}
		
		return player;
	}

	private Player getRandomBenchPlayer(String position, ArrayList<Player> al) {

		ArrayList<Player> def = new ArrayList<Player>();
		ArrayList<Player> mid = new ArrayList<Player>();
		ArrayList<Player> att = new ArrayList<Player>();
		Player player = new Player();
		
		for(Player p : al) {
			if(p.getPosition().equals("A")) {
				att.add(p);
			}
			else if(p.getPosition().equals("M")) {
				mid.add(p);
			}
			else if(p.getPosition().equals("D")) {
				def.add(p);
			}
		}
		
		
		
		if(position.equals("A")) {
			player = att.get(random.nextInt(att.size()));
		}
		else if(position.equals("M")) {
			player = mid.get(random.nextInt(mid.size()));
		}
		else if(position.equals("D")) {
			player = def.get(random.nextInt(def.size()));
		}
		
		
		return player;
	}
	
	private void incrementAction() {
		if(random.nextInt(101) > 50) {
			this.nbActions++;
		}else {
			this.nbActions = this.nbActions+2;
		}
	}
	
	
	private void injury(Player player, Team team) {
		Player newPlayer;
		
		if(player.getPosition().contentEquals("A")) {
			if(random.nextInt(101) > 97) {
				if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
					alPlayerStarterTeamA.remove(player);
					newPlayer = getRandomBenchPlayer(player.getPosition(), alPlayerBenchTeamA);
					alPlayerStarterTeamA.add(newPlayer);
				}
				else {
					alPlayerStarterTeamB.remove(player);
					newPlayer = getRandomBenchPlayer(player.getPosition(), alPlayerBenchTeamB);
					alPlayerStarterTeamB.add(newPlayer);
				}
				game.alrecap.add(player.getLastName()+" sort suite à une blessure, remplacé par "+newPlayer.getLastName());
			}
		} else if(player.getPosition().contentEquals("M")) {
			if(random.nextInt(101) > 98) {
				if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
					alPlayerStarterTeamA.remove(player);
					newPlayer = getRandomBenchPlayer(player.getPosition(), alPlayerBenchTeamA);
					alPlayerStarterTeamA.add(newPlayer);
				}
				else {
					alPlayerStarterTeamB.remove(player);
					newPlayer = getRandomBenchPlayer(player.getPosition(), alPlayerBenchTeamB);
					alPlayerStarterTeamB.add(newPlayer);
				}
				game.alrecap.add(player.getLastName()+" sort suite à une blessure, remplacé par "+newPlayer.getLastName());
			}
		} else if(player.getPosition().contentEquals("D")) {
			if(random.nextInt(101) > 99) {
				if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
					alPlayerStarterTeamA.remove(player);
					newPlayer = getRandomBenchPlayer(player.getPosition(), alPlayerBenchTeamA);
					alPlayerStarterTeamA.add(newPlayer);
				}
				else {
					alPlayerStarterTeamB.remove(player);
					newPlayer = getRandomBenchPlayer(player.getPosition(), alPlayerBenchTeamB);
					alPlayerStarterTeamB.add(newPlayer);
				}
				game.alrecap.add(player.getLastName()+" sort suite à une blessure, remplacé par "+newPlayer.getLastName());
			}
		}
		
		
	}
	
	private void getCard(Player player, Team team) {
		ArrayList<Player> alPlayer = new ArrayList<Player>();
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			alPlayer = alPlayerStarterTeamA;
		}
		else {
			alPlayer = alPlayerStarterTeamB;
		}
		
		if(player.getPosition().contentEquals("A")) {
			if(random.nextInt(101) > 90) {
				if(random.nextInt(101)>98) {

					game.alrecap.add(player.getLastName()+" commet une très grosse faute, il prend un carton rouge !");
					alPlayer.remove(player);
				}else {
					if(player.getCard()) {
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune mais en avait déjà un donc c'est le rouge !");
						alPlayer.remove(player);
					}else {
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune !");
						player.setCard(true);
					}
				}
			}
		} else if(player.getPosition().contentEquals("M")) {
			if(random.nextInt(101) > 90) {
				if(random.nextInt(101)>95) {
					alPlayer.remove(player);
					
					game.alrecap.add(player.getLastName()+" commet une très grosse faute, il prend un carton rouge !");
				}else {
					if(player.getCard()) {
						alPlayer.remove(player);
						
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune mais en avait déjà un donc c'est le rouge !");
					}else {
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune !");
						player.setCard(true);
					}
				}
			}
		} else if(player.getPosition().contentEquals("D")) {
			if(random.nextInt(101) > 85) {
				if(random.nextInt(101)>90) {
					alPlayer.remove(player);
					
					game.alrecap.add(player.getLastName()+" commet une très grosse faute, il prend un carton rouge !");
				}else {
					if(player.getCard()) {
						alPlayer.remove(player);
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune mais en avait déjà un donc c'est le rouge !");
					}else {
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune !");
						player.setCard(true);
					}
				}
			}
		}
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
	
	
	//Release 1 algo
		/*public void simulate() {
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
			/*for(int i=0; i<this.nbActionEqA; i++) {
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
		}*/
	
	
	//Release 1 algo
	/*private void setNbTeamActions() {
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
	}*/
	/*private void setLvlEq(Team t) {
		t.setLvlEq((t.getLvlAttack() + t.getLvlDefense()) / 2);
	}*/
	
	/*private void calNbLaps() {
		this.numberLaps = this.random.nextInt(15)+35;
	}*/
	
}
