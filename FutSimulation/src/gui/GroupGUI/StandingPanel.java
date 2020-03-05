package gui.GroupGUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Standing;
import data.Team;
import gui.JImagePanel;

public class StandingPanel extends JPanel {
	
	private static final long serialVersionUID = 6178054270516856411L;
	
	public StandingPanel() {
		super();
		this.setLayout(new GridLayout(1,4));
	}
	
	public void fillStandingPanel(String group, Standing standing, boolean point) {
		JPanel standingPpanel = new JPanel();
		JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);
		//groupLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		JLabel teamLabel = new JLabel("Team", SwingConstants.CENTER);
		JLabel pointsLabel = new JLabel("Pts", SwingConstants.CENTER);

		standingPpanel.setLayout(new GridLayout(6,3,20,20));
		
		standingPpanel.add(new JPanel());
		standingPpanel.add(groupLabel);
		standingPpanel.add(new JPanel());
		standingPpanel.add(new JPanel());
		standingPpanel.add(teamLabel);
		standingPpanel.add(pointsLabel);

		
		Team tFirst = standing.getFirst();
		JImagePanel jipf = new JImagePanel(tFirst.getFlagPath());
		standingPpanel.add(jipf);
		standingPpanel.add(new JLabel(tFirst.getTeamName(), SwingConstants.CENTER));
		if(point == true) {
			standingPpanel.add(new JLabel(Integer.toString(tFirst.getNbPoints()), SwingConstants.CENTER));
		} else {
			standingPpanel.add(new JLabel("0", SwingConstants.CENTER));
		}
		
		
		Team tSecond= standing.getSecond();
		JImagePanel jips = new JImagePanel(tSecond.getFlagPath());
		standingPpanel.add(jips);
		standingPpanel.add(new JLabel(tSecond.getTeamName(), SwingConstants.CENTER));
		if(point == true) {
			standingPpanel.add(new JLabel(Integer.toString(tSecond.getNbPoints()), SwingConstants.CENTER));
		} else {
			standingPpanel.add(new JLabel("0", SwingConstants.CENTER));
		}
		
		Team tThird = standing.getThird();
		JImagePanel jipt = new JImagePanel(tThird.getFlagPath());
		standingPpanel.add(jipt);
		standingPpanel.add(new JLabel(tThird.getTeamName(), SwingConstants.CENTER));
		if(point == true) {
			standingPpanel.add(new JLabel(Integer.toString(tThird.getNbPoints()), SwingConstants.CENTER));
		} else {
			standingPpanel.add(new JLabel("0", SwingConstants.CENTER));
		}
		
		Team tFourth = standing.getFourth();
		JImagePanel jipq = new JImagePanel(tFourth.getFlagPath());
		standingPpanel.add(jipq);
		standingPpanel.add(new JLabel(tFourth.getTeamName(), SwingConstants.CENTER));
		if(point == true) {
			standingPpanel.add(new JLabel(Integer.toString(tFourth.getNbPoints()), SwingConstants.CENTER));
		} else {
			standingPpanel.add(new JLabel("0", SwingConstants.CENTER));
		}
		
		
		this.add(standingPpanel);
	}
	
	
	
}
