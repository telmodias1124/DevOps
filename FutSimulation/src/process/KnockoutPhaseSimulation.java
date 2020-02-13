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
}
