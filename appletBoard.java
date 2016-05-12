
/**
 * Write a description of class appletBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Help from Mr. Sikora's C.S. google website's examples
 */
import java.awt.*; //buttons, animation, mouse
import java.applet.Applet; //To run an applet
public class appletBoard extends Applet
{
    public void paint(Graphics g)
    {
        // 4-lines of tic-tac-toe
        g.drawLine(166,0,166,500);
        g.drawLine(332,0,332,500);
        g.drawLine(0,166,498,166);
        g.drawLine(0,332,498,332);
        
        // 9 Rectangle Spaces
        for (int x = 0; x<= 334; x+= 167)
        {
            for (int y = 0; y<= 334 ; y+= 167)
            {
                g.drawRect(x, y,165, 165); //(topLeftCords,length,width)
            }
        }
    }
    
    
    
    
    public void playerPieces (Graphics g)
    {
        
    }
    
    
}
