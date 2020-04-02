package gui.GroupGUI;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;

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
	
	private Color blue_sky= new Color(4,66,167);
	private Color blue_middle = new Color(98,141,213);
	
	public GamePanel(GroupPhase gp, StandingPanel sp, MainFrame mf) {
		super();
		this.setLayout(new GridLayout(1,4));
		this.gp = gp;
		this.sp = sp;
		this.mf = mf;
		
		this.setOpaque(true);
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
					try {
	                    Image img = ImageIO.read(new File("images/next_phase.png"));
	                    jbStart.setIcon(new ImageIcon(img));
	                  } catch (Exception ex) {
	                    System.out.println(ex);
	                  }
					jbStart.setPreferredSize(new Dimension(90,80));
					jbStart.setBackground(Color.WHITE);
					jbStart.setOpaque(true);
					jbStart.addActionListener(sa);
					panel.add(jbStart);
				}
				else if(i==1){
					JButton jbExit;
					jbExit = new JButton("Exit");
					try {
	                    Image img = ImageIO.read(new File("images/exit.png"));
	                    jbExit.setIcon(new ImageIcon(img));
	                  } catch (Exception ex) {
	                    System.out.println(ex);
	                  }
					jbExit.setPreferredSize(new Dimension(90,80));
					jbExit.setBackground(Color.WHITE);
					jbExit.setOpaque(true);
					jbExit.addActionListener(new ExitAction());
					panel.add(jbExit);
					
				}else if(i==3) {
					JButton jbRestart;
					jbRestart = new JButton("Restart Match");
					try {
	                    Image img = ImageIO.read(new File("images/restart.png"));
	                    jbRestart.setIcon(new ImageIcon(img));
	                  } catch (Exception ex) {
	                    System.out.println(ex);
	                  }
					jbRestart.setBackground(perso);
					jbRestart.setOpaque(true);
					jbRestart.addActionListener(null);
					panel.add(jbRestart);
				}else if(i==0) {
					JButton jbRestart;
					jbRestart = new JButton("Restart");
					try {
	                    Image img = ImageIO.read(new File("images/restart_all.png"));
	                    jbRestart.setIcon(new ImageIcon(img));
	                  } catch (Exception ex) {
	                    System.out.println(ex);
	                  }
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
		groupLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		groupLabel.setForeground(Color.WHITE);
		groupLabel.setBackground(blue_sky);
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
    		scoreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            scoreLabel.setForeground(Color.WHITE);
    		scoreLabel.setBackground(blue_middle);
    		scoreLabel.setOpaque(true);
            standingPanel.add(scoreLabel);
        }
        if(group.equals("Group A")) {
        	JButton jbRestart;
			jbRestart = new JButton("Restart");
			try {
                Image img = ImageIO.read(new File("images/restart_all.png"));
                jbRestart.setIcon(new ImageIcon(img));
              } catch (Exception ex) {
                System.out.println(ex);
              }
			jbRestart.setBackground(Color.WHITE);
			jbRestart.setOpaque(true);
			jbRestart.addActionListener(new RestartAction(mf));
			standingPanel.add(jbRestart);
        }
        if(group.equals("Group B")) {
            JButton jbExit;
            jbExit = new JButton("Exit");
            try {
                Image img = ImageIO.read(new File("images/exit.png"));
                jbExit.setIcon(new ImageIcon(img));
              } catch (Exception ex) {
                System.out.println(ex);
              }
            jbExit.setBackground(Color.WHITE);
            jbExit.setOpaque(true);
            jbExit.addActionListener(new ExitAction());
            standingPanel.add(jbExit);
        }
        if(group.equals("Group C")) {
            JButton jbKnock;
            jbKnock = new JButton("Knockout Phase");
            try {
                Image img = ImageIO.read(new File("images/knockout_phase.png"));
                jbKnock.setIcon(new ImageIcon(img));
              } catch (Exception ex) {
                System.out.println(ex);
              }
            jbKnock.setBackground(Color.WHITE);
            jbKnock.setOpaque(true);
            KnockoutAction na = new KnockoutAction(this.mf);
            jbKnock.addActionListener(na);
            standingPanel.add(jbKnock);
        }if(group.equals("Group D")) {
        	JButton jbRestart;
			jbRestart = new JButton("Restart Match");
			try {
                Image img = ImageIO.read(new File("images/restart.png"));
                jbRestart.setIcon(new ImageIcon(img));
              } catch (Exception ex) {
                System.out.println(ex);
              }
			jbRestart.setBackground(Color.WHITE);
			jbRestart.setOpaque(true);
			jbRestart.addActionListener(new RestartMatchAction(mf,mf.getGroupPhase()));
			standingPanel.add(jbRestart);
        }
        standingPanel.setOpaque(false);
        this.add(standingPanel);
    }

	public MainFrame getMf() {
		return mf;
	}

	public void setMf(MainFrame mf) {
		this.mf = mf;
	}

	
	
}


