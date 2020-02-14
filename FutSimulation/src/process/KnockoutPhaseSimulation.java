package process;

import java.util.ArrayList;
import java.util.LinkedList;

import data.KnockoutPhase;
import data.Match;
import data.Standing;

public class KnockoutPhaseSimulation {
	public KnockoutPhase kp;
	private MatchSimulation ms;
	
	public KnockoutPhaseSimulation() {
		this.kp = new KnockoutPhase();
		this.ms = new MatchSimulation();
	}
	public void simulate() {
		quartersSimulate();
		setListSemi();
		semiSimulate();
		setFinal();
		finalSimulate();
	}
	
	public void setListQuarter(Standing stA, Standing stB, Standing stC, Standing stD) {
		LinkedList<Match> al = new LinkedList<Match>();
		al.add(new Match(stA.getFirst() , stB.getSecond()));
		al.add(new Match(stC.getFirst() , stD.getSecond()));
		al.add(new Match(stA.getSecond() , stB.getFirst()));
		al.add(new Match(stC.getSecond() , stD.getFirst()));
		kp.setListQuarter(al);
	}
	
	private void quartersSimulate() {
		for(Match m : kp.getListQuarter()) {
			m.setOvertime(true);
			ms.setGame(m);
			ms.simulate();
		}
	}

	private void setListSemi() {
		ArrayList<Match> al = new ArrayList<Match>();
		al.add(new Match(kp.getListQuarter().get(0).getWinner() , kp.getListQuarter().get(1).getWinner()));
		al.add(new Match(kp.getListQuarter().get(2).getWinner() , kp.getListQuarter().get(3).getWinner()));
		kp.setListSemi(al);
	}
	
	private void semiSimulate() {
		for(Match m : kp.getListSemi()) {
			m.setOvertime(true);
			ms.setGame(m);
			ms.simulate();
		}
	}
	
	private void setFinal() {
		Match m = new Match(kp.getListSemi().get(0).getWinner(), kp.getListSemi().get(1).getWinner());
		m.setOvertime(true);
		kp.setFinalMatch(m);
	}
	
	private void finalSimulate() {
		ms.setGame(kp.getFinalMatch());
		ms.simulate();
	}
	
	public String quartersToString() {
		String res = "Quarters : \n";
		for(Match m : this.kp.getListQuarter()) {
			res+=m.getTeamA().getTeamName() + " vs " + m.getTeamB().getTeamName() + "\n";	
		}
		res+="\n";
		for(Match t : this.kp.getListQuarter()) {
			res+=t.getTeamA().getTeamName() + " " + t.getScoreA() + " - " + t.getScoreB() + " "+ t.getTeamB().getTeamName() + "\n";
			if(t.isPenalty()) {
				res+="Penalty : \n";
				res+=t.getTeamA().getTeamName() + " " + t.getPenA() + " - " + t.getPenB() + " "+ t.getTeamB().getTeamName() + "\n\n";
			}
		}
		res+="\n";
		return res;
	}
	public String semiToString() {
		String res = "Semi : \n";
		for(Match m : this.kp.getListSemi()) {
			res+=m.getTeamA().getTeamName() + " vs " + m.getTeamB().getTeamName() + "\n";
		}
		res+="\n";
		for(Match t : this.kp.getListSemi()) {
			res+=t.getTeamA().getTeamName() + " " + t.getScoreA() + " - " + t.getScoreB() + " "+ t.getTeamB().getTeamName() + "\n";
			if(t.isPenalty()) {
				res+="Penalty : \n";
				res+=t.getTeamA().getTeamName() + " " + t.getPenA() + " - " + t.getPenB() + " "+ t.getTeamB().getTeamName() + "\n\n";
			}
		}
		res+="\n";
		return res;
	}
	public String finalToString() {
		String res = "Final : \n";
		res+=this.kp.getFinalMatch().getTeamA().getTeamName() + " " + this.kp.getFinalMatch().getScoreA() + " - " + this.kp.getFinalMatch().getScoreB() + " "+ this.kp.getFinalMatch().getTeamB().getTeamName() + "\n";
		if(this.kp.getFinalMatch().isPenalty()) {
			res+="Penalty : \n";
			res+=this.kp.getFinalMatch().getTeamA().getTeamName() + " " + this.kp.getFinalMatch().getPenA() + " - " + this.kp.getFinalMatch().getPenB() + " "+ this.kp.getFinalMatch().getTeamB().getTeamName() + "\n\n";
		}
		res+="The winner is : " + this.kp.getFinalMatch().getWinner().getTeamName();
		return res;
	}
}
