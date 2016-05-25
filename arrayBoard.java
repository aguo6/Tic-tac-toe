
/**
 * Write a description of class arrayBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arrayBoard
{
    private Space [][] arrayBoard;
    
    public arrayBoard()
    {
        arrayBoard = new Space [3][3];
    }
    
    public void setArray(Space[][] userBoard)
    {
       arrayBoard = userBoard;
    }
    
    public Space[][] getArray()
    {
        return (arrayBoard);
    }

    public int isPlayer(int row, int col)
    {
        if (arrayBoard[row][col].getPlayer() == 1)
            return (1);
        else if (arrayBoard[row][col].getPlayer() == 2)
            return (2);
        else
            return (0);
    }
    
    public boolean checkWin()
    {
         boolean win = false;
         boolean placedPieces = false;
         for(Space[] rows: arrayBoard)
         {
             for(Space spaces: arrayBoard[0])
             {
                 if(spaces.isBlank() == false)
                    placedPieces = true;
             }
         }
         
        if (placedPieces == true)
        {
             // check rows and columns
             
             //checks rows
              for (int i=0; i<3; i++) {
                  if ((arrayBoard[i][1].getPlayer()) == arrayBoard[i][0].getPlayer()) {
                      if ((arrayBoard [i][2].getPlayer()) == (arrayBoard[i][0].getPlayer())){
                          win = true;
                      }
                  }
              }
              
              //checks columns
              for (int j=0; j<3; j++) {
                  if ((arrayBoard[1][j].getPlayer()) == (arrayBoard[0][j].getPlayer())) {
                      if ((arrayBoard [2][j].getPlayer()) == (arrayBoard[0][j].getPlayer())){
                          win = true;
                      }
                  }
              }
      
              //check diag
              if ((arrayBoard[1][1].getPlayer()) == (arrayBoard[0][0].getPlayer())) {
                  if ((arrayBoard [1][1].getPlayer()) == (arrayBoard[2][2].getPlayer())){
                      win = true;
                  }
              }
              if ((arrayBoard[0][2].getPlayer()) == (arrayBoard[1][1].getPlayer())) {
                  if ((arrayBoard [2][0].getPlayer()) == (arrayBoard[1][1].getPlayer())){
                      win = true;
                  }
              }
        }
        return(win);
    }
      
    
    
}
