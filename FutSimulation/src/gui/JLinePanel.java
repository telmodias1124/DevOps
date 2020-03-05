package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JLinePanel extends JPanel {

    private static final long serialVersionUID = -5804186432308558412L;
    private String type;

    public JLinePanel(String path) {
        type = path;
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
        break;
    }
  }
}