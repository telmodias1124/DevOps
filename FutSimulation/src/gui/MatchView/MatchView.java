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
	    g.fillRect(650, 475, 200, 100);
	    g.fillRect(450, 600, 600, 400);
	    
	   
	    g.setColor(Color.WHITE);
	    g.setFont(fontScore);

	    g.drawString(Integer.toString(m.getScoreA()), 415, 555);
	    g.drawString(Integer.toString(m.getScoreB()), 1065, 555);
	    g.drawString("00:00", 700, 550);
	    
	    g.setFont(font);

	    //Drapeau et equipe
	    
	    g.drawString(m.getTeamA().getTeamName(), 435, 460);
	    g.drawString(m.getTeamB().getTeamName(), 1035, 460);
	    
	    
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
			g.drawImage(carte, 618, 120, 256, 369, null);
			g.drawString(Integer.toString(moyenne), 680, 225);
			g.drawString(p.getPosition(), 685, 255);
			try {
			    carte = ImageIO.read(new File(t.getFlagPath()));
			}
			catch (Exception e) { /*handled in paintComponent()*/ }
			g.drawImage(carte, 720, 230, 80, 80, null);
			g.drawString(p.getFirstName().substring(0,1)+". "+p.getLastName(), 670, 340);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPace()), 670, 375);
			g.drawString(Integer.toString(p.getPlayerStatistic().getShoot()), 670, 400);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPass()), 670, 425);
			g.drawString(Integer.toString(p.getPlayerStatistic().getDribble()), 765, 375);
			g.drawString(Integer.toString(p.getPlayerStatistic().getDef()), 765, 400);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPhysique()), 765, 425);
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
	    g.drawImage(field, 50, 10, ((MAINFRAME_WIDTH - 100)*mf.getWidth())/MAINFRAME_WIDTH, 400, null);
	    
	    try {
	    	field = ImageIO.read(new File("images/score_gauche.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(field, 390, 510, 172, 78, null);
	    
	    try {
	    	field = ImageIO.read(new File("images/score_droite.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(field, 950, 510, 172, 78, null);
	    
	    try {
	    	flag = ImageIO.read(new File(m.getTeamA().getFlagPath()));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, 370, 430, 50, 50, null);
	    
	    try {
	    	flag = ImageIO.read(new File(m.getTeamB().getFlagPath()));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, 970, 430, 50, 50, null);
	    
	    try {
	    	flag = ImageIO.read(new File("images/fond2.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, 0, 600, 300, mf.getHeight() - 600, null);
	    g.drawImage(flag, mf.getWidth() - 299, 600, 300, mf.getHeight() - 600, null);
	    
	    try {
	    	flag = ImageIO.read(new File("images/ballon.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, 550, 600, 400, 400, null);
	    
		return g;
	}
	
	public Graphics drawPlayers(Graphics g) {
		g.setColor(Color.WHITE);
	    int dep = (125 * mf.getWidth())/1500;
	    g.drawString(m.getTeamA().getStarter().get(0).getPosition() +" " +m.getTeamA().getStarter().get(0).getFirstName().substring(0,1)+"."+" "+ m.getTeamA().getStarter().get(0).getLastName(), dep, 215);
	    
	    g.drawString(m.getTeamA().getStarter().get(1).getPosition() +"  " +m.getTeamA().getStarter().get(1).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(1).getLastName(), 260, 90);
	    g.drawString(m.getTeamA().getStarter().get(2).getPosition() +" " +m.getTeamA().getStarter().get(2).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(2).getLastName(), 260, 170);
	    g.drawString(m.getTeamA().getStarter().get(3).getPosition() +" " +m.getTeamA().getStarter().get(3).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(3).getLastName(), 260, 260);
	    g.drawString(m.getTeamA().getStarter().get(4).getPosition() +" " +m.getTeamA().getStarter().get(4).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(4).getLastName(), 260, 330);
	    
	    g.drawString(m.getTeamA().getStarter().get(5).getPosition() +" " +m.getTeamA().getStarter().get(5).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(5).getLastName(), 400, 140);
	    g.drawString(m.getTeamA().getStarter().get(6).getPosition() +" " +m.getTeamA().getStarter().get(6).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(6).getLastName(), 400, 215);
	    g.drawString(m.getTeamA().getStarter().get(7).getPosition() +" " +m.getTeamA().getStarter().get(7).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(7).getLastName(), 400, 295);
	    
	    g.drawString(m.getTeamA().getStarter().get(8).getPosition() +" " +m.getTeamA().getStarter().get(8).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(8).getLastName(), 590, 140);
	    g.drawString(m.getTeamA().getStarter().get(9).getPosition() +" " +m.getTeamA().getStarter().get(9).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(9).getLastName(), 590, 215);
	    g.drawString(m.getTeamA().getStarter().get(10).getPosition() +" " +m.getTeamA().getStarter().get(10).getFirstName().substring(0,1)+"." +" "+ m.getTeamA().getStarter().get(10).getLastName(), 590, 295);

	    
	    g.drawString(m.getTeamB().getStarter().get(0).getPosition() +" " +m.getTeamB().getStarter().get(0).getFirstName().substring(0,1)+"."+" "+ m.getTeamB().getStarter().get(0).getLastName(), (((1500 - 125)* mf.getWidth())/1500), 215);
	    
	    g.drawString(m.getTeamB().getStarter().get(1).getPosition() +"  " +m.getTeamB().getStarter().get(1).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(1).getLastName(), (1500 - 260), 90);
	    g.drawString(m.getTeamB().getStarter().get(2).getPosition() +" " +m.getTeamB().getStarter().get(2).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(2).getLastName(), (1500 - 260), 170);
	    g.drawString(m.getTeamB().getStarter().get(3).getPosition() +" " +m.getTeamB().getStarter().get(3).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(3).getLastName(), (1500 - 260), 260);
	    g.drawString(m.getTeamB().getStarter().get(4).getPosition() +" " +m.getTeamB().getStarter().get(4).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(4).getLastName(), (1500 - 260), 330);
	    
	    g.drawString(m.getTeamB().getStarter().get(5).getPosition() +" " +m.getTeamB().getStarter().get(5).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(5).getLastName(), (1500 - 400), 140);
	    g.drawString(m.getTeamB().getStarter().get(6).getPosition() +" " +m.getTeamB().getStarter().get(6).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(6).getLastName(), (1500 -  400), 215);
	    g.drawString(m.getTeamB().getStarter().get(7).getPosition() +" " +m.getTeamB().getStarter().get(7).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(7).getLastName(), (1500 - 400), 295);
	    
	    g.drawString(m.getTeamB().getStarter().get(8).getPosition() +" " +m.getTeamB().getStarter().get(8).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(8).getLastName(), (1500 - 590), 140);
	    g.drawString(m.getTeamB().getStarter().get(9).getPosition() +" " +m.getTeamB().getStarter().get(9).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(9).getLastName(), (1500 - 590), 215);
	    g.drawString(m.getTeamB().getStarter().get(10).getPosition() +" " +m.getTeamB().getStarter().get(10).getFirstName().substring(0,1)+"." +" "+ m.getTeamB().getStarter().get(10).getLastName(), (1500 - 590), 295);

	    g = choosePlayer(125, 195, m.getTeamA().getStarter().get(0), m.getTeamA(), g);
	    g = choosePlayer(260, 70, m.getTeamA().getStarter().get(1), m.getTeamA(), g);
	    g = choosePlayer(260, 150, m.getTeamA().getStarter().get(2), m.getTeamA(), g);
	    g = choosePlayer(260, 240, m.getTeamA().getStarter().get(3), m.getTeamA(), g);
	    g = choosePlayer(260, 310, m.getTeamA().getStarter().get(4), m.getTeamA(), g);
	    g = choosePlayer(400, 120, m.getTeamA().getStarter().get(5), m.getTeamA(), g);
	    g = choosePlayer(400, 195, m.getTeamA().getStarter().get(6), m.getTeamA(), g);
	    g = choosePlayer(400, 275, m.getTeamA().getStarter().get(7), m.getTeamA(), g);
	    g = choosePlayer(590, 120, m.getTeamA().getStarter().get(8), m.getTeamA(), g);
	    g = choosePlayer(590, 195, m.getTeamA().getStarter().get(9), m.getTeamA(), g);
	    g = choosePlayer(590, 275, m.getTeamA().getStarter().get(10), m.getTeamA(), g);
	    
	    g = choosePlayer((MAINFRAME_WIDTH - 125), 195, m.getTeamB().getStarter().get(0), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 260), 70, m.getTeamB().getStarter().get(1), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 260), 150, m.getTeamB().getStarter().get(2), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 260), 240, m.getTeamB().getStarter().get(3), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 260), 310, m.getTeamB().getStarter().get(4), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 400), 120, m.getTeamB().getStarter().get(5), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 400), 195, m.getTeamB().getStarter().get(6), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 400), 275, m.getTeamB().getStarter().get(7), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 590), 120, m.getTeamB().getStarter().get(8), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 590), 195, m.getTeamB().getStarter().get(9), m.getTeamB(), g);
	    g = choosePlayer((MAINFRAME_WIDTH - 590), 275, m.getTeamB().getStarter().get(10), m.getTeamB(), g);
		return g;
	}
	
	public Graphics drawStatistiqes(Graphics g) {
		g.drawString("Statistiques : " + m.getTeamA().getTeamName(), 50, 630);
		g.drawString("Corners : " + Integer.toString(m.getCornersA()), 35, 660);
		g.drawString("Fautes : " + Integer.toString(m.getFoulsA()), 35, 690);
		g.drawString("Nbr d'actions : " + Integer.toString(m.getNbrActionsA()), 35, 720);
		g.drawString("Pénaltis : " + Integer.toString(m.getPenA()), 35, 750);
		g.drawString("Tirs : " + Integer.toString(m.getTotalKickA()), 35, 780);
		g.drawString("Passes : " + Integer.toString(m.getPassA()), 35, 810);
		g.drawString("Total passes : " + Integer.toString(m.getTotalPassA()), 35, 840);
		float percentPass = ((float)m.getPassA()/(float)m.getTotalPassA())*100;
		g.drawString("Pourcentages de passes réussis : " + Integer.toString((int) percentPass), 35, 870);
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
                    g.drawString(str, 460, 625+(i*20));
                    i++;
                    g.drawString(str2, 460, 625+(i*20));
                }else {
                    g.drawString(str, 460, 625+(i*20));
                }
		    }
		}
		return g;
	}
	
}
