package gui.Knockout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.KnockoutPhase;
import data.Match;
import gui.JImagePanel;
import gui.JLinePanel;
import gui.MainFrame;
import gui.actions.ExitAction;
import gui.actions.NextAction;
import gui.actions.PreviousAction;

public class KnockoutPanel extends JPanel{
	private GridBagConstraints c;
	//private LinkedList<Match> alMatch;

	private static final long serialVersionUID = 5552019855023405334L;
	private Image KnockoutBackground;
	private KnockoutPhase kp;
	private int stage;
	private MainFrame mf;

	public KnockoutPanel(KnockoutPhase kp, MainFrame mf) {
		super();
		this.kp = kp;
		this.stage = 1;
		this.mf = mf;
		this.setLayout(new GridLayout(8,11));
	}
	
	protected void paintComponent(Graphics g){
	    super.paintComponent(g); 
	    try {
	    	KnockoutBackground = ImageIO.read(new File("images/backtest.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(KnockoutBackground, 0, 0, mf.getWidth(), mf.getHeight(), null);
	}
	public String score(Match m, int team) {
		int score1, score2, pen;
		if(team == 1) {
			score1 = m.getScoreA();
			score2 = m.getScoreB();
			pen = m.getPenA();
		}
		else {
			score1 = m.getScoreB();
			score2 = m.getScoreA();
			pen = m.getPenB();
		}
		if(score1 == score2) {
			return score1+" +"+pen;
		}
		else {
			return Integer.toString(score1);
		}
			
	}
	
	public void drawQuarters() {
		//JPanel standingPpanel = new JPanel();
		
		for(int i=0; i<88; i++) {
			
			switch(i) {
			  case 0:
				  JImagePanel jip0;
				  if(this.stage > 1) {
					  jip0 = new JImagePanel(kp.getListQuarter().get(0).getTeamA().getFlagPath(), kp.getListQuarter().get(0).getTeamA().getTeamName(), score(kp.getListQuarter().get(0),1));
					  jip0.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(0).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(0).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(0)));
			                	

			                }  
			            });
				  }
				  else {
					  jip0 = new JImagePanel(kp.getListQuarter().get(0).getTeamA().getFlagPath(), kp.getListQuarter().get(0).getTeamA().getTeamName(), null);			 
				  }
				  jip0.setOpaque(false);
				  this.add(jip0);
				  //JLabel scoreLabe0 = new JLabel(kp.getListQuarter().get(0).getTeamA().getTeamName() + " : " + kp.getListQuarter().get(0).getScoreA(), SwingConstants.CENTER);
				  //this.add(scoreLabe0);
			    break;
			  case 1:
				  	JLinePanel jip1 = new JLinePanel("RightAngleRB");
				  	jip1.setOpaque(false);
					this.add(jip1);
			    break;
			  case 9:
				  	JLinePanel jip9 = new JLinePanel("RightAngleLB");
				  	jip9.setOpaque(false);
					this.add(jip9);
			    break;
			  case 10:
				  JImagePanel jip10;
				  if(this.stage > 1) {
					  jip10 = new JImagePanel(kp.getListQuarter().get(2).getTeamA().getFlagPath(), kp.getListQuarter().get(2).getTeamA().getTeamName(), score(kp.getListQuarter().get(2),1));
					  jip10.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(2).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(2).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(2)));
			                	

			                }  
			            });
				  }
				  
				  else {
					  jip10 = new JImagePanel(kp.getListQuarter().get(2).getTeamA().getFlagPath(), kp.getListQuarter().get(2).getTeamA().getTeamName(), null);
				  }
				  //JLabel scoreLabel10 = new JLabel(kp.getListQuarter().get(2).getTeamA().getTeamName(), SwingConstants.CENTER);
				  jip10.setOpaque(false);
				  this.add(jip10);
			    break;
			  case 12:
				  	JLinePanel jip12 = new JLinePanel("RightSwitchAngle");
				  	jip12.setOpaque(false);
					this.add(jip12);
			    break;
			  case 13:
				  JImagePanel jip13;
				  if(this.stage == 2) {
					  jip13 = new JImagePanel(kp.getListSemi().get(0).getTeamA().getFlagPath(), kp.getListSemi().get(0).getTeamA().getTeamName(), null);
					  
				  }
				  else if(this.stage >= 3 ) {
					  jip13 = new JImagePanel(kp.getListSemi().get(0).getTeamA().getFlagPath(), kp.getListSemi().get(0).getTeamA().getTeamName(), score(kp.getListSemi().get(0),1));
					  //JLabel scoreLabel13 = new JLabel(kp.getListQuarter().get(0).getWinner().getTeamName(), SwingConstants.CENTER);
					  jip13.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListSemi().get(0).getTeamA().getTeamName()+" - "+kp.getListSemi().get(0).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListSemi().get(0)));
			                	

			                }  
			            });
				  }
				  else {
					  jip13 = new JImagePanel(kp.getListSemi().get(0).getTeamA().getFlagPath(), kp.getListSemi().get(0).getTeamA().getTeamName(), score(kp.getListSemi().get(0),1),true);
				  }
				  jip13.setOpaque(false);
				  this.add(jip13);
			    break;
			  case 14:
				  	JLinePanel jip14 = new JLinePanel("RightAngleRB");
				  	jip14.setOpaque(false);
					this.add(jip14);
			    break;
			  case 18:
				  	JLinePanel jip18 = new JLinePanel("RightAngleLB");
				  	jip18.setOpaque(false);
					this.add(jip18);
			    break;
			  case 19:
				  JImagePanel jip19;
				  if(this.stage == 2) {
					  jip19 = new JImagePanel(kp.getListSemi().get(1).getTeamA().getFlagPath(), kp.getListSemi().get(1).getTeamA().getTeamName(), null);
					  
				  }
				  else if(this.stage >= 3 ) {
					  jip19 = new JImagePanel(kp.getListSemi().get(1).getTeamA().getFlagPath(), kp.getListSemi().get(1).getTeamA().getTeamName(), score(kp.getListSemi().get(1),1));
					  //JLabel scoreLabel19 = new JLabel(kp.getListQuarter().get(2).getWinner().getTeamName(), SwingConstants.CENTER);	
					  jip19.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListSemi().get(1).getTeamA().getTeamName()+" - "+kp.getListSemi().get(1).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListSemi().get(1)));
			                	

			                }  
			            });
				  }
				  else {
					  jip19 = new JImagePanel(kp.getListSemi().get(1).getTeamA().getFlagPath(), kp.getListSemi().get(1).getTeamA().getTeamName(), score(kp.getListSemi().get(1),1),true);
				  }
				  jip19.setOpaque(false);
				  this.add(jip19);
			    break;
			  case 20:
				  	JLinePanel jip20 = new JLinePanel("LeftSwitchAngle");
				  	jip20.setOpaque(false);
					this.add(jip20);
			    break;
			  case 22:
				  JImagePanel jip22;
				  if(this.stage > 1 ) {
					  jip22 = new JImagePanel(kp.getListQuarter().get(0).getTeamB().getFlagPath(), kp.getListQuarter().get(0).getTeamB().getTeamName(), score(kp.getListQuarter().get(0),0));
					  jip22.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(0).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(0).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(0)));
			                	

			                }  
			            });
				  }
				  else {
					  jip22 = new JImagePanel(kp.getListQuarter().get(0).getTeamB().getFlagPath(), kp.getListQuarter().get(0).getTeamB().getTeamName(), null);
						
				  }
				  //JLabel scoreLabel22 = new JLabel(kp.getListQuarter().get(0).getTeamB().getTeamName(), SwingConstants.CENTER);
				  jip22.setOpaque(false);
				  this.add(jip22);
			    break;
			  case 23:
				  	JLinePanel jip23 = new JLinePanel("RightAngleRT");
				  	jip23.setOpaque(false);
					this.add(jip23);
			    break;
			  case 25:
				  	JLinePanel jip25 = new JLinePanel("VerticalLine");
				  	jip25.setOpaque(false);
					this.add(jip25);
			    break;
			  case 27:
				  JImagePanel jip27;
				  if(this.stage == 0) {
					  jip27 = new JImagePanel(kp.getFinalMatch().getWinner().getFlagPath(), kp.getFinalMatch().getWinner().getTeamName(), null);
						
				  }
				  else if(this.stage >= 4) {
					  jip27 = new JImagePanel(kp.getFinalMatch().getWinner().getFlagPath(), kp.getFinalMatch().getWinner().getTeamName(), "Win");
					  //JLabel scoreLabel27 = new JLabel(kp.getFinalMatch().getWinner().getTeamName(), SwingConstants.CENTER);  
				  }
				  else {
					  jip27 = new JImagePanel(kp.getFinalMatch().getWinner().getFlagPath(), kp.getFinalMatch().getWinner().getTeamName(), "Win",true);
				  }
				  jip27.setOpaque(false);
				  this.add(jip27);
			    break;
			  case 29:
				  	JLinePanel jip29 = new JLinePanel("VerticalLine");
				  	jip29.setOpaque(false);
					this.add(jip29);
			    break;
			  case 31:
				  	JLinePanel jip31 = new JLinePanel("RightAngleLT");
				  	jip31.setOpaque(false);
					this.add(jip31);
			    break;
			  case 32:
				  JImagePanel jip32;
				  if(this.stage > 1) {
					  jip32 = new JImagePanel(kp.getListQuarter().get(2).getTeamB().getFlagPath(), kp.getListQuarter().get(2).getTeamB().getTeamName(), score(kp.getListQuarter().get(2),0));
					  jip32.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(2).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(2).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(2)));
			                	

			                }  
			            });
				  }
				  else {
					  jip32 = new JImagePanel(kp.getListQuarter().get(2).getTeamB().getFlagPath(), kp.getListQuarter().get(2).getTeamB().getTeamName(), null);
						 
				  }
				  //JLabel scoreLabel32 = new JLabel(kp.getListQuarter().get(2).getTeamB().getTeamName(), SwingConstants.CENTER);
				  jip32.setOpaque(false);
				  this.add(jip32);
			    break;
			  case 36:
				  	JLinePanel jip36 = new JLinePanel("RightSwitchAngle");
				  	jip36.setOpaque(false);
					this.add(jip36);
			    break;
			  case 37:
				  JImagePanel jip37;
				  if(this.stage == 3) {
					  jip37 = new JImagePanel(kp.getFinalMatch().getTeamA().getFlagPath(), kp.getFinalMatch().getTeamA().getTeamName(), null);
				  }
				  else if(this.stage >= 4) {
					  jip37 = new JImagePanel(kp.getFinalMatch().getTeamA().getFlagPath(), kp.getFinalMatch().getTeamA().getTeamName(), score(kp.getFinalMatch(),1));
					  //JLabel scoreLabel37 = new JLabel(kp.getListSemi().get(0).getWinner().getTeamName(), SwingConstants.CENTER);
					  jip37.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getFinalMatch().getTeamA().getTeamName()+" - "+kp.getFinalMatch().getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getFinalMatch()));
			                	

			                }  
			            });
				  }
				  
				  else {
					  jip37 = new JImagePanel(kp.getFinalMatch().getTeamA().getFlagPath(), kp.getFinalMatch().getTeamA().getTeamName(), score(kp.getFinalMatch(),1),true);
				  }
				  jip37.setOpaque(false);
				  this.add(jip37);
			    break;
			  case 38:
				  	JLinePanel jip38 = new JLinePanel("TopSwitchAngle");
				  	jip38.setOpaque(false);
					this.add(jip38);
			    break;
			  case 39:
				  JImagePanel jip39;
				  if(this.stage == 3) {
					  jip39 = new JImagePanel(kp.getFinalMatch().getTeamB().getFlagPath(), kp.getFinalMatch().getTeamB().getTeamName(), null);
				  }
				  else if(this.stage >= 4) {
					  jip39 = new JImagePanel(kp.getFinalMatch().getTeamB().getFlagPath(), kp.getFinalMatch().getTeamB().getTeamName(), score(kp.getFinalMatch(),0));
					  //JLabel scoreLabel39 = new JLabel(kp.getListSemi().get(1).getWinner().getTeamName(), SwingConstants.CENTER);
					  jip39.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getFinalMatch().getTeamA().getTeamName()+" - "+kp.getFinalMatch().getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getFinalMatch()));
			                	

			                }  
			            });
				  }
				  else {
					  jip39 = new JImagePanel(kp.getFinalMatch().getTeamB().getFlagPath(), kp.getFinalMatch().getTeamB().getTeamName(), score(kp.getFinalMatch(),0),true);
				  }
				  jip39.setOpaque(false);
				  this.add(jip39);
			    break;
			  case 40:
				  	JLinePanel jip40 = new JLinePanel("LeftSwitchAngle");
				  	jip40.setOpaque(false);
					this.add(jip40);
			    break;
			  case 44:
				  JImagePanel jip44;
				  if(this.stage > 1 ) {
					  jip44 = new JImagePanel(kp.getListQuarter().get(1).getTeamA().getFlagPath(), kp.getListQuarter().get(1).getTeamA().getTeamName(), score(kp.getListQuarter().get(1),1));
					  jip44.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(1).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(1).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(1)));
			                	

			                }  
			            });
				  }
				  else {
					  jip44 = new JImagePanel(kp.getListQuarter().get(1).getTeamA().getFlagPath(), kp.getListQuarter().get(1).getTeamA().getTeamName(),null);
						
				  }
				  //JLabel scoreLabel44 = new JLabel(kp.getListQuarter().get(1).getTeamA().getTeamName(), SwingConstants.CENTER);
				  jip44.setOpaque(false);
				  this.add(jip44);
			    break;
			  case 45:
				  	JLinePanel jip45 = new JLinePanel("RightAngleRB");
				  	jip45.setOpaque(false);
					this.add(jip45);
			    break;
			  case 47:
				  	JLinePanel jip47 = new JLinePanel("VerticalLine");
				  	jip47.setOpaque(false);
					this.add(jip47);
			    break;
			  case 51:
				  	JLinePanel jip51 = new JLinePanel("VerticalLine");
				  	jip51.setOpaque(false);
					this.add(jip51);
			    break;
			  case 53:
				  	JLinePanel jip53 = new JLinePanel("RightAngleLB");
				  	jip53.setOpaque(false);
					this.add(jip53);
			    break;
			  case 54:
				  JImagePanel jip54;
				  if(this.stage > 1) {
					  jip54 = new JImagePanel(kp.getListQuarter().get(3).getTeamA().getFlagPath(), kp.getListQuarter().get(3).getTeamA().getTeamName(), score(kp.getListQuarter().get(3),1));
					  jip54.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(3).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(3).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(3)));
			                	

			                }  
			            });
				  }
				  else {
					  jip54 = new JImagePanel(kp.getListQuarter().get(3).getTeamA().getFlagPath(), kp.getListQuarter().get(3).getTeamA().getTeamName(), null);
						
				  }
				  //JLabel scoreLabel54 = new JLabel(kp.getListQuarter().get(3).getTeamA().getTeamName(), SwingConstants.CENTER);
				  jip54.setOpaque(false);
				  this.add(jip54);
			    break;
			  case 56:
				  	JLinePanel jip56 = new JLinePanel("RightSwitchAngle");
				  	jip56.setOpaque(false);
					this.add(jip56);
			    break;
			  case 57:
				  JImagePanel jip57;
				  if(this.stage == 2 ) {
					  jip57 = new JImagePanel(kp.getListSemi().get(0).getTeamB().getFlagPath(), kp.getListSemi().get(0).getTeamB().getTeamName(), null);
						 
				  }
				  else if(this.stage >= 3) {
					  jip57 = new JImagePanel(kp.getListSemi().get(0).getTeamB().getFlagPath(), kp.getListSemi().get(0).getTeamB().getTeamName(), score(kp.getListSemi().get(0),0));
					  //JLabel scoreLabel57 = new JLabel(kp.getListQuarter().get(1).getWinner().getTeamName(), SwingConstants.CENTER);
					  jip57.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListSemi().get(0).getTeamA().getTeamName()+" - "+kp.getListSemi().get(0).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListSemi().get(0)));
			                	

			                }  
			            });
				  }
				  else {
					  jip57 = new JImagePanel(kp.getListSemi().get(0).getTeamB().getFlagPath(), kp.getListSemi().get(0).getTeamB().getTeamName(), score(kp.getListSemi().get(0),0),true);
				  }
				  jip57.setOpaque(false);
				  this.add(jip57);
			    break;
			  case 58:
				  	JLinePanel jip58 = new JLinePanel("RightAngleRT");
				  	jip58.setOpaque(false);
					this.add(jip58);
			    break;
			  case 62:
				  	JLinePanel jip62 = new JLinePanel("RightAngleLT");
				  	jip62.setOpaque(false);
					this.add(jip62);
			    break;
			  case 63:
				  JImagePanel jip63;
				  if(this.stage == 2) {
					  jip63 = new JImagePanel(kp.getListSemi().get(1).getTeamB().getFlagPath(), kp.getListSemi().get(1).getTeamB().getTeamName(), null);
				  }
				  else if(this.stage >= 3) {
					  jip63 = new JImagePanel(kp.getListSemi().get(1).getTeamB().getFlagPath(), kp.getListSemi().get(1).getTeamB().getTeamName(), score(kp.getListSemi().get(0),0));
					  //JLabel scoreLabel63 = new JLabel(kp.getListQuarter().get(3).getWinner().getTeamName(), SwingConstants.CENTER); 
					  jip63.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListSemi().get(1).getTeamA().getTeamName()+" - "+kp.getListSemi().get(1).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListSemi().get(1)));
			                	

			                }  
			            });
				  }
				  else {
					  jip63 = new JImagePanel(kp.getListSemi().get(1).getTeamB().getFlagPath(), kp.getListSemi().get(1).getTeamB().getTeamName(), score(kp.getListSemi().get(0),0),true);
				  }
				  jip63.setOpaque(false);
				  this.add(jip63);
			    break;
			  case 64:
				  	JLinePanel jip64 = new JLinePanel("LeftSwitchAngle");
				  	jip64.setOpaque(false);
					this.add(jip64);
			    break;
			  case 66:
				  JImagePanel jip66;
				  if(this.stage > 1) {
					  jip66 = new JImagePanel(kp.getListQuarter().get(1).getTeamB().getFlagPath(), kp.getListQuarter().get(1).getTeamB().getTeamName(), score(kp.getListQuarter().get(1),0));
					  jip66.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(1).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(1).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(1)));
			                	

			                }  
			            });
				  }
				  else {
					  jip66 = new JImagePanel(kp.getListQuarter().get(1).getTeamB().getFlagPath(), kp.getListQuarter().get(1).getTeamB().getTeamName(), null);
						
				  }
				  //JLabel scoreLabel66 = new JLabel(kp.getListQuarter().get(1).getTeamB().getTeamName(), SwingConstants.CENTER);
				  jip66.setOpaque(false);
				  this.add(jip66);
			    break;
			  case 67:
				  	JLinePanel jip67 = new JLinePanel("RightAngleRT");
				  	jip67.setOpaque(false);
					this.add(jip67);
			    break;
			  case 75:
				  	JLinePanel jip75 = new JLinePanel("RightAngleLT");
				  	jip75.setOpaque(false);
					this.add(jip75);
			    break;
			  case 76:
				  JImagePanel jip76;
				  if(this.stage > 1 ) {
					  jip76 = new JImagePanel(kp.getListQuarter().get(3).getTeamB().getFlagPath(), kp.getListQuarter().get(3).getTeamB().getTeamName(), score(kp.getListQuarter().get(3),0));
					  jip76.addMouseListener(new MouseAdapter()  
			            {  
			                public void mouseClicked(MouseEvent e)  
			                {  
			                	MainFrame frameMatch = new MainFrame();
			                	frameMatch.setTitle(kp.getListQuarter().get(3).getTeamA().getTeamName()+" - "+kp.getListQuarter().get(3).getTeamB().getTeamName());
			                	frameMatch.createMatchView((kp.getListQuarter().get(3)));
			                	

			                }  
			            });
				  }
				  else {
					  jip76 = new JImagePanel(kp.getListQuarter().get(3).getTeamB().getFlagPath(), kp.getListQuarter().get(3).getTeamB().getTeamName(), null);
						
				  }
				  //JLabel scoreLabel76 = new JLabel(kp.getListQuarter().get(3).getTeamB().getTeamName(), SwingConstants.CENTER);
				  jip76.setOpaque(false);
				  this.add(jip76);
			    break;
			  case 81:
                  JPanel p1 = new JPanel();
                  p1.setOpaque(false);
                
                 // BufferedImage buttonIcon = null;
                  JButton jbPrev = new JButton();
                  try {
                    Image img = ImageIO.read(new File("images/flecheGauche.png"));
                    jbPrev.setIcon(new ImageIcon(img));
                  } catch (Exception ex) {
                    System.out.println(ex);
                  }
                 
                  jbPrev.setPreferredSize(new Dimension(90,80));        
                  jbPrev.setBorder(BorderFactory.createEmptyBorder());
                  jbPrev.setContentAreaFilled(false);
                //  JButton jbPrev = new JButton("Next");
                    
                //  jbPrev.setPreferredSize(new Dimension(100, 100));
                  jbPrev.addActionListener(new PreviousAction(mf,this));
                  p1.add(jbPrev);
                  this.add(p1);
                  
                  break;
			  case 82:
                  JPanel p0 = new JPanel();
                  p0.setOpaque(false);
                  
                  
                  
                // BufferedImage buttonIcon = null;
                  JButton jbExit = new JButton();
                  try {
                    Image img = ImageIO.read(new File("images/close.png"));
                    jbExit.setIcon(new ImageIcon(img));
                  } catch (Exception ex) {
                    System.out.println(ex);
                  }
                 
                  jbExit.setPreferredSize(new Dimension(90,80));        
                  jbExit.setBorder(BorderFactory.createEmptyBorder());
                  jbExit.setContentAreaFilled(false);
                //  JButton jbNext = new JButton("Next");
                    
                //  jbNext.setPreferredSize(new Dimension(100, 100));
                  jbExit.addActionListener(new ExitAction());
                  p0.add(jbExit);
                  this.add(p0);
                  break;
                  
                  
                  
                  /**
                  JButton jbExit = new JButton("Exit");
                  jbExit.setPreferredSize(new Dimension(100, 100));
                  jbExit.addActionListener(new ExitAction());
                  this.add(jbExit);
                  break;
                  **/
                  
                  
                  
              case 83:
                  JPanel p2 = new JPanel();
                  p2.setOpaque(false);
                
                 // BufferedImage buttonIcon = null;
                  JButton jbNext = new JButton();
                  try {
                    Image img = ImageIO.read(new File("images/flecheDroite.png"));
                    jbNext.setIcon(new ImageIcon(img));
                  } catch (Exception ex) {
                    System.out.println(ex);
                  }
                 
                      jbNext.setPreferredSize(new Dimension(90,80));        
                    jbNext.setBorder(BorderFactory.createEmptyBorder());
                    jbNext.setContentAreaFilled(false);
                //  JButton jbNext = new JButton("Next");
                    
                //  jbNext.setPreferredSize(new Dimension(100, 100));
                  jbNext.addActionListener(new NextAction(this));
                  p2.add(jbNext);
                  this.add(p2);
                  
                  break;
                  
              
              default:
                      JPanel standingPpanel = new JPanel();
                      standingPpanel.setOpaque(false);
                    //standingPpanel.setBackground(Color.BLACK);
                    this.add(standingPpanel);
            }
			
			/*if(i==2) {
				JPanel standingPpanel = new JPanel();
				standingPpanel.setBackground(Color.BLUE);
				this.add(standingPpanel);

			}else {
				JPanel standingPpanel = new JPanel();
				standingPpanel.setBackground(Color.BLACK);
				this.add(standingPpanel);
			}*/
		}
		/*JPanel standingPpanel2 = new JPanel();
		JPanel standingPpanel3 = new JPanel();
		JPanel standingPpanel4 = new JPanel();
		JPanel standingPpanel5 = new JPanel();
		JPanel standingPpanel6 = new JPanel();
		JPanel standingPpanel7 = new JPanel();
		JPanel standingPpanel8 = new JPanel();
		JPanel standingPpanel9 = new JPanel();

		JPanel standingPpanel10 = new JPanel();
		JPanel standingPpanel11 = new JPanel();
		JPanel standingPpanel12 = new JPanel();
		JPanel standingPpanel13 = new JPanel();
		JPanel standingPpanel14 = new JPanel();
		JPanel standingPpanel15 = new JPanel();
		
		JLabel eq1 = new JLabel("France", SwingConstants.CENTER);
		
		standingPpanel.setBackground(Color.BLACK);
		standingPpanel2.setBackground(Color.RED);
		standingPpanel3.setBackground(Color.CYAN);
		standingPpanel4.setBackground(Color.YELLOW);
		standingPpanel5.setBackground(Color.GRAY);
		standingPpanel6.setBackground(Color.GREEN);
		standingPpanel7.setBackground(Color.MAGENTA);
		standingPpanel8.setBackground(Color.WHITE);

		standingPpanel9.setBackground(Color.PINK);
		standingPpanel10.setBackground(Color.BLACK);
		standingPpanel11.setBackground(Color.BLACK);
		standingPpanel12.setBackground(Color.BLACK);
		standingPpanel13.setBackground(Color.BLACK);
		standingPpanel14.setBackground(Color.BLACK);
		standingPpanel15.setBackground(Color.BLACK);
		
		
		this.add(standingPpanel);
		this.add(standingPpanel2);
		this.add(standingPpanel3);
		this.add(standingPpanel4);
		this.add(standingPpanel5);
		this.add(standingPpanel6);
		this.add(standingPpanel7);
		this.add(standingPpanel8);
		this.add(standingPpanel9);

		this.add(standingPpanel10);
		this.add(standingPpanel11);
		this.add(standingPpanel12);
		this.add(standingPpanel13);
		this.add(standingPpanel14);
		this.add(standingPpanel15);*/
		
		
		/*Match m1 = alMatch.get(0);
		Match m2 = alMatch.get(1);
		Match m3 = alMatch.get(2);
		Match m4 = alMatch.get(3);

		JLabel teamLabelM1A = new JLabel(m1.getTeamA().getTeamName());
		JLabel teamLabelM1B = new JLabel(m1.getTeamB().getTeamName());
		JLabel teamLabelM2A = new JLabel(m2.getTeamA().getTeamName());
		JLabel teamLabelM2B = new JLabel(m2.getTeamB().getTeamName());
		
		JLabel teamLabelM3A = new JLabel(m3.getTeamA().getTeamName());
		JLabel teamLabelM3B = new JLabel(m3.getTeamB().getTeamName());
		JLabel teamLabelM4A = new JLabel(m4.getTeamA().getTeamName());
		JLabel teamLabelM4B = new JLabel(m4.getTeamB().getTeamName());*/
		
		/*c.fill = GridBagConstraints.HORIZONTAL;
		//c.weightx = 0.5;
		c.gridx = 10;
		c.gridy = 0;
		this.add(teamLabelM3A, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 10;
		c.gridy = 2;
		this.add(teamLabelM3B, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 10;
		c.gridy = 4;
		this.add(teamLabelM4A, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 10;
		c.gridy = 6;
		this.add(teamLabelM4B, c);
		
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		this.add(teamLabelM1A, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		this.add(teamLabelM1B, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 4;
		this.add(teamLabelM2A, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 6;
		this.add(teamLabelM2B, c);	
		*/
	}
	
	
	public void drawVerticalLine(int heigth, int width, Graphics g) {
		g.drawLine(width/2, heigth, width/2, 0);
	}
	public void drawHorizontalLine(int heigth, int width, Graphics g) {
		g.drawLine(0, heigth/2, width, heigth/2);
	}
	public void drawRightAngleLB(int heigth, int width, Graphics g) {
		g.drawLine(0, heigth/2, width/2, 0);
	}
	public void drawRightAngleRB(int heigth, int width, Graphics g) {
		g.drawLine(width, heigth/2, width/2, 0);
	}
	public void drawRightAngleLT(int heigth, int width, Graphics g) {
		g.drawLine(0, heigth/2, width/2, heigth);
	}
	public void drawRightAngleRT(int heigth, int width, Graphics g) {
		g.drawLine(width, heigth/2, width/2, heigth);
	}
	public void changeStage() {
		if(this.stage < 4) {
			this.stage++;
		}
	}
}
