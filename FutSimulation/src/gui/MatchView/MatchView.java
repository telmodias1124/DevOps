package gui.MatchView;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import data.Match;
import data.Player;
import data.Team;
import gui.GlobalParameter;
import gui.MainFrame;
import listener.Mouse;


public class MatchView extends JPanel{
	private static final long serialVersionUID = 7690322266008392032L;
	private Image viewBackground;
	private Image field;
	private Image flag;
	private Image carte;
	private Match m;
	private MainFrame mf;
	private int state = 0;
	private static int MAINFRAME_WIDTH = GlobalParameter.MAINFRAME_WIDTH;
	private static int MAINFRAME_HEIGHT = GlobalParameter.MAINFRAME_HEIGHT;
	private int i = 0;
	private int j = 0;
	private int lk = 0;
	private int newI = 0;
	private int retenuI[] = new int[30];
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
	    
	    if(m.isDraw() && m.isOvertime()) {
	    	g.drawString(Integer.toString(m.getScoreA())+" +"+Integer.toString(m.getPenA()), (405*mf.getWidth())/MAINFRAME_WIDTH, (565*mf.getHeight())/MAINFRAME_HEIGHT);
		    g.drawString(Integer.toString(m.getScoreB())+" +"+Integer.toString(m.getPenB()), (1025*mf.getWidth())/MAINFRAME_WIDTH, (565*mf.getHeight())/MAINFRAME_HEIGHT);
	    }
	    else {
	    	g.drawString(Integer.toString(m.getScoreA()), (415*mf.getWidth())/MAINFRAME_WIDTH, (565*mf.getHeight())/MAINFRAME_HEIGHT);
		    g.drawString(Integer.toString(m.getScoreB()), (1065*mf.getWidth())/MAINFRAME_WIDTH, (565*mf.getHeight())/MAINFRAME_HEIGHT);
	    }
	    
	    if(m.isDraw() && m.isOvertime()) {
		    g.drawString("120:00", (685*mf.getWidth())/MAINFRAME_WIDTH, (550*mf.getHeight())/MAINFRAME_HEIGHT);

	    }
	    else{
	    	g.drawString("90:00", (700*mf.getWidth())/MAINFRAME_WIDTH, (550*mf.getHeight())/MAINFRAME_HEIGHT);
	    }
	    
	    g.setFont(font);

	    //Drapeau et equipe
	    
	    g.drawString(m.getTeamB().getTeamName(), ((MAINFRAME_WIDTH - 435)*mf.getWidth()/MAINFRAME_WIDTH), ((460*mf.getHeight())/MAINFRAME_HEIGHT));
	    g.drawString(m.getTeamA().getTeamName(), ((MAINFRAME_WIDTH - 1035)*mf.getWidth()/MAINFRAME_WIDTH), ((460*mf.getHeight())/MAINFRAME_HEIGHT));
	    
	    //g.drawString("Nbr d'Actions : "+Integer.toString(m.getAlrecap().size()), 310, (620*mf.getHeight())/MAINFRAME_HEIGHT);
	    g.drawString("Pages : "+Integer.toString(state+1), (360*mf.getWidth())/MAINFRAME_WIDTH, (620*mf.getHeight())/MAINFRAME_HEIGHT);
	   
	    g = drawRecap(g);
	    	
	    g = drawPlayers(g);
	    
	    g = drawStatistiqes(g);

	    g.setColor(Color.WHITE);
	    g.drawLine(0, (600*mf.getHeight())/MAINFRAME_HEIGHT, mf.getWidth(), (600*mf.getHeight())/MAINFRAME_HEIGHT);
	    
