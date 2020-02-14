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
	private Standing standingGroupA, standingGroupB, standingGroupC, standingGroupD; 
	
	
	
	public GroupPhaseSimulation() {
		
		this.r = new Random();
		this.gp = new GroupPhase();
		this.ms = new MatchSimulation();
		this.standingGroupA = new Standing();
		this.standingGroupB = new Standing();
		this.standingGroupC = new Standing();
		this.standingGroupD = new Standing();
		
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
			ms.simulate();
			ms.setGame(gp.getListMatchGroupB().get(i));
			ms.simulate();
			ms.setGame(gp.getListMatchGroupC().get(i));
			ms.simulate();
			ms.setGame(gp.getListMatchGroupD().get(i));
			ms.simulate();
			
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
		sortGroupByPoints(this.gp.getGroupA(), this.standingGroupA);
		sortGroupByPoints(this.gp.getGroupB(), this.standingGroupB);
		sortGroupByPoints(this.gp.getGroupC(), this.standingGroupC);
		sortGroupByPoints(this.gp.getGroupD(), this.standingGroupD);
		
		/*System.out.println("First : " + this.standingGroupA.getFirst().getTeamName() + " points : " + this.standingGroupA.getFirst().getNbPoints() + " goals " + this.standingGroupA.getFirst().getGoals() );
		System.out.println("Second : " + this.standingGroupA.getSecond().getTeamName() + " points : " + this.standingGroupA.getSecond().getNbPoints() + " goals " + this.standingGroupA.getSecond().getGoals());
		System.out.println("Third : " + this.standingGroupA.getThird().getTeamName() + " points : " + this.standingGroupA.getThird().getNbPoints() + " goals " + this.standingGroupA.getThird().getGoals());
		System.out.println("Fourth : " + this.standingGroupA.getFourth().getTeamName() + " points : " + this.standingGroupA.getFourth().getNbPoints() + " goals " + this.standingGroupA.getFourth().getGoals());
		System.out.println("");
		
		System.out.println("First : " + this.standingGroupB.getFirst().getTeamName() + " points : " + this.standingGroupB.getFirst().getNbPoints() + " goals " + this.standingGroupB.getFirst().getGoals());
		System.out.println("Second : " + this.standingGroupB.getSecond().getTeamName() + " points : " + this.standingGroupB.getSecond().getNbPoints()  + " goals " + this.standingGroupB.getSecond().getGoals());
		System.out.println("Third : " + this.standingGroupB.getThird().getTeamName() + " points : " + this.standingGroupB.getThird().getNbPoints()  + " goals " + this.standingGroupB.getThird().getGoals());
		System.out.println("Fourth : " + this.standingGroupB.getFourth().getTeamName() + " points : " + this.standingGroupB.getFourth().getNbPoints() + " goals " + this.standingGroupB.getFourth().getGoals());
		System.out.println("");
		
		System.out.println("First : " + this.standingGroupC.getFirst().getTeamName() + " points : " + this.standingGroupC.getFirst().getNbPoints() + " goals " + this.standingGroupC.getFirst().getGoals());
		System.out.println("Second : " + this.standingGroupC.getSecond().getTeamName() + " points : " + this.standingGroupC.getSecond().getNbPoints()  + " goals " + this.standingGroupC.getSecond().getGoals());
		System.out.println("Third : " + this.standingGroupC.getThird().getTeamName() + " points : " + this.standingGroupC.getThird().getNbPoints() + " goals " + this.standingGroupC.getThird().getGoals());
		System.out.println("Fourth : " + this.standingGroupC.getFourth().getTeamName() + " points : " + this.standingGroupC.getFourth().getNbPoints() + " goals " + this.standingGroupC.getFourth().getGoals());
		System.out.println("");

		System.out.println("First : " + this.standingGroupD.getFirst().getTeamName() + " points : " + this.standingGroupD.getFirst().getNbPoints() + " goals " + this.standingGroupD.getFirst().getGoals());
		System.out.println("Second : " + this.standingGroupD.getSecond().getTeamName() + " points : " + this.standingGroupD.getSecond().getNbPoints() + " goals " + this.standingGroupD.getSecond().getGoals());
		System.out.println("Third : " + this.standingGroupD.getThird().getTeamName() + " points : " + this.standingGroupD.getThird().getNbPoints() + " goals " + this.standingGroupD.getThird().getGoals());
		System.out.println("Fourth : " + this.standingGroupD.getFourth().getTeamName() + " points : " + this.standingGroupD.getFourth().getNbPoints() + " goals " + this.standingGroupD.getFourth().getGoals());
		System.out.println("");*/
	}
	public Standing getStandingGroupA() {
		return standingGroupA;
	}
	public void setStandingGroupA(Standing standingGroupA) {
		this.standingGroupA = standingGroupA;
	}
	public Standing getStandingGroupB() {
		return standingGroupB;
	}
	public void setStandingGroupB(Standing standingGroupB) {
		this.standingGroupB = standingGroupB;
	}
	public Standing getStandingGroupC() {
		return standingGroupC;
	}
	public void setStandingGroupC(Standing standingGroupC) {
		this.standingGroupC = standingGroupC;
	}
	public Standing getStandingGroupD() {
		return standingGroupD;
	}
	public void setStandingGroupD(Standing standingGroupD) {
		this.standingGroupD = standingGroupD;
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
		res+= this.standingGroupA.getFirst().getTeamName() + " - "+ this.standingGroupA.getFirst().getNbPoints() + "\t";
		res+= this.standingGroupB.getFirst().getTeamName() + " - "+ this.standingGroupB.getFirst().getNbPoints() + "\t";
		res+= this.standingGroupC.getFirst().getTeamName() + " - "+ this.standingGroupC.getFirst().getNbPoints() + "\t";
		res+= this.standingGroupD.getFirst().getTeamName() + " - "+ this.standingGroupD.getFirst().getNbPoints() + "\t";
		res+="\n";
		
		res+= this.standingGroupA.getSecond().getTeamName() + " - "+ this.standingGroupA.getSecond().getNbPoints() + "\t";
		res+= this.standingGroupB.getSecond().getTeamName() + " - "+ this.standingGroupB.getSecond().getNbPoints() + "\t";
		res+= this.standingGroupC.getSecond().getTeamName() + " - "+ this.standingGroupC.getSecond().getNbPoints() + "\t";
		res+= this.standingGroupD.getSecond().getTeamName() + " - "+ this.standingGroupD.getSecond().getNbPoints() + "\t";
		res+="\n";
		
		res+= this.standingGroupA.getThird().getTeamName() + " - "+ this.standingGroupA.getThird().getNbPoints() + "\t";
		res+= this.standingGroupB.getThird().getTeamName() + " - "+ this.standingGroupB.getThird().getNbPoints() + "\t";
		res+= this.standingGroupC.getThird().getTeamName() + " - "+ this.standingGroupC.getThird().getNbPoints() + "\t";
		res+= this.standingGroupD.getThird().getTeamName() + " - "+ this.standingGroupD.getThird().getNbPoints() + "\t";
		res+="\n";
		
		res+= this.standingGroupA.getFourth().getTeamName() + " - "+ this.standingGroupA.getFourth().getNbPoints() + "\t";
		res+= this.standingGroupB.getFourth().getTeamName() + " - "+ this.standingGroupB.getFourth().getNbPoints() + "\t";
		res+= this.standingGroupC.getFourth().getTeamName() + " - "+ this.standingGroupC.getFourth().getNbPoints() + "\t";
		res+= this.standingGroupD.getFourth().getTeamName() + " - "+ this.standingGroupD.getFourth().getNbPoints() + "\t";
		res+="\n";
		
		return res;
	}
}
