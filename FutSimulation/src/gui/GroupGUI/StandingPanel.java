package gui.GroupGUI;

import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.Team;

public class StandingPanel extends JPanel {
	
	private static final long serialVersionUID = 6178054270516856411L;
	
	public StandingPanel() {
		super();
		this.setLayout(new GridLayout(1,4));
	}
	
	
	
	public void createGroupPanel(String group, ArrayList<Team> alGroup) {
		JPanel panel = new JPanel();
		JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);
		JLabel teamLabel = new JLabel("Team", SwingConstants.CENTER);
		JLabel pointsLabel = new JLabel("Pts", SwingConstants.CENTER);

		panel.setLayout(new GridLayout(6,3));
		
		panel.add(new JPanel());
		panel.add(groupLabel);
		panel.add(new JPanel());
		panel.add(new JPanel());
		panel.add(teamLabel);
		panel.add(pointsLabel);

		
		for(Team t : alGroup) {
			JLabel jl = new JLabel();
			System.out.println(t.getFlagPath());
			jl.setIcon(new ImageIcon(new ImageIcon(t.getFlagPath()).getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT)));
			panel.add(jl);
			panel.add(new JLabel(t.getTeamName(), SwingConstants.CENTER));
			panel.add(new JLabel(Integer.toString(t.getNbPoints()), SwingConstants.CENTER));
		}
		this.add(panel);
	}
}
