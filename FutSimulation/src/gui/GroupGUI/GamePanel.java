package gui.GroupGUI;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Match;
import data.Team;
import gui.JImagePanel;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -7903191950575270474L;
	
	
	public GamePanel() {
		super();
		this.setLayout(new GridLayout(1,4));
	}
	
	public void createGamePanel(String group, ArrayList<Match> alMatch) {
		JPanel standingPanel = new JPanel();
		JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);
		
		standingPanel.setLayout(new GridLayout(7,1,20,20));
		//standingPanel.add(new JPanel());
		standingPanel.add(groupLabel);
		//standingPanel.add(new JPanel());
		
		for(Match m : alMatch) {
			Team a,b;
			a = m.getTeamA();
			b = m.getTeamB();
			JImagePanel jipA = new JImagePanel(a.getFlagPath());
			JLabel scoreLabel = new JLabel(a.getTeamName()+" "+m.getScoreA()+" - "+m.getScoreB()+" "+b.getTeamName(), SwingConstants.CENTER);
			JImagePanel jipB = new JImagePanel(b.getFlagPath());
			//standingPanel.add(jipA);
			standingPanel.add(scoreLabel);
			//standingPanel.add(jipB);
		}
		this.add(standingPanel);
	}
}
