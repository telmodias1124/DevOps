package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import data.GroupPhase;
import data.Match;
import data.Team;
import data.TeamData;
import gui.MainFrame;
import process.GroupPhaseSimulation;
import process.KnockoutPhaseSimulation;
public class RestartMatchAction implements ActionListener {
	private MainFrame mf;
	private GroupPhaseSimulation groupPhase;
	
	public RestartMatchAction(MainFrame mf, GroupPhaseSimulation groupPhase) {
		super();
		this.mf = mf;
		this.groupPhase = groupPhase;
	}
	public void actionPerformed(ActionEvent e) {
		mf.getContentPane().removeAll();
		TeamData td = new TeamData();
		ArrayList<Team> al = mf.getGroupPhase().getAlTeams();
	
		td.createTeams(al);
		for(int i=0;i<16;i++) {
			al.get(i).setGoals(0);
			al.get(i).setNbPoints(0);
		}
		ArrayList<Match> matchA = new ArrayList<Match>();
		ArrayList<Match> matchB = new ArrayList<Match>();
		ArrayList<Match> matchC = new ArrayList<Match>();
		ArrayList<Match> matchD = new ArrayList<Match>();
		
		
		groupPhase.gp.setListMatchGroupA(matchA);
		groupPhase.gp.setListMatchGroupB(matchB);
		groupPhase.gp.setListMatchGroupC(matchC);
		groupPhase.gp.setListMatchGroupD(matchD);
		
		groupPhase.createMatchGroup(groupPhase.gp);
		groupPhase.setAlTeams(al);
		
		groupPhase.simulateMatchGroupe();
		
		System.out.println(groupPhase.groupToString());
		System.out.println(groupPhase.matchsToString());
		System.out.println(groupPhase.standingToString());
		
		
		
		KnockoutPhaseSimulation ks = new KnockoutPhaseSimulation();
		ks.setListQuarter(groupPhase.gp.getStandingGroupA(), groupPhase.gp.getStandingGroupB(), groupPhase.gp.getStandingGroupC(), groupPhase.gp.getStandingGroupD());
		ks.simulate();
		System.out.println(ks.quartersToString());
		System.out.println(ks.semiToString());
		System.out.println(ks.finalToString());

		mf.createGroupPhasePanel(groupPhase.gp, ks.kp, groupPhase);

		mf.revalidate();
		mf.repaint();
		
	}
}
