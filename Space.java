
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space
{
    private int playerPiece;
    private boolean isBlank;
    public Space()
    {
        isBlank = true;
        playerPiece = 0;
    }
    
    public int getPlayer()
    {
        return (playerPiece);
    }
    
    public boolean isBlank()
    {
        return (isBlank);
    }
    
    public void setPlayer(int playerNum)
    {
        playerNum = playerPiece;
        setBlank(false);
    }
    
    private void setBlank(boolean setBlank)
    {
        setBlank = isBlank;
    }
}
