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
import gui.GroupGUI.GroupPhasePanel;
import gui.Knockout.KnockoutPanel;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 2230254401958956708L;
	
	private GroupPhasePanel gpp;
	
	public MainFrame() {
		super("FutSimulation");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(GlobalParameter.MAINFRAME_WIDTH,GlobalParameter.MAINFRAME_HEIGHT));
		//this.setLayout(new GridLayout(2,1));
		this.setMinimumSize(new Dimension(GlobalParameter.MAINFRAME_WIDTH,GlobalParameter.MAINFRAME_HEIGHT));
		
		
		
		
		
		
		
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	public void createGroupPhasePanel(GroupPhase gp) {
		gpp = new GroupPhasePanel();
		gpp.fillGroupPhasePanel(gp);
		this.add(gpp);
	}
	
	public void createKnockout(KnockoutPhase kp) {
		KnockoutPanel knp = new KnockoutPanel();
		//knp.setAlMatch(kp.getListQuarter());
		knp.drawQuarters(kp);
		this.add(knp);
	}
}
