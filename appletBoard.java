
/**
 * Write a description of class appletBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 * 
 * Lots of help from Mr. Sikora's C.S. google website's examples & comments from Mr. Sikora's example code
 * 
 * Asked (Mr. Gumminger) for help on implementing click-able squares:
 * Create Square/piece class
 * mouseListener (for position of click)
 * if click is within square => call player piece
 * 
 * mouseListener Help from oracle Java Documentation Tutorial
 * 
 */
import java.awt.*; //abstract window toolkit
import java.awt.event.*; //buttons, animation, mouse
import java.applet.Applet; //To run an applet
public class appletBoard extends Applet implements ActionListener //implements MouseListener 
{
    private Button leftMove;
    private Button rightMove;
    private Button upMove;
    private Button downMove;
    private Button placePiece;
    public static int xMove = 167;
    public static int yMove = 167;
    private int move = 0;
    private int playerNum = 1;
    
    
    private Space clickSpace = new Space();
    
    private int col;
    private int row;
    
    private arrayBoard compBoard = new arrayBoard();
    private playerPiece piece = new playerPiece();
    
    private boolean win = false;
    
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
        
        placePiece = new Button ("Place");
        add(placePiece);
        placePiece.addActionListener(this);
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
        else if (source.equals(placePiece))
        {
            move = 5;
        }
        repaint();
    }
    
    //     public int mouseClickedX (MouseEvent e)
    //     {
    //         return(e.getXOnScreen());
    //     }
    //         
    //     public int mouseClickedY (MouseEvent e)
    //     {
    //         return(e.getXOnScreen());
    //     }
    
    public void paint(Graphics g)
    {
        //while (win == false)
        //{
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
            
            //"cursor"
            g.setColor(Color.orange);
            g.fillOval(xMove,yMove,30,30);
            
            //Button options
            if(move == 1) //Moves cursor left 1 space
            {
                g.setColor(Color.white);
                g.fillOval(xMove,yMove,30,30);
                if (xMove >= 166)
                    xMove = xMove - 166;
                g.setColor(Color.orange);
                g.fillOval(xMove,yMove,30,30);
            }
            else if (move == 2) //Moves cursor right 1 space
            {
                g.setColor(Color.white);
                g.fillOval(xMove,yMove,30,30);
                if (xMove <= 332)
                    xMove = xMove + 166;
                g.setColor(Color.orange);
                g.fillOval(xMove,yMove,30,30);
            }
            else if (move == 3) //Moves cursor down 1 space
            {
                g.setColor(Color.white);
                g.fillOval(xMove,yMove,30,30);
                if (yMove >= 166)
                    yMove = yMove - 166;
                g.setColor(Color.orange);
                g.fillOval(xMove,yMove,30,30);
            }
            else if (move == 4) //Moves cursor up 1 space
            {
                g.setColor(Color.white);
                g.fillOval(xMove,yMove,30,30);
                if (yMove <= 332)
                    yMove = yMove + 166;
                g.setColor(Color.orange);
                g.fillOval(xMove,yMove,30,30);
                //pieceMaintain(g);
            }
            else if (move == 5) // Places a piece (circle for first player & cross for second player)
            {
                g.setColor(Color.black);
                if (playerNum%2 == 0)
                {
                    row = getRow(xMove);
                    col = getCol(yMove);
                    if(compBoard.isPlayer(row,col) != 2)
                    {
                        piece.drawCross(g);
                        clickSpace.setPlayer(1);
                        clickSpace.setBlank(false);
                        compBoard.setPiece(row, col, clickSpace);
                    }
                }
                else
                {
                    row = getRow(xMove);
                    col = getCol(yMove);
                    if(compBoard.isPlayer(row,col) != 1)
                    {
                        piece.drawCircle(g);
                        clickSpace.setPlayer(2);
                        clickSpace.setBlank(false);
                        compBoard.setPiece(row, col, clickSpace);
                    }
                }
                playerNum++;
            }
//             if (compBoard.checkWin())
//             {
//                 win = true;
//             }
        //}
    }
    
//     public void pieceMaintain(Graphics g)
//     {
//         for(int r = 0; r<3; r++)
//         {
//             for (int c = 0; c<3;c++)
//             {
//                 if(compBoard.isPlayer(r,c) == 1)
//                 {
//                     piece.drawCross(g);
//                 }
//                 else if(compBoard.isPlayer(r,c) == 2)
//                 {
//                     piece.drawCircle(g);
//                 }
//             }
//         }
//     }
    
    public int getXPos()
    {
        return (xMove);
    }
    
    public int getYPos()
    {
        return (yMove);
    }
    
    public int getRow(int xCord)
    {
        if (xCord == 332)
            row = 2;
        else if (xCord == 166)
            row = 1;
        else if (xCord == 0)
            row = 0;
        return (row);
    }
    
    public int getCol(int yCord)
    {
        if (yCord == 332)
            col = 2;
        else if (yCord == 166)
            col = 1;
        else if (yCord == 0)
            col = 0;
        return (col);
    }
}
