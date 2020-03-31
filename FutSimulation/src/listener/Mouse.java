package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;

public class Mouse implements MouseListener {
    public static int x, y;
    public static boolean click = false;
    
    public void mouseClicked(MouseEvent arg0) {
        Mouse.x = arg0.getX();
        Mouse.y = arg0.getY();
        System.out.println(x +" ,"+ y + " MOUSE");
    }

    
    public void mouseEntered(MouseEvent arg0) {}
    public void mouseExited(MouseEvent arg0) {}
    public void mousePressed(MouseEvent arg0) {}
    public void mouseReleased(MouseEvent arg0) {Mouse.click = false;}

}