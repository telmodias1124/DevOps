package process;

import java.util.ArrayList;
import java.util.Random;

import data.GroupPhase;
import data.Match;
import data.Standing;
import data.Team;

public class GroupPhaseSimulation {
	public GroupPhase gp;
	private MatchSimulation ms;
	private Random r;
	public ArrayList<Team> al;
	private ArrayList<Team> allTirage;
	
	
	
	
	public GroupPhaseSimulation() {
		
		this.r = new Random();
		this.gp = new GroupPhase();
		this.ms = new MatchSimulation();
		
	}
	public void simulate() {
		createGroups(al);
		createMatchGroupe(gp);
		simulateMatchGroupe();
		updateStandings();
	}
	/* ou passer l'arraylist des equipes */
	private void createGroups(ArrayList<Team> alTeams) {
		allTirage = (ArrayList<Team>)al.clone();
		int tirage;
		for(int i=0; i<4; i++) {
			//allTirage.get(r.nextInt(16));
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupA().add(allTirage.get(tirage));
			allTirage.remove(tirage);
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupB().add(allTirage.get(tirage));
			allTirage.remove(tirage);
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupC().add(allTirage.get(tirage));
			allTirage.remove(tirage);
			
			tirage = r.nextInt(allTirage.size());
			gp.getGroupD().add(allTirage.get(tirage));
			allTirage.remove(tirage);
		}
	}
	
	private void createMatchGroupe(GroupPhase gp) {
		for(int i=0; i<4; i++) {
			for(int j=i+1; j<4; j++) {
				gp.getListMatchGroupA().add(new Match(gp.getGroupA().get(i),gp.getGroupA().get(j)));
				gp.getListMatchGroupB().add(new Match(gp.getGroupB().get(i),gp.getGroupB().get(j)));
				gp.getListMatchGroupC().add(new Match(gp.getGroupC().get(i),gp.getGroupC().get(j)));
				gp.getListMatchGroupD().add(new Match(gp.getGroupD().get(i),gp.getGroupD().get(j)));

			}
		}
		
	}
	
	public void simulateMatchGroupe() {
		for(int i=0; i<gp.getListMatchGroupA().size(); i++) {
			
			ms.setGame(gp.getListMatchGroupA().get(i));
			ms.simulate2();
			/*ms.setGame(gp.getListMatchGroupB().get(i));
			ms.simulate2();
			ms.setGame(gp.getListMatchGroupC().get(i));
			ms.simulate2();
			ms.setGame(gp.getListMatchGroupD().get(i));
			ms.simulate2();*/
			
		}
	}
	
	
	
	private void sortGroupByPoints(ArrayList<Team> alT, Standing s) {
		Team t;
		int i=0;
		allTirage = (ArrayList<Team>)alT.clone();
		while(allTirage.size() > 0 ) {
			t = allTirage.get(0);
			for(Team t2 : allTirage) {
				if (t2.getNbPoints() >= t.getNbPoints()) {
					if(t2.getNbPoints() == t.getNbPoints()) {
						if(t2.getGoals() > t.getGoals() ) {
							t = t2;
						}
					}
					else {
						t = t2;
					}
				}
			}
			switch(i) {
			case 0 :
				s.setFirst(t);
				break;
			case 1 :
				s.setSecond(t);
				break;
			case 2 :
				s.setThird(t);
				break;
			case 3 :
				s.setFourth(t);
				break;
			default :
				System.out.println("Erreur dans le classement");
			}
			i++;
			//System.out.println("Team : " + t.getTeamName() + " points : " + t.getNbPoints());
			allTirage.remove(t);
		}
		//System.out.println("");
	}
	
