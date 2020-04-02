package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.Team;
import data.TeamData;
import gui.MainFrame;
import process.GroupPhaseSimulation;
import process.KnockoutPhaseSimulation;
public class RestartAction implements ActionListener {
	private MainFrame mf;
	
	public RestartAction(MainFrame mf) {
		super();
		this.mf = mf;
	}
	public void actionPerformed(ActionEvent e) {
		mf.getContentPane().removeAll();
		TeamData td = new TeamData();
		ArrayList<Team> al = new ArrayList<Team>();
		td.createTeams(al);
		GroupPhaseSimulation groupePhase = new GroupPhaseSimulation();
		mf.setGroupPhase(groupePhase);
		groupePhase.setAlTeams(al);
		groupePhase.simulate();
		
		groupePhase.gp.getListMatchGroupA().get(0);
		groupePhase.updateStandingsFalse();
		
		
		System.out.println(groupePhase.groupToString());
		System.out.println(groupePhase.matchsToString());
		System.out.println(groupePhase.standingToString());
		
		
		
		KnockoutPhaseSimulation ks = new KnockoutPhaseSimulation();
		ks.setListQuarter(groupePhase.gp.getStandingGroupA(), groupePhase.gp.getStandingGroupB(), groupePhase.gp.getStandingGroupC(), groupePhase.gp.getStandingGroupD());
		ks.simulate();
		System.out.println(ks.quartersToString());
		System.out.println(ks.semiToString());
		System.out.println(ks.finalToString());

		mf.createGroupPhasePanel(groupePhase.gp, ks.kp, mf.getGroupPhase());

		mf.revalidate();
		mf.repaint();
		
	}
}
