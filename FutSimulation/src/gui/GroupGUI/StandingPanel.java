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
	private Color blue_sky= new Color(4,66,167);
	private Color blue_middle = new Color(98,141,213);
	private Color blue_dark = new Color(11,21,70);
	public StandingPanel() {
		super();
		this.setLayout(new GridLayout(1,4));
		this.setOpaque(false);
	}
	
	public void fillStandingPanel(String group, Standing standing, boolean point) {
		JPanel standingPpanel = new JPanel();
		
		JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);
		groupLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		groupLabel.setForeground(Color.WHITE);
		groupLabel.setBackground(blue_sky);
		groupLabel.setOpaque(true);
		JLabel teamLabel = new JLabel("Equipe", SwingConstants.CENTER);
		teamLabel.setForeground(Color.WHITE);
		teamLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		teamLabel.setBackground(blue_sky);
		teamLabel.setOpaque(true);
		JLabel pointsLabel = new JLabel("Pts", SwingConstants.CENTER);
		pointsLabel.setForeground(Color.WHITE);
		pointsLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		pointsLabel.setBackground(blue_sky);
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
    	jvide3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    	jvide3.setForeground(Color.WHITE);
    	jvide3.setBackground(blue_sky);
    	jvide3.setOpaque(true);
		standingPpanel.add(jvide3);
		teamLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		standingPpanel.add(teamLabel);
		pointsLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		standingPpanel.add(pointsLabel);

		
		Team tFirst = standing.getFirst();
		JImagePanel jipf = new JImagePanel(tFirst.getFlagPath());
		jipf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jipf.setForeground(Color.WHITE);
		jipf.setBackground(blue_middle);
		jipf.setOpaque(true);
		standingPpanel.add(jipf);
		
		JLabel jltf = new JLabel(tFirst.getTeamName(), SwingConstants.CENTER);
		jltf.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jltf.setForeground(Color.WHITE);
		jltf.setBackground(blue_middle);
		jltf.setOpaque(true);
		standingPpanel.add(jltf);
		if(point == true) {
			JLabel numLabel1f = new JLabel(Integer.toString(tFirst.getNbPoints()), SwingConstants.CENTER);
			numLabel1f.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel1f.setForeground(Color.WHITE);
			numLabel1f.setBackground(blue_middle);
			numLabel1f.setOpaque(true);
			standingPpanel.add(numLabel1f);
			
		} else {
			JLabel numLabel2f = new JLabel("0", SwingConstants.CENTER);
			numLabel2f.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel2f.setForeground(Color.WHITE);
			numLabel2f.setBackground(blue_middle);
			numLabel2f.setOpaque(true);
			standingPpanel.add(numLabel2f);
		}
		
		
		Team tSecond= standing.getSecond();
		JImagePanel jips = new JImagePanel(tSecond.getFlagPath());
		jips.setBorder(BorderFactory.createLineBorder(blue_middle));
		standingPpanel.add(jips);

		JLabel jlts = new JLabel(tSecond.getTeamName(), SwingConstants.CENTER);
		jlts.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jlts.setForeground(Color.WHITE);
		jlts.setBackground(blue_middle);
		jlts.setOpaque(true);
		standingPpanel.add(jlts);
		if(point == true) {
			JLabel numLabel1s = new JLabel(Integer.toString(tSecond.getNbPoints()), SwingConstants.CENTER);
			numLabel1s.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel1s.setForeground(Color.WHITE);
			numLabel1s.setBackground(blue_middle);
			numLabel1s.setOpaque(true);
			standingPpanel.add(numLabel1s);
		} else {
			JLabel numLabel2s = new JLabel("0", SwingConstants.CENTER);
			numLabel2s.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel2s.setBackground(blue_middle);
			numLabel2s.setForeground(Color.WHITE);
			numLabel2s.setOpaque(true);
			standingPpanel.add(numLabel2s);
		}
		
		Team tThird = standing.getThird();
		JImagePanel jipt = new JImagePanel(tThird.getFlagPath());
		jipt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jipt.setForeground(Color.WHITE);
		standingPpanel.add(jipt);
		JLabel jltt = new JLabel(tThird.getTeamName(), SwingConstants.CENTER);
		jltt.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jltt.setForeground(Color.WHITE);
		jltt.setBackground(blue_middle);
		jltt.setOpaque(true);
		standingPpanel.add(jltt);
		if(point == true) {
			JLabel numLabel1t = new JLabel(Integer.toString(tThird.getNbPoints()), SwingConstants.CENTER);
			numLabel1t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel1t.setForeground(Color.WHITE);
			numLabel1t.setBackground(blue_middle);
			numLabel1t.setOpaque(true);
			standingPpanel.add(numLabel1t);
		} else {
			JLabel numLabel2t = new JLabel("0", SwingConstants.CENTER);
			numLabel2t.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel2t.setForeground(Color.WHITE);
			numLabel2t.setBackground(blue_middle);
			numLabel2t.setOpaque(true);
			standingPpanel.add(numLabel2t);
		}
		
		Team tFourth = standing.getFourth();
		JImagePanel jipq = new JImagePanel(tFourth.getFlagPath());
		jipq.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jipq.setForeground(Color.WHITE);
		standingPpanel.add(jipq);
		JLabel jltq = new JLabel(tFourth.getTeamName(), SwingConstants.CENTER);
		jltq.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		jltq.setForeground(Color.WHITE);
		jltq.setBackground(blue_middle);
		jltq.setOpaque(true);
		standingPpanel.add(jltq);
		if(point == true) {
			JLabel numLabel1q = new JLabel(Integer.toString(tFourth.getNbPoints()), SwingConstants.CENTER);
			numLabel1q.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel1q.setForeground(Color.WHITE);
			numLabel1q.setBackground(blue_middle);
			numLabel1q.setOpaque(true);
			standingPpanel.add(numLabel1q);
		} else {
			JLabel numLabel2q = new JLabel("0", SwingConstants.CENTER);
			numLabel2q.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			numLabel2q.setForeground(Color.WHITE);
			numLabel2q.setBackground(blue_middle);
			numLabel2q.setOpaque(true);
			standingPpanel.add(numLabel2q);
		}
		
		standingPpanel.setBorder(BorderFactory.createLineBorder(blue_dark));
		standingPpanel.setOpaque(false);
		this.add(standingPpanel);
	}
	
	
	
}
