
/**
 * Write a description of class appletBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Lots of help from Mr. Sikora's C.S. google website's examples & comments from Mr. Sikora's example code
 * Asked (Mr. Gumminger) for help on implementing click-able squares
 */
import java.awt.*; //abstract window toolkit
import java.awt.event.*; //buttons, animation, mouse
import java.applet.Applet; //To run an applet
public class appletBoard extends Applet implements ActionListener
{
    private Button leftMove;
    private Button rightMove;
    private Button upMove;
    private Button downMove;
    private int xMove = 167;
    private int yMove = 167;
    private int move = 0;
    
    
    public void init()
    {
        //3 steps to create a button
        leftMove = new Button ("Left");
        add(leftMove);
        leftMove.addActionListener(this);
        
        rightMove = new Button ("Right");
        add(rightMove);
        rightMove.addActionListener(this);

        upMove = new Button ("Up");
        add(upMove);
        upMove.addActionListener(this);
        
        downMove = new Button ("Down");
        add(downMove);
        downMove.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        Object source = ae.getSource(); // method event within ActionEvent which gets source of event
        if (source.equals(leftMove))
        {
            move = 1;
        }
        else if (source.equals(rightMove))
        {
            move = 2;
        }
        else if (source.equals(upMove))
        {
            move = 3;
        }
        else if (source.equals(downMove))
        {
            move = 4;
        }
        repaint();
    }
    
    public void paint(Graphics g)
    {
        setBackground(Color.white);
        
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
                g.drawRect(x, y,164, 164); //(topLeftCords,length,width)
            }
        }
        
        
        g.setColor(Color.orange);
        g.fillOval(xMove,yMove,30,30);
        if(move == 1){
            g.setColor(Color.white);
            g.fillOval(xMove,yMove,30,30);
            xMove = xMove - 166;
            g.setColor(Color.orange);
            g.fillOval(xMove,yMove,30,30);
        }
        else if (move == 2)
        {
            g.setColor(Color.white);
            g.fillOval(xMove,yMove,30,30);
            xMove = xMove + 166;
            g.setColor(Color.orange);
            g.fillOval(xMove,yMove,30,30);
        }
        else if (move == 3)
        {
            g.setColor(Color.white);
            g.fillOval(xMove,yMove,30,30);
            yMove = yMove - 166;
            g.setColor(Color.orange);
            g.fillOval(xMove,yMove,30,30);
        }
        else if (move == 4)
        {
            g.setColor(Color.white);
            g.fillOval(xMove,yMove,30,30);
            yMove = yMove + 166;
            g.setColor(Color.orange);
            g.fillOval(xMove,yMove,30,30);
        }
        else
        {
        }
        
    }
}
