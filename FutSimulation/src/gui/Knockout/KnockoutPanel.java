package gui.Knockout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.LinkedList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import data.Match;

public class KnockoutPanel extends JPanel{
	private GridBagConstraints c;
	private LinkedList<Match> alMatch;

	private static final long serialVersionUID = 5552019855023405334L;

	public KnockoutPanel() {
		super();
		this.setLayout(new GridBagLayout());
		this.c = new GridBagConstraints();
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString("dzdzdzdzdzdzdzdzd", 10, 10);
		drawQuarters(this.alMatch,g);
	}
	
	public void drawQuarters(LinkedList<Match> alMatch, Graphics g) {
		Match m1 = alMatch.get(0);
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
		JLabel teamLabelM4B = new JLabel(m4.getTeamB().getTeamName());
		
		c.fill = GridBagConstraints.HORIZONTAL;
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
	
	public LinkedList<Match> getAlMatch() {
		return alMatch;
	}
	public void setAlMatch(LinkedList<Match> alMatch) {
		this.alMatch = alMatch;
	}
	
	

}
