package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import data.GroupPhase;
import data.KnockoutPhase;
import data.Team;
import data.TeamData;
import gui.actions.ExitAction;
import gui.actions.StartAction;
import listener.Mouse;
import process.GroupPhaseSimulation;
import process.KnockoutPhaseSimulation;

public class Start extends JFrame{

	public KnockoutPhaseSimulation kss;
	private static final long serialVersionUID = 0;
		
	public Start() {
		super("Start FutSimulation");
		this.addMouseListener(new Mouse());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setPreferredSize(new Dimension(GlobalParameter.STARTFRAME_WIDTH,GlobalParameter.STARTRAME_HEIGHT));
		this.setMinimumSize(new Dimension(GlobalParameter.STARTFRAME_WIDTH,GlobalParameter.STARTRAME_HEIGHT));
		this.setResizable(false);
		this.getContentPane().setBackground(Color.GRAY);
		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		DrawPane dp = new DrawPane();

		this.add(dp);
		this.revalidate();
		this.repaint();
	}
	
	class DrawPane extends JPanel{
		Font font = new Font("SansSerif", Font.BOLD, 40);
		public DrawPane() {
			super();
		}
		private static final long serialVersionUID = 7690322266208392032L;
		protected void paintComponent(Graphics g){
			super.paintComponent(g); 
			try {
		           Image img = ImageIO.read(new File("images/viewBackground_base.png"));
		           g.drawImage(img, 0, 0, 800, 500, null, null);
		        } catch (Exception ex) {
		           System.out.println(ex);
		        }
			
			g.setFont(font);
			g.setColor(Color.WHITE);
			g.drawString("FutSimulation", 270, 80);
			g.drawString("Quitter", 100, 380);
			
			g.drawString("Commencer", 500, 360);
			g.drawString("Simulation", 517, 400);
			
			if(chooseOption()) {
				JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
				topFrame.dispose();
			}
			repaint();
		}
	}
	
	public void createMainFrame() {
		MainFrame mf = new MainFrame();
	    mf.getContentPane().removeAll();
	    TeamData td = new TeamData();
	    ArrayList<Team> al = new ArrayList<Team>();
	    td.createTeams(al);
	    GroupPhaseSimulation groupePhase = new GroupPhaseSimulation();
	    mf.setGroupPhase(groupePhase);
	    groupePhase.setAlTeams(al);
	    groupePhase.simulate();

	    groupePhase.gp.getListMatchGroupA().get(0);


	    System.out.println(groupePhase.groupToString());
	    System.out.println(groupePhase.matchsToString());
	    System.out.println(groupePhase.standingToString());


	    KnockoutPhaseSimulation ks = new KnockoutPhaseSimulation();
	    ks.setListQuarter(groupePhase.gp.getStandingGroupA(), groupePhase.gp.getStandingGroupB(), groupePhase.gp.getStandingGroupC(), groupePhase.gp.getStandingGroupD());
	    ks.simulate();
	    System.out.println(ks.quartersToString());
	    System.out.println(ks.semiToString());
	    System.out.println(ks.finalToString());

	    mf.createGroupPhasePanel(groupePhase.gp, ks.kp, groupePhase);
	    
	    this.kss = ks;
	    mf.revalidate();
	    mf.repaint();

	}
	
	public boolean chooseOption() {
		if(Mouse.y > 330 && Mouse.y < GlobalParameter.STARTRAME_HEIGHT + 30) {
			if(Mouse.x > 0 && Mouse.x < 400) {
				return true;
			}
			if(Mouse.x > 400 && Mouse.x < 800) {
				createMainFrame();
				return true;
			}
		}
		return false;
	}
}
