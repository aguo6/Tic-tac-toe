
/**
 * Write a description of class appletBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Help from Mr. Sikora's C.S. google website's examples & comments from Mr. Sikora's example code
 */
import java.awt.*; //abstract window toolkit
import java.awt.event.*; //buttons, animation, mouse
import java.applet.Applet; //To run an applet
public class appletBoard extends Applet implements ActionListener
{
    private Button clickSpace;
    
    
    public void initializeButtons()
    {
        //3 steps to create a button
        clickSpace = 
        add(clickSpace);
        clickSpace.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        Object source = ae.getSource(); // method event within ActionEvent which gets source of event
        if (source.equals(clickSpace))
        {
            
        }
    }
    
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
