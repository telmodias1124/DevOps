package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JImagePanel extends JPanel {
	
	private static final long serialVersionUID = -5804186432308558412L;
	private Image image;
	private String name;
	private int score;
	
	public JImagePanel(String path) {
		this.name = null;
	    try {
	      image = ImageIO.read(new File(path));
	    }
	    catch (Exception e) { /*handled in paintComponent()*/ }
	  	}
	
	public JImagePanel(String path, String name, int score) {
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
    	g.drawImage(image, 0,this.getHeight()/2 - 20 ,30,30,this);
    	/*g.setColor(Color.RED);
    	g.drawLine(0, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
    	g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, 0);*/
    	g.drawString(name, 40, this.getHeight()/2);
    	g.drawString(Integer.toString(score), this.getWidth() - 20, this.getHeight()/2);
    	g.drawLine(0, this.getHeight()/2 - 20, this.getWidth(), this.getHeight()/2 - 20);
        g.drawLine(0, this.getHeight()/2 - 20 + 30, this.getWidth(), this.getHeight()/2 - 20 + 30);
        g.drawLine(0,this.getHeight()/4 ,0, this.getHeight()-this.getHeight()/4);
        g.drawLine(this.getWidth()-1,this.getHeight()/4 ,this.getWidth()-1, this.getHeight()-this.getHeight()/4);
    }
    else {
    	g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    }
  }
}
