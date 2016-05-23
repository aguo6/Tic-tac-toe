
/**
 * Write a description of class arrayBoard here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class arrayBoard
{
    public static Space [][] arrayBoard;
    public arrayBoard()
    {
        arrayBoard = new Space [3][3];
    }
    
    public void setPiece(int row, int col, Space clickedSpace)
    {
        arrayBoard[row][col] = clickedSpace;
    }

    
    
    public boolean checkWin()
    {
         boolean win = false;
 
         // check rows and columns
          for (int i=0; i<3; i++) {
              if ((arrayBoard[i][1].getPlayer()) == arrayBoard[i][0].getPlayer()) {
                  if ((arrayBoard [i][2].getPlayer()) == (arrayBoard[i][0].getPlayer())){
                      win = true;
                  }
              }
          }
  
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
          return win;
    }
      
    
    
}
