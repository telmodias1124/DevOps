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
		//Maximum action number in overtime
		this.nbActionsMax = 30;
		this.nbActions = 0;
		Player player;
		
		game.alrecap.add("Début des prolongations");
		//Kick-off, select a random team who will begin
		if(random.nextInt(101) < 50) {
			player = getRandomPlayer("A", game.getTeamA(), "");
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamA().getTeamName());
			mid(game.getTeamA(), game.getTeamB(), player);
		}
		else {
			player = getRandomPlayer("A", game.getTeamB(), "");
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamB().getTeamName());
			mid(game.getTeamB(), game.getTeamA(), player);
		}
		
		//Check who win the game
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
		//Maximum action number in the game
		this.nbActionsMax = 90;
		this.nbActions = 0;
		this.halfTime = false;
		
		//Copy player's array to make replacement
		alPlayerStarterTeamA =  (ArrayList<Player>)game.getTeamA().getStarter().clone();
		alPlayerStarterTeamB =  (ArrayList<Player>)game.getTeamB().getStarter().clone();
		alPlayerBenchTeamA =  (ArrayList<Player>)game.getTeamA().getBench().clone();
		alPlayerBenchTeamB =  (ArrayList<Player>)game.getTeamB().getBench().clone();
		
		
		game.alrecap.add("Début du match entre "+game.getTeamA().getTeamName()+" et "+game.getTeamB().getTeamName());
		//Kick-off, select a random team who will begin
		if(random.nextInt(101) < 50) {
			player = getRandomPlayer("A", game.getTeamA(), "");
			teamStart = game.getTeamA();
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamA().getTeamName());
			game.alrecap.add("");
			mid(game.getTeamA(), game.getTeamB(), player);
		}
		else {
			player = getRandomPlayer("A", game.getTeamB(), "");
			teamStart = game.getTeamB();
			game.alrecap.add("Coup d'envoi donné par "+player.getLastName()+" pour l'équipe "+game.getTeamB().getTeamName());
			game.alrecap.add("");
			mid(game.getTeamB(), game.getTeamA(), player);
		}
		
		//Check who win the game
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
			//Check if the game is in the knockout phase to see if there is overtime 
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
		//Check if game is over
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			return;
		}
		//Check if it is half time
		else if((this.nbActions > 45) && (this.halfTime == false)) {
			Player newPlayer;
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			this.halfTime=true;
			if(teamStart.getTeamName().equals(game.getTeamB().getTeamName())) {
				newPlayer = getRandomPlayer("A", game.getTeamA(), "");
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA().getTeamName()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamA(), game.getTeamB(), newPlayer);
			}
			else {
				newPlayer = getRandomPlayer("A", game.getTeamB(), "");
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB().getTeamName()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamB(), game.getTeamA(), newPlayer);
			}
		}
				
		//Check again if game is over
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
		//Check if game is over
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			return;
		}
		//Check if it is half time
		else if((this.nbActions > 45) && (this.halfTime == false)) {
			Player newPlayer;
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			this.halfTime=true;
			if(teamStart.getTeamName().equals(game.getTeamB().getTeamName())) {
				newPlayer = getRandomPlayer("A", game.getTeamA(), "");
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA().getTeamName()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamA(), game.getTeamB(), newPlayer);
			}
			else {
				newPlayer = getRandomPlayer("A", game.getTeamB(), "");
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB().getTeamName()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamB(), game.getTeamA(), newPlayer);
			}
		}
		
		//Check again if game is over
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
		//Check if game is over
		if(this.nbActions>this.nbActionsMax) {
			game.alrecap.add("Fin du match !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			return;
		}
		//Check if it is half time
		else if((this.nbActions > 45) && (this.halfTime == false)) {
			Player newPlayer;
			game.alrecap.add("Mi_temps !");
			game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
			game.alrecap.add("");
			this.halfTime=true;
			if(teamStart.getTeamName().equals(game.getTeamB().getTeamName())) {
				newPlayer = getRandomPlayer("A", game.getTeamA(), "");
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamA().getTeamName()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamA(), game.getTeamB(), newPlayer);
			}
			else {
				newPlayer = getRandomPlayer("A", game.getTeamB(), "");
				game.alrecap.add("Début de la deuxième mi-temps");
				game.alrecap.add("L'equipe "+game.getTeamB().getTeamName()+" engage à son tour par l'intermédiaire de "+newPlayer.getLastName());
				mid(game.getTeamB(), game.getTeamA(), newPlayer);
			}
		}
		
		//Check again if game is over
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
		int attacker, defender, goalKeeper;
		Player newPlayer;
		//Use a switch to different position on the field
		switch(position) {
		case "att" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("D", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculateKickAtt(tAtt, position, player);
			defender = calculateKickDef(tDef, position, newPlayer);
			goalKeeper = calculateGoalKeeper(tDef);
		
			//Check if defender try to get the ball
			if(random.nextInt(101)  > defender + this.calLuck(-5,11)) {
				
				//Attacker will try to kick
				incrementTotalKicks(tAtt);
				game.alrecap.add(nbActions+"min - Tir de "+player.getLastName()+" pour l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+" depuis la surface");
				
				//Check if the goalkeeper can defend the kick
				if(attacker + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//Score a goal
					game.setScore(tAtt);
					game.alrecap.add("But de l'équipe "+ tAtt.getTeamName() + " marqué par "+player.getLastName());
					game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
					game.alrecap.add("");
					newPlayer = getRandomPlayer("A", tDef, player.getLastName());
					game.alrecap.add("Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement par "+newPlayer.getLastName());
					incrementAction(tAtt);
					mid(tDef, tAtt, newPlayer);
				}else {
					//Check if the goalkeeper can catch the ball
					if(random.nextInt(101)<50) {
						//Goalkeeper catch the ball
						newPlayer = getRandomPlayer("D", tDef, player.getLastName());
						game.alrecap.add("Arrêt de "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName() + " et passe à "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "def", newPlayer);
					}else {
						//Check if Goalkeeper touch the ball and then go out or just the kick go out
						if(random.nextInt(101)<50) {
							//Corner
							game.alrecap.add("Le gardien la touche mais le ballon sort du terrain.");
							game.alrecap.add("Corner pour l'équipe "+ tAtt.getTeamName()+" tapé par "+player.getLastName());
							incrementCorners(tAtt);
							incrementAction(tAtt);
							freeKick(tAtt, tDef, "att", player);
						}else {
							//Goalie kick
							game.alrecap.add("Le tir de "+player.getLastName()+" sort du terrain, le ballon ne va même pas dans le cadre");
							game.alrecap.add("Six mètre tiré par "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName());
							incrementAction(tAtt);
							freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
						}
					}
				}
			}else {
				 //Defender try to get the ball
				game.alrecap.add(nbActions+"min - Tentative de récupération du ballon par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" dans sa surface");
				if(random.nextInt(101) + this.calLuck(-5,11) > defender) {
					
					//Defender get the ball
					game.alrecap.add("Ballon récupérer par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" dans sa surface");
					incrementAction(tAtt);
					def(tDef, tAtt, newPlayer);
				} else {
					//Defender doesn't get the ball but check if he commits a foul or not
					if(random.nextInt(101)  < 85+ this.calLuck(-5,11)) {
						//Ball goes out on defender's pressure
						if(random.nextInt(101)<50) {
							//Corner
							game.alrecap.add("Le ballon est dévié par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName()+" dans sa surface");
							game.alrecap.add("Corner pour l'équipe "+ tAtt.getTeamName()+" tapé par "+player.getLastName());
							incrementAction(tAtt);
							incrementCorners(tAtt);
							freeKick(tAtt, tDef, "att", player);
						}else {
							//Goalie kick
							game.alrecap.add("Le ballon sort suite à la pression de "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
							game.alrecap.add("Six mètre pour l'équipe "+ tDef.getTeamName()+" tapé par "+tDef.getGoalKeeper().getLastName());
							incrementAction(tAtt);
							freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
						}
					} else {
						//Defender commits foul so free kick for attacker
						game.alrecap.add("Faute commis par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
						incrementFouls(tDef);
						getCard(newPlayer, tDef);
						injury(player, tAtt);
						game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName());
						incrementAction(tAtt);
						freeKick(tAtt, tDef, "att", player);
					}
				}
			}
			break;
		case "mid" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("M", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculateKickAtt(tAtt, position, player);
			defender = calculateKickDef(tDef, position, newPlayer);
			goalKeeper = calculateGoalKeeper(tDef);
							
			//Check if defender try to get the ball
			if(random.nextInt(101) > defender + this.calLuck(-5,11)) {
				
				//Attacker will try to kick
				incrementTotalKicks(tAtt);
				game.alrecap.add(nbActions+"min - Tir de "+player.getLastName()+" pour l'équipe "+ tAtt.getTeamName() + " contre l'équipe "+tDef.getTeamName()+" depuis le milieu du terrain");
				
				//Check if the goalkeeper can defend the kick
				if(attacker + this.calLuck(-5,11) > goalKeeper + this.calLuck(-5,11)) {
					//Score a goal
					game.setScore(tAtt);
					game.alrecap.add("But de l'équipe "+ tAtt.getTeamName()+ " marqué par "+player.getLastName());
					game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
					game.alrecap.add("");
					newPlayer = getRandomPlayer("A", tDef, player.getLastName());
					game.alrecap.add("Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement par "+newPlayer.getLastName());
					incrementAction(tAtt);
					mid(tDef, tAtt, newPlayer);
				}else {
					//Check if the goalkeeper can catch the ball
					if(random.nextInt(101)<50) {
						//Goalkeeper catch the ball
						newPlayer = getRandomPlayer("D", tDef, player.getLastName());
						game.alrecap.add("Arrêt de "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName() + " et passe "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "def", newPlayer);
					}else {
						//Check if Goalkeeper touch the ball and then go out or just the kick go out
						if(random.nextInt(101)<50) {
							//Corner
							game.alrecap.add("Le gardien la touche mais le ballon sort du terrain.");
							game.alrecap.add("Corner pour l'équipe "+ tAtt.getTeamName()+" tapé par "+player.getLastName());
							incrementCorners(tAtt);
							incrementAction(tAtt);
							freeKick(tAtt, tDef, "att", player);
						}else {
							//Goalie kick
							game.alrecap.add("Le tir de "+player.getLastName()+" sort du terrain, le ballon ne va même pas dans le cadre");
							game.alrecap.add("Six mètre tiré par "+tDef.getGoalKeeper().getLastName()+" pour l'équipe "+ tDef.getTeamName());
							incrementAction(tAtt);
							freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
						}
					}
				}
			}else {
				//Defender try to get the ball
				game.alrecap.add(nbActions+"min - Tentative de récupération du ballon par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName()+" dans le milieu de terrain");
				if(random.nextInt(101) + this.calLuck(-5,11) > defender) {
					
					//Defender get the ball
					game.alrecap.add("Ballon récupérer par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain");
					incrementAction(tAtt);
					mid(tDef, tAtt, newPlayer);
				} else {
					//Defender doesn't get the ball but check if he commits a foul or not
					if(random.nextInt(101)  < 85+ this.calLuck(-5,11)) {
						//Ball goes out on defender's pressure, check who will have the ball
						if(random.nextInt(101)<50) {
							game.alrecap.add("Le ballon est dévié par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain");
							game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+ " par "+player.getLastName());
							incrementAction(tAtt);
							pass(tAtt, tDef, "mid", player);
						}else {
							game.alrecap.add("Le ballon sort suite à la pression de "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
							game.alrecap.add("Touche pour l'équipe"+ tDef.getTeamName() +" par "+newPlayer.getLastName());
							incrementAction(tAtt);
							pass(tDef, tAtt, "mid", newPlayer);
						}
					} else {
						//Defender commits foul so free kick for attacker
						game.alrecap.add("Faute commis par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
						incrementFouls(tDef);
						getCard(newPlayer, tDef);
						injury(player, tAtt);
						game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName());
						incrementAction(tAtt);
						freeKick(tAtt, tDef, "mid", player);
					}
				}
			}
			break;
		case "def" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("A", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculateKickAtt(tAtt, position, player);
			defender = calculateKickDef(tDef, position, newPlayer);
			
			//Check if there is a foul on the kick
			if(random.nextInt(101)  <85 + this.calLuck(-5,11)) {
				game.alrecap.add(nbActions+"min - Tentative de dégagement par "+player.getLastName()+" de l'équipe "+ tAtt.getTeamName()+" depuis son camp");
				//Check is kick is successful
				if(random.nextInt(101)  < attacker+ this.calLuck(-5,11)) {
					//Check if defender will get the ball
					if(random.nextInt(101)  > defender+ this.calLuck(-5,11)) {
						//Check if it will be a medium or long kick
						incrementTotalPass(tAtt);
						if(random.nextInt(101)  < 60+ this.calLuck(-5,11)) {
							//Medium kick, check who will get the ball
							if(random.nextInt(101)  < 80+ this.calLuck(-5,11)) {
								//Attacker get the ball
								newPlayer = getRandomPlayer("M", tAtt, player.getLastName());
								game.alrecap.add("Dégagement réussi par "+player.getLastName()+" pour l'équipe "+ tAtt.getTeamName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain");
								incrementAction(tAtt);
								incrementPass(tAtt);
								mid(tAtt, tDef,newPlayer);
							} else {
								//Defender get the ball
								newPlayer = getRandomPlayer("M", tDef, player.getLastName());
								game.alrecap.add("Dégagement raté par "+player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain par "+newPlayer.getLastName()+" l'équipe "+tDef.getTeamName()+"");
								incrementAction(tAtt);
								mid(tDef, tAtt, newPlayer);
							}
						} else {
							//Long kick, check who will get the ball
							if(random.nextInt(101)  < 70+ this.calLuck(-5,11)) {
								//Attacker get the ball
								newPlayer = getRandomPlayer("A", tAtt, player.getLastName());
								game.alrecap.add("Dégagement long réussi par "+player.getLastName()+ "pour l'équipe "+ tAtt.getTeamName()+" "+newPlayer.getLastName()+" récupère le ballon en attaque");
								incrementAction(tAtt);
								incrementPass(tAtt);
								att(tAtt, tDef, newPlayer);
							} else {
								//Defender get the ball
								newPlayer = getRandomPlayer("D", tDef, player.getLastName());
								game.alrecap.add("Dégagement long raté par "+player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en défense terrain pour "+tDef.getTeamName());
								incrementAction(tAtt);
								def(tDef, tAtt, newPlayer);
							}
						}
					}
					else {
						//Defender get the ball
						game.alrecap.add(newPlayer.getLastName()+" récupère la balle avant le dégagement de "+ player.getLastName());
						incrementAction(tAtt);
						att(tDef, tAtt, newPlayer);
					}
				}
				else {
					//The ball go out, check who will have the ball
					if(random.nextInt(101) < 50) {
						game.alrecap.add("Le ballon sort suite à la pression de "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
						game.alrecap.add("Touche pour l'équipe"+ tDef.getTeamName() +" par "+newPlayer.getLastName()+" en attaque");
						incrementAction(tAtt);
						pass(tDef, tAtt, "att", newPlayer);
					}
					else {
						game.alrecap.add("Le ballon est dévié par "+newPlayer.getLastName()+" pour l'équipe "+ tDef.getTeamName());
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+ " par "+player.getLastName()+" dans son camp");
						incrementAction(tAtt);
						pass(tAtt, tDef, "def", player);
					}
				}
			}
			else {
				//Defender commits foul so free kick for attacker
				game.alrecap.add(nbActions+"min - Faute commis par "+newPlayer.getLastName()+" de l'équipe "+ tDef.getTeamName());
				incrementFouls(tDef);
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName()+" depuis son camp");
				incrementAction(tAtt);
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
		int attacker, defender;
		Player newPlayer;
		//Use a switch to different position on the field
		switch(position) {
		case "att" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("D", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculateKickAtt(tAtt, position, player);
			defender = calculateKickDef(tDef, position, newPlayer);
			
			game.alrecap.add("L'équipe "+tAtt.getTeamName()+" hésite en la passe et le tir");
			//Check if attacker will try to kick or pass
			if(random.nextInt(101) < 80) {
				//Try to kick
				game.alrecap.add(nbActions+"min - " + player.getLastName() + " tente le tir direct");
				incrementTotalKicks(tAtt);
				
				//Check if the kick will go in the player wall
				if(random.nextInt(101) > defender + this.calLuck(-5,11)) {
					
					//Check if the goalkeeper can defend the kick
					if(attacker + this.calLuck(-5,11) > calculateGoalKeeper(tDef) + this.calLuck(-5,21)) {
						//Score a goal
						game.setScore(tAtt);
						newPlayer = getRandomPlayer("A", tDef, player.getLastName());
						game.alrecap.add("But de l'équipe "+ tAtt.getTeamName() + " !");
						game.alrecap.add("Quelle frappe enroulée de "+player.getLastName()+" sur le tir !");
						game.alrecap.add("Score "+ game.getTeamA().getTeamName() + ": "+ game.getScoreA() + " - "+game.getTeamB().getTeamName() + ": "+ game.getScoreB());
						game.alrecap.add("");
						game.alrecap.add("Retour au milieu pour l'équipe "+tDef.getTeamName()+ " et engagement par "+newPlayer.getLastName());
						incrementAction(tAtt);
						mid(tDef, tAtt, newPlayer);
					}else {
						//Check if the goalkeeper can catch the ball
						if(random.nextInt(101)<50) {
							//Goalkeeper catch the ball
							newPlayer = getRandomPlayer("D", tDef, player.getLastName());
							game.alrecap.add("Ballon arrêté par "+tDef.getGoalKeeper().getLastName()+" de l'équipe "+ tDef.getTeamName() + ", remet en jeu en passant à "+newPlayer.getLastName());
							incrementAction(tAtt);
							pass(tDef, tAtt, "def", newPlayer);
						}else {
							game.alrecap.add("Le ballon sort sur le tir de "+player.getLastName());
							//Check if Goalkeeper touch the ball and then go out or just the kick go out
							if(random.nextInt(101)<50) {
								//Corner
								game.alrecap.add("Le gardien la touche mais le ballon sort du terrain.");
								game.alrecap.add("Corner pour l'équipe "+ tAtt.getTeamName()+" tiré par "+player.getLastName());
								incrementAction(tAtt);
								incrementCorners(tAtt);
								freeKick(tAtt, tDef, "att", player);
							}else {
								//Goalie kick
								game.alrecap.add("Le tir de "+player.getLastName()+" passe totalement à côté de la cage");
								game.alrecap.add("Six mètre pour l'équipe "+ tDef.getTeamName());
								incrementAction(tAtt);
								freeKick(tDef, tAtt, "def", tDef.getGoalKeeper());
							}
						}
					}
				} else {
					//Kick goes in the player wall
					game.alrecap.add("Le tir de "+player.getLastName()+" va dans le mur de joueur de l'équipe "+ tDef.getTeamName()+", "+newPlayer.getLastName()+" récupère la balle dans son camp");
					incrementAction(tAtt);
					def(tDef, tAtt, newPlayer);
				}
				
			} else {
				//Attacker will try to pass the ball
				game.alrecap.add(nbActions+"min - "+ player.getLastName() + " tente la passe en attaque");
				incrementTotalPass(tAtt);
				//Check if the pass is intercept
				if(random.nextInt(101)<95) {
					//Pass successful
					newPlayer = getRandomPlayer("A", tAtt, player.getLastName());
					game.alrecap.add("Passe réussi par "+ player.getLastName() +" à "+newPlayer.getLastName()+", ballon dans la surface");
					incrementPass(tAtt);
					incrementAction(tAtt);
					att(tAtt, tDef, newPlayer);
				}else {
					//Pass intercept
					newPlayer = getRandomPlayer("D", tDef, player.getLastName());
					game.alrecap.add("Passe raté par "+ player.getLastName() +", "+ newPlayer.getLastName()+" récupère la balle dans son camp");
					incrementAction(tAtt);
					def(tDef, tAtt, newPlayer);
				}
			}
			break;
		case "mid" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("M", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculateKickAtt(tAtt, position, player);
			defender = calculateKickDef(tDef, position, newPlayer);
			
			game.alrecap.add("L'équipe "+tAtt.getTeamName()+" hésite en la passe et le dégagement");
			//Check if attacker will try to kick or pass
			if(random.nextInt(101) < 40) {
				game.alrecap.add(nbActions+"min - Tentative de dégagement depuis le milieu du terrain par "+ player.getLastName());
				//Check if kick is successful
				incrementTotalPass(tAtt);
				if(random.nextInt(101) + this.calLuck(-5,11) < attacker) {
					//Check who will get the ball
					if(random.nextInt(101)  < defender + this.calLuck(-5,11)) {
						//Attacker get the ball
						newPlayer = getRandomPlayer("A", tAtt, player.getLastName());
						game.alrecap.add("Dégagement long réussi par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en attaque");
						incrementPass(tAtt);
						incrementAction(tAtt);
						att(tAtt, tDef, newPlayer);
					} else {
						//Defender get the ball
						newPlayer = getRandomPlayer("D", tDef, player.getLastName());
						game.alrecap.add("Dégagement long raté par "+ player.getLastName()+", l'équipe "+tDef.getTeamName()+" récupère le ballon au milieu du terrain par l'intermédiaire de "+newPlayer.getLastName());
						incrementAction(tAtt);
						def(tDef, tAtt, newPlayer);
					}
				}
				//Bad kick 
				else {
					//Check who pulls out the ball
					if(random.nextInt(101) < 50) {
						newPlayer = getRandomPlayer("D", tDef, player.getLastName());
						game.alrecap.add("Le ballon sort suite à la pression de "+newPlayer.getLastName());
						game.alrecap.add("Touche pour l'équipe"+ tDef.getTeamName()+ " au milieu du terrain, remis en jeu par "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "mid", newPlayer);
					}
					else {
						newPlayer = getRandomPlayer("D", tDef, player.getLastName());
						game.alrecap.add("Le ballon est dévié par "+ newPlayer.getLastName()+" au milieu du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+ " au milieu du terrain, remis en jeu par "+player.getLastName());
						incrementAction(tAtt);
						pass(tAtt, tDef, "mid", player);
					}
				}
				//Pass
			} else {
				game.alrecap.add(nbActions+"min - "+ player.getLastName() + " tente la passe depuis le milieu du terrain");
				incrementTotalPass(tAtt);
				//Check if the ball will be intercept
				if(random.nextInt(101)<=95) {
					//Pass successful
					newPlayer = getRandomPlayer("M", tAtt, player.getLastName());
					game.alrecap.add("Passe réussi par "+ player.getLastName()+ " à "+newPlayer.getLastName()+", ballon au milieu du terrain");
					incrementPass(tAtt);
					incrementAction(tAtt);
					mid(tAtt, tDef, newPlayer);
				}else {
					//Defender intercepts the pass
					game.alrecap.add("Passe raté par "+ player.getLastName()+", "+ newPlayer.getLastName()+" récupère la balle au milieu du terrain");
					incrementAction(tAtt);
					mid(tDef, tAtt, newPlayer);
				}
			}
			break;
		case "def" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("A", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculateKickAtt(tAtt, position, player);
			defender = calculateKickDef(tDef, position, newPlayer);
			
			//Check if attacker will try to kick or pass
			if(random.nextInt(101) < 30) {
				game.alrecap.add(nbActions+"min - Tentative de dégagement par "+player.getLastName()+" de l'équipe "+ tAtt.getTeamName()+" depuis son camp");
				//Check if kick is successful
				if(random.nextInt(101)  < attacker+ this.calLuck(-5,11)) {
					incrementTotalPass(tAtt);
					//Check if it will be a medium or long kick
					if(random.nextInt(101) < 60) {
						//Check who will get the ball
						if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
							//Attacker get the ball
							newPlayer = getRandomPlayer("M", tAtt, player.getLastName());
							game.alrecap.add("Dégagement réussi par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain");
							incrementPass(tAtt);
							incrementAction(tAtt);
							mid(tAtt, tDef, newPlayer);
						} else {
							//Defender get the ball
							newPlayer = getRandomPlayer("M", tDef, player.getLastName());
							game.alrecap.add("Dégagement raté par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon au milieu du terrain");
							incrementAction(tAtt);
							mid(tDef, tAtt, newPlayer);
						}
					} else {
						//Check who will get the ball
						if(random.nextInt(101) + this.calLuck(-5,11) < 80) {
							//Attacker get the ball
							newPlayer = getRandomPlayer("A", tAtt, player.getLastName());
							game.alrecap.add("Dégagement long réussi par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en attaque");
							incrementPass(tAtt);
							incrementAction(tAtt);
							att(tAtt, tDef, newPlayer);
						} else {
							//Defender get the ball
							newPlayer = getRandomPlayer("D", tDef, player.getLastName());
							game.alrecap.add("Dégagement long raté par "+ player.getLastName()+", "+newPlayer.getLastName()+" récupère le ballon en défense");
							incrementAction(tAtt);
							def(tDef, tAtt, newPlayer);
						}
					}
					//Bad kick 
				}else {
					//Defender get tje ball
					game.alrecap.add("Le ballon par vers la touche suite au dégagement de "+player.getLastName());
					newPlayer = getRandomPlayer("M", tDef, player.getLastName());
					game.alrecap.add("Touche pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain, remis en jeu par"+newPlayer.getLastName());
					incrementAction(tAtt);
					pass(tDef, tAtt, "mid", newPlayer);
				}
				//Pass
			} else {
				game.alrecap.add(nbActions+"min - L'équipe "+ tAtt.getTeamName()+ " tente la passe depuis leur camp");
				incrementTotalPass(tAtt);
				//Check if the ball will be intercept
				if(random.nextInt(101)<=98) {
					//Pass successful
					newPlayer = getRandomPlayer("D", tAtt, player.getLastName());
					game.alrecap.add("Passe réussi par "+ player.getLastName()+" à "+newPlayer.getLastName()+" ballon en défense");
					incrementPass(tAtt);
					incrementAction(tAtt);
					def(tAtt, tDef, newPlayer);
				}else {
					//Defender intercepts the pass
					game.alrecap.add("Passe raté par "+ player.getLastName()+", "+ newPlayer.getLastName()+" récupère le ballon dans la surface");
					incrementAction(tAtt);
					att(tDef, tAtt, newPlayer);
				}
			}
			break;
		}
	}

	
	private void pass(Team tAtt, Team tDef, String position, Player player) {
		int attacker, defender;
		Player newPlayer;
		//Use a switch to different position on the field
		switch(position) {		
		case "att" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("D", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculatePassAtt(tAtt, position, player);
			defender = calculatePassDef(tDef, position, newPlayer);
			
			//Check if there is a foul on the pass
			if(random.nextInt(101)  < 85  + this.calLuck(-5,11)) {
				incrementTotalPass(tAtt);
				//Check if it is a good pass
				if(random.nextInt(101)  < attacker + this.calLuck(-5,11)) {
					//Check if defender intercept the pass
					if(random.nextInt(101)  > defender + this.calLuck(-5,11)) {
						//Pass successful
						newPlayer = getRandomPlayer("A", tAtt, player.getLastName());
						game.alrecap.add(nbActions+"min - Passe réussi par "+player.getLastName()+" à "+newPlayer.getLastName()+", il conserve la balle en attaque");
						incrementPass(tAtt);
						incrementAction(tAtt);
						att(tAtt, tDef, newPlayer);
					}
					else {
						//Defender get the ball
						game.alrecap.add(nbActions+"min - Passe interceptée par "+ newPlayer.getLastName()+", il récupère la balle dans sa surface");
						incrementAction(tAtt);
						def(tDef, tAtt, newPlayer);
					}
				}
				//Bas pass
				else {
					//Check who push out the ball
					if(random.nextInt(101) < 50) {
						game.alrecap.add(nbActions+"min - Passe raté par "+player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tDef.getTeamName()+" dans leur camp, remis en jeu par "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "def", newPlayer);
					}
					else {
						game.alrecap.add(nbActions+"min - Passe déviée par "+ newPlayer.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+" en attaque, remis en jeu par "+player.getLastName());
						incrementAction(tAtt);
						pass(tAtt, tDef, "att", player);
					}
				}
			}
			else {
				//Foul commit by the defender on the pass
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName() +" tente de récupérer la balle mais commet une faute");
				incrementFouls(tDef);
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de marquer");
				incrementAction(tAtt);
				freeKick(tAtt, tDef, "att", player);
			}
			break;
		case "mid" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("M", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculatePassAtt(tAtt, position, player);
			defender = calculatePassDef(tDef, position, newPlayer);
			
			//Check if there is a foul on the pass
			if(random.nextInt(101)  < 85+ this.calLuck(-5,11)) {
				incrementTotalPass(tAtt);
				//Check if it is a good pass
				if(random.nextInt(101)  < attacker+ this.calLuck(-5,11)) {
					//Check if defender intercept the pass
					if(random.nextInt(101)  < defender+ this.calLuck(-5,11)) {
						//Pass successful
						newPlayer = getRandomPlayer("A", tAtt, player.getLastName());
						game.alrecap.add(nbActions+"min - Passe réussi par "+player.getLastName()+" à "+newPlayer.getLastName()+" il passe en attaque");
						incrementPass(tAtt);
						incrementAction(tAtt);
						att(tAtt, tDef, newPlayer);
					}
					else {
						//Defender get the ball
						game.alrecap.add(nbActions+"min - Passe interceptée par "+ newPlayer.getLastName()+", il récupère la balle au milieu du terrain");
						incrementAction(tAtt);
						mid(tDef, tAtt, newPlayer);
					}
				}
				//Bas pass
				else {
					//Check who push out the ball
					if(random.nextInt(101) < 50) {
						game.alrecap.add(nbActions+"min - Passe raté par "+player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain remis en jeu par "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "mid", newPlayer);
					}
					else {
						game.alrecap.add(nbActions+"min - Passe déviée par l'équipe "+ newPlayer.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+" au milieu du terrain remis en jeu par "+player.getLastName());
						incrementAction(tAtt);
						pass(tAtt, tDef, "mid", player);
					}
				}
			}
			else {
				//Foul commit by the defender on the pass
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				incrementFouls(tDef);
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+", par "+player.getLastName() +" au milieu du terrain");
				incrementAction(tAtt);
				freeKick(tAtt, tDef, "mid", player);
			}
			break;
		case "def" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("A", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculatePassAtt(tAtt, position, player);
			defender = calculatePassDef(tDef, position, newPlayer);
			
			//Check if there is a foul on the pass
			if(random.nextInt(101)  < 90 + this.calLuck(-5,11)) {
				incrementTotalPass(tAtt);
				//Check if it is a good pass
				if(random.nextInt(101)  < attacker+ this.calLuck(-5,11)) {
					//Check if defender intercept the pass
					if(random.nextInt(101)  < defender+ this.calLuck(-5,11)) {
						//Pass successful
						newPlayer = getRandomPlayer("M", tAtt, player.getLastName());
						game.alrecap.add(nbActions+"min - Passe réussi par "+player.getLastName()+" à "+newPlayer.getLastName()+" il passe au milieu du terrain");
						incrementPass(tAtt);
						incrementAction(tAtt);
						mid(tAtt, tDef, newPlayer);
					}
					else {
						//Defender get the ball
						game.alrecap.add(nbActions+"min - Passe interceptée par "+ newPlayer.getLastName()+" il récupère la balle et peut directement attaquer");
						incrementAction(tAtt);
						att(tDef, tAtt, newPlayer);
					}
				}
				//Bad pass
				else {
					//Check who push out the ball
					if(random.nextInt(101) < 50) {
						game.alrecap.add(nbActions+"min - Passe raté par "+player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tDef.getTeamName()+" en attaque remis en jeu par "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "att", newPlayer);
					}
					else {
						game.alrecap.add(nbActions+"min - Passe déviée par "+ newPlayer.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+" dans leur camp remis en jeu par "+player.getLastName());
						incrementAction(tAtt);
						pass(tAtt, tDef, "def", player);
					}
				}
			}
			else {
				//Foul commit by the defender on the pass
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				incrementFouls(tDef);
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de se dégager de son camp");
				incrementAction(tAtt);
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
		int attacker, defender;
		Player newPlayer;
		//Use a switch to different position on the field
		switch(position) {
		case "att" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("D", tDef, player.getLastName());
			
			//Force is calculated according to statistics
			attacker = calculateDribbleAtt(tAtt, position, player);
			defender = calculateDribbleDef(tDef, position, newPlayer);
			
			//Check if there is a foul on the dribble
			if(random.nextInt(101) <85  + this.calLuck(-5,11)) {
				//Check if it is a good dribble
				if(random.nextInt(101)  < attacker + this.calLuck(-5,11)) {
					//Check if defender intercept the dribble
					if(random.nextInt(101)  > defender + this.calLuck(-5,11)) {
						//Dribble successful
						game.alrecap.add(nbActions+"min - Dribble réussi par "+ player.getLastName()+" il conserve la balle en attaque");
						incrementAction(tAtt);
						att(tAtt, tDef, player);
					}
					else {
						//Defender get the ball
						game.alrecap.add(nbActions+"min - Ballon récupéré par "+ newPlayer.getLastName()+" sur le dribble de "+player.getLastName()+", il récupère la balle dans sa surface");
						incrementAction(tAtt);
						def(tDef, tAtt, newPlayer);
					}
				}
				//Bad dribble
				else {
					//Check who push out the ball
					if(random.nextInt(101) < 50) {
						game.alrecap.add(nbActions+"min - Dribble raté par "+ player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tDef.getTeamName()+" dans leur camp remis en jeu par "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "def", newPlayer);
					}
					else {
						game.alrecap.add(nbActions+"min - "+ player.getLastName()+" tente de dribbler "+newPlayer.getLastName()+" mais il sort le ballon du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+" en attaque remis en jeu par "+player.getLastName());
						incrementAction(tAtt);
						pass(tAtt, tDef, "att", player);
					}
				}
			}
			else {
				//Foul commit by the defender on the dribble
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				incrementFouls(tDef);
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de marquer");
				incrementAction(tAtt);
				freeKick(tAtt, tDef, "att", player);
			}
			break;
		case "mid" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("M", tDef, player.getLastName());
			
			attacker = calculateDribbleAtt(tAtt, position, player);
			defender = calculateDribbleDef(tDef, position, newPlayer);
			
			//Check if there is a foul on the dribble
			if(random.nextInt(101)  <85 + this.calLuck(-5,11)) {
				//Check if it is a good dribble
				if(random.nextInt(101)  < attacker + this.calLuck(-5,11)) {
					//Check if defender intercept the dribble
					if(random.nextInt(101)  > defender + this.calLuck(-5,11)) {
						//Dribble successful
						game.alrecap.add(nbActions+"min - Dribble réussi par "+ player.getLastName()+" il passe en attaque");
						incrementAction(tAtt);
						att(tAtt, tDef, player);
					}
					else {
						//Defender get the ball
						game.alrecap.add(nbActions+"min - Ballon récupéré par "+ newPlayer.getLastName()+" sur le dribble de "+player.getLastName()+", il récupère la balle au milieu du terrain");
						incrementAction(tAtt);
						mid(tDef, tAtt, newPlayer);
					}
				}
				//Bad dribble
				else {
					//Check who push out the ball
					if(random.nextInt(101) < 50) {
						game.alrecap.add(nbActions+"min - Dribble raté par "+ player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("min - Touche pour l'équipe "+ tDef.getTeamName()+" au milieu du terrain remis en jeu par "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "mid", newPlayer);
					}
					else {
						game.alrecap.add(nbActions+"min - "+ player.getLastName()+" tente de dribbler "+newPlayer.getLastName()+" mais il sort le ballon du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+" au milieu du terrain remis en jeu par "+player.getLastName());
						incrementAction(tAtt);
						pass(tAtt, tDef, "mid", player);
					}
				}
			}
			else {
				//Foul commit by the defender on the dribble
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				incrementFouls(tDef);
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+", par "+player.getLastName() +" au milieu du terrain");
				incrementAction(tAtt);
				freeKick(tAtt, tDef, "mid", player);
			}
			break;
		case "def" : 
			//Get random player who will defend
			newPlayer = getRandomPlayer("A", tDef, player.getLastName());
			
			attacker = calculateDribbleAtt(tAtt, position, player);
			defender = calculateDribbleDef(tDef, position, newPlayer);
			
			//Check if there is a foul on the dribble
			if(random.nextInt(101)  <90 + this.calLuck(-5,11)) {
				//Check if it is a good dribble
				if(random.nextInt(101)  < attacker + this.calLuck(-5,11)) {
					//Check if defender intercept the dribble
					if(random.nextInt(101)  > defender + this.calLuck(-5,11)) {
						//Dribble successful
						game.alrecap.add(nbActions+"min - Dribble réussi par "+ player.getLastName()+" il passe au milieu");
						incrementAction(tAtt);
						mid(tAtt, tDef, player);
					}
					else {
						//Defender get the ball
						game.alrecap.add(nbActions+"min - Ballon récupéré par "+ newPlayer.getLastName() +" sur le dribble de "+player.getLastName()+", il récupère la balle dans sa surface");
						incrementAction(tAtt);
						att(tDef, tAtt, newPlayer);
					}
				}
				//Bad dribble
				else {
					//Check who push out the ball
					if(random.nextInt(101) < 50) {
						game.alrecap.add(nbActions+"min - Dribble raté par "+ player.getLastName()+" et le ballon sort du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tDef.getTeamName()+" en attaque remis en jeu par "+newPlayer.getLastName());
						incrementAction(tAtt);
						pass(tDef, tAtt, "att", newPlayer);
					}
					else {
						game.alrecap.add(nbActions+"min - "+ player.getLastName()+" tente de dribbler "+newPlayer.getLastName()+" mais il sort le ballon du terrain");
						game.alrecap.add("Touche pour l'équipe "+ tAtt.getTeamName()+" dans leur camp remis en jeu par "+player.getLastName());
						incrementAction(tAtt);
						pass(tAtt, tDef, "def", player);
					}
				}
			}
			else {
				//Foul commit by the defender on the dribble
				game.alrecap.add(nbActions+"min - "+ newPlayer.getLastName()+" tente de récupérer la balle mais commet une faute");
				incrementFouls(tDef);
				getCard(newPlayer, tDef);
				injury(player, tAtt);
				game.alrecap.add("Coup franc pour l'équipe "+ tAtt.getTeamName()+", "+player.getLastName()+" peut tenter de se dégager de son camp");
				incrementAction(tAtt);
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
	
	
	private Player getRandomPlayer(String position, Team team, String name) {
		//Get the starter player and put them in array by there positions
		ArrayList<Player> def = new ArrayList<Player>();
		ArrayList<Player> mid = new ArrayList<Player>();
		ArrayList<Player> att = new ArrayList<Player>();
		ArrayList<Player> alPlayer = new ArrayList<Player>();
		Player player = new Player();
		
		//Check in which team we get player
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			alPlayer = alPlayerStarterTeamA;
		}
		else {
			alPlayer = alPlayerStarterTeamB;
		}
		
		//Put players in arrays
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
				
		//Get random player by his position 
		if(position.equals("A")) {
			if(att.size()!=0) {
				player = att.get(random.nextInt(att.size()));
			} else if(mid.size()!=0) {
				player = mid.get(random.nextInt(mid.size()));
			} else if(def.size()!=0) {
				player = def.get(random.nextInt(def.size()));
			}
		}
		else if(position.equals("M")) {
			if(mid.size()!=0) {
				player = mid.get(random.nextInt(mid.size()));
			} else if(att.size()!=0) {
				player = att.get(random.nextInt(att.size()));
			} else if(def.size()!=0) {
				player = def.get(random.nextInt(def.size()));
			}
		}
		else if(position.equals("D")) {
			if(def.size()!=0) {
				player = def.get(random.nextInt(def.size()));
			} else if(mid.size()!=0) {
				player = mid.get(random.nextInt(mid.size()));
			} else if(att.size()!=0) {
				player = att.get(random.nextInt(att.size()));
			}
		}
		
		if((att.size() < 2) || (def.size() < 2) || (mid.size() < 2)) {
			System.out.println("////////////////////// att "+att.size()+" def "+def.size()+" mid "+mid.size());
		}
		//Check if the new player name is note equals to the current player name
		if(name.equals(player.getLastName())) {
			System.out.println(" Player "+name+" newplayer "+ player.getLastName());
			player = getRandomPlayer(position, team, name);
		}
		
		return player;
	}

	
	private Player getRandomBenchPlayer(String position, ArrayList<Player> al) {
		//Get the starter player and put them in array by there positions
		ArrayList<Player> def = new ArrayList<Player>();
		ArrayList<Player> mid = new ArrayList<Player>();
		ArrayList<Player> att = new ArrayList<Player>();
		Player player = new Player();
		
		//Put players in arrays
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
		
		//Get random player by his position
		if(position.equals("A")) {
			if(att.size()!=0) {
				player = att.get(random.nextInt(att.size()));
			} else if(mid.size()!=0) {
				player = mid.get(random.nextInt(mid.size()));
			} else if(def.size()!=0) {
				player = def.get(random.nextInt(def.size()));
			}
		}
		else if(position.equals("M")) {
			if(mid.size()!=0) {
				player = mid.get(random.nextInt(mid.size()));
			} else if(att.size()!=0) {
				player = att.get(random.nextInt(att.size()));
			} else if(def.size()!=0) {
				player = def.get(random.nextInt(def.size()));
			}
		}
		else if(position.equals("D")) {
			if(def.size()!=0) {
				player = def.get(random.nextInt(def.size()));
			} else if(mid.size()!=0) {
				player = mid.get(random.nextInt(mid.size()));
			} else if(att.size()!=0) {
				player = att.get(random.nextInt(att.size()));
			}
		}
		
		player.setPosition(position);
		return player;
	}
	
	
	private void incrementAction(Team team) {
		//Random to choose if action take 1 or 2 nbrActions
		if(random.nextInt(101) > 50) {
			if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
				game.incrementNbrActionsA();
			}
			else {
				game.incrementNbrActionsB();
			}
			this.nbActions++;
		}else {
			if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
				game.incrementNbrActionsA();
				game.incrementNbrActionsA();
			}
			else {
				game.incrementNbrActionsB();
				game.incrementNbrActionsB();
			}
			this.nbActions = this.nbActions+2;
		}
		
	}
	
	private void injury(Player player, Team team) {
		Player newPlayer;
		
		//Check player's position
		if(player.getPosition().contentEquals("A")) {
			//Check if the player is injured
			if(random.nextInt(101) > 97) {
				//Check the team to make replacement
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
			//Check if the player is injured
			if(random.nextInt(101) > 98) {
				//Check the team to make replacement
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
			//Check if the player is injured
			if(random.nextInt(101) > 99) {
				//Check the team to make replacement
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
		//Check the team to get the players starter array
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			alPlayer = alPlayerStarterTeamA;
		}
		else {
			alPlayer = alPlayerStarterTeamB;
		}
		
		//Check player's position
		if(player.getPosition().contentEquals("A")) {
			//Check if the player get a card
			if(random.nextInt(101) > 98) {
				//Check if it is a red or yellow card
				if(random.nextInt(101)>98) {
					//Red card
					game.alrecap.add(player.getLastName()+" commet une très grosse faute, il prend un carton rouge !");
					player.setRedCard(true);
					alPlayer.remove(player);
				}else {
					//Yellow card, check if the player already had a yellow card
					if(player.getYellowCard()) {
						//Red card
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune mais en avait déjà un donc c'est le rouge !");
						player.setRedCard(true);
						alPlayer.remove(player);
					}else {
						//Yellow card
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune !");
						player.setYellowCard(true);
					}
				}
			}
		} else if(player.getPosition().contentEquals("M")) {
			//Check if the player get a card
			if(random.nextInt(101) > 95) {
				//Check if it is a red or yellow card
				if(random.nextInt(101)>97) {
					//Red card
					game.alrecap.add(player.getLastName()+" commet une très grosse faute, il prend un carton rouge !");
					player.setRedCard(true);
					alPlayer.remove(player);
				}else {
					//Yellow card, check if the player already had a yellow card
					if(player.getYellowCard()) {
						//Red card
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune mais en avait déjà un donc c'est le rouge !");
						player.setRedCard(true);
						alPlayer.remove(player);
					}else {
						//Yellow card
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune !");
						player.setYellowCard(true);
					}
				}
			}
		} else if(player.getPosition().contentEquals("D")) {
			//Check if the player get a card
			if(random.nextInt(101) > 90) {
				//Check if it is a red or yellow card
				if(random.nextInt(101)>96) {
					//Red card
					game.alrecap.add(player.getLastName()+" commet une très grosse faute, il prend un carton rouge !");
					player.setRedCard(true);
					alPlayer.remove(player);
				}else {
					//Yellow card, check if the player already had a yellow card
					if(player.getYellowCard()) {
						//Red card
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune mais en avait déjà un donc c'est le rouge !");
						player.setRedCard(true);
						alPlayer.remove(player);
					}else {
						//Yellow card
						game.alrecap.add(player.getLastName()+" commet une faute, il prend un carton jaune !");
						player.setYellowCard(true);
					}
				}
			}
		}
		
		checkNumberPlayerByPosition(team);
	}
	
	private void checkNumberPlayerByPosition(Team team) {
		ArrayList<Player> alPlayer = new ArrayList<Player>();
		Player player = new Player();
		//Check the team to get the players starter array
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			alPlayer = alPlayerStarterTeamA;
		}
		else {
			alPlayer = alPlayerStarterTeamB;
		}
		
		ArrayList<Player> def = new ArrayList<Player>();
		ArrayList<Player> mid = new ArrayList<Player>();
		ArrayList<Player> att = new ArrayList<Player>();
		
		//Put players in arrays
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
		
		if(att.size()<2) {
			if(mid.size()>2) {
				player = mid.get(random.nextInt(mid.size()));
				mid.remove(player);
				player.setPosition("A");
				att.add(player);
			}else if(def.size()>2) {
				player = def.get(random.nextInt(def.size()));
				def.remove(player);
				player.setPosition("A");
				att.add(player);
			} else {
				game.alrecap.add("L'équipe "+team.getTeamName()+" n'a plus assez de joueur pour continuer le match, elle doit déclarer forfait !");
				if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
					game.setScoreA(0);
					game.setScoreB(3);
				}
				else {
					game.setScoreA(3);
					game.setScoreB(0);
				}
				return;
			}
		} else if(mid.size()<2) {
			if(mid.size()>2) {
				player = att.get(random.nextInt(att.size()));
				att.remove(player);
				player.setPosition("M");
				mid.add(player);
			}else if(def.size()>2) {
				player = def.get(random.nextInt(def.size()));
				def.remove(player);
				player.setPosition("M");
				mid.add(player);
			}else {
				game.alrecap.add("L'équipe "+team.getTeamName()+" n'a plus assez de joueur pour continuer le match, elle doit déclarer forfait !");
				if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
					game.setScoreA(0);
					game.setScoreB(3);
				}
				else {
					game.setScoreA(3);
					game.setScoreB(0);
				}
				return;
			}
		} else if(def.size()<2) {
			if(mid.size()>2) {
				player = mid.get(random.nextInt(mid.size()));
				mid.remove(player);
				player.setPosition("D");
				def.add(player);
			}else if(att.size()>2) {
				player = att.get(random.nextInt(att.size()));
				att.remove(player);
				player.setPosition("D");
				def.add(player);
			}else {
				game.alrecap.add("L'équipe "+team.getTeamName()+" n'a plus assez de joueur pour continuer le match, elle doit déclarer forfait !");
				if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
					game.setScoreA(0);
					game.setScoreB(3);
				}
				else {
					game.setScoreA(3);
					game.setScoreB(0);
				}
				return;
			}
		}
		
	}
	
	private int calLuck(int min, int max) {
		return this.random.nextInt(max)+min;
	}
	
	private void incrementTotalPass(Team team) {
		//Check wich team
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			game.incrementTotalPassA();
		}
		else {
			game.incrementTotalPassB();
		}
	}	
	
	private void incrementPass(Team team) {
		//Check wich team
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			game.incrementPassA();
		}
		else {
			game.incrementPassB();
		}
	}
	
	private void incrementFouls(Team team) {
		//Check wich team
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			game.incrementFoulsA();
		}
		else {
			game.incrementFoulsB();
		}
	}	
	
	private void incrementCorners(Team team) {
		//Check wich team
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			game.incrementCornersA();
		}
		else {
			game.incrementCornersB();
		}
	}
	
	private void incrementTotalKicks(Team team) {
		//Check wich team
		if(team.getTeamName().equals(game.getTeamA().getTeamName())) {
			game.incrementTotalKickA();
		}
		else {
			game.incrementTotalKickB();
		}
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
