
/**
 * Write a description of class playerPiece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Lots of help from Mr. Sikora's C.S. google website's examples & comments from Mr. Sikora's example code
 */
import java.awt.*; //abstract window toolkit
import java.awt.event.*; //buttons, animation, mouse
import java.applet.Applet; //To run an applet
public class playerPiece
{
    private int centerX;
    private int centerY;
    
    public void drawCross(Graphics g)
    {
        appletBoard selectedSpace = new appletBoard();
        centerX = selectedSpace.getXPos() + 83;
        centerY = selectedSpace.getYPos() + 83;
        g.drawLine(centerX - 40, centerY - 40, centerX + 40, centerY + 40);
        g.drawLine(centerX + 40, centerY - 40, centerX - 40, centerY + 40);
    }
    
    public void drawCircle(Graphics g)
    {
        appletBoard selectedSpace = new appletBoard();
        centerX = selectedSpace.getXPos() + 83;
        centerY = selectedSpace.getYPos() + 83;
        g.drawOval(centerX-40, centerY - 40, 80,80);
    }
}
