package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import data.Match;
import gui.GroupGUI.GamePanel;

public class StartAction implements ActionListener {
	
	private GamePanel panel;
	private String group;
	private ArrayList<Match> alMatch;
	
	public StartAction(GamePanel jp) {
		super();
		this.panel = jp;
		this.group = group;
		this.alMatch = alMatch;
	}
	public void actionPerformed(ActionEvent e) {
		this.panel.removeAll();
		this.panel.createGamePanel(group, alMatch);
		System.exit(0);
	}
}