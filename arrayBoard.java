
/**
 * Write a description of class arrayBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arrayBoard
{
    public arrayBoard()
    {
        Space [][] arrayBoard = new Space [3][3];
    }
    
    public void placePiece(Space clickedSpace, int playerNum)
    {
        if ((!clickedSpace.isBlank()) && (clickedSpace.getPlayer() != 0))
        {
            clickedSpace.setPlayer(playerNum);
            clickedSpace.setBlank(false);
        }
    }
    
    
}
