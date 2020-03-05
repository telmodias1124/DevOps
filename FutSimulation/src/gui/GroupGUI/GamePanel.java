package gui.GroupGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.GroupPhase;
import data.Match;
import data.Team;
import gui.JImagePanel;
import gui.MainFrame;
import gui.actions.ExitAction;
import gui.actions.KnockoutAction;
import gui.actions.StartAction;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -7903191950575270474L;
	private GroupPhase gp;
	private StandingPanel sp;
	private MainFrame mf;
	
	public GamePanel(GroupPhase gp, StandingPanel sp, MainFrame mf) {
		super();
		this.setLayout(new GridLayout(1,4));
		this.gp = gp;
		this.sp = sp;
		this.mf = mf;
	}
	
	public void createStartPanel() {
		JPanel panel;
		for(int i=0; i<4; i++) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(8,1,20,20));
			if(i==1 || i== 2) {
				for(int j=0; j<7; j++) {
					panel.add(new JPanel());
				}
				if(i==2) {
					JButton jbStart;
					StartAction sa = new StartAction(this, this.gp, this.sp);
					jbStart = new JButton("Start");
					jbStart.addActionListener(sa);
					panel.add(jbStart);
				}
				else {
					JButton jbExit;
					jbExit = new JButton("Exit");
					jbExit.addActionListener(new ExitAction());
					panel.add(jbExit);
				}
			}
			this.add(panel);
		}
	}
	
	public void createGamePanel(String group, ArrayList<Match> alMatch) {

        JPanel standingPanel = new JPanel();
        JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);

        standingPanel.setLayout(new GridLayout(8,1,20,20));
        standingPanel.add(groupLabel);

        for(Match m : alMatch) {

            Team a,b;
            a = m.getTeamA();
            b = m.getTeamB();
            JLabel scoreLabel = new JLabel(a.getTeamName()+" "+m.getScoreA()+" - "+m.getScoreB()+" "+b.getTeamName(), SwingConstants.CENTER);
            standingPanel.add(scoreLabel);
        }
        if(group.equals("Group A") || group.equals("Group D")) {
            standingPanel.add(new JPanel());
        }
        if(group.equals("Group B")) {
            JButton jbExit;
            jbExit = new JButton("Exit");
            jbExit.addActionListener(new ExitAction());
            standingPanel.add(jbExit);
        }
        if(group.equals("Group C")) {
            JButton jbKnock;
            jbKnock = new JButton("Knockout Phase");
            KnockoutAction na = new KnockoutAction(this.mf);
            jbKnock.addActionListener(na);
            standingPanel.add(jbKnock);
        }
        this.add(standingPanel);
    }

	
	
}