	    repaint();
	}
	
	public Graphics choosePlayer(int x, int y, Player p, Team t, Graphics g) {
		if(p.getYellowCard()) {
			g.setColor(Color.YELLOW);
			g.fillRect(x-15, y, 10, 20);
		}
		if(p.getRedCard()) {
			g.setColor(Color.RED);
			g.fillRect(x-15, y, 10, 20);
		}
		g.setColor(Color.WHITE);
		int length = ((p.getLastName().length())*10)+40;
		int newY = y + 30;
		int moyenne = (p.getPlayerStatistic().getPace()+p.getPlayerStatistic().getShoot()+p.getPlayerStatistic().getPass()+p.getPlayerStatistic().getDribble()+p.getPlayerStatistic().getDef()+p.getPlayerStatistic().getPhysique())/6;
		//g.drawRect(x, y, length, 20);
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
		    g.drawImage(carte, (750*mf.getWidth())/MAINFRAME_WIDTH, (220*mf.getHeight())/MAINFRAME_HEIGHT, (80*mf.getWidth())/MAINFRAME_WIDTH, (80*mf.getHeight())/MAINFRAME_HEIGHT, null);
			g.drawString(p.getFirstName().substring(0,1)+". "+p.getLastName(), (670*mf.getWidth())/MAINFRAME_WIDTH, (340*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPace()), (670*mf.getWidth())/MAINFRAME_WIDTH, (375*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getShoot()), (670*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPass()), (670*mf.getWidth())/MAINFRAME_WIDTH, (425*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getDribble()), (765*mf.getWidth())/MAINFRAME_WIDTH, (375*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getDef()), (765*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT);
			g.drawString(Integer.toString(p.getPlayerStatistic().getPhysique()), (765*mf.getWidth())/MAINFRAME_WIDTH, (425*mf.getHeight())/MAINFRAME_HEIGHT);
			if(p.getYellowCard()) {
				g.setColor(Color.YELLOW);
				g.fillRect(685, 285, 15, 20);
			}
			if(p.getRedCard()) {
				g.setColor(Color.RED);
				g.fillRect(685, 285, 15, 20);
			}
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
	    g.drawImage(field, ((mf.getWidth() - ((1400*mf.getWidth())/MAINFRAME_WIDTH))/2), 10, (1400*mf.getWidth())/MAINFRAME_WIDTH, (400*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
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
	    
	    try {
	    	flag = ImageIO.read(new File("images/fleche_haut.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, (1050*mf.getWidth())/MAINFRAME_WIDTH, (610*mf.getHeight())/MAINFRAME_HEIGHT, (50*mf.getWidth())/MAINFRAME_WIDTH, (50*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
	    try {
	    	flag = ImageIO.read(new File("images/fleche_bas.png"));
		    }
		    catch (Exception e) { /*handled in paintComponent()*/ }
	    g.drawImage(flag, (1050*mf.getWidth())/MAINFRAME_WIDTH, (900*mf.getHeight())/MAINFRAME_HEIGHT, (50*mf.getWidth())/MAINFRAME_WIDTH, (50*mf.getHeight())/MAINFRAME_HEIGHT, null);
	    
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

	    
	    g.drawString(m.getTeamB().getStarter().get(0).getPosition() +" " +m.getTeamB().getStarter().get(0).getFirstName().substring(0,1)+"."+" "+ m.getTeamB().getStarter().get(0).getLastName(), ((MAINFRAME_WIDTH - 240)*mf.getWidth())/MAINFRAME_WIDTH, (215*mf.getHeight())/MAINFRAME_HEIGHT);

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
	    
	    g = choosePlayer(((MAINFRAME_WIDTH - 240)*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(0), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (70*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(1), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (150*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(2), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (240*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(3), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 360)*mf.getWidth())/MAINFRAME_WIDTH, (310*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(4), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 500)*mf.getWidth())/MAINFRAME_WIDTH, (120*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(5), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 500)*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(6), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 500)*mf.getWidth())/MAINFRAME_WIDTH, (275*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(7), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (120*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(8), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (195*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(9), m.getTeamB(), g);
	    g = choosePlayer(((MAINFRAME_WIDTH - 690)*mf.getWidth())/MAINFRAME_WIDTH, (275*mf.getHeight())/MAINFRAME_HEIGHT, m.getTeamB().getStarter().get(10), m.getTeamB(), g);
	    
		return g;
	}
	
	public Graphics drawStatistiqes(Graphics g) {
		g.setColor(Color.WHITE);
		float percentPassA = ((float)m.getPassA()/(float)m.getTotalPassA())*100;
		float percentShootA = ((float)m.getScoreA()/(float)m.getTotalKickA())*100;
		float percentPossA = ((float)m.getNbrActionsA()/((float)m.getNbrActionsA()+(float)m.getNbrActionsB()))*100;

		g.drawString("Statistiques : " + m.getTeamA().getTeamName(), (50*mf.getWidth())/MAINFRAME_WIDTH, (630*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Tirs : " + Integer.toString(m.getTotalKickA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (680*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Possession : " + Integer.toString((int)percentPossA)+"%", (35*mf.getWidth())/MAINFRAME_WIDTH, (710*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Fautes : " + Integer.toString(m.getFoulsA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (740*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Corners : " + Integer.toString(m.getCornersA()), (35*mf.getWidth())/MAINFRAME_WIDTH, (770*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Précision Tirs : " + Integer.toString((int)percentShootA)+"%", (35*mf.getWidth())/MAINFRAME_WIDTH, (800*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Précision Passes : " + Integer.toString((int)percentPassA)+"%", (35*mf.getWidth())/MAINFRAME_WIDTH, (830*mf.getHeight())/MAINFRAME_HEIGHT);
		
		float percentPassB = ((float)m.getPassB()/(float)m.getTotalPassB())*100;
		float percentShootB = ((float)m.getScoreB()/(float)m.getTotalKickB())*100;
		float percentPossB = ((float)m.getNbrActionsB()/((float)m.getNbrActionsA()+(float)m.getNbrActionsB()))*100;
		
		g.drawString("Statistiques : " + m.getTeamB().getTeamName(), ((1201 + 50)*mf.getWidth())/MAINFRAME_WIDTH, (630*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Tirs : " + Integer.toString(m.getCornersA()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (680*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Possession : " + Integer.toString((int)percentPossB)+"%", ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (710*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Fautes : " + Integer.toString(m.getFoulsB()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (740*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Corners : " + Integer.toString(m.getCornersB()), ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (770*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Précision Tirs : " + Integer.toString((int)percentShootB)+"%", ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (800*mf.getHeight())/MAINFRAME_HEIGHT);
		g.drawString("Précision Passes : " + Integer.toString((int)percentPassB)+"%", ((1201 + 35)*mf.getWidth())/MAINFRAME_WIDTH, (830*mf.getHeight())/MAINFRAME_HEIGHT);
		
		return g;
	}
	
	public Graphics drawRecap(Graphics g) {
		//System.out.println(i +"  "+j);
		if(Mouse.x > 1050 && Mouse.x < 1100) {
		    if(Mouse.y > 610+30 && Mouse.y < 650+30 && Mouse.click == true) {
		    	if(state > 0) {
		    		this.i = (this.retenuI[state-1]);
		    		this.newI = this.i;
		    		state--;
		    		Mouse.click = false;
		    	}
		    }
		    if(Mouse.y > 900 +30 && Mouse.y < 1000+30 && Mouse.click == true) {
		    	if(this.j < m.getAlrecap().size()-1) {
		    		this.retenuI[state] = this.newI;
		    		this.i = this.j;
		    		this.newI = this.i;
		    		state++;
		    		Mouse.click = false;
		    	}
		    }
		}
		    
		g.setColor(Color.WHITE);
		
			int h = 0;
			for(this.j = this.i; this.j < this.i + 13; this.j++) {
				if(this.j < m.getAlrecap().size()-1) {
					String str = new String();
	                String str2 = new String();
	                int lastIndex = m.getAlrecap().get(this.j).length();
	                int lastIndexOri = m.getAlrecap().get(this.j).length();
	                int width = g.getFontMetrics().stringWidth(m.getAlrecap().get(this.j));
	                str = m.getAlrecap().get(this.j);
	                while(width > 580) {
	                    lastIndex = str.lastIndexOf(" ");
	                    str = str.substring(0, lastIndex);
	                    width = g.getFontMetrics().stringWidth(str);
	                    str2 = m.getAlrecap().get(this.j).substring(lastIndex, lastIndexOri);
	                }
	                if(g.getFontMetrics().stringWidth(m.getAlrecap().get(this.j)) > 580) {
	                    g.drawString(str, (460*mf.getWidth())/MAINFRAME_WIDTH, (625*mf.getHeight())/MAINFRAME_HEIGHT+(h*25));
	                    h++;
	                    g.drawString(str2, (460*mf.getWidth())/MAINFRAME_WIDTH, (625*mf.getHeight())/MAINFRAME_HEIGHT+(h*25));
	                    h++;
	                    this.i--;
	                }
	                else {
	                    g.drawString(str, (460*mf.getWidth())/MAINFRAME_WIDTH, (625*mf.getHeight())/MAINFRAME_HEIGHT+(h*25));
	                    h++;
	                }
				}
			}
			
			this.i = this.newI;
			
		if(this.lk == 0) {
			for(String n : m.getAlrecap()) {
	            System.out.println(n);
	            this.lk = 1;
			}
		}
		return g;
	}
}
