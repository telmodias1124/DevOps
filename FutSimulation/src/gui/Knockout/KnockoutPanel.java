package gui.Knockout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import data.KnockoutPhase;
import data.Match;
import gui.JImagePanel;
import gui.JLinePanel;

public class KnockoutPanel extends JPanel{
	private GridBagConstraints c;
	//private LinkedList<Match> alMatch;

	private static final long serialVersionUID = 5552019855023405334L;

	public KnockoutPanel() {
		super();
		this.setLayout(new GridLayout(8,11));
	}
	
	public void drawQuarters(KnockoutPhase kp) {
		//JPanel standingPpanel = new JPanel();
		
		for(int i=0; i<88; i++) {
			
			switch(i) {
			  case 0:
				  JImagePanel jip0 = new JImagePanel(kp.getListQuarter().get(0).getTeamA().getFlagPath(), kp.getListQuarter().get(0).getTeamA().getTeamName(), kp.getListQuarter().get(0).getScoreA());
				  this.add(jip0);
				  //JLabel scoreLabe0 = new JLabel(kp.getListQuarter().get(0).getTeamA().getTeamName() + " : " + kp.getListQuarter().get(0).getScoreA(), SwingConstants.CENTER);
				  //this.add(scoreLabe0);
			    break;
			  case 1:
				  	JLinePanel jip1 = new JLinePanel("RightAngleRB");
					this.add(jip1);
			    break;
			  case 9:
				  	JLinePanel jip9 = new JLinePanel("RightAngleLB");
					this.add(jip9);
			    break;
			  case 10:
				  JLabel scoreLabel10 = new JLabel(kp.getListQuarter().get(2).getTeamA().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel10);
			    break;
			  case 12:
				  	JLinePanel jip12 = new JLinePanel("RightSwitchAngle");
					this.add(jip12);
			    break;
			  case 13:
				  JLabel scoreLabel13 = new JLabel(kp.getListQuarter().get(0).getWinner().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel13);
			    break;
			  case 14:
				  	JLinePanel jip14 = new JLinePanel("RightAngleRB");
					this.add(jip14);
			    break;
			  case 18:
				  	JLinePanel jip18 = new JLinePanel("RightAngleLB");
					this.add(jip18);
			    break;
			  case 19:
				  JLabel scoreLabel19 = new JLabel(kp.getListQuarter().get(2).getWinner().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel19);
			    break;
			  case 20:
				  	JLinePanel jip20 = new JLinePanel("LeftSwitchAngle");
					this.add(jip20);
			    break;
			  case 22:
				  JLabel scoreLabel22 = new JLabel(kp.getListQuarter().get(0).getTeamB().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel22);
			    break;
			  case 23:
				  	JLinePanel jip23 = new JLinePanel("RightAngleRT");
					this.add(jip23);
			    break;
			  case 25:
				  	JLinePanel jip25 = new JLinePanel("VerticalLine");
					this.add(jip25);
			    break;
			  case 27:
				  JLabel scoreLabel27 = new JLabel(kp.getFinalMatch().getWinner().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel27);
			    break;
			  case 29:
				  	JLinePanel jip29 = new JLinePanel("VerticalLine");
					this.add(jip29);
			    break;
			  case 31:
				  	JLinePanel jip31 = new JLinePanel("RightAngleLT");
					this.add(jip31);
			    break;
			  case 32:
				  JLabel scoreLabel32 = new JLabel(kp.getListQuarter().get(2).getTeamB().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel32);
			    break;
			  case 36:
				  	JLinePanel jip36 = new JLinePanel("RightSwitchAngle");
					this.add(jip36);
			    break;
			  case 37:
				  JLabel scoreLabel37 = new JLabel(kp.getListSemi().get(0).getWinner().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel37);
			    break;
			  case 38:
				  	JLinePanel jip38 = new JLinePanel("TopSwitchAngle");
					this.add(jip38);
			    break;
			  case 39:
				  JLabel scoreLabel39 = new JLabel(kp.getListSemi().get(1).getWinner().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel39);
			    break;
			  case 40:
				  	JLinePanel jip40 = new JLinePanel("LeftSwitchAngle");
					this.add(jip40);
			    break;
			  case 44:
				  JLabel scoreLabel44 = new JLabel(kp.getListQuarter().get(1).getTeamA().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel44);
			    break;
			  case 45:
				  	JLinePanel jip45 = new JLinePanel("RightAngleRB");
					this.add(jip45);
			    break;
			  case 47:
				  	JLinePanel jip47 = new JLinePanel("VerticalLine");
					this.add(jip47);
			    break;
			  case 51:
				  	JLinePanel jip51 = new JLinePanel("VerticalLine");
					this.add(jip51);
			    break;
			  case 53:
				  	JLinePanel jip53 = new JLinePanel("RightAngleLB");
					this.add(jip53);
			    break;
			  case 54:
				  JLabel scoreLabel54 = new JLabel(kp.getListQuarter().get(3).getTeamA().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel54);
			    break;
			  case 56:
				  	JLinePanel jip56 = new JLinePanel("RightSwitchAngle");
					this.add(jip56);
			    break;
			  case 57:
				  JLabel scoreLabel57 = new JLabel(kp.getListQuarter().get(1).getWinner().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel57);
			    break;
			  case 58:
				  	JLinePanel jip58 = new JLinePanel("RightAngleRT");
					this.add(jip58);
			    break;
			  case 62:
				  	JLinePanel jip62 = new JLinePanel("RightAngleLT");
					this.add(jip62);
			    break;
			  case 63:
				  JLabel scoreLabel63 = new JLabel(kp.getListQuarter().get(3).getWinner().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel63);
			    break;
			  case 64:
				  	JLinePanel jip64 = new JLinePanel("LeftSwitchAngle");
					this.add(jip64);
			    break;
			  case 66:
				  JLabel scoreLabel66 = new JLabel(kp.getListQuarter().get(1).getTeamB().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel66);
			    break;
			  case 67:
				  	JLinePanel jip67 = new JLinePanel("RightAngleRT");
					this.add(jip67);
			    break;
			  case 75:
				  	JLinePanel jip75 = new JLinePanel("RightAngleLT");
					this.add(jip75);
			    break;
			  case 76:
				  JLabel scoreLabel76 = new JLabel(kp.getListQuarter().get(3).getTeamB().getTeamName(), SwingConstants.CENTER);
				  this.add(scoreLabel76);
			    break;
			  
			  default:
				  	JPanel standingPpanel = new JPanel();
					standingPpanel.setBackground(Color.BLACK);
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
	
	
	

}
