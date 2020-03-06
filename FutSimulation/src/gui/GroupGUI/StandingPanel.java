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
		this.setOpaque(false);
	}
	
	public void fillStandingPanel(String group, Standing standing, boolean point) {
		JPanel standingPpanel = new JPanel();
		
		JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);
		groupLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		groupLabel.setBackground(Color.LIGHT_GRAY);
		groupLabel.setOpaque(true);
		JLabel teamLabel = new JLabel("Team", SwingConstants.CENTER);
		teamLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		teamLabel.setBackground(Color.LIGHT_GRAY);
		teamLabel.setOpaque(true);
		JLabel pointsLabel = new JLabel("Pts", SwingConstants.CENTER);
		pointsLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		pointsLabel.setBackground(Color.LIGHT_GRAY);
		pointsLabel.setOpaque(true);

		standingPpanel.setLayout(new GridLayout(6,3, 0, 20));
		
		JPanel jvide = new JPanel();
    	jvide.setOpaque(false);
		standingPpanel.add(jvide);

		standingPpanel.add(groupLabel);
		JPanel jvide2 = new JPanel();
    	jvide2.setOpaque(false);
		standingPpanel.add(jvide2);
		JPanel jvide3 = new JPanel();
    	jvide3.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    	jvide3.setBackground(Color.LIGHT_GRAY);
    	jvide3.setOpaque(true);
		standingPpanel.add(jvide3);
		teamLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		standingPpanel.add(teamLabel);
		pointsLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));

		standingPpanel.add(pointsLabel);

		
		Team tFirst = standing.getFirst();
		JImagePanel jipf = new JImagePanel(tFirst.getFlagPath());
		jipf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		jipf.setBackground(Color.LIGHT_GRAY);
		jipf.setOpaque(true);
		standingPpanel.add(jipf);
		
		JLabel jltf = new JLabel(tFirst.getTeamName(), SwingConstants.CENTER);
		jltf.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		jltf.setBackground(Color.LIGHT_GRAY);
		jltf.setOpaque(true);
		standingPpanel.add(jltf);
		if(point == true) {
			JLabel numLabel1f = new JLabel(Integer.toString(tFirst.getNbPoints()), SwingConstants.CENTER);
			numLabel1f.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel1f.setBackground(Color.LIGHT_GRAY);
			numLabel1f.setOpaque(true);
			standingPpanel.add(numLabel1f);
			
		} else {
			JLabel numLabel2f = new JLabel("0", SwingConstants.CENTER);
			numLabel2f.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel2f.setBackground(Color.LIGHT_GRAY);
			numLabel2f.setOpaque(true);
			standingPpanel.add(numLabel2f);
		}
		
		
		Team tSecond= standing.getSecond();
		JImagePanel jips = new JImagePanel(tSecond.getFlagPath());
		jips.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		standingPpanel.add(jips);

		JLabel jlts = new JLabel(tSecond.getTeamName(), SwingConstants.CENTER);
		jlts.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		jlts.setBackground(Color.LIGHT_GRAY);
		jlts.setOpaque(true);
		standingPpanel.add(jlts);
		if(point == true) {
			JLabel numLabel1s = new JLabel(Integer.toString(tSecond.getNbPoints()), SwingConstants.CENTER);
			numLabel1s.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel1s.setBackground(Color.LIGHT_GRAY);
			numLabel1s.setOpaque(true);
			standingPpanel.add(numLabel1s);
		} else {
			JLabel numLabel2s = new JLabel("0", SwingConstants.CENTER);
			numLabel2s.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel2s.setBackground(Color.LIGHT_GRAY);
			numLabel2s.setOpaque(true);
			standingPpanel.add(numLabel2s);
		}
		
		Team tThird = standing.getThird();
		JImagePanel jipt = new JImagePanel(tThird.getFlagPath());
		jipt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		standingPpanel.add(jipt);
		JLabel jltt = new JLabel(tThird.getTeamName(), SwingConstants.CENTER);
		jltt.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		jltt.setBackground(Color.LIGHT_GRAY);
		jltt.setOpaque(true);
		standingPpanel.add(jltt);
		if(point == true) {
			JLabel numLabel1t = new JLabel(Integer.toString(tThird.getNbPoints()), SwingConstants.CENTER);
			numLabel1t.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel1t.setBackground(Color.LIGHT_GRAY);
			numLabel1t.setOpaque(true);
			standingPpanel.add(numLabel1t);
		} else {
			JLabel numLabel2t = new JLabel("0", SwingConstants.CENTER);
			numLabel2t.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel2t.setBackground(Color.LIGHT_GRAY);
			numLabel2t.setOpaque(true);
			standingPpanel.add(numLabel2t);
		}
		
		Team tFourth = standing.getFourth();
		JImagePanel jipq = new JImagePanel(tFourth.getFlagPath());
		jipq.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		standingPpanel.add(jipq);
		JLabel jltq = new JLabel(tFourth.getTeamName(), SwingConstants.CENTER);
		jltq.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		jltq.setBackground(Color.LIGHT_GRAY);
		jltq.setOpaque(true);
		standingPpanel.add(jltq);
		if(point == true) {
			JLabel numLabel1q = new JLabel(Integer.toString(tFourth.getNbPoints()), SwingConstants.CENTER);
			numLabel1q.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel1q.setBackground(Color.LIGHT_GRAY);
			numLabel1q.setOpaque(true);
			standingPpanel.add(numLabel1q);
		} else {
			JLabel numLabel2q = new JLabel("0", SwingConstants.CENTER);
			numLabel2q.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
			numLabel2q.setBackground(Color.LIGHT_GRAY);
			numLabel2q.setOpaque(true);
			standingPpanel.add(numLabel2q);
		}
		
		standingPpanel.setBorder(BorderFactory.createLineBorder(Color.WHITE));
		standingPpanel.setOpaque(false);
		this.add(standingPpanel);
	}
	
	
	
}
