package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;

import data.GroupPhase;
import data.Match;
import gui.GroupGUI.GamePanel;
import gui.GroupGUI.StandingPanel;

public class StartAction implements ActionListener {
	
	private GamePanel gamePanel;
	private StandingPanel standingPanel;
	private GroupPhase gp;
	
	public StartAction(GamePanel gamePanel, GroupPhase gp, StandingPanel standingPanel) {
		super();
		this.gamePanel = gamePanel;
		this.standingPanel = standingPanel;
		this.gp = gp;
	}
	public void actionPerformed(ActionEvent e) {
		this.gamePanel.removeAll();
		this.gamePanel.createGamePanel("Groupe A", this.gp.getListMatchGroupA());
		this.gamePanel.createGamePanel("Groupe B", this.gp.getListMatchGroupB());
		this.gamePanel.createGamePanel("Groupe C", this.gp.getListMatchGroupC());
		this.gamePanel.createGamePanel("Groupe D", this.gp.getListMatchGroupD());
		this.gamePanel.revalidate();
		this.gamePanel.repaint();
		this.gamePanel.setVisible(true);
		this.gamePanel.getMf().getGroupPhase().updateStandings();
		
		this.standingPanel.removeAll();
		this.standingPanel.fillStandingPanel("Groupe A", this.gp.getStandingGroupA(), true);
		this.standingPanel.fillStandingPanel("Groupe B", this.gp.getStandingGroupB(), true);
		this.standingPanel.fillStandingPanel("Groupe C", this.gp.getStandingGroupC(), true);
		this.standingPanel.fillStandingPanel("Groupe D", this.gp.getStandingGroupD(), true);
		
		this.standingPanel.revalidate();
		this.standingPanel.repaint();
		this.standingPanel.setVisible(true);
	}
}