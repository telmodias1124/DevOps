package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JImagePanel extends JPanel {
	
	private static final long serialVersionUID = -5804186432308558412L;
	private Image image;
	private Image KnockoutBackground;
	private String name;
	private String score;
	Font tr = new Font("SansSerif", Font.BOLD, 12);
	
	public JImagePanel(String path) {
		this.name = null;
	    try {
	      image = ImageIO.read(new File(path));
	    }
	    catch (Exception e) { /*handled in paintComponent()*/ }
	  	}
	
	public JImagePanel(String path, String name, String score) {
		this.name = name;
		this.score = score;
    try {
      image = ImageIO.read(new File(path));
    }
    catch (Exception e) { /*handled in paintComponent()*/ }
  	}
	
	
 
  @Override
  protected void paintComponent(Graphics g){
    super.paintComponent(g); 
    if (name != null) {
    	g.drawImage(image, 0,this.getHeight()/2 - 15 ,30,30,this);
    	g.setFont(tr);
    	g.setColor(Color.WHITE);
    	g.drawString(name, 35, this.getHeight()/2 + 5);
    	g.drawString(score, this.getWidth() - 10 - (score.length()*5), this.getHeight()/2 + 5);
    	g.drawLine(0, this.getHeight()/2 - 15, this.getWidth(), this.getHeight()/2 - 15);
        g.drawLine(0, this.getHeight()/2 - 15 + 30, this.getWidth(), this.getHeight()/2 - 15 + 30);
        g.drawLine(0,this.getHeight()/2 - 15 ,0, this.getHeight()/2 - 15 + 30);
        g.drawLine(this.getWidth()-1,this.getHeight()/2 - 15 ,this.getWidth()-1, this.getHeight()/2 - 15 + 30);
    }
    else {
    	g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }
  }
}
