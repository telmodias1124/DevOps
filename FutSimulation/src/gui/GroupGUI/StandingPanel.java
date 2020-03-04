package gui.GroupGUI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Team;
import gui.JImagePanel;

public class StandingPanel extends JPanel {
	
	private static final long serialVersionUID = 6178054270516856411L;
	
	public StandingPanel() {
		super();
		this.setLayout(new GridLayout(1,4));
	}
	
	public void createGroupPanel(String group, ArrayList<Team> alGroup) {
		JPanel standingPpanel = new JPanel();
		JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);
		JLabel teamLabel = new JLabel("Team", SwingConstants.CENTER);
		JLabel pointsLabel = new JLabel("Pts", SwingConstants.CENTER);

		standingPpanel.setLayout(new GridLayout(6,3,20,20));
		
		standingPpanel.add(new JPanel());
		standingPpanel.add(groupLabel);
		standingPpanel.add(new JPanel());
		standingPpanel.add(new JPanel());
		standingPpanel.add(teamLabel);
		standingPpanel.add(pointsLabel);

		
		for(Team t : alGroup) {
			JImagePanel jip = new JImagePanel(t.getFlagPath());
			standingPpanel.add(jip);
			standingPpanel.add(new JLabel(t.getTeamName(), SwingConstants.CENTER));
			standingPpanel.add(new JLabel(Integer.toString(t.getNbPoints()), SwingConstants.CENTER));
		}
		this.add(standingPpanel);
	}
}
