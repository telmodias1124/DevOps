package gui.MatchView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseListener;
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
import data.Player;
import data.PlayerStatistic;
import data.Team;
import gui.GlobalParameter;
import gui.JImagePanel;
import gui.JLinePanel;
import gui.MainFrame;
import gui.actions.ExitAction;
import gui.actions.NextAction;
import listener.Mouse;


public class MatchView extends JPanel{
	private static final long serialVersionUID = 7690322266008392032L;
	//private LinkedList<Match> alMatch;

	private Image viewBackground;
	private Image field;
	private Image flag;
	private Image carte;
	private Match m;
	private MainFrame mf;
	private int state = 0;
	private static int MAINFRAME_WIDTH = GlobalParameter.MAINFRAME_WIDTH;
	private static int MAINFRAME_HEIGHT = GlobalParameter.MAINFRAME_HEIGHT;
	Font font = new Font("SansSerif", Font.BOLD, 18);
	Font fontScore = new Font("SansSerif", Font.BOLD, 40);

	public MatchView() {
		super();
	}
	
	public MatchView(Match m, MainFrame mf) {
		super();
		this.m = m;
		this.mf = mf;
	}
	
	
	protected void paintComponent(Graphics g){
		
		super.paintComponent(g); 
	    g.setFont(font);
	    g.setColor(Color.BLACK);
	    
	    g = drawImages(g);
	    //Phase + deroulement
	    g.fillRect((650*mf.getWidth())/MAINFRAME_WIDTH, (475*mf.getHeight())/MAINFRAME_HEIGHT, (200*mf.getWidth())/MAINFRAME_WIDTH, (100*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.fillRect((450*mf.getWidth())/MAINFRAME_WIDTH, (600*mf.getHeight())/MAINFRAME_HEIGHT, (600*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT);
	   
	    g.setColor(Color.WHITE);
	    g.setFont(fontScore);

	    g.drawString(Integer.toString(m.getScoreA()), (415*mf.getWidth())/MAINFRAME_WIDTH, (555*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(Integer.toString(m.getScoreB()), (1065*mf.getWidth())/MAINFRAME_WIDTH, (555*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString("00:00", (700*mf.getWidth())/MAINFRAME_WIDTH, (550*mf.getHeight())/MAINFRAME_HEIGHT);
	    
	    g.setFont(font);

	    //Drapeau et equipe
	    
	    g.drawString(m.getTeamA().getTeamName(), ((MAINFRAME_WIDTH - 435)*mf.getWidth()/MAINFRAME_WIDTH), ((460*mf.getHeight())/MAINFRAME_HEIGHT));
	    g.drawString(m.getTeamB().getTeamName(), ((MAINFRAME_WIDTH - 1035)*mf.getWidth()/MAINFRAME_WIDTH), ((460*mf.getHeight())/MAINFRAME_HEIGHT));
	    
	    g.drawString(Integer.toString(m.getAlrecap().size()), 400, 620);
	    g.drawString(Integer.toString(state), 400, 640);
	   
	    g = drawRecap(g);
	    	
	    g = drawPlayers(g);
	    
	    g = drawStatistiqes(g);

	    g.setColor(Color.WHITE);
	    g.drawLine(0, 600, mf.getWidth(), 600);
	    
	    repaint();
	}
	
	public Graphics choosePlayer(int x, int y, Player p, Team t, Graphics g) {
		int length = ((p.getFirstName().length()+p.getLastName().length())*14)+10;
		int newY = y + 30;
		int moyenne = (p.getPlayerStatistic().getPace()+p.getPlayerStatistic().getShoot()+p.getPlayerStatistic().getPass()+p.getPlayerStatistic().getDribble()+p.getPlayerStatistic().getDef()+p.getPlayerStatistic().getPhysique())/6;
		if(Mouse.x > x && Mouse.x < x + length && Mouse.y > newY && Mouse.y < newY + 20) {
			try {
			    carte = ImageIO.read(new File("images/carte_vierge.png"));
			}
			catch (Exception e) { /*handled in paintComponent()*/ }
		    g.drawImage(carte, (618*mf.getWidth())/MAINFRAME_WIDTH, (120*mf.getHeight())/MAINFRAME_HEIGHT, (256*mf.getWidth())/MAINFRAME_WIDTH, (369*mf.getHeight())/MAINFRAME_HEIGHT, null);
			g.drawString(Integer.toString(moyenne), (680*mf.getWidth())/MAINFRAME_WIDTH, (225*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(p.getPosition(), (685*mf.getWidth())/MAINFRAME_WIDTH, (255*mf.getHeight())/MAINFRAME_HEIGHT);
			try {
			    carte = ImageIO.read(new File(t.getFlagPath()));
			}
			catch (Exception e) { /*handled in paintComponent()*/ }
		    g.drawImage(carte, (720*mf.getWidth())/MAINFRAME_WIDTH, (230*mf.getHeight())/MAINFRAME_HEIGHT, (80*mf.getWidth())/MAINFRAME_WIDTH, (80*mf.getHeight())/MAINFRAME_HEIGHT, null);
			g.drawString(p.getFirstName().substring(0,1)+". "+p.getLastName(), (670*mf.getWidth())/MAINFRAME_WIDTH, (340*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPace()), (670*mf.getWidth())/MAINFRAME_WIDTH, (375*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getShoot()), (670*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPass()), (670*mf.getWidth())/MAINFRAME_WIDTH, (425*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getDribble()), (765*mf.getWidth())/MAINFRAME_WIDTH, (375*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getDef()), (765*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPhysique()), (765*mf.getWidth())/MAINFRAME_WIDTH, (425*mf.getHeight())/MAINFRAME_HEIGHT);
		}
		return g;
	}
	
	public Graphics drawImages(Graphics g) {
		try {
	    	viewBackground = ImageIO.read(new File("images/mvback.jpg"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(viewBackground, 0, 0, mf.getWidth(), mf.getHeight(), null);
	    
	    try {
	    	field = ImageIO.read(new File("images/field2.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(field, ((mf.getWidth() - ((1400*mf.getWidth())/MAINFRAME_WIDTH))/2), 10, (1400*mf.getWidth())/MAINFRAME_WIDTH, 400, null);
	    
	    try {
	    	field = ImageIO.read(new File("images/score_gauche.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(field, (390*mf.getWidth())/MAINFRAME_WIDTH, (510*mf.getHeight())/MAINFRAME_HEIGHT, (172*mf.getWidth())/MAINFRAME_WIDTH, (78*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
	    try {
	    	field = ImageIO.read(new File("images/score_droite.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(field, (950*mf.getWidth())/MAINFRAME_WIDTH, (510*mf.getHeight())/MAINFRAME_HEIGHT, (172*mf.getWidth())/MAINFRAME_WIDTH, (78*mf.getHeight())/MAINFRAME_HEIGHT, null);

	    try {
	    	flag = ImageIO.read(new File(m.getTeamA().getFlagPath()));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, (370*mf.getWidth())/MAINFRAME_WIDTH, (430*mf.getHeight())/MAINFRAME_HEIGHT, (50*mf.getWidth())/MAINFRAME_WIDTH, (50*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
	    try {
	    	flag = ImageIO.read(new File(m.getTeamB().getFlagPath()));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, (970*mf.getWidth())/MAINFRAME_WIDTH, (430*mf.getHeight())/MAINFRAME_HEIGHT, (50*mf.getWidth())/MAINFRAME_WIDTH, (50*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
	    try {
	    	flag = ImageIO.read(new File("images/fond2.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, (0*mf.getWidth())/MAINFRAME_WIDTH, (600*mf.getHeight())/MAINFRAME_HEIGHT, (300*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    g.drawImage(flag, (1201*mf.getWidth())/MAINFRAME_WIDTH, (600*mf.getHeight())/MAINFRAME_HEIGHT, (600*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
	    try {
	    	flag = ImageIO.read(new File("images/ballon.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(field, (550*mf.getWidth())/MAINFRAME_WIDTH, (600*mf.getHeight())/MAINFRAME_HEIGHT, (400*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
		return g;
	}
	
	public Graphics drawPlayers(Graphics g) {
		g.setColor(Color.WHITE);
	 
	    g.drawString(m.getTeamA().getStarter().get(0).getPosition() +" " +m.getTeamA().getStarter().get(0).getFirstName().substring(0,1)+"."+" "+ m.getTeamA().getStarter().get(0).getLastName(), (125*mf.getWidth())/MAINFRAME_WIDTH, (215*mf.getHeight())/MAINFRAME_HEIGHT);

	    g.drawString(m.getTeamA().getStarter().get(1).getPosition() +"  " +m.getTeamA().getStarter().get(1).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(1).getLastName(), (260*mf.getWidth())/MAINFRAME_WIDTH, (90*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamA().getStarter().get(2).getPosition() +" " +m.getTeamA().getStarter().get(2).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(2).getLastName(), (260*mf.getWidth())/MAINFRAME_WIDTH, (170*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamA().getStarter().get(3).getPosition() +" " +m.getTeamA().getStarter().get(3).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(3).getLastName(), (260*mf.getWidth())/MAINFRAME_WIDTH, (260*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamA().getStarter().get(4).getPosition() +" " +m.getTeamA().getStarter().get(4).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(4).getLastName(), (260*mf.getWidth())/MAINFRAME_WIDTH, (330*mf.getHeight())/MAINFRAME_HEIGHT);
	    
	    g.drawString(m.getTeamA().getStarter().get(5).getPosition() +" " +m.getTeamA().getStarter().get(5).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(5).getLastName(), (400*mf.getWidth())/MAINFRAME_WIDTH, (140*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamA().getStarter().get(6).getPosition() +" " +m.getTeamA().getStarter().get(6).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(6).getLastName(), (400*mf.getWidth())/MAINFRAME_WIDTH, (215*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamA().getStarter().get(7).getPosition() +" " +m.getTeamA().getStarter().get(7).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(7).getLastName(), (400*mf.getWidth())/MAINFRAME_WIDTH, (295*mf.getHeight())/MAINFRAME_HEIGHT);
	    
	    g.drawString(m.getTeamA().getStarter().get(8).getPosition() +" " +m.getTeamA().getStarter().get(8).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(8).getLastName(), (590*mf.getWidth())/MAINFRAME_WIDTH, (140*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamA().getStarter().get(9).getPosition() +" " +m.getTeamA().getStarter().get(9).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(9).getLastName(), (590*mf.getWidth())/MAINFRAME_WIDTH, (215*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamA().getStarter().get(10).getPosition() +" " +m.getTeamA().getStarter().get(10).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(10).getLastName(), (590*mf.getWidth())/MAINFRAME_WIDTH, (295*mf.getHeight())/MAINFRAME_HEIGHT);

	    
	    g.drawString(m.getTeamB().getStarter().get(0).getPosition() +" " +m.getTeamB().getStarter().get(0).getFirstName().substring(0,1)+"."+" "+ m.getTeamB().getStarter().get(0).getLastName(), ((MAINFRAME_WIDTH - 225)*mf.getWidth())/MAINFRAME_WIDTH, (215*mf.getHeight())/MAINFRAME_HEIGHT);

	    g.drawString(m.getTeamB().getStarter().get(1).getPosition() +"  " +m.getTeamB().getStarter().get(1).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(1).getLastName(), ((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (90*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamB().getStarter().get(2).getPosition() +" " +m.getTeamB().getStarter().get(2).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(2).getLastName(), ((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (170*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamB().getStarter().get(3).getPosition() +" " +m.getTeamB().getStarter().get(3).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(3).getLastName(), ((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (260*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamB().getStarter().get(4).getPosition() +" " +m.getTeamB().getStarter().get(4).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(4).getLastName(), ((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (330*mf.getHeight())/MAINFRAME_HEIGHT);
	    
	    g.drawString(m.getTeamB().getStarter().get(5).getPosition() +" " +m.getTeamB().getStarter().get(5).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(5).getLastName(), ((MAINFRAME_WIDTH - 500)*mf.getWidth())/MAINFRAME_WIDTH, (140*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamB().getStarter().get(6).getPosition() +" " +m.getTeamB().getStarter().get(6).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(6).getLastName(), ((MAINFRAME_WIDTH - 500)*mf.getWidth())/MAINFRAME_WIDTH, (215*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamB().getStarter().get(7).getPosition() +" " +m.getTeamB().getStarter().get(7).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(7).getLastName(), ((MAINFRAME_WIDTH - 500)*mf.getWidth())/MAINFRAME_WIDTH, (295*mf.getHeight())/MAINFRAME_HEIGHT);
	    
	    g.drawString(m.getTeamB().getStarter().get(8).getPosition() +" " +m.getTeamB().getStarter().get(8).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(8).getLastName(), ((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (140*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamB().getStarter().get(9).getPosition() +" " +m.getTeamB().getStarter().get(9).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(9).getLastName(), ((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (215*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString(m.getTeamB().getStarter().get(10).getPosition() +" " +m.getTeamB().getStarter().get(10).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(10).getLastName(), ((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (295*mf.getHeight())/MAINFRAME_HEIGHT);
	    
	    g = choosePlayer((125*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(0), m.getTeamA(), g);
	    g = choosePlayer((260*mf.getWidth())/MAINFRAME_WIDTH, (70*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(1), m.getTeamA(), g);
	    g = choosePlayer((260*mf.getWidth())/MAINFRAME_WIDTH, (150*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(2), m.getTeamA(), g);
	    g = choosePlayer((260*mf.getWidth())/MAINFRAME_WIDTH, (240*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(3), m.getTeamA(), g);
	    g = choosePlayer((260*mf.getWidth())/MAINFRAME_WIDTH, (310*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(4), m.getTeamA(), g);
	    g = choosePlayer((400*mf.getWidth())/MAINFRAME_WIDTH, (120*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(5), m.getTeamA(), g);
	    g = choosePlayer((400*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(6), m.getTeamA(), g);
	    g = choosePlayer((400*mf.getWidth())/MAINFRAME_WIDTH, (275*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(7), m.getTeamA(), g);
	    g = choosePlayer((590*mf.getWidth())/MAINFRAME_WIDTH, (120*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(8), m.getTeamA(), g);
	    g = choosePlayer((590*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(9), m.getTeamA(), g);
	    g = choosePlayer((590*mf.getWidth())/MAINFRAME_WIDTH, (275*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamA().getStarter().get(10), m.getTeamA(), g);
	    
	    g = choosePlayer(((MAINFRAME_WIDTH - 225)*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(0), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (70*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(1), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (150*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(2), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (240*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(3), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (310*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(4), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 300)*mf.getWidth())/MAINFRAME_WIDTH, (120*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(5), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 300)*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(6), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 300)*mf.getWidth())/MAINFRAME_WIDTH, (275*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(7), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (120*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(8), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(9), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (275*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(10), m.getTeamB(), g);
	    
		return g;
	}
	
	public Graphics drawStatistiqes(Graphics g) {
		g.drawString("Statistiques : " + m.getTeamA().getTeamName(), (50*mf.getWidth())/MAINFRAME_WIDTH, (630*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Tirs : " + Integer.toString(m.getTotalKickA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (780*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Tirs cadrés : " + Integer.toString(m.getCornersA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (660*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Possession : " + Integer.toString(m.getFoulsA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (690*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Fautes : " + Integer.toString(m.getNbrActionsA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (720*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Corners : " + Integer.toString(m.getPenA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (750*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Précision Tirs : " + Integer.toString(m.getPassA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (810*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Précision Passes : " + Integer.toString(m.getTotalPassA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (840*mf.getHeight())/MAINFRAME_HEIGHT);
		/*float percentPassA = ((float)m.getPassA()/(float)m.getTotalPassA())*100;
		g.drawString("Pourcentages de passes réussis : " + Integer.toString((int) percentPassA), (35*mf.getWidth())/MAINFRAME_WIDTH, (870*mf.getHeight())/MAINFRAME_HEIGHT);*/
		
		
		g.drawString("Statistiques : " + m.getTeamA().getTeamName(), ((1201 + 50)*mf.getWidth())/MAINFRAME_WIDTH, (630*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Corners : " + Integer.toString(m.getCornersA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (660*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Fautes : " + Integer.toString(m.getFoulsA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (690*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Nbr d'actions : " + Integer.toString(m.getNbrActionsA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (720*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Pénaltis : " + Integer.toString(m.getPenA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (750*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Tirs : " + Integer.toString(m.getTotalKickA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (780*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Passes : " + Integer.toString(m.getPassA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (810*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Total passes : " + Integer.toString(m.getTotalPassA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (840*mf.getHeight())/MAINFRAME_HEIGHT);
		/*float percentPassB = ((float)m.getPassA()/(float)m.getTotalPassA())*100;
		g.drawString("Pourcentages de passes réussis : " + Integer.toString((int) percentPassB), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (870*mf.getHeight())/MAINFRAME_HEIGHT);*/
		
		
		return g;
	}
	
	public Graphics drawRecap(Graphics g) {
		if(Mouse.x > 1050 && Mouse.x < 1100) {
		    if(Mouse.y > 600+30 && Mouse.y < 650+30 && Mouse.click == true) {
		    	if(state > 0) {
		    		state--;
		    		Mouse.click = false;
		    	}
		    }
		    if(Mouse.y > 900 +30 && Mouse.y < 950+30 && Mouse.click == true) {
		    	if(state < (m.getAlrecap().size()/17)) {
		    		state++;
		    		Mouse.click = false;
		    	}
		    }
		}
		    
		g.setColor(Color.WHITE);

		for(int i=0; i< 17; i++) {
		    if(i+(state*17)< m.getAlrecap().size()) {
		    	String str = new String();
                String str2 = new String();
                int lastIndex = m.getAlrecap().get(i+(state*17)).length();
                int lastIndexOri = m.getAlrecap().get(i+(state*17)).length();
                int width = g.getFontMetrics().stringWidth(m.getAlrecap().get(i+(state*17)));
                str = m.getAlrecap().get(i+(state*17));
                while(width > 580) {
                    lastIndex = str.lastIndexOf(" ");
                    str = str.substring(0, lastIndex);
                    width = g.getFontMetrics().stringWidth(str);
                    str2 = m.getAlrecap().get(i+(state*17)).substring(lastIndex, lastIndexOri);
                }
                if(g.getFontMetrics().stringWidth(m.getAlrecap().get(i+(state*17))) > 580) {
                    g.drawString(str, (460*mf.getWidth())/MAINFRAME_WIDTH, (625*mf.getHeight())/MAINFRAME_HEIGHT+(i*20));
                    i++;
                    g.drawString(str2, (460*mf.getWidth())/MAINFRAME_WIDTH, (625*mf.getHeight())/MAINFRAME_HEIGHT+(i*20));
                }else {
                    g.drawString(str, (460*mf.getWidth())/MAINFRAME_WIDTH, (625*mf.getHeight())/MAINFRAME_HEIGHT+(i*20));
                }
		    }
		}
		return g;
	}
	
}
