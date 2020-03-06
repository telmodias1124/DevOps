package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Stroke;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JImagePanel extends JPanel {
	
	private static final long serialVersionUID = -5804186432308558412L;
	private Image image;
	private Image KnockoutBackground;
	private String name;
	private String score;
	private boolean onlyRec;
	Font tr = new Font("SansSerif", Font.BOLD, 12);
	
	public JImagePanel(String path) {
		this.name = null;
	    try {
	      this.image = ImageIO.read(new File(path));
	      this.onlyRec = false;
	    }
	    catch (Exception e) { /*handled in paintComponent()*/ }
	  	}
	
	public JImagePanel(String path, String name, String score) {
		this.name = name;
		this.score = score;
		this.onlyRec = false;
    try {
      image = ImageIO.read(new File(path));
    }
    catch (Exception e) { /*handled in paintComponent()*/ }
  	}
	public JImagePanel(String path, String name, String score, boolean onlyRec) {
		this.name = name;
		this.score = score;
		this.onlyRec = onlyRec;
    try {
      image = ImageIO.read(new File(path));
    }
    catch (Exception e) { /*handled in paintComponent()*/ }
  	}
 
  @Override
  protected void paintComponent(Graphics g){
	 Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g); 
    if (name != null) {
    	g.setFont(tr);
    	if(!onlyRec) {

        	g.setColor(Color.BLACK);
        	g.fillRect(0, this.getHeight()/2 - 30, this.getWidth(), this.getHeight()/2);

        	g.setColor(Color.WHITE);
	    	g.drawImage(image, 0,this.getHeight()/2 - 15 ,30,30,this); 	
	    	g.drawString(name, 35, this.getHeight()/2 + 5);
	    	if(score != null) {
	    		g.drawString(score, this.getWidth() - 10 - (score.length()*5), this.getHeight()/2 + 5);
	    	}
    	}else {
    		g.setColor(Color.BLACK);	
    		g.fillRect(0, this.getHeight()/2 - 30, this.getWidth(), this.getHeight()/2);
    	}
    	
    	Stroke stroke = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, new float[] { 3, 0 }, 0);
    	g2.setStroke(stroke);
    	
    	/*g.drawLine(0, this.getHeight()/2 - 30, this.getWidth(), this.getHeight()/2 - 30);
        g.drawLine(0, this.getHeight()/2 - 30 + 60, this.getWidth(), this.getHeight()/2 - 30 + 60);
        g.drawLine(0,this.getHeight()/2 - 30 ,0, this.getHeight()/2 - 30 + 60);
        g.drawLine(this.getWidth()-1,this.getHeight()/2 - 30 ,this.getWidth()-1, this.getHeight()/2 - 30 + 60);*/
    }
    else {
    	g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }
  }
}
