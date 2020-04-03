package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import data.GroupPhase;
import data.KnockoutPhase;
import data.Match;
import data.Team;
import gui.GroupGUI.GroupPhasePanel;
import gui.Knockout.KnockoutPanel;
import gui.MatchView.MatchView;
import listener.Mouse;
import process.GroupPhaseSimulation;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2230254401958956708L;
	
	private GroupPhasePanel gpp;
	public KnockoutPhase kp;
	private GroupPhase gp;
	public GroupPhaseSimulation groupPhase;
	
	private Color blue_dark = new Color(11,21,70);
	
	public MainFrame() {
		super("FutSimulation");
		this.addMouseListener(new Mouse());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(GlobalParameter.MAINFRAME_WIDTH,GlobalParameter.MAINFRAME_HEIGHT));
		//this.setLayout(new GridLayout(2,1));
		this.setMinimumSize(new Dimension(GlobalParameter.MAINFRAME_WIDTH,GlobalParameter.MAINFRAME_HEIGHT));
		this.getContentPane().setBackground(blue_dark);
		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public void createGroupPhasePanel(GroupPhase gp, KnockoutPhase kp,GroupPhaseSimulation groupPhase) {
		this.kp = kp;
		this.gp =gp;
		gpp = new GroupPhasePanel();
		gpp.fillGroupPhasePanel(gp, this);
		gpp.setOpaque(false);
		this.add(gpp);
	}

	
	public void createKnockout() {
		KnockoutPanel knp = new KnockoutPanel(this.kp, this);
		knp.drawQuarters();
		this.add(knp);
	}
	
	public void createMatchView(Match m) {
		MatchView mv = new MatchView(m, this);
		this.add(mv);
	}
	public KnockoutPhase getKp() {
		return kp;
	}
	public GroupPhase getGp() {
		return gp;
	}
	public void setKp(KnockoutPhase kp) {
		this.kp = kp;
	}
	public void setGp(GroupPhase gp) {
		this.gp = gp;
	}
	public GroupPhasePanel getGpp() {
		return gpp;
	}
	public void setGpp(GroupPhasePanel gpp) {
		this.gpp = gpp;
	}
	public GroupPhaseSimulation getGroupPhase() {
		return groupPhase;
	}
	public void setGroupPhase(GroupPhaseSimulation groupPhase) {
		this.groupPhase = groupPhase;
	}
	
	
}
