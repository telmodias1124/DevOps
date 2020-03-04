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
	
	public JImagePanel(String path) {
    try {
      image = ImageIO.read(new File(path));
    }
    catch (Exception e) { /*handled in paintComponent()*/ }
  	}
 
  @Override
  protected void paintComponent(Graphics g){
    super.paintComponent(g); 
    if (image != null) {
    	//g.drawImage(image, 0,0,this.getWidth(),this.getHeight(),this);
    	g.setColor(Color.RED);
    	g.drawLine(0, this.getHeight()/2, this.getWidth()/2, this.getHeight()/2);
    	g.drawLine(this.getWidth()/2, this.getHeight()/2, this.getWidth()/2, this.getHeight());
    }
  }
}
