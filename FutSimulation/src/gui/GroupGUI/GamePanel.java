package gui.GroupGUI;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;

import data.GroupPhase;
import data.Match;
import data.Team;
import gui.JImagePanel;
import gui.MainFrame;
import gui.MatchView.MatchView;
import gui.MatchView.MatchView.*;
import gui.actions.ExitAction;
import gui.actions.KnockoutAction;
import gui.actions.RestartAction;
import gui.actions.RestartMatchAction;
import gui.actions.StartAction;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = -7903191950575270474L;
	private GroupPhase gp;
	private StandingPanel sp;
	private MainFrame mf;
	private Color perso = new Color(83,83,83);
	public GamePanel(GroupPhase gp, StandingPanel sp, MainFrame mf) {
		super();
		this.setLayout(new GridLayout(1,4));
		this.gp = gp;
		this.sp = sp;
		this.mf = mf;
		this.setOpaque(false);
	}
	
	public void createStartPanel() {
		JPanel panel;
		for(int i=0; i<4; i++) {
			panel = new JPanel();
			panel.setLayout(new GridLayout(8,1,20,20));
			if(i ==0 ||i==1 || i== 2 || i==3) {
				for(int j=0; j<7; j++) {
					JPanel jvide = new JPanel();
		        	jvide.setOpaque(false);
					panel.add(jvide);
				}
				if(i==2) {
					JButton jbStart;
					StartAction sa = new StartAction(this, this.gp, this.sp);
					jbStart = new JButton("Start");
					jbStart.setBackground(Color.WHITE);
					jbStart.setOpaque(true);
					jbStart.addActionListener(sa);
					panel.add(jbStart);
				}
				else if(i==1){
					JButton jbExit;
					jbExit = new JButton("Exit");
					jbExit.setBackground(Color.WHITE);
					jbExit.setOpaque(true);
					jbExit.addActionListener(new ExitAction());
					panel.add(jbExit);
				}else if(i==3) {
					JButton jbRestart;
					jbRestart = new JButton("Restart Match");
					jbRestart.setBackground(perso);
					jbRestart.setOpaque(true);
					jbRestart.addActionListener(null);
					panel.add(jbRestart);
				}else if(i==0) {
					JButton jbRestart;
					jbRestart = new JButton("Restart");
					jbRestart.setBackground(Color.WHITE);
					jbRestart.setOpaque(true);
					jbRestart.addActionListener(new RestartAction(mf));
					panel.add(jbRestart);
				}
			}
			panel.setOpaque(false);
			this.add(panel);
		}
	}
	
	public void createGamePanel(String group, ArrayList<Match> alMatch) {

        JPanel standingPanel = new JPanel();
        JLabel groupLabel = new JLabel(group, SwingConstants.CENTER);
		groupLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
		groupLabel.setBackground(Color.LIGHT_GRAY);
		groupLabel.setOpaque(true);

        standingPanel.setLayout(new GridLayout(8,1,20,20));
        standingPanel.add(groupLabel);

        for(Match m : alMatch) {
            Team a,b;
            a = m.getTeamA();
            b = m.getTeamB();
            JLabel scoreLabel = new JLabel(a.getTeamName()+" "+m.getScoreA()+" - "+m.getScoreB()+" "+b.getTeamName(), SwingConstants.CENTER);
            scoreLabel.addMouseListener(new MouseAdapter()  
            {  
                public void mouseClicked(MouseEvent e)  
                {  
                	System.out.println("Ca moche pas");
                	MainFrame frameMatch = new MainFrame();
                	frameMatch.setTitle(m.getTeamA().getTeamName()+" - "+m.getTeamB().getTeamName());
                	frameMatch.createMatchView(m);
                	

                }  
            });
    		scoreLabel.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    		scoreLabel.setBackground(Color.LIGHT_GRAY);
    		scoreLabel.setOpaque(true);
            standingPanel.add(scoreLabel);
        }
        if(group.equals("Group A")) {
        	JButton jbRestart;
			jbRestart = new JButton("Restart");
			jbRestart.setBackground(Color.WHITE);
			jbRestart.setOpaque(true);
			jbRestart.addActionListener(new RestartAction(mf));
			standingPanel.add(jbRestart);
        }
        if(group.equals("Group B")) {
            JButton jbExit;
            jbExit = new JButton("Exit");
            jbExit.setBackground(Color.WHITE);
            jbExit.setOpaque(true);
            jbExit.addActionListener(new ExitAction());
            standingPanel.add(jbExit);
        }
        if(group.equals("Group C")) {
            JButton jbKnock;
            jbKnock = new JButton("Knockout Phase");
            jbKnock.setBackground(Color.WHITE);
            jbKnock.setOpaque(true);
            KnockoutAction na = new KnockoutAction(this.mf);
            jbKnock.addActionListener(na);
            standingPanel.add(jbKnock);
        }if(group.equals("Group D")) {
        	JButton jbRestart;
			jbRestart = new JButton("Restart Match");
			jbRestart.setBackground(Color.WHITE);
			jbRestart.setOpaque(true);
			jbRestart.addActionListener(new RestartMatchAction(mf,mf.getGroupPhase()));
			standingPanel.add(jbRestart);
        }
        standingPanel.setOpaque(false);
        this.add(standingPanel);
    }

	
	
}