	private void updateStandings() {
		sortGroupByPoints(this.gp.getGroupA(), this.gp.getStandingGroupA());
		sortGroupByPoints(this.gp.getGroupB(), this.gp.getStandingGroupB());
		sortGroupByPoints(this.gp.getGroupC(), this.gp.getStandingGroupC());
		sortGroupByPoints(this.gp.getGroupD(), this.gp.getStandingGroupD());
		
		
	}
	
	
	public String groupToString(){
		String res ="Group A : ";
		for(int i=0; i<this.gp.getGroupA().size(); i++) {
			res+= this.gp.getGroupA().get(i).getTeamName() + " ";
		}
		res+="\n";
		
		res +="Group B : ";
		for(int i=0; i<this.gp.getGroupB().size(); i++) {
			res+= this.gp.getGroupB().get(i).getTeamName() + " ";
		}
		res+="\n";
		
		res +="Group C : ";
		for(int i=0; i<this.gp.getGroupC().size(); i++) {
			res+= this.gp.getGroupC().get(i).getTeamName() + " ";
		}
		res+="\n";
		
		res +="Group D : ";
		for(int i=0; i<this.gp.getGroupD().size(); i++) {
			res+= this.gp.getGroupD().get(i).getTeamName() + " ";
		}
		res+="\n";
		return res;
	}
	
	public String matchsToString() {
		String res="Match Results : \n \n";
		
		res+="Group A : \n";
		for(Match t : this.gp.getListMatchGroupA()) {
			res+=t.getTeamA().getTeamName() + " " + t.getScoreA() + " - " + t.getScoreB() + " "+ t.getTeamB().getTeamName() + "\n";
		}
		
		res+="\nGroup B : \n";
		for(Match t : this.gp.getListMatchGroupB()) {
			res+=t.getTeamA().getTeamName() + " " + t.getScoreA() + " - " + t.getScoreB() + " "+ t.getTeamB().getTeamName() + "\n";
		}
		
		res+="\nGroup C : \n";
		for(Match t : this.gp.getListMatchGroupC()) {
			res+=t.getTeamA().getTeamName() + " " + t.getScoreA() + " - " + t.getScoreB() + " "+ t.getTeamB().getTeamName() + "\n";
		}
		
		res+="\nGroup D : \n";
		for(Match t : this.gp.getListMatchGroupD()) {
			res+=t.getTeamA().getTeamName() + " " + t.getScoreA() + " - " + t.getScoreB() + " "+ t.getTeamB().getTeamName() + "\n";
		}
		return res;
	}
	
	public String standingToString() {
		String res="Standing : \n";
		res+="Group A \t Group B \t Group C \t Group D\n";
		res+= this.gp.getStandingGroupA().getFirst().getTeamName() + " - "+ this.gp.getStandingGroupA().getFirst().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupB().getFirst().getTeamName() + " - "+ this.gp.getStandingGroupB().getFirst().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupC().getFirst().getTeamName() + " - "+ this.gp.getStandingGroupC().getFirst().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupD().getFirst().getTeamName() + " - "+ this.gp.getStandingGroupD().getFirst().getNbPoints() + "\t";
		res+="\n";
		
		res+= this.gp.getStandingGroupB().getSecond().getTeamName() + " - "+ this.gp.getStandingGroupA().getSecond().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupB().getSecond().getTeamName() + " - "+ this.gp.getStandingGroupB().getSecond().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupC().getSecond().getTeamName() + " - "+ this.gp.getStandingGroupC().getSecond().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupD().getSecond().getTeamName() + " - "+ this.gp.getStandingGroupD().getSecond().getNbPoints() + "\t";
		res+="\n";
		
		res+= this.gp.getStandingGroupA().getThird().getTeamName() + " - "+ this.gp.getStandingGroupA().getThird().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupB().getThird().getTeamName() + " - "+ this.gp.getStandingGroupB().getThird().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupC().getThird().getTeamName() + " - "+ this.gp.getStandingGroupC().getThird().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupD().getThird().getTeamName() + " - "+ this.gp.getStandingGroupD().getThird().getNbPoints() + "\t";
		res+="\n";
		
		res+= this.gp.getStandingGroupA().getFourth().getTeamName() + " - "+ this.gp.getStandingGroupA().getFourth().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupB().getFourth().getTeamName() + " - "+ this.gp.getStandingGroupB().getFourth().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupC().getFourth().getTeamName() + " - "+ this.gp.getStandingGroupC().getFourth().getNbPoints() + "\t";
		res+= this.gp.getStandingGroupD().getFourth().getTeamName() + " - "+ this.gp.getStandingGroupD().getFourth().getNbPoints() + "\t";
		res+="\n";
		
		return res;
	}
}
