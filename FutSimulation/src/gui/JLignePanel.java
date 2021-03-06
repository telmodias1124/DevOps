package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JLignePanel extends JPanel {
	
	private static final long serialVersionUID = -5804186432308558412L;
	private String type;
	private String names;
	
	public JLignePanel(String path) {
		this.type = path;
  	}
	
	public JLignePanel(String path, String name) {
		this.type = path;
		this.names = name;
  	}
 
  @Override
  protected void paintComponent(Graphics g){
    super.paintComponent(g); 
   
    switch(type) {
	    case "HorizontalLine":
	    	g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
	    break;
    	case "VerticalLine":
    		g.drawLine(this.getWidth()/2, this.getHeight(), this.getWidth()/2, 0);
	    break;
    	case "RightAngleRB":
    		g.drawLine(0, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
        	g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, this.getHeight());
	    break;
    	case "RightAngleRT":
    		g.drawLine(0, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
        	g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, 0);
	    break;
    	case "RightAngleLB":
    		g.drawLine(this.getWidth(), this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
        	g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, this.getHeight());
	    break;
    	case "RightAngleLT":
    		g.drawLine(this.getWidth(), this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
        	g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, 0);
	    break;
    	case "RightSwitchAngle":
    		g.drawLine(this.getWidth(), this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
        	g.drawLine(this.getWidth()/2, this.getHeight(), this.getWidth()/2, 0);
	    break;
    	case "LeftSwitchAngle":
    		g.drawLine(0, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
        	g.drawLine(this.getWidth()/2, this.getHeight(), this.getWidth()/2, 0);
	    break;
    	case "TopSwitchAngle":
    		g.drawLine(0, this.getHeight()/2, this.getWidth(), this.getHeight()/2);
        	g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, 0);
	    break;
    	case "Rectangle":
    		g.drawLine(0, this.getHeight()/4, this.getWidth(), this.getHeight()/4);
    		g.drawLine(0, this.getHeight()- this.getHeight()/4, this.getWidth(), this.getHeight()- this.getHeight()/4);
    		g.drawLine(0,this.getHeight()/4 ,0, this.getHeight()-this.getHeight()/4);
    		g.drawLine(this.getWidth()-1,this.getHeight()/4 ,this.getWidth()-1, this.getHeight()-this.getHeight()/4);
    		g.setFont(new Font("TimesRoman", Font.PLAIN, 16));
    		g.drawString(names,this.getWidth()/3, this.getHeight()/2+1);
    		
	    break;
	    
    }
  }
}